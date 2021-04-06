package com.tsiy.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class FlightDAOImpl implements FlightDAO {

	private PersistenceManagerFactory pmf;

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

	public Flight getElement(String id) {
		Flight detached;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String id");
			q.setFilter("id == id");
			q.setUnique(true);

			Flight flight = (Flight) q.execute(id);
			detached = (Flight) pm.detachCopy(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

		return detached;

	}

	public void addElement(Flight flight) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public List<Flight> SearchFlight(String direction) {
		List<Flight> flights = getAll();
		List<Flight> dir = new ArrayList<Flight>();
		Iterator<Flight> it = flights.iterator();
		while (it.hasNext()) {
			Flight f = it.next();
			if (f.getDirection().equals(direction))
				dir.add(f);
		}
		return dir;

	}

	public String getFlightDetail(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight detached = new Flight();
		Flight f;

		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String idnum");
			q.setFilter("id == idnum");
			f = (Flight) q.execute(id);
			detached = (Flight) pm.detachCopy(f);
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

	public void deleteElement(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String id");
			q.setFilter("id == id");
			q.setUnique(true);

			Flight flight = (Flight) q.execute(id);

			pm.deletePersistent(flight);

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
			q.setFilter("identifier == id");
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
		Flight f = this.getElement(name);
		List<Passenger> p = f.getPassengers();
		p.add(pass);
		f.setPassengers(p);
		this.editElement(name, f);

	}

}