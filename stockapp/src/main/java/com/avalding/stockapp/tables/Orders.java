package com.avalding.stockapp.tables;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ticker")
	private String ticker;
	@Column(name = "amount")
	private int amount;
	// if it's false it's a sell
	// maybe needs another type of variable
	@Column(name = "type_of_order")
	private String typeOfOrder;
	@Column(name = "limit")
	private int limit;
	@Column(name = "state")
	private String state;
	@Column(name = "timestamp")
	private Date timestamp;
	@Column(name = "expiration")
	private Date expiration;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "fk_account_id_orders")
	private Account accounts;


	public Orders() {
	}

	public Orders(String ticker, int amount, String typeOfOrder, int limit, String state, Date timestamp,
			Date expiration) {
		this.ticker = ticker;
		this.amount = amount;
		this.typeOfOrder = typeOfOrder;
		this.limit = limit;
		this.state = state;
		this.timestamp = timestamp;
		this.expiration = expiration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTypeOfOrder() {
		return typeOfOrder;
	}

	public void setTypeOfOrder(String typeOfOrder) {
		this.typeOfOrder = typeOfOrder;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	@Override
	public String toString() {
		return "Orders: id=" + id + ", ticker=" + ticker + ", amount=" + amount + ", typeOfOrder=" + typeOfOrder
				+ ", limit=" + limit + ", state=" + state + ", timestamp=" + timestamp + ", expiration=" + expiration;
	}

}
