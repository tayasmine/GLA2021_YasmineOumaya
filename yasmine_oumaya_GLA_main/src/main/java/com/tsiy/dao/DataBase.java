package com.tsiy.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

	private static List<Passenger> passengers;
	private static List<Flight> flights;
	private static List<Aircraft> aircrafts;
	private static List<Pilot> pilots;

	public DataBase() {
		flights = new ArrayList<Flight>();
		passengers = new ArrayList<Passenger>();
		pilots = new ArrayList<Pilot>();
		aircrafts = new ArrayList<Aircraft>();
	}

	public DataBase(String fakeData) {
		aircrafts = new ArrayList<Aircraft>();
		pilots = new ArrayList<Pilot>();
		flights = new ArrayList<Flight>();
		passengers = new ArrayList<Passenger>();

		Aircraft a1 = new Aircraft("A75B09", "Boeing", 6);
		Pilot p1 = new Pilot("Max");
		Pilot p2 = new Pilot("Nino");
		Passenger i1 = new Passenger("Julien");
		Passenger i2 = new Passenger("Nawal");
		Flight f1 = new Flight("A10", "CDG", "Malte", LocalDate.parse("2021-08-03"), LocalTime.now(), "2h30", 75,
				"découverte", "Aeroport CDG", 4, "Venez découvrir Malte", passengers, p1, a1);

		aircrafts.add(a1);

		flights.add(f1);

		passengers.add(i1);
		passengers.add(i2);

		pilots.add(p1);
		pilots.add(p2);
	}

	public DataBase(List<Aircraft> aircrafts, List<Passenger> passengers, List<Pilot> pilots, List<Flight> flights) {
		DataBase.flights = flights;
		DataBase.passengers = passengers;
		DataBase.pilots = pilots;
		DataBase.aircrafts = aircrafts;
	}

	/*
	 * getter
	 */

	public static List<Passenger> getAllPassengers() {
		return passengers;
	}

	public static List<Pilot> getAllPilots() {
		return pilots;
	}

	public List<Flight> getAllFlights() {
		return flights;
	}

	public static List<Aircraft> getAllAircrafts() {
		return aircrafts;
	}

	/*
	 * adder
	 */
	public void addFlight(Flight f) {
		flights.add(f);
	}

	public void addPilot(Pilot p) {
		pilots.add(p);
	}

	public void addPassenger(Passenger p) {
		passengers.add(p);
	}

	public void addAircraft(Aircraft a) {
		aircrafts.add(a);
	}

	/*
	 * setter
	 */

	public void setFlights(List<Flight> flightList) {
		flights = flightList;
	}

	public void setAircrafts(List<Aircraft> aircraftList) {
		aircrafts = aircraftList;
	}

	public void setPilots(List<Pilot> pilotList) {
		pilots = pilotList;
	}

	public void setPassengers(List<Passenger> passengerList) {
		passengers = passengerList;
	}

}
