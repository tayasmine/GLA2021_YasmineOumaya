package com.tsiy.dao;

import java.util.ArrayList;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class AircraftDAOImpl implements AircraftDAO {

	PersistenceManagerFactory pmf;

	public AircraftDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}


	public Aircraft getElement(String tailnum) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft f;
		tx.setRetainValues(true);
		try {
			tx.begin();
			f = pm.getObjectById(Aircraft.class, tailnum);
			tx.commit();

		}

		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();

		}

		return f;
	}


	@SuppressWarnings("unchecked")
	public List<Aircraft> getAll() {
		List<Aircraft> Aircrafts = null;
		List<Aircraft> detached = new ArrayList<Aircraft>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			Aircrafts = (List<Aircraft>) q.execute();
			detached = (List<Aircraft>) pm.detachCopyAll(Aircrafts);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public void addElement(Aircraft a) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}


	public void deleteElement(String tailnum) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		 Aircraft a;
	    tx.setRetainValues(true);
	    
		try {
			tx.begin();
			a = pm.getObjectById(Aircraft.class, tailnum);
			pm.deletePersistent(a);
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
			
		
	}

	}
		/*PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);

			Aircraft airport = (Aircraft) q.execute(tailnumber);
			pm.deletePersistent(airport);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return;*/

