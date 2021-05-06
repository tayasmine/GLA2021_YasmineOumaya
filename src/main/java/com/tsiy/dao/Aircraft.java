package com.tsiy.dao;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aircraft {
	@PrimaryKey
	@Persistent
	protected String tailnumber;
	
	protected String aircrafttype;
	protected int numberofseats;

	public String getTailnumber() {
		return tailnumber;
	}

	public void setTailnumber(String tailnumber) {
		this.tailnumber = tailnumber;
	}

	public String getAircrafttype() {
		return aircrafttype;
	}

	public void setAircrafttype(String aircrafttype) {
		this.aircrafttype = aircrafttype;
	}

	public int getNumberofseats() {
		return numberofseats;
	}

	public void setNumberofseats(int numberofseats) {
		this.numberofseats = numberofseats;
	}

	public Aircraft(String tailnumber, String aircrafttype, int numberofseats) {
		// super();
		this.tailnumber = tailnumber;
		this.aircrafttype = aircrafttype;
		this.numberofseats = numberofseats;
	}

	public Aircraft(String tailnumber) {
		this.tailnumber = tailnumber;
	}

	public Aircraft() {
	}

	public boolean edit(Aircraft a) {
		if (!this.tailnumber.equals(a.tailnumber)) {
			return false;
		}
		this.numberofseats = a.numberofseats;
		return true;
	}

	@Override
	public String toString() {
		return "Aircraft [tailnumber=" + tailnumber + ", aircrafttype=" + aircrafttype + ", numberofseats="
				+ numberofseats + "]";
	}
}