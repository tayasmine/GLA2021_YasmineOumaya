package com.tsiy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class BookingDAOImpl implements BookingDAO {

	PersistenceManagerFactory pmf;

	public BookingDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	@SuppressWarnings("unchecked")
	public List<Booking> getBookings() {
		List<Booking> books = null;
		List<Booking> detached = new ArrayList<Booking>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Booking.class);
			books = (List<Booking>) q.execute();
			detached = (List<Booking>) pm.detachCopyAll(books);

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
	public List<Booking> getAll() {
		List<Booking> books = null;
		List<Booking> detached = new ArrayList<Booking>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Booking.class);
			books = (List<Booking>) q.execute();
			detached = (List<Booking>) pm.detachCopyAll(books);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}


	public Booking getElement(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Booking b;
		tx.setRetainValues(true);
		try {
			tx.begin();
			b = pm.getObjectById(Booking.class, id);
			tx.commit();

		}

		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();

		}

		return b;
	}
	public void addElement(Booking f) {
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
	public void cancel(String flightid) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f;
		

		try {
			tx.begin();
			f= pm.getObjectById(Flight.class,flightid);
			int n=f.getAvailableseats();
			f.setAvailableseats(n+1);

			pm.makePersistent(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public void Validate(String bookingid,String pilotid) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Booking f;
		

		try {
			tx.begin();
			f= pm.getObjectById(Booking.class,bookingid);
			
			f.setStatut("validate");

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
		Booking b;
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
	    tx.setRetainValues(true);
	    
		try {
			tx.begin();
			b = pm.getObjectById(Booking.class, id);
			pm.deletePersistent(b);
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
			
			
			
	}

}
