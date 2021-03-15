package com.fly.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sky.jetty_jersy.dao.Aircraft;
import com.sky.jetty_jersy.dao.DAO;

@Path("/Aircraft")
public class aircraftResource {

	// List<Aircraft> aircrafts= new ArrayList<Aircraft>();

	DAO ac = new DAO();
	// DaoSingletonFaactac;
	/*
	 * private static DAO dao=null; public static DAO getInstance() { return
	 * AircraftDAO; }
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
	@Path("/Aircraft")
	public List<Aircraft> getAircraftsDetails() {
		if (ac == null) {
			throw new NotFoundException();
		}
		return ac.getAircrafts();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/{name}")
	public Response retrieveAircraft(@PathParam("name") String Tail) {

		for (Aircraft a : ac.getAircrafts()) {
			if (ac.getTailnumber(a).equals(Tail)) {
				System.out.println("the tail number is:" + ac.getTailnumber(a));
			}
		}
		return Response.ok().build();
	}

	/*
	 * @PUT
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Path("/Aircraft/{name}") public Response putAircraft(@PathParam("name")
	 * Aircraft name) { ac.getAircrafts().add(name);
	 * System.out.println("aircraft added"); return Response.ok().build(); }
	 */

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/{name}")
	public Response deleteAircraft(@PathParam("name") String name) {
		for (Aircraft a : ac.getAircrafts()) {
			if (ac.getTailnumber(a).equals(name)) {
				System.out.println(ac.getTailnumber(a));
				ac.getAircrafts().remove(a);
				System.out.println("this aircraft was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
