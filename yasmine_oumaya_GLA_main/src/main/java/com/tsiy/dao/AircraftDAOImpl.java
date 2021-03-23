package com.tsiy.dao;

import java.util.ArrayList;
import java.util.List;

public class AircraftDAOImpl implements AircraftDAO {
	List<Aircraft> aircrafts;

	public AircraftDAOImpl() {
		this.aircrafts = new ArrayList<Aircraft>();
		Aircraft a1 = new Aircraft("A75B09", "Boeing", 6);
		Aircraft a2 = new Aircraft("R78OP8", "Airbus", 9);
		Aircraft a3 = new Aircraft("LO4569", "Airbus", 4);
		this.aircrafts.add(a1);
		this.aircrafts.add(a2);
		this.aircrafts.add(a3);
	}

	@Override
	public String getAircraftdetails(String tailnum) {
		for (Aircraft a : this.aircrafts) {
			if (a.getTailnumber().equals(tailnum)) {
				return a.toString();
			}
		}
		return "Aircraf not founded";
	}

	@Override
	public List<Aircraft> getAllAircrafts() {
		return this.aircrafts;
	}
}
