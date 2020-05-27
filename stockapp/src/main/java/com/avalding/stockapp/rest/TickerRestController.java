package com.avalding.stockapp.rest;

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

import com.avalding.stockapp.tables.Tickers;
import com.avalding.stockapp.dao.TickerRepository;

@RestController
@RequestMapping("/api")
public class TickerRestController {

	// quick and dirty: inject Tickers DAO
	// @Autowired
	// private StockDAO stockDAO;

	private TickerRepository repository;


	@Autowired
	public TickerRestController(TickerRepository theRepository) {
		repository = theRepository;
	}

	// expose "/Tickers" get back uses
	@GetMapping("/tickers")
	public List<Tickers> findAll() {

		return repository.findAll();

	}

	// expose "/Tickers" get back users by id
	@GetMapping("/tickers/{tickersId}")
	public Optional<Tickers> getTickers(@PathVariable int tickersId) {

		return repository.findById(tickersId);
	}

	// add mapping to add new Tickers
	@PostMapping(path = "/tickers", consumes = "application/json", produces = "application/json")
	public Tickers addTickers(@RequestBody Tickers theTickers) {

		return repository.save(theTickers);

	}

	// add mapping to update an Tickers
	@PutMapping("/tickers/{tickersId}")
	public Optional<Tickers> updateTickers(@RequestBody Tickers theTickers, @PathVariable int tickersId) {

		return repository.findById(tickersId)
				.map(tickers -> {
				tickers.setActualPrice(theTickers.getActualPrice());
				tickers.setCurrency(theTickers.getCurrency());
				tickers.setName(theTickers.getName());
				tickers.setTickerId(theTickers.getTickerId());
				tickers.setTotalAmount(theTickers.getTotalAmount());
				tickers.setType(theTickers.getType());
				return repository.save(tickers);
		
		});
	}

	// add mapping to remove an Tickers
	@DeleteMapping("/tickers/{tickersId}")
	public String removeTickers(@PathVariable int tickersId) {

		repository.deleteById(tickersId);

		return "Tickers with id: " + tickersId + " has been permanently removed from the Database.";
	}

}
