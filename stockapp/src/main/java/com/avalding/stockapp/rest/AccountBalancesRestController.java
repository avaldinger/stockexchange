package com.avalding.stockapp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.dao.AccountBalancesRepository;

@RestController
@RequestMapping("/api")
public class AccountBalancesRestController {

	// quick and dirty: inject AccountBalances DAO
	// @Autowired
	// private StockDAO stockDAO;

	private AccountBalancesRepository repository;

	public List<AccountBalances> testList = new ArrayList<>();

	@Autowired
	public AccountBalancesRestController(AccountBalancesRepository theRepository) {
		repository = theRepository;
	}

	// expose "/AccountBalancess" get back uses
	@GetMapping("/accountBalances")
	public List<AccountBalances> findAll() {

		return repository.findAll();

	}

	// expose "/AccountBalancess" get back users by id
	@GetMapping("/accountBalances/{accountBalancesId}")
	public Optional<AccountBalances> getAccountBalances(@PathVariable int AccountBalancesId) {

		return repository.findById(AccountBalancesId);
	}

	// add mapping to add new AccountBalances
	@PostMapping(path = "/accountBalances", consumes = "application/json", produces = "application/json")
	public AccountBalances addAccountBalances(@RequestBody AccountBalances theAccountBalances) {

		return repository.save(theAccountBalances);

	}

	// add mapping to update an AccountBalances
	@PutMapping("/accountBalances/{accountBalancesId}")
	public Optional<AccountBalances> updateAccountBalances(@RequestBody AccountBalances theAccountBalances, @PathVariable int accountBalancesId) {

		return repository.findById(accountBalancesId)
				.map(accountBalances -> {
				accountBalances.setAmount(theAccountBalances.getAmount());
				accountBalances.setCurrency(theAccountBalances.getCurrency());
				accountBalances.setBalanceAvailable(theAccountBalances.isBalanceAvailable());
				return repository.save(accountBalances);
		
		});
	}

	// add mapping to remove an AccountBalances
	@DeleteMapping("/accountBalances/{accountBalancesId}")
	public String removeAccountBalances(@PathVariable int accountBalancesId) {

		repository.deleteById(accountBalancesId);

		return "AccountBalances with id: " + accountBalancesId + " has been permanently removed from the Database.";
	}

}
