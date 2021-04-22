package com.tsiy.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Flight;
import com.tsiy.dao.FlightDAO;
import com.tsiy.dao.Passenger;
import com.tsiy.dao.Aircraft;


@Path("/Flight")
public class FlightResource implements FlightDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/All")
	public List<Flight> getAll() {
		return DAOFactory.getFlightDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/getFlight/{name}")
	public List<Flight> getElement(@PathParam("name") String id) {
		return DAOFactory.getFlightDAO().getElement(id);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/addFlight")
	public void addElement(Flight f) {
		DAOFactory.getFlightDAO().addElement(f);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/delete/{name}")
	public void deleteElement(@PathParam("name") String name) {
		DAOFactory.getFlightDAO().deleteElement(name);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	public List<Flight> SearchFlight(@PathParam("name") String direction) {
		return DAOFactory.getFlightDAO().SearchFlight(direction);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/Edit/{name}")
	public void Bookaflight(Passenger elt, @PathParam("name") String id) {
		DAOFactory.getFlightDAO().Bookaflight(elt, id);
	}

}
