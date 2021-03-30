package com.tsiy.dao;

import java.util.List;

public interface FlightDAO {

	List<Flight> getAllFlights();

	void addFlight(Flight f);

	String getFlightDetail(String id);

	List<Flight> SearchFlight(String direction);

	void modifyFlight(Flight f, String appointment);
}
