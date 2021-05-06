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
//import com.tsiy.dao.AircraftDAO;
import com.tsiy.dao.DAOFactory;

@Path("/Aircraft")
public class AircraftResource implements AircraftDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Aircraft> getAll() {
		return DAOFactory.getAircraftDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAircraft/{name}")
	public Aircraft getElement(@PathParam("name") String tailNum) {
		return DAOFactory.getAircraftDAO().getElement(tailNum);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addAircraft")
	public void addElement(Aircraft a) {
		DAOFactory.getAircraftDAO().addElement(a);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{tailnum}")
	public void deleteElement(@PathParam("tailnum") String tailnum) {
		DAOFactory.getAircraftDAO().deleteElement(tailnum);
	}

}
