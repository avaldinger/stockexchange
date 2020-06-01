package com.avalding.stockapp.dao;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.Portfolios;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class AccountDAOImpl implements AccountDAO<Account>{

    // defining EntityManager to use
    // the spring boot feature to connect to the DB
    private EntityManager entityManager;


    @Override
    @Transactional
    public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);


        theAccount.addPortfolio(tempPortfolios);


        // save the account
        currentSession.saveOrUpdate(theAccount);

    }

    @Override
    @Transactional
    public void addNewEntitytoDB(Account theAccount, Orders tempOrders) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);



        theAccount.addOrders(tempOrders);

        // save the account
        currentSession.saveOrUpdate(theAccount);

    }

    @Override
    @Transactional
    public void addNewEntitytoDB(Account theAccount, AccountBalances tempAccountBalances) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        theAccount.addAccountBalance(tempAccountBalances);

        // save the account
        currentSession.saveOrUpdate(theAccount);

    }

    @Override
    @Transactional
    public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios, Orders tempOrders, AccountBalances tempAccountBalances) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);


        theAccount.addPortfolio(tempPortfolios);
        theAccount.addOrders(tempOrders);
        theAccount.addAccountBalance(tempAccountBalances);

        // save the account
        currentSession.saveOrUpdate(theAccount);


    }
}
