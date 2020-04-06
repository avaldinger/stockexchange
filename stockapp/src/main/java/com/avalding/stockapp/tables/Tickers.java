package com.avalding.stockapp.tables;

import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickers")
public class Tickers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="ticker_id")
	private String tickerId;
	@Column(name="name")
	private String name;
	@Column(name="currency")
	private Currency currency;
	@Column(name="type")
	private String type;
	@Column(name="actual_price")
	private double actualPrice;
	// total amount of Stocks
	@Column(name="total_amount_stock")
	private int totalAmount;
	
	public Tickers() {}

	public Tickers(String tickerId, String name, Currency currency, String type, double actualPrice, int totalAmount) {
		this.tickerId = tickerId;
		this.name = name;
		this.currency = currency;
		this.type = type;
		this.actualPrice = actualPrice;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTickerId() {
		return tickerId;
	}

	public void setTickerId(String tickerId) {
		this.tickerId = tickerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Tickers: id=" + id + ", tickerId=" + tickerId + ", name=" + name + ", currency=" + currency + ", type="
				+ type + ", actualPrice=" + actualPrice + ", totalAmount=" + totalAmount;
	}	
}
