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
import com.tsiy.dao.Pilot;
import com.tsiy.dao.PilotDAO;

@Path("/Pilot")
public class PilotResource implements PilotDAO {

	// List<Pilot> pilots = DataBase.getAllPilots();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot/getpilotbyid/{name}")
	public String getPilotDetails(@PathParam("name") String name) {
		List<Pilot> pilots = DataBase.getAllPilots();
		if (pilots == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getPilotDAO().getPilotDetails(name);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot/All")
	public List<Pilot> getAll() {
		List<Pilot> pilots = DataBase.getAllPilots();
		if (pilots == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getPilotDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{name}")
	public Pilot getElement(@PathParam("name") String name) {
		List<Pilot> pilots = DataBase.getAllPilots();
		if (pilots == null) {
			throw new NotFoundException();
		}
		return DAOFactory.getPilotDAO().getElement(name);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft")
	public void addElement(Pilot p) {
		List<Pilot> pilots = DataBase.getAllPilots();
		if (pilots.contains(p)) {
			throw new NotFoundException();
		}
		DAOFactory.getPilotDAO().addElement(p);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{name}")
	public void deleteElement(@PathParam("name") String name) {
		List<Pilot> pilots = DataBase.getAllPilots();
		if (!pilots.contains(getElement(name))) {
			throw new NotFoundException();
		}
		DAOFactory.getPilotDAO().deleteElement(name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot/Edit/{name}")
	public void editElement(@PathParam("name") String name, Pilot elt) {
		List<Pilot> pilots = DataBase.getAllPilots();
		if (!pilots.contains(elt)) {
			throw new NotFoundException();
		}
		DAOFactory.getPilotDAO().editElement(name, elt);
	}
}
