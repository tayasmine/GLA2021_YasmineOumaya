package com.example.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.example.jetty_jersy.dao.*;



@Path("/Aircraft")
public class aircraftResource {
	
	
	//List<Aircraft> aircrafts= new ArrayList<Aircraft>();
	
	DAO ac=new DAO();
	//DaoSingletonFaactac;
	/*private static DAO dao=null;
	public static DAO getInstance() {
		return AircraftDAO;
	}*/

/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft") //ce qu on ecrit dans le path est la fin de lappel //si {} on ecrit ce quon vet
	public List<Aircraft> getAircraft() {
		//List<Aircraft> fleet= new ArrayList<Aircraft>();
		List<Aircraft> fleet= DAO.getInstance().getFleet();
		return fleet;
	}*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft")
	public List<Aircraft> getDetailAircraft() {
		return ac.getAircrafts();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft")
	public Response retrieveAircraft(Aircraft name) {
		System.out.println(ac.getTailnumber(name));
		return Response.ok().build();
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Aircraft")
	public Response putAircraft(Aircraft name) {
		System.out.println(ac.getTailnumber(name));
		return Response.ok().build();
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Aircraft")
	public Response deleteExample(Aircraft name) {
		name.tailnumber="";//remove id donc remove the aircraft
		System.out.println("this user was deleted");
		return Response.ok().build();
	}

}
