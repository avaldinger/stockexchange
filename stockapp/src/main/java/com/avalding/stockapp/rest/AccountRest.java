package com.avalding.stockapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.dao.StockDAO;

@RestController
@RequestMapping("/api")
public class AccountRest {

	// quick and dirty: inject Account DAO
	private StockDAO stockDAO;

	public List<Account> testList = new ArrayList<>();

	public AccountRest(StockDAO theStockDAO) {
		stockDAO = theStockDAO;
	}

	// expose "/accounts" get back uses
	@GetMapping("/accounts")
	public List<Account> findAll() {

		testList = stockDAO.findAll();

		System.out.println(testList);

		return stockDAO.findAll();

	}

	// expose "/accounts" get back users by id
	@GetMapping("/accounts/{accountId}")
	public Account getAccount(@PathVariable int accountId) {

		Account theAccount = (Account) stockDAO.findById(accountId);

		return theAccount;
	}

	// add mapping to add new account
	@PostMapping(path="/accounts", consumes = "application/json", produces = "application/json")
	public Account addAccount(@RequestBody Account theAccount) {

		theAccount.setId(0);

		stockDAO.addNewEntitytoDB(theAccount);

		return theAccount;

	}
	
	// add mapping to update an Account
	@PutMapping("/accounts/{accountId}")
	public Account updateAccount(@PathVariable int accountId) {
		
		Account theAccount = (Account) stockDAO.updatById(accountId);
		
		return theAccount;
		
	}
	
	
	// add mapping to remove an account
	@DeleteMapping("/accounts/{accountId}")
	public String removeAccount(@PathVariable int accountId) {
		
		stockDAO.deleteById(accountId);
		
		return "Account with id: " +  accountId + " has been permanently removed from the Database.";
	}

}
