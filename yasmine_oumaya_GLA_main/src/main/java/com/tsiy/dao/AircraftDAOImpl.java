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
	public List<Aircraft> getAllAircrafts() {
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

}
