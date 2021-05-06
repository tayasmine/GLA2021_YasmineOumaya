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

	

	public Flight getElement(String id) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f;
		tx.setRetainValues(true);
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);
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
	public void addeditedElement(String flightid,String passengerid,int s) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f;
		

		try {
			tx.begin();
			f= pm.getObjectById(Flight.class,flightid);
			int n=f.getAvailableseats();
			f.setAvailableseats(n-s);

			pm.makePersistent(f);

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
			Flight f;
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
		    tx.setRetainValues(true);
		    
			try {
				tx.begin();
				f = pm.getObjectById(Flight.class, id);
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
	/*public List<String> getPassengers(String id){
		Flight f=DAOFactory.getFlightDAO().getSpecificFlight(id);
		return f.getPassengers();
		
	}*/

	

}