package com.tsiy.dao;

public interface AircraftDAO extends DAO<Aircraft> {

	String getAircraftdetails(String tailnum);

}
