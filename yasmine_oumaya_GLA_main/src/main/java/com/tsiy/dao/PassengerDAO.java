package com.tsiy.dao;

import java.util.List;

public interface PassengerDAO {

	String getPassengerid(Passenger pass);

	String getPassengerName(Passenger pass);

	String getPassengerMail(Passenger pass);

	boolean Bookaflight(Passenger pass, Flight name);

	List<Flight> getBookedFlights(Passenger pass);

}
