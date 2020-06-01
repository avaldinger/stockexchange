package com.avalding.stockapp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.Portfolios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.dao.AccountRepository;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value= "/api",  produces = { MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE })
public class AccountRest {

    // quick and dirty: inject Account DAO
    // @Autowired
    // private StockDAO stockDAO;

    private AccountRepository repository;



    public List<Account> theAccounts = new ArrayList<>();

    @Autowired
    public AccountRest(AccountRepository theRepository) {
        repository = theRepository;
    }

    // expose "/accounts" get back uses
    // Pagination added with Pageable Interface and the RequestParams
    @GetMapping(value = "/accounts")
    public Page<Account> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {


        Pageable pageInfo = PageRequest.of(page, size);


        return repository.findAll(pageInfo);

        // return repository.findAll();

    }

    // expose "/accounts" get back users by id
    @GetMapping("/accounts/{accountId}")
    public Optional<Account> getAccount(@PathVariable int accountId) {

        // checking for existing accounts
        // throwing error in case of invali/non-existing ID
        if(repository.findById(accountId).isPresent()){
            return repository.findById(accountId);
        } else {
            throw new EntityNotFoundException("Account is not found.");
        }

    }

    // add mapping to add new account
    @PostMapping(path = "/accounts", consumes = "application/json", produces = "application/json")
    public Account addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios, Orders tempOrders, AccountBalances tempAccountBalances) {

        theAccount.addPortfolio(tempPortfolios);
        theAccount.addAccountBalance(tempAccountBalances);
        theAccount.addOrders(tempOrders);

        return repository.save(theAccount);

    }

    // add mapping to update an Account
    @PutMapping("/accounts/{accountId}")
    public Optional<Account> updateAccount(@RequestBody Account theAccount, @PathVariable int accountId) {

        return repository.findById(accountId).map(account -> {
            account.setFirstName(theAccount.getFirstName());
            account.setLastName(theAccount.getLastName());
            account.setOwnerType(theAccount.getOwnerType());
            account.setPortfolios(theAccount.getPortfolios());
            account.setOrders(theAccount.getOrders());
            account.setAccountBalances(theAccount.getAccountBalances());
            return repository.save(account);

        });
    }

    // add mapping to remove an account
    @DeleteMapping("/accounts/{accountId}")
    public String removeAccount(@PathVariable int accountId) {

        repository.deleteById(accountId);

        return "Account with id: " + accountId + " has been permanently removed from the Database.";
    }

}
