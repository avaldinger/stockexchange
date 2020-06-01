package com.avalding.stockapp.dao;

import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.Portfolios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avalding.stockapp.tables.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Account addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios, Orders tempOrders, AccountBalances tempAccountBalances);

}
