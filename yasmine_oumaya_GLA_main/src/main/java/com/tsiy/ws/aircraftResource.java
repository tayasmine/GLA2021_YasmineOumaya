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

import com.tsiy.dao.Aircraft;
import com.tsiy.dao.AircraftDAO;
import com.tsiy.dao.DAOFactory;

@Path("/Aircraft")
public class aircraftResource implements AircraftDAO {

	// List<Aircraft> ac = DataBase.getAllAircrafts(); // elle va pas evoluer:
	// static: call it each time in ws

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Path("/Aircraft/getAircraft/{name}") public String
	 * getAircraftDetails(@PathParam("name") String tailNum) { return
	 * DAOFactory.getAircraftDAO().getElement(tailNum); }
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/All")
	public List<Aircraft> getAll() {
		return DAOFactory.getAircraftDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/getAircraft/{name}")
	public List<Aircraft> getElement(@PathParam("name") String tailNum) {
		return DAOFactory.getAircraftDAO().getElement(tailNum);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/addAircraft")
	public void addElement(Aircraft a) {
		DAOFactory.getAircraftDAO().addElement(a);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft/delete/{name}")
	public void deleteElement(@PathParam("name") String name) {
		DAOFactory.getAircraftDAO().deleteElement(name);
	}

	/*
	 * @POST
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Path("/Aircraft/Edit/{name}") public void editElement(@PathParam("name")
	 * String name, Aircraft elt) { DAOFactory.getAircraftDAO().editElement(name,
	 * elt); }
	 */

}
