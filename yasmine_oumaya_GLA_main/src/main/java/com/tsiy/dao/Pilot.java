package com.tsiy.dao;

import java.time.LocalDate;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pilot {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	protected String pilotid;
	protected String pilotName;
	protected String description;
	protected String pilotMail;
	protected int phonenumber;
	protected LocalDate birthdate;
	protected List<Flight> Listofflights;

	public Pilot(String pilotid, String pilotName, String description, String pilotMail, int phonenumber,
			LocalDate birthdate, List<Flight> listofflights) {
		this.pilotid = pilotid;
		this.pilotName = pilotName;
		this.description = description;
		this.pilotMail = pilotMail;
		this.phonenumber = phonenumber;
		this.birthdate = birthdate;
		Listofflights = listofflights;
	}

	public Pilot(String id, String nom, String mail) {
		this.pilotid = id;
		this.pilotName = nom;
		this.pilotMail = mail;

	}

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

	public List<Flight> getListofflights() {
		return Listofflights;
	}

	public void setListofflights(List<Flight> listofflights) {
		Listofflights = listofflights;
	}

	@Override
	public String toString() {
		return "Pilot [pilotid=" + pilotid + ", pilotName=" + pilotName + ", description=" + description
				+ ", pilotMail=" + pilotMail + ", phonenumber=" + phonenumber + "]";
	}

	public boolean edit(Pilot p) {
		if (!this.pilotid.equals(p.pilotid)) {
			return false;
		}
		this.pilotid = p.pilotid;
		this.pilotName = p.pilotName;
		this.pilotMail = p.pilotMail;
		this.phonenumber = p.phonenumber;
		this.birthdate = p.birthdate;
		return true;
	}

}