package com.tsiy.dao;

import java.util.ArrayList;
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
	public List<Flight> getAllFlights() {
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

	public void addFlight(Flight flight) {
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

	@SuppressWarnings("unchecked")
	public List<Flight> SearchFlight(String direction) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Flight> fleet = null;
		List<Flight> detached = new ArrayList<Flight>();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("String dir");
			q.setFilter("direction = dir ");
			fleet = (List<Flight>) q.execute(direction);
			detached = (List<Flight>) pm.detachCopyAll(fleet);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

		return detached;
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

	@Override
	public void modifyFlight(Flight f, String appointment) {
		f.setAppointment(appointment);
		System.out.println("The flight " + f.toString() + "is updated");
	}

}
