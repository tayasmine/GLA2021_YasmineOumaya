package com.tsiy.dao;

import java.util.List;

public interface FlightDAO extends DAO<Flight> {

	String getFlightDetail(String id);

	List<Flight> SearchFlight(String direction);

	void Bookaflight(Passenger pass, String id);
}
