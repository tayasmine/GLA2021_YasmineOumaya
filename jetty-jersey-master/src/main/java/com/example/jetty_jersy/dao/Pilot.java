package com.example.jetty_jersy.dao;

import java.util.List;

public class Pilot{
	 public String Pilotid;
	 String Pilotname;
	 String PilotMmail;
	 String PilotDescription;
	 List<Flight> plannedFlights;
	 public Pilot(String name) {
		 this.Pilotname=name;
	 }
	 
}