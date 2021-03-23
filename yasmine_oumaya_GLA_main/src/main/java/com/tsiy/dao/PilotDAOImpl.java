package com.tsiy.dao;

import java.util.List;

public class PilotDAOImpl implements PilotDAO {
	List<Pilot> pilots;

	public PilotDAOImpl() {
		Pilot i1 = new Pilot("Max");
		Pilot i2 = new Pilot("Nino");
		this.pilots.add(i1);
		this.pilots.add(i2);
	}

	@Override
	public List<Pilot> getAllPilots() {
		return this.pilots;
	}

	@Override
	public String getPilotDetail(String id) {
		for (Pilot p : this.getAllPilots()) {
			if (p.getPilotid().equals(id)) {
				return p.toString();
			}
		}
		return "Pilot not found";

	}

	@Override
	public boolean postaflight(Pilot p, Flight name) {

		return p.getListofflights().add(name);
	}

}
