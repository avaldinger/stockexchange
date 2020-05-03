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
import com.avalding.stockapp.tables.Orders;

@Repository
@Component("OrderDAO")
public class OrderDAOHibernateImpl implements StockDAO<Orders> {

	private static final Logger log = LoggerFactory.getLogger(OrderDAOHibernateImpl.class);

	// defining EntityManager to use
	// the spring boot feature to connect to the DB
	private EntityManager entityManager;

	@Autowired
	public OrderDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void addNewEntitytoDB(Orders theOrder) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Add new entry method has been called");

		// save the Orders
		currentSession.saveOrUpdate(theOrder);

		log.info("New Order has been added: " + theOrder.toString());

	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the Orders by the given id
		Orders theOrders = currentSession.get(Orders.class, theId);

		// update the given Orders
		currentSession.remove(theOrders);

		log.info("Orders has been deleted with id: " + theId);

	}

	@Override
	@Transactional
	public List<Orders> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Query all the rows from the Orders table
		Query<Orders> theQuery = currentSession.createQuery("from Orders", Orders.class);

		List<Orders> theOrders = theQuery.getResultList();

		return theOrders;
	}

	@Override
	@Transactional
	public Orders findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		log.info("Looking for Orders wiht id: " + theId);

		// get the Orders by the given id
		Orders theOrders = currentSession.get(Orders.class, theId);

		log.info("Orders retrieved from DB:" + theOrders.toString());

		return theOrders;
	}

	@Override
	@Transactional
	public Orders updatById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the Orders by the given id
		Orders theOrders = currentSession.get(Orders.class, theId);

		currentSession.update(theOrders);

		return theOrders;

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
