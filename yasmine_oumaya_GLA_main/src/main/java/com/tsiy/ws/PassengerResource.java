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

import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.DataBase;
import com.tsiy.dao.Passenger;
import com.tsiy.dao.PassengerDAO;

@Path("/passenger")
public class PassengerResource implements PassengerDAO {

	List<Passenger> passengers = DataBase.getAllPassengers();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/Details/{name}")
	public String getPassengerDetail(@PathParam("name") String nom) {
		if (passengers == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getPassengerDAO().getPassengerDetail(nom);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/All")
	public List<Passenger> getAll() {
		if (passengers == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getPassengerDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{name}")
	public Passenger getElement(@PathParam("name") String nom) {
		if (passengers == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getPassengerDAO().getElement(nom);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft")
	public void addElement(Passenger p) {
		if (passengers.contains(p)) {
			throw new NotFoundException();
		}
		DAOFactory.getPassengerDAO().addElement(p);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Passenger/{name}")
	public void deleteElement(@PathParam("name") String name) {
		if (!passengers.contains(getElement(name))) {
			throw new NotFoundException();
		}
		DAOFactory.getAircraftDAO().deleteElement(name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Passenger/Edit/{name}")
	public void editElement(@PathParam("name") String name, Passenger elt) {
		if (!passengers.contains(elt)) {
			throw new NotFoundException();
		}
		DAOFactory.getPassengerDAO().editElement(name, elt);
	}

}
