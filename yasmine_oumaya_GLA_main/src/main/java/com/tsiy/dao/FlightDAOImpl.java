package com.tsiy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class FlightDAOImpl implements FlightDAO {

	PersistenceManagerFactory pmf;

	public FlightDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getAll() {
		List<Flight> Flights = null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			Flights = (List<Flight>) q.execute();
			detached = (List<Flight>) pm.detachCopyAll(Flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getElement(String id) {
		List<Flight> a = null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		// Flight a;

		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String id");
			q.setFilter("id == id");
			a = (List<Flight>) q.execute(id);
			// pm.getObjectById
			detached = (List<Flight>) pm.detachCopyAll(a);
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

	public void addElement(Flight f) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Flight> SearchFlight(String direction) {
		List<Flight> a = null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		// Flight a;

		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String direction");
			q.setFilter("direction == direction");
			a = (List<Flight>) q.execute(direction);
			// pm.getObjectById
			detached = (List<Flight>) pm.detachCopyAll(a);
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

	/*
	 * public String getFlightDetail(String id) { PersistenceManager pm =
	 * pmf.getPersistenceManager(); Transaction tx = pm.currentTransaction(); Flight
	 * detached = new Flight(); Flight f;
	 * 
	 * try { tx.begin(); Query q = pm.newQuery(Flight.class);
	 * q.declareParameters("String idnum"); q.setFilter("id == idnum"); f = (Flight)
	 * q.execute(id); detached = (Flight) pm.detachCopy(f); tx.commit();
	 * 
	 * }
	 * 
	 * 
	 * finally
	 * 
	 * { if (tx.isActive()) { tx.rollback(); }
	 * 
	 * pm.close();
	 * 
	 * }
	 * 
	 * return detached.toString(); }
	 */

	public void deleteElement(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);

			Flight fl = (Flight) q.execute(id);
			pm.deletePersistent(fl);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return;

	}

	public void editElement(String id, Flight elt) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String id");
			q.setFilter("id == id");
			q.setUnique(true);

			Flight flight = (Flight) q.execute(id);
			flight.edit(elt);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public void Bookaflight(Passenger pass, String name) {
		List<Flight> f = this.getElement(name);
		for (Flight fl : f) {
			if (fl.getId().equals(name)) {
				List<Passenger> p = fl.getPassengers();
				p.add(pass);
				fl.setPassengers(p);
				this.editElement(name, fl);

			}
		}

	}

}