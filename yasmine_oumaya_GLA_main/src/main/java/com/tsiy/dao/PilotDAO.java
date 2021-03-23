package com.tsiy.dao;

import java.util.List;

public interface PilotDAO {
	List<Pilot> getAllPilots();

	String getPilotDetail(String id);

	boolean postaflight(Pilot p, Flight name);

}
