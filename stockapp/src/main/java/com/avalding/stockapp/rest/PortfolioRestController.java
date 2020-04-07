package com.avalding.stockapp.rest;

import java.util.ArrayList;
import java.util.List;

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

import com.avalding.stockapp.tables.Portfolios;
import com.avalding.stockapp.tables.dao.StockDAO;

@RestController
@RequestMapping("/api")
public class PortfolioRestController {

	// quick and dirty: inject Portfolios DAO
	@Autowired
	@Qualifier("PortfoliosDAO") 
	private StockDAO stockDAO;

	public List<Portfolios> testList = new ArrayList<>();

	@Autowired
	public PortfolioRestController(StockDAO theStockDAO) {
		stockDAO = theStockDAO;
	}
	
	public PortfolioRestController() {}

	// expose "/Portfolios" get back uses
	@GetMapping("/portfolios")
	public List<Portfolios> findAll() {

		testList = stockDAO.findAll();

		System.out.println(testList);

		return stockDAO.findAll();

	}

	// expose "/Portfolios" get back users by id
	@GetMapping("/portfolios/{portfolioId}")
	public Portfolios getPortfolios(@PathVariable int portfolioId) {

		Portfolios thePortfolios = (Portfolios) stockDAO.findById(portfolioId);

		return thePortfolios;
	}

	// add mapping to add new Portfolios
	@PostMapping(path="/portfolios", consumes = "application/json", produces = "application/json")
	public Portfolios addPortfolios(@RequestBody Portfolios thePortfolios) {

		thePortfolios.setId(0);

		stockDAO.addNewEntitytoDB(thePortfolios);

		return thePortfolios;

	}
	
	// add mapping to update an Portfolios
	@PutMapping("/portfolios/{portfolioId}")
	public Portfolios updatePortfolios(@PathVariable int portfolioId) {
		
		Portfolios thePortfolios = (Portfolios) stockDAO.updatById(portfolioId);
		
		return thePortfolios;
		
	}
	
	
	// add mapping to remove an Portfolios
	@DeleteMapping("/portfolios/{portfolioId}")
	public String removePortfolios(@PathVariable int portfolioId) {
		
		stockDAO.deleteById(portfolioId);
		
		return "Portfolios with id: " +  portfolioId + " has been permanently removed from the Database.";
	}

}
