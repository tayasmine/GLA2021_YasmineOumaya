package com.tsiy.dao;







import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Flight {
	@PrimaryKey
	@Persistent
	protected String id;
	
	@Persistent
	protected String departure;
	
	@Persistent
	protected String direction;
	@Persistent
	protected String date;
	protected String time;
	protected String duration;
	protected int price;
	protected String flighttype;
	protected String appointment;
	protected int availableseats;
	protected String description;
	protected String pilotid;
	protected String aircrafttype;

	public Flight(String id,String departure, String direction, String date, String time, String duration,
			int price, String flighttype, String appointment, int availableseats, String description, String pilot, String aircraft) {
		this.id=id;
		this.departure = departure;
		this.direction = direction;
		this.date = date;
		
		this.time = time;
		this.duration = duration;
		this.price = price;
		this.flighttype = flighttype;
		this.appointment = appointment;
		this.availableseats = availableseats;
		this.description = description;
		this.pilotid = pilot;
		this.aircrafttype = aircraft;
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

	public String getdeparture() {
		return departure;
	}

	public void setdeparture(String departure) {
		this.departure = departure;
	}

	public String getAircrafttype() {
		return aircrafttype;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	/*public List<Passenger> getPassengersid() {
		return passengersid;
	}*/

	/*public void setPassengersid(List<Passenger> pass) {
		this.passengersid = pass;
	}*/

	public String getPilotid() {
		return pilotid;
	}

	public void setPilot(String pilot) {
		this.pilotid = pilot;
	}



	@Override
	public String toString() {
		return "Flight [id=" + id + ", departure=" + departure + ", direction=" + direction + ", date=" + date
				+ ", time" + time + ", price=" + price + ", flighttype=" + flighttype + ", appointment=" + appointment
				+ ", availableseats=" + availableseats + ", description=" + description 
				+ ",pilot" + pilotid + ", Duration=" + duration + ",aircraft" + aircrafttype + "]";
	}

}