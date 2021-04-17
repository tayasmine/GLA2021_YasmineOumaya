package com.tsiy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class PilotDAOImpl implements PilotDAO {

	PersistenceManagerFactory pmf;

	public PilotDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings("unchecked")
	public List<Pilot> getAll() {
		List<Pilot> Pilots = null;
		List<Pilot> detached = new ArrayList<Pilot>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Pilot.class);
			Pilots = (List<Pilot>) q.execute();
			detached = (List<Pilot>) pm.detachCopyAll(Pilots);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public Pilot getElement(String name) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot detached = new Pilot();
		Pilot a;

		try {
			tx.begin();
			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("String name");
			q.setFilter("pilotid == name");
			q.setUnique(true);
			a = (Pilot) q.execute(name);
			detached = (Pilot) pm.detachCopy(a);
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

	public void addElement(Pilot a) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public void deleteElement(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);

			q.declareParameters("String id");
			q.setFilter("pilotid == id");
			q.setUnique(true);

			Pilot p = (Pilot) q.execute(id);
			pm.deletePersistent(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return;
	}

	public void editElement(String name, Pilot elt) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("String name");
			q.setFilter("pilotid == name");
			q.setUnique(true);

			Pilot pilot = (Pilot) q.execute(name);

			if (pilot != null) {
				pilot.edit(elt);
			}

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public String getPilotDetails(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot detached = new Pilot();
		Pilot a;

		try {
			tx.begin();
			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("String id");
			q.setFilter("pilotid == id");
			a = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(a);
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

}
