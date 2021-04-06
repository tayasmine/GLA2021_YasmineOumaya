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

	public String getAircraftdetails(String tailnum) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft detached = new Aircraft();
		Aircraft a;

		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String tailnumber");
			q.setFilter("tailnum == tailnumber");
			a = (Aircraft) q.execute(tailnum);
			detached = (Aircraft) pm.detachCopy(a);
			tx.commit();

		}

		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();

		}

		return detached.toString();
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

	public Aircraft getElement(String tailnum) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft detached = new Aircraft();
		Aircraft a;

		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String tailnum");
			q.setFilter("tailnumber == tailnum");
			q.setUnique(true);
			a = (Aircraft) q.execute(tailnum);
			detached = (Aircraft) pm.detachCopy(a);
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
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);

			q.declareParameters("String tailnum");
			q.setFilter("tailnumber == tailnum");
			q.setUnique(true);

			Aircraft airport = (Aircraft) q.execute(tailnum);
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

	public void editElement(String tailnum, Aircraft a) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String tailnum");
			q.setFilter("tailnumber == tailnum");
			q.setUnique(true);

			Aircraft aircraft = (Aircraft) q.execute(tailnum);

			if (aircraft != null) {
				aircraft.edit(a);
			}

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public void editElement(String newTailnum, String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String tailnum");
			q.setFilter("tailnumber == tailnum");
			q.setUnique(true);

			Aircraft aircraft = (Aircraft) q.execute(newTailnum);

			if (aircraft != null) {
				aircraft.edit(getElement(id));
			}

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
