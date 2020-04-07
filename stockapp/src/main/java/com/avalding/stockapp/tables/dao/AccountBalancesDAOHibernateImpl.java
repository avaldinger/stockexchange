package com.avalding.stockapp.tables.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avalding.stockapp.tables.AccountBalances;

@Repository
@Component("AccountBalancesDAO")
public class AccountBalancesDAOHibernateImpl implements StockDAO<AccountBalances> {

	private static final Logger log = LoggerFactory.getLogger(AccountBalancesDAOHibernateImpl.class);

	// defining EntityManager to use
	// the spring boot feature to connect to the DB
	private EntityManager entityManager;

	@Autowired
	public AccountBalancesDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public void addNewEntitytoDB(AccountBalances theAccountBalance) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Add new entry method has been called");

		// save the AccountBalances
		currentSession.saveOrUpdate(theAccountBalance);

		log.info("New Order has been added: " + theAccountBalance.toString());

	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the AccountBalances by the given id
		AccountBalances theAccountBalances = currentSession.get(AccountBalances.class, theId);

		// update the given AccountBalances
		currentSession.remove(theAccountBalances);

		log.info("AccountBalances has been deleted with id: " + theId);

	}

	@Override
	@Transactional
	public List<AccountBalances> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Query all the rows from the AccountBalances table
		Query<AccountBalances> theQuery = currentSession.createQuery("from AccountBalances", AccountBalances.class);

		List<AccountBalances> theAccountBalances = theQuery.getResultList();

		return theAccountBalances;
	}

	@Override
	@Transactional
	public AccountBalances findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Looking for AccountBalances wiht id: " + theId);

		// get the AccountBalances by the given id
		AccountBalances theAccountBalances = currentSession.get(AccountBalances.class, theId);

		log.info("AccountBalances retrieved from DB:" + theAccountBalances.toString());

		return theAccountBalances;
	}

	@Override
	@Transactional
	public AccountBalances updatById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the AccountBalances by the given id
		AccountBalances theAccountBalances = currentSession.get(AccountBalances.class, theId);

		currentSession.update(theAccountBalances);

		return theAccountBalances;

	}

}
