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

import com.avalding.stockapp.tables.Account;
import com.avalding.stockapp.tables.AccountBalances;
import com.avalding.stockapp.tables.Orders;
import com.avalding.stockapp.tables.Portfolios;

@Repository
@Component("PortfoliosDAO")
public class PortfoliosDAOHibernateImpl implements StockDAO<Portfolios> {

	private static final Logger log = LoggerFactory.getLogger(PortfoliosDAOHibernateImpl.class);

	// defining EntityManager to use
	// the spring boot feature to connect to the DB
	private EntityManager entityManager;

	@Autowired
	public PortfoliosDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void addNewEntitytoDB(Portfolios thePortfolios) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Add new entry method has been called");

		// save the Portfolios
		currentSession.saveOrUpdate(thePortfolios);

		log.info(thePortfolios.toString());

	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the Portfolios by the given id
		Portfolios thePortfolios = currentSession.get(Portfolios.class, theId);

		// update the given Portfolios
		currentSession.remove(thePortfolios);

		log.info("Portfolios has been deleted with id: " + theId);

	}

	@Override
	@Transactional
	public List<Portfolios> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Query all the rows from the Portfolios table
		Query<Portfolios> theQuery = currentSession.createQuery("from Portfolios", Portfolios.class);

		List<Portfolios> thePortfolioss = theQuery.getResultList();

		return thePortfolioss;
	}

	@Override
	@Transactional
	public Portfolios findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Looking for Portfolios wiht id: " + theId);

		// get the Portfolios by the given id
		Portfolios thePortfolios = currentSession.get(Portfolios.class, theId);

		log.info("Portfolios retrieved from DB:" + thePortfolios.toString());

		return thePortfolios;
	}

	@Override
	@Transactional
	public Portfolios updatById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the Portfolios by the given id
		Portfolios thePortfolios = currentSession.get(Portfolios.class, theId);

		currentSession.update(thePortfolios);

		return thePortfolios;

	}

	@Override
	public void addNewEntitytoDB(Account theAccount, Portfolios tempPortfolios) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewEntitytoDB(Account theAccount, Orders tempOrders) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewEntitytoDB(Account theAccount, AccountBalances tempAccountBalances) {
		// TODO Auto-generated method stub
		
	}

}
