package com.avalding.stockapp.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.dao.StockDAO;

@RestController
@RequestMapping("/api")
public class OrderRestController {

	// quick and dirty: inject Orders DAO
	@Autowired
	@Qualifier("OrderDAO")
	private StockDAO stockDAO;

	public List<Orders> testList = new ArrayList<>();

	@Autowired
	public OrderRestController(StockDAO theStockDAO) {
		stockDAO = theStockDAO;
	}

	public OrderRestController() {
	}

	// expose "/orders" get back uses
	@GetMapping("/orders")
	public List<Orders> findAll() {

		testList = stockDAO.findAll();

		System.out.println(testList);

		return stockDAO.findAll();

	}

	// expose "/orders" get back users by id
	@GetMapping("/orders/{orderId}")
	public Orders getOrders(@PathVariable int orderId) {

		Orders theOrders = (Orders) stockDAO.findById(orderId);

		return theOrders;
	}

	// add mapping to add new Orders
	@PostMapping(path = "/orders", consumes = "application/json", produces = "application/json")
	public Orders addOrders(@RequestBody Orders theOrders) {

		theOrders.setId(0);

		// getting the current date when a new entry is created
		// creating a Timestamp object to populate the corresponding field
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);

		theOrders.setTimestamp(ts);

		stockDAO.addNewEntitytoDB(theOrders);

		return theOrders;

	}

	// add mapping to update an Orders
	@PutMapping("/orders/{orderId}")
	public Orders updateOrders(@PathVariable int orderId) {

		Orders theOrders = (Orders) stockDAO.updatById(orderId);

		return theOrders;

	}

	// add mapping to remove an Orders
	@DeleteMapping("/orders/{orderId}")
	public String removeOrders(@PathVariable int orderId) {

		stockDAO.deleteById(orderId);

		return "Orders with id: " + orderId + " has been permanently removed from the Database.";
	}

}
