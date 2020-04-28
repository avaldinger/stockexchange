package com.avalding.stockapp.tables;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pricehistory")
public class PriceHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="time_stamp")
	private Timestamp timeStamp;
	@Column(name="ticker_name")
	private String tickerName;
	@Column(name="price")
	private double price;
	
	public PriceHistory() {}

	public PriceHistory(Timestamp timeStamp, String tickerName, double price) {
		this.timeStamp = timeStamp;
		this.tickerName = tickerName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTickerName() {
		return tickerName;
	}

	public void setTickerName(String tickerName) {
		this.tickerName = tickerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PriceHistory: id=" + id + ", timeStamp=" + timeStamp + ", tickerName=" + tickerName + ", price=" + price;
	}
	
	
	
	

}
