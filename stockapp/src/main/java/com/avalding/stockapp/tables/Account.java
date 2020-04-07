package com.avalding.stockapp.tables;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "owner_type")
	private String ownerType;

	
	@OneToMany(mappedBy="accounts", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Portfolios> portfolios;
	
	
	
	@OneToMany(mappedBy="accounts", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<AccountBalances> accountBalances;
	
	
	
	@OneToMany(mappedBy="accounts", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Orders> orders;
	


	protected Account() {
	}

	public Account(String firstName, String lastName, String ownerType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ownerType = ownerType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	@Override
	public String toString() {
		return "Accounts id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ownerType=" + ownerType;
	}

	public List<Portfolios> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<Portfolios> portfolios) {
		this.portfolios = portfolios;
	}

	public List<AccountBalances> getAccountBalances() {
		return accountBalances;
	}

	public void setAccountBalances(List<AccountBalances> accountBalances) {
		this.accountBalances = accountBalances;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	
	// convenience method to add portfolios
	public void addPortfolio(Portfolios tempPortfolio) {

		if (portfolios == null) {
			portfolios = new ArrayList<>();
		}

		portfolios.add(tempPortfolio);
	}
	
	
	
	

}
