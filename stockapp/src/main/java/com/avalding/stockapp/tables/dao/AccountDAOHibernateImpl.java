package com.avalding.stockapp.tables.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.Portfolios;

@Repository
@Primary
public class AccountDAOHibernateImpl implements StockDAO<Account> {

	private static final Logger log = LoggerFactory.getLogger(AccountDAOHibernateImpl.class);

	// defining EntityManager to use
	// the spring boot feature to connect to the DB
	private EntityManager entityManager;

	private Portfolios tempPortfolios;

	@Autowired
	public AccountDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Add new entry method has been called");

		theAccount.addPortfolio(tempPortfolios);

		// save the account
		currentSession.saveOrUpdate(theAccount);

		log.info(theAccount.toString());

	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the account by the given id
		Account theAccount = currentSession.get(Account.class, theId);

		// update the given account
		currentSession.remove(theAccount);

		log.info("Account has been deleted with id: " + theId);

	}

	@Override
	@Transactional
	public List<Account> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Query all the rows from the Account table
		Query<Account> theQuery = currentSession.createQuery("from Account", Account.class);

		List<Account> theAccounts = theQuery.getResultList();

		return theAccounts;
	}

	@Override
	@Transactional
	public Account findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Looking for account wiht id: " + theId);

		// get the account by the given id
		Account theAccount = currentSession.get(Account.class, theId);

		log.info("Account retrieved from DB:" + theAccount.toString());

		return theAccount;
	}

	@Override
	@Transactional
	public Account updatById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the account by the given id
		Account theAccount = currentSession.get(Account.class, theId);

		currentSession.update(theAccount);

		return theAccount;

	}

	@Override
	public void addNewEntitytoDB(Account theAccount) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Add new entry method has been called");

		// save the account
		currentSession.saveOrUpdate(theAccount);

		log.info(theAccount.toString());

	}

	@Override
	public void addNewEntitytoDB(Account theAccount, Orders tempOrders) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Add new entry method has been called");

		theAccount.addPortfolio(tempPortfolios);

		// save the account
		currentSession.saveOrUpdate(theAccount);

		log.info(theAccount.toString());

	}

	@Override
	public void addNewEntitytoDB(Account theAccount, AccountBalances tempAccountBalances) {
		// TODO Auto-generated method stub

	}

}
