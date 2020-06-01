package com.avalding.stockapp.dao;

import java.util.List;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.Portfolios;

public interface StockDAO<T> {

	public void addNewEntitytoDB(T theT);

	public void deleteById(int theId);

	public List<T> findAll();

	public T findById(int theId);

	public T updatById(int theId);

	public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios);
	
	public void addNewEntitytoDB(Account theAccount, Orders tempOrders);
	
	public void addNewEntitytoDB(Account theAccount, AccountBalances tempAccountBalances);

	public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios, Orders tempOrders, AccountBalances tempAccountBalances);

}
