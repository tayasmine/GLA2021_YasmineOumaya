package com.tsiy.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class PilotDAOImpl implements PilotDAO {

	PersistenceManagerFactory pmf;

	public PilotDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * 
	 */
	public void addAFlight(int idUser) {

		PersistenceManager pm;
		Transaction tr;
		Pilot pilotRetrieved;
		@SuppressWarnings("unused")
		List<Flight> pilotFlightsList;

		Flight f = new Flight();
		f.setDescription("Travelling with TSIY is always a good idea!");

		// save
		pm = pmf.getPersistenceManager();
		tr = pm.currentTransaction();
		try {
			tr.begin();
			pilotRetrieved = pm.getObjectById(Pilot.class, idUser);
			pilotFlightsList = pilotRetrieved.getListofflights();
			pm.makePersistent(f);

			tr.commit();
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}
			pm.close();
		}

		// retrieve
		pm = pmf.getPersistenceManager();
		tr = pm.currentTransaction();
		try {
			tr.begin();

			// Query q = pm.newQuery("SELECT FROM " + Flight.class.getName() + " WHERE price
			// < 150.00 ORDER BY price ASC");
			Flight f_ret = pm.getObjectById(Flight.class, idUser);
			System.out.println("flight retrieved : " + f_ret.getDescription());
			tr.commit();
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}

			pm.close();
		}

	}

	public void editAFlight(int idUser, int idFlight) {
		System.out.println("A flight is editing");

	}

	@Override
	public List<Pilot> getAllPilots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPilotDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean postaflight(Pilot p, Flight name) {
		// TODO Auto-generated method stub
		return false;
	}
}
