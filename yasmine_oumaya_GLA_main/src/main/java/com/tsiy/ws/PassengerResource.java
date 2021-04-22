package com.tsiy.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Passenger;
import com.tsiy.dao.PassengerDAO;

@Path("/Passenger")
public class PassengerResource implements PassengerDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/All")
	public List<Passenger> getAll() {
		return DAOFactory.getPassengerDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/getPassenger/{name}")
	public List<Passenger> getElement(@PathParam("name") String nom) {
		return DAOFactory.getPassengerDAO().getElement(nom);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Passenger/addPassenger")
	public void addElement(Passenger p) {
		DAOFactory.getPassengerDAO().addElement(p);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Passenger/delete/{name}")
	public void deleteElement(@PathParam("name") String name) {
		DAOFactory.getPassengerDAO().deleteElement(name);
	}

}
