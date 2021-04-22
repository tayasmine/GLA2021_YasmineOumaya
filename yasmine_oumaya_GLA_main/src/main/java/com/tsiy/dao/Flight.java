package com.tsiy.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
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
	Aircraft aircraft;

	public Flight(String id, String airport, String direction, LocalDate date, LocalTime time, String duration,
			int price, String flighttype, String appointment, int availableseats, String description,
			List<Passenger> passengers, Pilot pilot, Aircraft aircraft) {

		this.id = id;
		this.airport = airport;
		this.direction = direction;
		this.date = date;
		this.time = time;
		this.Duration = duration;
		this.price = price;
		this.flighttype = flighttype;
		this.appointment = appointment;
		this.availableseats = availableseats;
		this.description = description;
		this.passengers = passengers;
		this.pilot = pilot;
		this.aircraft = aircraft;
	}

	public Flight() {
	}

	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFlighttype() {
		return flighttype;
	}

	public void setFlighttype(String flighttype) {
		this.flighttype = flighttype;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public boolean edit(Flight elt) {
		if (!this.id.equals(elt.id)) {
			return false;
		}
		this.id = elt.id;
		this.airport = elt.airport;
		this.direction = elt.direction;
		this.date = elt.date;
		this.time = elt.time;
		this.Duration = elt.Duration;
		this.price = elt.price;
		this.flighttype = elt.flighttype;
		this.appointment = elt.appointment;
		this.availableseats = elt.availableseats;
		this.description = elt.description;
		this.passengers = elt.passengers;
		this.pilot = elt.pilot;
		this.aircraft = elt.aircraft;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airport=" + airport + ", direction=" + direction + ", date=" + date + ", time"
				+ time + ", price=" + price + ", flighttype=" + flighttype + ", appointment=" + appointment
				+ ", availableseats=" + availableseats + ", description=" + description + ",passengers" + passengers
				+ ",pilot" + pilot + ", Duration=" + Duration + ",aircraft" + aircraft + "]";
	}

}