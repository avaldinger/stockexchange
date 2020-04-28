package com.avalding.stockapp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.dao.AccountRepository;

@Controller
@RequestMapping("/api")
public class WebController {
	
	
	private AccountRepository repository;

	public List<Account> theAccounts = new ArrayList<>();

	@Autowired
	public WebController(AccountRepository theRepository) {
		repository = theRepository;
	}

	@GetMapping("/list-accounts")
	public String listAccounts(Model theModel) {

		// get all the acounts into a list
		theAccounts = repository.findAll();

		// add to the spring model
		theModel.addAttribute("accounts", theAccounts);

		return "list-accounts";

	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		
		//create the modelAttribute to bind the data
		Account theAccount = new Account();
		
		theModel.addAttribute("accounts", theAccount);
		
		
		return "account-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("accountId") int theId, Model theModel) {
		
		// add to the spring model
		theModel.addAttribute("accounts", theAccounts);
		
		//create the modelAttribute to bind the data
		Optional<Account> theAccount = repository.findById(theId);
		
		theModel.addAttribute("accounts", theAccount);
		
		
		return "account-form";
		
	}
	
	@PostMapping("/save")
	public String Account(@ModelAttribute("${accounts}") Account theAccount) {
		
		// save the account
		repository.save(theAccount);
		

		//use a redirect to prevent duplicate submission
		return "redirect:/api/list-accounts";
		
	}

}
