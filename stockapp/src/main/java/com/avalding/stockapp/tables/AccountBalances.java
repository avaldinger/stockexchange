package com.avalding.stockapp.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="account_balances")
public class AccountBalances {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="amount")
	private int amount;
	@Column(name="currency")
	private String currency;
	@Column(name="balance_available")
	private boolean balanceAvailable;

	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "fk_account_id_account_balances")
	// Annotation to avoid JSON loop when calling 
	// all the info about the Account
	@JsonBackReference
	private Account accounts;
	
	
	public AccountBalances() {}

	public AccountBalances(int amount, String currency, boolean balanceAvailable, Account account) {
		this.amount = amount;
		this.currency = currency;
		this.balanceAvailable = balanceAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	public boolean isBalanceAvailable() {
		return balanceAvailable;
	}

	public void setBalanceAvailable(boolean balanceAvailable) {
		this.balanceAvailable = balanceAvailable;
	}

	@Override
	public String toString() {
		return "AccountBalances: id=" + id + ", amount=" + amount + ", currency=" + currency + ", balanceAvailable="
				+ balanceAvailable;
	}

	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}
	
	
	
	
	
	
	
	

}
