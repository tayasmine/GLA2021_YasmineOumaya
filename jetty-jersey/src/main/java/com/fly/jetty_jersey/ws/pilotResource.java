package com.fly.jetty_jersey.ws;

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

import com.sky.jetty_jersy.dao.DAO;
import com.sky.jetty_jersy.dao.Pilot;

@Path("/Pilot")
public class pilotResource {

	DAO p = new DAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public List<Pilot> getAllPilots() {
		if (p == null) {
			throw new NotFoundException();
		}
		return p.getPilots();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{id}")
	public Pilot getPassangerDetail(@PathParam("id") String nom) {
		for (Pilot pi : p.getPilots()) {
			if (p.getPilotName(pi).equals(nom)) {
				System.out.println(p.getPilotid(pi));
				System.out.println(p.getPilotName(pi));
				System.out.println(p.getPilotMail(pi));
				System.out.println(p.getPilotDescription(pi));
				return pi;
			}
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{name}")
	public Response retrievePilot(@PathParam("name") String name) {

		for (Pilot a : p.getPilots()) {
			if (p.getPilotid(a).equals(name)) {
				System.out.println("the pilot id is:" + p.getPilotid(a));
			}
		}
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot/{name}")
	public Response deleteAircraft(@PathParam("name") String name) {
		for (Pilot a : p.getPilots()) {
			if (p.getPilotid(a).equals(name)) {
				System.out.println(p.getPilotid(a));
				p.getPilots().remove(a);
				System.out.println("this pilot was deleted from the system");
			}
		}
		return Response.ok().build();
	}

}
