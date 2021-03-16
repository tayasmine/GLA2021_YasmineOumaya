package com.tsiy.dao;

import java.util.List;

public interface AircraftDAO {

	String getTailnumber(Aircraft plane);

	String getAircrafttype(Aircraft plane);

	int getNumberofseats(Aircraft plane);

	List<Flight> previousFlights(Aircraft plane);
}
