package com.tsiy.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tsiy.dao.Pilot;
import com.tsiy.dao.PilotDAOImpl;

@Path("/Pilot")
public class PilotResource {

	PilotDAOImpl p = new PilotDAOImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public List<Pilot> getAllPilots() {
		if (p == null) {
			throw new NotFoundException();
		}
		return p.getAllPilots();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{id}")
	public Pilot getPassangerDetail(@PathParam("id") String nom) {
		for (Pilot pi : p.getAllPilots()) {
			if (pi.getPilotName().equals(nom)) {
				System.out.println(pi.getPilotid());
				System.out.println(pi.getPilotName());
				System.out.println(pi.getPilotMail());
				System.out.println(pi.getDescription());
				return pi;
			}
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{name}")
	public Response retrievePilot(@PathParam("name") String name) {

		for (Pilot a : p.getAllPilots()) {
			if (a.getPilotid().equals(name)) {
				System.out.println("the pilot id is:" + a.getPilotid());
			}
		}
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{name}")
	public Response deleteAircraft(@PathParam("name") String name) {
		for (Pilot a : p.getAllPilots()) {
			if (a.getPilotid().equals(name)) {
				System.out.println(a.getPilotid());
				p.getAllPilots().remove(a);
				System.out.println("this pilot was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
