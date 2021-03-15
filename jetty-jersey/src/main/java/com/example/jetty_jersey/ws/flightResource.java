package com.example.jetty_jersey.ws;

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

import com.example.jetty_jersy.dao.DAO;
import com.example.jetty_jersy.dao.Flight;

public class flightResource {

	DAO ac = new DAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight")
	public List<Flight> getAllFlight() {
		if (ac == null) {
			throw new NotFoundException();
		}
		return ac.getFlights();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	public Response retrieveFlight(@PathParam("name") String flt) {
		for (Flight a : ac.getFlights()) {
			if (ac.getID(a).equals(flt)) {
				System.out.println("the flight id is:" + ac.getID(a));
			}
		}
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	public Response deleteFlight(@PathParam("name") String name) {
		for (Flight a : ac.getFlights()) {
			if (ac.getID(a).equals(name)) {
				System.out.println(ac.getID(a));
				ac.getFlights().remove(a);
				System.out.println("this flight was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
