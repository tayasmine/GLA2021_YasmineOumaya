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

public class flightResource {

		/*public static class Flight {
			public static String tailNumber;
			public static String FlightType;
			public static int numOfSeats;
			public static List<String> previousFlights;
		}*/
		
		
		//List<Flight>> Flights= new ArrayList<Flight>();
		
		DAO ac=new DAO();
		/*private static DAO dao=null;
		public static DAO getInstance() {
			return FlightDAO.dao;
		}*/

	/*	@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/Flight") //ce qu on ecrit dans le path est la fin de lappel //si {} on ecrit ce quon vet
		public List<Flight> getFlight() {
			//List<Flight> fleet= new ArrayList<Flight>();
			List<Flight> fleet= DAO.getInstance().getFleet();
			return fleet;
		}*/
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/Flight")
		public List<Flight> getAllFlight() {
			/*List<Object> fleet= new ArrayList<Object>();
			fleet.add(ac.getAirport(flt));
			fleet.add(ac.getDuration(flt));
			fleet.add(ac.getTime(flt));
			fleet.add(ac.getPrice(flt));
			fleet.add(ac.getDescription(flt));
			fleet.add(ac.getAppointment(flt));
			fleet.add(ac.getAvailableSeats(flt));
			return fleet;*/
			return ac.getFlights();
		}

		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/Flight")
		public Response retrieveFlight(Flight name) {
			System.out.println(ac.getDescription(name));
			return Response.ok().build();
		}
		
	/*	@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/{id}")
		public Response retrieveDetailFlight (Flight flt) { //ici jai mis ac mais ca doit etre DAO....
			List<Object> fleet= new ArrayList<Object>();
			fleet.add(ac.getAirport(flt));
			fleet.add(ac.getDuration(flt));
			fleet.add(ac.getTime(flt));
			fleet.add(ac.getPrice(flt));
			fleet.add(ac.getDescription(flt));
			fleet.add(ac.getAppointment(flt));
			fleet.add(ac.getAvailableSeats(flt));
			return Response.ok().build();
		}*/
		
		@PUT
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/pasenger")
		public Response putFlight(Flight flt) {
			System.out.println(ac.getDescription(flt));
			return Response.ok().build();
		}
		
		@DELETE 
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/Flight")
		public Response deleteExample(Flight flt) {
			flt.description="";
			System.out.println("this user was deleted");
			return Response.ok().build();
		}

}

