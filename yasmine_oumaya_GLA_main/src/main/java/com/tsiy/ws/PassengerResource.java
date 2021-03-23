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

import com.tsiy.dao.Passenger;
import com.tsiy.dao.PassengerDAOImpl;

@Path("/passenger")
public class PassengerResource {

	/*
	 * public static class Aircraft { public static String tailNumber; public static
	 * String aircraftType; public static int numOfSeats; public static List<String>
	 * previousFlights; }
	 */

	// List<Aircraft> aircrafts= new ArrayList<Aircraft>();

	PassengerDAOImpl ac = new PassengerDAOImpl();
	/*
	 * private static PassengerDAOImpl=null; public static PassengerDAOImpl
	 * getInstance() { return Aircraf PassengerDAOImpl; }
	 */

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Path("/aircraft") //ce qu on ecrit dans le path est la fin de lappel //si {}
	 * on ecrit ce quon vet public List<Aircraft> getAircraft() { //List<Aircraft>
	 * fleet= new ArrayList<Aircraft>(); List<Aircraft> fleet=
	 * PassengerDAOImpl.getInstance().getFleet(); return fleet; }
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger")
	public List<Passenger> getAllPassager() {
		if (ac == null) {
			throw new NotFoundException();
		}
		return ac.getAllPassengers();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{id}")
	public Passenger getPassangerDetail(@PathParam("id") String nom) {
		for (Passenger p : ac.getAllPassengers()) {
			if (p.getPassengerName().equals(nom)) {
				System.out.println(p.getPassengerid());
				System.out.println(p.getPassengerName());
				System.out.println(p.getPassengerMail());
				return p;
			}
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{id}")
	public Response retrievePassager(@PathParam("id") String name) {
		for (Passenger p : ac.getAllPassengers()) {
			if (p.getPassengerName().equals(name)) {
				System.out.println("the passenger" + p.getPassengerName() + "is found");
			}
		}
		return Response.ok().build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{passager}")
	public Response putPassenger(@PathParam("passager") String name) {
		Passenger p = new Passenger(name);
		ac.getAllPassengers().add(p);
		System.out.println("Passenger " + p.getPassengerName() + "is added");
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{name}")
	public Response deletePassenger(@PathParam("name") String name) {
		for (Passenger a : ac.getAllPassengers()) {
			if (a.getPassengerName().equals(name)) {
				System.out.println(a.getPassengerName());
				ac.getAllPassengers().remove(a);
				System.out.println("this aircraft was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
