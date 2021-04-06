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

	public void addElement(Passenger id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction t = pm.currentTransaction();
		try {
			t.begin();
			pm.makePersistent(id);
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
	public List<Passenger> getAll() {
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

	public Passenger getElement(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger detached = new Passenger();
		Passenger a;

		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String id");
			q.setFilter("passengerid == id");
			q.setUnique(true);
			a = (Passenger) q.execute(id);
			detached = (Passenger) pm.detachCopy(a);
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

	public void Bookaflight(Passenger pass, Flight name) {

		return;
	}

	public void deleteElement(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);

			q.declareParameters("String id");
			q.setFilter("passengerid == id");
			q.setUnique(true);

			Passenger pass = (Passenger) q.execute(id);
			pm.deletePersistent(pass);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return;
	}

	public void editElement(String id, Passenger elt) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String id");
			q.setFilter("passengerid == id");
			q.setUnique(true);

			Passenger pass = (Passenger) q.execute(id);

			if (pass != null) {
				pass.edit(elt);
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