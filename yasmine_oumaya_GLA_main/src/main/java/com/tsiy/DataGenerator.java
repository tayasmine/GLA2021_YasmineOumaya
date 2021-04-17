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

		Aircraft a1 = new Aircraft("A75B09", "Boeing", 6);
		DAOFactory.getAircraftDAO().addElement(a1);
		aircrafts.add(a1);

		Pilot p1 = new Pilot("Max");
		Pilot p2 = new Pilot("Nino");
		DAOFactory.getPilotDAO().addElement(p1);
		DAOFactory.getPilotDAO().addElement(p2);
		pilots.add(p1);
		pilots.add(p2);

		Passenger pa1 = new Passenger("Julien");
		DAOFactory.getPassengerDAO().addElement(pa1);
		passengers.add(pa1);

		Flight f1 = new Flight("A10", "CDG", "Malte", LocalDate.parse("2021-08-03"), LocalTime.now(), "2h30", 75,
				"découverte", "Aeroport CDG", 4, "Venez découvrir Malte", passengers, p1, a1);
		DAOFactory.getFlightDAO().addElement(f1);
		flights.add(f1);

	}

}
