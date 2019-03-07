package com.restful.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/json/metallica")
public class JSONService {


    @GET @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World!123" ;
    }

    @GET @Path("/test/{param}")
	@Produces(MediaType.TEXT_PLAIN)
    public String sayHelloToUTF8(@PathParam("param") String username) {
        return "Hello1111 " + username;
    }

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();

	}

}