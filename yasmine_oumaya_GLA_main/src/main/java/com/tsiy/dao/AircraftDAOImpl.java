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

	@SuppressWarnings("unchecked")
	public List<Aircraft> getElement(String tailnum) {
		List<Aircraft> a = null;
		List<Aircraft> detached = new ArrayList<Aircraft>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String tailnum");
			q.setFilter("tailnumber == tailnum");
			a = (List<Aircraft>) q.execute(tailnum);
			// pm.getObjectById
			detached = (List<Aircraft>) pm.detachCopyAll(a);
			tx.commit();
		}

		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();

		}

		return detached;
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

	public void deleteElement(String tailnumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
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
		return;
	}

	/*
	 * public void editElement(String tailnum, Aircraft a) {
	 * 
	 * PersistenceManager pm = pmf.getPersistenceManager(); Transaction tx =
	 * pm.currentTransaction(); try { tx.begin();
	 * 
	 * Query q = pm.newQuery(Aircraft.class);
	 * 
	 * q.declareParameters("String tailnum"); q.setFilter("tailnumber == tailnum");
	 * q.setUnique(true); Aircraft aircraft = (Aircraft) q.execute(tailnum);
	 * aircraft.edit(a);
	 * 
	 * tx.commit(); } finally
	 * 
	 * { if (tx.isActive()) { tx.rollback(); } pm.close(); }
	 * 
	 * }
	 */

}
