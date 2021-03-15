package com.sky.jetty_jersy.dao;

import java.util.List;

public interface PilotDAO {

	String getPilotid(Pilot pilot);

	String getPilotName(Pilot pilot);

	String getPilotMail(Pilot pilot);

	String getPilotDescription(Pilot pilot);

	List<Flight> getPlannedFlights(Pilot pilot);

	boolean postaflight(Flight name);// the flight isposted

}
