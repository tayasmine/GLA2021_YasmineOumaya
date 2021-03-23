package com.tsiy.dao;

import java.util.List;

public interface FlightDAO {

	List<Flight> getAllFlights();

	Boolean addFlight(Flight f);

	String getFlightDetail(String id);

	Flight SearchFlight(String direction);

	void modifyFlight(Flight f, String appointment);
}
