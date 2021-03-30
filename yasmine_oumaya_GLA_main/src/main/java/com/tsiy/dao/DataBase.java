package com.tsiy.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class DataBase implements PassengerDAO, FlightDAO, PilotDAO, AircraftDAO {

	// passenger
	List<Passenger> passengers;
	List<Flight> fleet;
	List<Pilot> pilots;

	public DataBase() {
		fleet = new ArrayList<Flight>();
		passengers = new ArrayList<>();

		Passenger i1 = new Passenger("Julien");
		Passenger i2 = new Passenger("Nawal");
		this.passengers.add(i1);
		this.passengers.add(i2);

		Aircraft a1 = new Aircraft("A75B09", "Boeing", 6);
		Pilot p = new Pilot("Max");
		Flight f1 = new Flight("A10", "CDG", "Malte", LocalDate.parse("2021-08-03"), LocalTime.now(), "2h30", 75,
				"découverte", "Aeroport CDG", 4, "Venez découvrir Malte", passengers, p, a1);
		fleet.add(f1);

		Pilot p1 = new Pilot("Max");
		Pilot p2 = new Pilot("Nino");
		this.pilots.add(p1);
		this.pilots.add(p2);
	}

	@Override
	public String getPassengerDetail(String id) {
		for (Passenger p : this.passengers) {
			if (p.getPassengerid().equals(id)) {
				return p.toString();
			}
		}
		return "No passenger with this id found";

	}

	@Override
	public List<Passenger> getAllPassengers() {
		return this.passengers;
	}

	@Override
	public boolean Bookaflight(Passenger pass, Flight name) {
		if (name.availableseats > 0) {
			name.passengers.add(pass);
			name.availableseats--;
			pass.getBookedflights().add(name);

			return true;
		} else {
			return false;
		}
	}

	// flight

	@Override
	public List<Flight> getAllFlights() {
		return this.fleet;
	}

	@Override
	public void addFlight(Flight f) {
		this.fleet.add(f);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> SearchFlight(String direction) {
		for (Flight f : this.fleet) {
			if (f.getDirection().equals(direction)) {
				return (List<Flight>) f;
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

	// pilot

	@Override
	public List<Pilot> getAllPilots() {
		return this.pilots;
	}

	@Override
	public String getPilotDetail(String id) {
		for (Pilot p : this.getAllPilots()) {
			if (p.getPilotid().equals(id)) {
				return p.toString();
			}
		}
		return "Pilot not found";

	}

	@Override
	public boolean postaflight(Pilot p, Flight name) {

		return p.getListofflights().add(name);
	}

	// aircraft: ya rien

}
