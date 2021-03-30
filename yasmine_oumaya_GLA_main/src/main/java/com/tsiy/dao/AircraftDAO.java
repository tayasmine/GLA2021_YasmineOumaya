package com.tsiy.dao;

import java.util.List;

public interface AircraftDAO {

	String getAircraftdetails(String tailnum);

	List<Aircraft> getAllAircrafts();

}
