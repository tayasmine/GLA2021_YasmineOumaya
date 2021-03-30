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

import com.tsiy.dao.Flight;
import com.tsiy.dao.FlightDAOImpl;

public class FlightResource {

	FlightDAOImpl ac = new FlightDAOImpl(null);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight")
	public List<Flight> getAllFlight() {
		if (ac == null) {
			throw new NotFoundException();
		}
		return ac.getAllFlights();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	public Response retrieveFlight(@PathParam("name") String flt) {
		for (Flight a : ac.getAllFlights()) {
			if (a.getId().equals(flt)) {
				System.out.println("the flight id is:" + a.getId());
			}
		}
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	public Response deleteFlight(@PathParam("name") String name) {
		for (Flight a : ac.getAllFlights()) {
			if (a.getId().equals(name)) {
				System.out.println(a.getId());
				ac.getAllFlights().remove(a);
				System.out.println("this flight was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
