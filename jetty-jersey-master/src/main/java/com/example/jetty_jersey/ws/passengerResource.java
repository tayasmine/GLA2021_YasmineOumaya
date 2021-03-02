package com.example.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.example.jetty_jersy.dao.*;



@Path("/passenger")
public class passengerResource {

	/*public static class Aircraft {
		public static String tailNumber;
		public static String aircraftType;
		public static int numOfSeats;
		public static List<String> previousFlights;
	}*/
	
	
	//List<Aircraft> aircrafts= new ArrayList<Aircraft>();
	
	DAO ac=new DAO();
	/*private static DAO dao=null;
	public static DAO getInstance() {
		return AircraftDAO.dao;
	}*/

/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft") //ce qu on ecrit dans le path est la fin de lappel //si {} on ecrit ce quon vet
	public List<Aircraft> getAircraft() {
		//List<Aircraft> fleet= new ArrayList<Aircraft>();
		List<Aircraft> fleet= DAO.getInstance().getFleet();
		return fleet;
	}*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public List<Passenger> getAllPassager() {
		return ac.getPassengers();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/passenger")
	public Response retrievePassager(Passenger name) {
		System.out.println(ac.getPassengerid(name));
		return Response.ok().build();
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pasenger")
	public Response putAircraft(Passenger passager) {
		System.out.println(ac.getPassengerid(passager));
		return Response.ok().build();
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/passenger")
	public Response deleteExample(Passenger passager) {
		passager.passengerid="";
		System.out.println("this user was deleted");
		return Response.ok().build();
	}

}
