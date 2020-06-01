package com.avalding.stockapp.dao;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.Portfolios;

public interface AccountDAO<T> {


    public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios);

    public void addNewEntitytoDB(Account theAccount, Orders tempOrders);

    public void addNewEntitytoDB(Account theAccount, AccountBalances tempAccountBalances);

    public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios, Orders tempOrders, AccountBalances tempAccountBalances);
}
