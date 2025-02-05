package com.avalding.stockapp.rest;

import java.util.ArrayList;
import java.util.List;

import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.Portfolios;
import com.avalding.stockapp.dao.StockDAO;

@RestController
@RequestMapping("/api")
public class AccountRestController {

	// quick and dirty: inject Portfolios DAO
	@Autowired
	private StockDAO stockDAO;

	public List<Account> testList = new ArrayList<>();

	@Autowired
	public AccountRestController(StockDAO theStockDAO) {
		stockDAO = theStockDAO;
	}
	
	public AccountRestController() {}

	// expose "/Portfolios" get back uses
	@GetMapping("/accounts2")
	public List<Account> findAll() {

		testList = stockDAO.findAll();

		System.out.println(testList);

		return stockDAO.findAll();

	}


	// add mapping to add new Portfolios
	@PostMapping(path="/accounts2", consumes = "application/json", produces = "application/json")
	public Account addAccounts2(@RequestBody Account theAccount, Portfolios thePortfolio) {

		theAccount.setId(0);

		stockDAO.addNewEntitytoDB(theAccount, thePortfolio);

		return theAccount;
	}
	
	@PostMapping(path="/accounts3", consumes = "application/json", produces = "application/json")
	public Account addAccounts3(@RequestBody Account theAccount) {

		theAccount.setId(0);

		stockDAO.addNewEntitytoDB(theAccount);

		return theAccount;
	}
	// add mapping to add new Portfolios
	@PostMapping(path="/accounts4", consumes = "application/json", produces = "application/json")
	public Account addAccounts2(@RequestBody Account theAccount, Portfolios thePortfolio, Orders tempOrder, AccountBalances tempAccountBalances) {

		theAccount.setId(0);

		stockDAO.addNewEntitytoDB(theAccount, thePortfolio, tempOrder, tempAccountBalances);

		return theAccount;
	}

	// add mapping to add new Portfolios
	@PostMapping(path="/accounts5", consumes = "application/json", produces = "application/json")
	public Account addAccounts2(@RequestBody Account theAccount, Orders tempOrder) {

		theAccount.setId(0);

		stockDAO.addNewEntitytoDB(theAccount, tempOrder);

		return theAccount;
	}

	@PostMapping(path="/accounts6", consumes = "application/json", produces = "application/json")
	public Account addAccounts6(@RequestBody Account theAccount, AccountBalances tempAccountBalances) {

		theAccount.setId(0);

		stockDAO.addNewEntitytoDB(theAccount,tempAccountBalances);

		return theAccount;
	}


}
