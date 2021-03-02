package com.example.jetty_jersy.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlightDAO {

	List<Flight> getFlights();
	boolean addFlight(Flight name);
	boolean deleteFlight(Flight name);
	Pilot getPilot(Flight name);
	List<Passenger> getPassengers(Flight name);
	
	
	
	
	String getAirport(Flight name);
	String getDirection(Flight name);
	LocalDate getDate(Flight name);
	LocalTime getTime(Flight name);
	String getDuration(Flight name);
	int getPrice(Flight name);
	String getDescription(Flight name);
	String getAppointment(Flight name);
	int getAvailableSeats(Flight name);
	
	
	
	
}
