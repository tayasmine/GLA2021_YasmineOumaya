package com.example.jetty_jersy.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DAO implements FlightDAO, AircraftDAO, PilotDAO, PassengerDAO {
	List<Flight> fleet = new ArrayList<>();
	List<Passenger> passengers = new ArrayList<>();
	List<Pilot> pilots = new ArrayList<>();
	List<Aircraft> aircrafts = new ArrayList<>();

	public DAO() {
		Pilot p = new Pilot("Max");
		Pilot d = new Pilot("Jean");
		this.pilots.add(d);
		this.pilots.add(p);

		Passenger i1 = new Passenger("Julien");
		Passenger i2 = new Passenger("Nawal");
		this.passengers.add(i1);
		this.passengers.add(i2);

		Aircraft a1 = new Aircraft("A75B09", "Boeing", 6);
		Aircraft a2 = new Aircraft("R78OP8", "Airbus", 9);
		this.aircrafts.add(a1);
		this.aircrafts.add(a2);

		this.fleet.add(new Flight("A10", "CDG", "Malte", LocalDate.parse("2021-08-03"), LocalTime.now(), "2h30", 75,
				"découverte", "Aeroport CDG", 5, "Venez découvrir Malte", this.passengers, p));

	}

	public List<Flight> getFlights() {
		return this.fleet;

	}

	public List<Passenger> getPassengers() {
		return this.passengers;

	}

	public List<Pilot> getPilots() {
		return this.pilots;

	}

	public List<Aircraft> getAircrafts() {
		return this.aircrafts;

	}

	public boolean addFlight(Flight name) {
		return fleet.add(name);
	}

	public boolean deleteFlight(Flight name) {
		return fleet.remove(name);
	}

	public String getAirport(Flight name) {
		return name.airport;
	}

	public String getDirection(Flight name) {
		return name.direction;
	}

	public LocalDate getDate(Flight name) {
		return name.date;
	}

	public LocalTime getTime(Flight name) {

		return name.time;
	}

	public String getDuration(Flight name) {
		return name.Duration;
	}

	public int getPrice(Flight name) {
		return name.price;
	}

	public String getDescription(Flight name) {
		return name.description;
	}

	public String getAppointment(Flight name) {
		//
		return name.appointment;
	}

	public int getAvailableSeats(Flight name) {
		return name.availableseats;
	}

//***
	public String getTailnumber(Aircraft plane) {
		return plane.tailnumber;
	}

	public String getAircrafttype(Aircraft plane) {
		return plane.aircrafttype;
	}

	public int getNumberofseats(Aircraft plane) {
		return plane.numberofseats;
	}

	public List<Flight> getpreviousFlights(Aircraft plane) {
		return plane.previousFlights;
	}

	public List<Passenger> getPassengers(Flight name) {
		return name.passengers;
	}

	public Pilot getPilot(Flight name) {
		return name.pilot;
	}

	public boolean Bookaflight(Passenger pass, Flight name) {
		if (name.availableseats > 0) {
			fleet.add(name);
			name.passengers.add(pass);
			name.availableseats--;
			return true;
		} else
			return false;
	}

	public List<Flight> getBookedFlights(Passenger pass) {
		return pass.bookedflights;
	}

	public String getPilotid(Pilot pilot) {
		return pilot.Pilotid;
	}

	public String getPilotName(Pilot pilot) {
		return pilot.Pilotname;
	}

	public String getPilotMail(Pilot pilot) {
		return pilot.PilotMmail;
	}

	public String getPilotDescription(Pilot pilot) {
		return pilot.PilotDescription;
	}

	public List<Flight> getPlannedFlights(Pilot pilot) {
		return pilot.plannedFlights;
	}

	public boolean postaflight(Flight name) {

		return fleet.add(name);
	}

	public List<Flight> previousFlights(Aircraft plane) {
		return plane.previousFlights;
	}

	public String getPassengerid(Passenger pass) {
		return pass.passengerid;
	}

	public String getPassengerName(Passenger pass) {
		return pass.passengerName;
	}

	public String getPassengerMail(Passenger pass) {

		return pass.passengerMail;
	}

	@Override
	public String getID(Flight name) {

		return name.id;
	}

}
