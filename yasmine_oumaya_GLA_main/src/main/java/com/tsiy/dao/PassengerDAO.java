package com.tsiy.dao;

import java.util.List;

public interface PassengerDAO {

	String getPassengerDetail(String id);

	List<Passenger> getAllPassengers();

	void ModifyPassengerPhoneNum(Passenger pass, int num);

	boolean Bookaflight(Passenger pass, Flight name);

}
