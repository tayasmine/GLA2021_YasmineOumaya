package com.tsiy.Test;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.tsiy.dao.Aircraft;
import com.tsiy.dao.AircraftDAO;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Flight;
import com.tsiy.dao.FlightDAO;
import com.tsiy.dao.Passenger;
import com.tsiy.dao.PassengerDAO;
import com.tsiy.dao.Pilot;
import com.tsiy.dao.PilotDAO;

public class DAOTest {

	@Test
	public void testAircraft() {
		System.out.println("Test Aircraft :\n");

		AircraftDAO aircraftDAO = DAOFactory.getAircraftDAO();

		aircraftDAO.addElement(new Aircraft("OU1547"));
		aircraftDAO.addElement(new Aircraft("Ya1548"));
		aircraftDAO.addElement(new Aircraft("Lo1565"));

		aircraftDAO.deleteElement("Ya1548");

		List<Aircraft> a = aircraftDAO.getElement("Lo1565");
		System.out.println(a);

		Collection<Aircraft> b = aircraftDAO.getAll();

		if (b.isEmpty()) {
			System.out.println("Empty");
		}

		for (Aircraft ac : b) {
			System.out.println(ac);
		}
		assertEquals(2, b.size());
	}

	@Test
	public void testFlight() {
		System.out.println("Test Flight :\n");

		FlightDAO flightDAO = DAOFactory.getFlightDAO();
		flightDAO.addElement(new Flight("125687"));

		List<Flight> c = flightDAO.getAll();

		for (Flight f : c) {
			System.out.println(f);
		}
		assertEquals(1, c.size());
	}

	@Test
	public void testPassengerAndPilot() {
		System.out.println("Test Passenger & Pilot :\n");

		PassengerDAO PassengerDAO = DAOFactory.getPassengerDAO();
		PilotDAO PilotDAO = DAOFactory.getPilotDAO();

		PassengerDAO.addElement(new Passenger("tyas", "yasmine tahi", "yasmine@gmail.com"));
		System.out.println(PassengerDAO.getElement("tyas"));

		PilotDAO.addElement(new Pilot("Oums1", "oumaya satouri", "oumaya@outlook.fr"));
		System.out.println(PilotDAO.getAll());

		assertEquals(2, PassengerDAO.getAll().size());
	}

}