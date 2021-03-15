package com.sky.jetty_jersy.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Flight {
	String id;
	String airport;
	String direction;
	LocalDate date;
	LocalTime time;
	String Duration;
	int price;
	String flighttype;
	String appointment;
	int availableseats;
	public String description;
	List<Passenger> passengers;
	Pilot pilot;

	public Flight(String id, String airport, String direction, LocalDate date, LocalTime time, String Duration,
			int price, String flighttype, String appointment, int availableseats, String description,
			List<Passenger> passengers, Pilot pilot) {
		this.id = id;
		this.airport = airport;
		this.direction = direction;
		this.date = date;
		this.time = time;
		this.Duration = Duration;
		this.price = price;
		this.flighttype = flighttype;
		this.appointment = appointment;
		this.availableseats = availableseats;
		this.description = description;
		this.passengers = passengers;
		this.pilot = pilot;

	}

}
