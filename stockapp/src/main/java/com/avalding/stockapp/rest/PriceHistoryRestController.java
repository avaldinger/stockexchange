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

import com.avalding.stockapp.tables.PriceHistory;
import com.avalding.stockapp.tables.dao.PriceHistoryRepository;
import com.avalding.stockapp.tables.dao.StockDAO;

@RestController
@RequestMapping("/api")
public class PriceHistoryRestController {

	// quick and dirty: inject PriceHistory DAO
	// @Autowired
	// private StockDAO stockDAO;

	private PriceHistoryRepository repository;


	@Autowired
	public PriceHistoryRestController(PriceHistoryRepository theRepository) {
		repository = theRepository;
	}

	// expose "/PriceHistorys" get back uses
	@GetMapping("/priceHistorys")
	public List<PriceHistory> findAll() {

		return repository.findAll();

	}

	// expose "/PriceHistorys" get back users by id
	@GetMapping("/priceHistorys/{priceHistoryId}")
	public Optional<PriceHistory> getPriceHistory(@PathVariable int PriceHistoryId) {

		return repository.findById(PriceHistoryId);
	}

	// add mapping to add new PriceHistory
	@PostMapping(path = "/priceHistorys", consumes = "application/json", produces = "application/json")
	public PriceHistory addPriceHistory(@RequestBody PriceHistory thePriceHistory) {

		return repository.save(thePriceHistory);

	}

	// add mapping to update an PriceHistory
	@PutMapping("/priceHistorys/{priceHistoryId}")
	public Optional<PriceHistory> updatePriceHistory(@RequestBody PriceHistory thePriceHistory, @PathVariable int priceHistoryId) {

		return repository.findById(priceHistoryId)
				.map(priceHistory -> {
				priceHistory.setPrice(thePriceHistory.getPrice());
				priceHistory.setTickerName(thePriceHistory.getTickerName());
				priceHistory.setTimeStamp(thePriceHistory.getTimeStamp());
				return repository.save(priceHistory);
		
		});
	}

	// add mapping to remove an PriceHistory
	@DeleteMapping("/priceHistorys/{priceHistoryId}")
	public String removePriceHistory(@PathVariable int priceHistoryId) {

		repository.deleteById(priceHistoryId);

		return "PriceHistory with id: " + priceHistoryId + " has been permanently removed from the Database.";
	}

}
