package com.tsiy.dao;

import java.time.LocalDate;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Passenger {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	protected String passengerid;
	protected String passengerName;
	protected String passengerMail;
	protected int phonenumber;
	protected LocalDate birthdate;
	protected List<Flight> bookedflights;

	public Passenger() {

	}

	public Passenger(String name) {
		this.passengerName = name;

	}

	public Passenger(String passengerid, String passengerName, String passengerMail, int phonenumber,
			LocalDate birthdate, List<Flight> bookedflights) {
		super();
		this.passengerid = passengerid;
		this.passengerName = passengerName;
		this.passengerMail = passengerMail;
		this.phonenumber = phonenumber;
		this.birthdate = birthdate;
		this.bookedflights = bookedflights;
	}

	public String getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(String passengerid) {
		this.passengerid = passengerid;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerMail() {
		return passengerMail;
	}

	public void setPassengerMail(String passengerMail) {
		this.passengerMail = passengerMail;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<Flight> getBookedflights() {
		return bookedflights;
	}

	public void setBookedflights(List<Flight> bookedflights) {
		this.bookedflights = bookedflights;
	}

	@Override
	public String toString() {
		return "Passenger [passengerid=" + passengerid + ", passengerName=" + passengerName + ", passengerMail="
				+ passengerMail + ", phonenumber=" + phonenumber + "]";
	}

}
