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



@Path("/Pilot")
public class pilotResource {
	
		
	DAO pilot=new DAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public List<Pilot> getDetailPilot() {
		return pilot.getPilots();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public Response retrievePilot(Pilot name) {
		System.out.println(pilot.getPilotid(name));
		return Response.ok().build();
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public Response putPilot(Pilot name) {
		System.out.println(pilot.getPilotid(name));
		return Response.ok().build();
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public Response deleteExample(Pilot name) {
		name.Pilotid="";//remove id donc remove the Pilot
		System.out.println("this user was deleted");
		return Response.ok().build();
	}

}
