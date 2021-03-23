package com.tsiy.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {
	List<Flight> fleet;

	public FlightDAOImpl() {
		fleet = new ArrayList<Flight>();
		List<Passenger> passengers = new ArrayList<>();
		Passenger i1 = new Passenger("Julien");
		Passenger i2 = new Passenger("Nawal");
		Aircraft a1 = new Aircraft("A75B09", "Boeing", 6);
		passengers.add(i1);
		passengers.add(i2);
		Pilot p = new Pilot("Max");
		Flight f1 = new Flight("A10", "CDG", "Malte", LocalDate.parse("2021-08-03"), LocalTime.now(), "2h30", 75,
				"découverte", "Aeroport CDG", 4, "Venez découvrir Malte", passengers, p, a1);
		fleet.add(f1);
	}

	@Override
	public List<Flight> getAllFlights() {
		return this.fleet;
	}

	@Override
	public Boolean addFlight(Flight f) {
		return this.fleet.add(f);

	}

	@Override
	public Flight SearchFlight(String direction) {
		for (Flight f : this.fleet) {
			if (f.getDirection().equals(direction)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public void modifyFlight(Flight f, String appointment) {
		f.setAppointment(appointment);
		System.out.println("The flight " + f.toString() + "is updated");

	}

	@Override
	public String getFlightDetail(String id) {
		for (Flight f : this.getAllFlights()) {
			if (f.getId().equals(id)) {
				return f.toString();
			}
		}
		return "No flight with this id found";
	}
}
