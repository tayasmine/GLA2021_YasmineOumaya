package com.tsiy.dao;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pilot {
	@PrimaryKey
	@Persistent
	protected String pilotid;
	protected String pilotName;
	protected String description;
	protected String pilotMail;
	protected String password;
	protected String phonenumber;
	protected String birthdate;
	protected int flighthours;

	public Pilot(String pilotid, String pilotName, String description, String pilotMail, String password,
			String phonenumber, String birthdate, int flighthours) {
		this.pilotid = pilotid;
		this.pilotName = pilotName;
		this.description = description;
		this.pilotMail = pilotMail;
		this.password = password;
		this.phonenumber = phonenumber;
		this.birthdate = birthdate;
		this.flighthours = flighthours;
	}

	/*
	 * public Pilot(String id, String nom, String mail) { this.pilotid = id;
	 * this.pilotName = nom; this.pilotMail = mail;
	 * 
	 * }
	 */

	public Pilot() {
	}

	public Pilot(String name) {
		this.pilotName = name;
	}

	public String getPilotid() {
		return pilotid;
	}

	public void setPilotid(String pilotid) {
		this.pilotid = pilotid;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPilotMail() {
		return pilotMail;
	}

	public void setPilotMail(String pilotMail) {
		this.pilotMail = pilotMail;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlighthours() {
		return flighthours;
	}

	public void setFlighthours(int flighthours) {
		this.flighthours = flighthours;
	}

	@Override
	public String toString() {
		return "Pilot [pilotid=" + pilotid + ", pilotName=" + pilotName + ", description=" + description
				+ ", pilotMail=" + pilotMail + ", phonenumber=" + phonenumber + "]";
	}

}