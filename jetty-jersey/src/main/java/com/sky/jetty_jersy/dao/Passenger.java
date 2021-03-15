package com.sky.jetty_jersy.dao;

import java.util.List;

public class Passenger {
	public String passengerid;
	String passengerName;
	String passengerMail;
	List<Flight> bookedflights;

	public Passenger(String name) {
		this.passengerName = name;
	}

}
