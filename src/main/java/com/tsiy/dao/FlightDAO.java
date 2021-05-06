package com.tsiy.dao;



public interface FlightDAO extends DAO<Flight> {

	void addeditedElement(String flightid, String passengerid,int s);

	

	//List<String> getPassengers(String id);

	//void Bookaflight(Passenger pass, String id);
}
