package com.example.jetty_jersy.dao;

import java.util.List;

public class Aircraft {
	public String tailnumber;
	String aircrafttype;
	int numberofseats;
	List<Flight> previousFlights;
	
	public Aircraft() {}
	
	public Aircraft(String numb,String type,int num) {
		this.tailnumber=numb;
		this.aircrafttype=type;
		this.numberofseats=num;
	}
	

}
