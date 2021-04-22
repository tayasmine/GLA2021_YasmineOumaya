package com.tsiy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.tsiy.dao.Aircraft;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Flight;
import com.tsiy.dao.Passenger;
import com.tsiy.dao.Pilot;

public class DataGenerator {

	public static void init() {
		List<Passenger> passengers = new ArrayList<Passenger>();
		List<Flight> flights = new ArrayList<Flight>();
		List<Aircraft> aircrafts = new ArrayList<Aircraft>();
		List<Pilot> pilots = new ArrayList<Pilot>();

		Aircraft a1 = new Aircraft("A01", "Airbus", 6);
		Aircraft a2 = new Aircraft("A02", "Airbus", 3);
		Aircraft a3 = new Aircraft("A03", "Airbus", 9);

		DAOFactory.getAircraftDAO().addElement(a1);
		aircrafts.add(a1);
		DAOFactory.getAircraftDAO().addElement(a2);
		aircrafts.add(a2);
		DAOFactory.getAircraftDAO().addElement(a3);
		aircrafts.add(a3);

		Pilot p1 = new Pilot("Max");
		Pilot p2 = new Pilot("Nino");
		DAOFactory.getPilotDAO().addElement(p1);
		DAOFactory.getPilotDAO().addElement(p2);
		pilots.add(p1);
		pilots.add(p2);

		Passenger pa1 = new Passenger("Juju", "Julien", "julien@monmail.fr");
		Passenger pa2 = new Passenger("Toto", "Théo", "titi@monmail.fr");
		DAOFactory.getPassengerDAO().addElement(pa1);
		DAOFactory.getPassengerDAO().addElement(pa2);
		passengers.add(pa1);
		passengers.add(pa2);

		Flight f1 = new Flight("A10", "CDG", "Malte", LocalDate.parse("2021-08-03"), LocalTime.now(), "2h30", 75,
				"découverte", "Aeroport CDG", 4, "Venez découvrir Malte", passengers, p1, a1);
		DAOFactory.getFlightDAO().addElement(f1);
		flights.add(f1);

	}

}
