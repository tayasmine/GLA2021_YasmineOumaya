package com.tsiy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.ws.rs.NotFoundException;

public class PassengerDAOImpl implements PassengerDAO {

	PersistenceManagerFactory pmf;

	public PassengerDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings("unchecked")
	public List<Passenger> getAll() {
		List<Passenger> Flights = null;
		List<Passenger> detached = new ArrayList<Passenger>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			Flights = (List<Passenger>) q.execute();
			detached = (List<Passenger>) pm.detachCopyAll(Flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	



	public Passenger getElement(String passengerid) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger f;
		tx.setRetainValues(true);
		try {
			tx.begin();
			f = pm.getObjectById(Passenger.class, passengerid);
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

	public void addElement(Passenger p) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}



	public void deleteElement(String id) {
			PersistenceManager pm;
			Transaction tx;
			Passenger f;
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
		    tx.setRetainValues(true);
		    
			try {
				tx.begin();
				f = pm.getObjectById(Passenger.class, id);
				pm.deletePersistent(f);
				tx.commit();
				
			} 
			
			finally {
				if (tx.isActive()) {
					tx.rollback();
				}

				pm.close();
				
			}

				
			
		}
		/*
		 * Flight fl = (Flight) q.execute(id); pm.deletePersistent(fl);
		 * 
		 * tx.commit(); } finally { if (tx.isActive()) { tx.rollback(); } pm.close(); }
		 * return;
		 */

	@SuppressWarnings("unchecked")
	public Passenger getPassengerByEmailAndPassword(String passengerMail, String password) {
		
		List<Passenger> users = new ArrayList<Passenger>();
		List<Passenger> detached = new ArrayList<Passenger>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			if (passengerMail != null && password != null) {
				q.declareParameters("String passengerMail");
				q.setFilter("passengerMail == passengerMail");

				users = (List<Passenger>) q.execute(passengerMail);
				detached = (List<Passenger>) pm.detachCopyAll(users);
			}
			for (Passenger u : detached) {
				if (u.getPassword().equals(password)) {
					return u;
				}
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundException();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return null;
	}

	}


	/*public void editElement(String id, Flight elt) {
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
		}*/

