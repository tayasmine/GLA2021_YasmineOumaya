package com.tsiy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class PassengerDAOImpl implements PassengerDAO {
	private PersistenceManagerFactory pmf;

	public PassengerDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@Override
	public void addPassenger(Passenger p) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction t = pm.currentTransaction();
		try {
			t.begin();
			pm.makePersistent(p);
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
			pm.close();
		}
	}

	public String getPassengerDetail(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger detached = new Passenger();
		Passenger f;

		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String idnum");
			q.setFilter("id == idnum");
			f = (Passenger) q.execute(id);
			detached = (Passenger) pm.detachCopy(f);
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
	@Override
	public List<Passenger> getAllPassengers() {
		List<Passenger> Passenger = null;
		List<Passenger> detached = new ArrayList<Passenger>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			Passenger = (List<Passenger>) q.execute();
			detached = (List<Passenger>) pm.detachCopyAll(Passenger);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@Override
	public boolean Bookaflight(Passenger pass, Flight name) {

		return false;
	}

}