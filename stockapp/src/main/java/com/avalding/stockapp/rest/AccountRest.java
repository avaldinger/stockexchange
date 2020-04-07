package com.avalding.stockapp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.dao.AccountRepository;
import com.avalding.stockapp.tables.dao.StockDAO;

@RestController
@RequestMapping("/api")
public class AccountRest {

	// quick and dirty: inject Account DAO
	// @Autowired
	// private StockDAO stockDAO;

	private AccountRepository repository;

	public List<Account> testList = new ArrayList<>();

	@Autowired
	public AccountRest(AccountRepository theRepository) {
		repository = theRepository;
	}

	// expose "/accounts" get back uses
	@GetMapping("/accounts")
	public List<Account> findAll() {

		return repository.findAll();

	}

	// expose "/accounts" get back users by id
	@GetMapping("/accounts/{accountId}")
	public Optional<Account> getAccount(@PathVariable int accountId) {

		return repository.findById(accountId);
	}

	// add mapping to add new account
	@PostMapping(path = "/accounts", consumes = "application/json", produces = "application/json")
	public Account addAccount(@RequestBody Account theAccount) {

		return repository.save(theAccount);

	}

	// add mapping to update an Account
	@PutMapping("/accounts/{accountId}")
	public Optional<Account> updateAccount(@RequestBody Account theAccount, @PathVariable int accountId) {

		return repository.findById(accountId)
				.map(account -> {
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
