package com.tsiy.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tsiy.dao.DAO;
import com.tsiy.dao.Passenger;

@Path("/passenger")
public class passengerResource {

	/*
	 * public static class Aircraft { public static String tailNumber; public static
	 * String aircraftType; public static int numOfSeats; public static List<String>
	 * previousFlights; }
	 */

	// List<Aircraft> aircrafts= new ArrayList<Aircraft>();

	DAO ac = new DAO();
	/*
	 * private static DAO dao=null; public static DAO getInstance() { return
	 * AircraftDAO.dao; }
	 */

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Path("/aircraft") //ce qu on ecrit dans le path est la fin de lappel //si {}
	 * on ecrit ce quon vet public List<Aircraft> getAircraft() { //List<Aircraft>
	 * fleet= new ArrayList<Aircraft>(); List<Aircraft> fleet=
	 * DAO.getInstance().getFleet(); return fleet; }
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger")
	public List<Passenger> getAllPassager() {
		if (ac == null) {
			throw new NotFoundException();
		}
		return ac.getPassengers();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{id}")
	public Passenger getPassangerDetail(@PathParam("id") String nom) {
		for (Passenger p : ac.getPassengers()) {
			if (ac.getPassengerName(p).equals(nom)) {
				System.out.println(ac.getPassengerid(p));
				System.out.println(ac.getPassengerName(p));
				System.out.println(ac.getPassengerMail(p));
				return p;
			}
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{id}")
	public Response retrievePassager(@PathParam("id") String name) {
		for (Passenger p : ac.getPassengers()) {
			if (ac.getPassengerName(p).equals(name)) {
				System.out.println("the passenger" + ac.getPassengerName(p) + "is founded");
			}
		}
		return Response.ok().build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{passager}")
	public Response putPassenger(@PathParam("passager") String name) {
		Passenger p = new Passenger(name);
		ac.getPassengers().add(p);
		System.out.println("Passenger " + ac.getPassengerName(p) + "is added");
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{name}")
	public Response deletePassenger(@PathParam("name") String name) {
		for (Passenger a : ac.getPassengers()) {
			if (ac.getPassengerName(a).equals(name)) {
				System.out.println(ac.getPassengerName(a));
				ac.getPassengers().remove(a);
				System.out.println("this aircraft was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
