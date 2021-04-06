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

import com.tsiy.dao.Aircraft;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.DataBase;
import com.tsiy.dao.Flight;
import com.tsiy.dao.FlightDAO;
import com.tsiy.dao.Passenger;

public class FlightResource implements FlightDAO {

	List<Aircraft> ac = DataBase.getAllAircrafts();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/Details/{name}")
	public String getFlightDetail(@PathParam("name") String num) {
		if (ac == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getFlightDAO().getFlightDetail(num);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/All")
	public List<Flight> getAll() {
		if (ac == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getFlightDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	public Flight getElement(@PathParam("name") String num) {
		if (ac == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getFlightDAO().getElement(num);
	}

	@SuppressWarnings("unlikely-arg-type")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight")
	public void addElement(Flight a) {
		if (ac.contains(a)) {
			throw new NotFoundException();
		}
		DAOFactory.getFlightDAO().addElement(a);
	}

	@SuppressWarnings("unlikely-arg-type")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	public void deleteElement(@PathParam("name") String name) {
		if (!ac.contains(getElement(name))) {
			throw new NotFoundException();
		}
		DAOFactory.getFlightDAO().deleteElement(name);
	}

	@SuppressWarnings("unlikely-arg-type")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/Edit/{name}")
	public void editElement(@PathParam("name") String name, Flight elt) {
		if (!ac.contains(elt)) {
			throw new NotFoundException();
		}
		DAOFactory.getFlightDAO().editElement(name, elt);
	}

	// on fait quoi icii???

	@SuppressWarnings("unlikely-arg-type")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/{name}")
	@Override
	public List<Flight> SearchFlight(@PathParam("name") String direction) {
		if (ac == null || !ac.contains(direction)) {
			throw new NotFoundException();
		}
		return DAOFactory.getFlightDAO().SearchFlight(direction);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Flight/Edit/{name}")
	@Override
	public void Bookaflight(Passenger elt, @PathParam("name") String id) {
		if (ac == null) {
			throw new NotFoundException();
		}
		DAOFactory.getFlightDAO().Bookaflight(elt, id);
	}
}
