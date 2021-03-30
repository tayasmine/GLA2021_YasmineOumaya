package com.tsiy.dao;

import java.util.List;

public interface PassengerDAO {

	void addPassenger(Passenger p);

	String getPassengerDetail(String id);

	List<Passenger> getAllPassengers();

	boolean Bookaflight(Passenger pass, Flight name);

}
