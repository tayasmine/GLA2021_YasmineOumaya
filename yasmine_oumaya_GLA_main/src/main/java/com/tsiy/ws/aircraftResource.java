package com.tsiy.ws;

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

import com.tsiy.dao.Aircraft;
import com.tsiy.dao.AircraftDAOImpl;

@Path("/Aircraft")
public class aircraftResource {

	AircraftDAOImpl ac = new AircraftDAOImpl(null);

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
		return ac.getAllAircrafts();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/{name}")
	public Response retrieveAircraft(@PathParam("name") String Tail) {

		for (Aircraft a : ac.getAllAircrafts()) {
			if (a.getTailnumber().equals(Tail)) {
				System.out.println(ac.getAircraftdetails(Tail));
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
		for (Aircraft a : ac.getAllAircrafts()) {
			if (a.getTailnumber().equals(name)) {
				System.out.println(a.getTailnumber());
				ac.getAllAircrafts().remove(a);
				System.out.println("this aircraft was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
