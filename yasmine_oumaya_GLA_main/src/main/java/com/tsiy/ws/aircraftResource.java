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
import com.tsiy.dao.AircraftDAO;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.DataBase;

@Path("/Aircraft")
public class aircraftResource implements AircraftDAO {

	List<Aircraft> ac = DataBase.getAllAircrafts();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/Details/{name}")
	public String getAircraftdetails(@PathParam("name") String tailNum) {
		if (ac == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getAircraftDAO().getAircraftdetails(tailNum);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/All")
	public List<Aircraft> getAll() {
		if (ac == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getAircraftDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/{name}")
	public Aircraft getElement(@PathParam("name") String tailNum) {
		if (ac == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getAircraftDAO().getElement(tailNum);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft")
	public void addElement(Aircraft a) {
		if (ac.contains(a)) {
			throw new NotFoundException();
		}
		DAOFactory.getAircraftDAO().addElement(a);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/{name}")
	public void deleteElement(@PathParam("name") String name) {
		if (!ac.contains(getElement(name))) {
			throw new NotFoundException();
		}
		DAOFactory.getAircraftDAO().deleteElement(name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/Edit/{name}")
	public void editElement(@PathParam("name") String name, Aircraft elt) {
		if (!ac.contains(elt)) {
			throw new NotFoundException();
		}
		DAOFactory.getAircraftDAO().editElement(name, elt);
	}

}
