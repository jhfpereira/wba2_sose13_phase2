package de.fhkoeln.gm.wba2.phase2.rest_webservice.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.fhkoeln.gm.wba2.phase2.rest_webservice.Config;
import de.fhkoeln.gm.wba2.phase2.rest_webservice.DataHandler;

@Path("/colour")
public class ColourResource {

	private DataHandler dh;
	
	public ColourResource() {
		dh = DataHandler.getInstance();
	}
	
	/**
	 * Create a new colour
	 * 
	 * @param body XML structure with the data of the colour to be created
	 * @return HTTP-Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response createColour(String body) {
		
		String colour_id = dh.createColour(body);
		
		if(colour_id != null) {
			String location = Config.hostname + ":" + Config.port + "/colour/" + colour_id.toString();
			return Response.status(201).header("Location", location).build();
		}
		else {
			return Response.status(404).build();
		}
	}
	
	/**
	 * Retrieve a colour
	 * 
	 * @param colour_id colour code (hex code)
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{colour_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getColour(@PathParam("colour_id") String colour_id) {
		
		String colour_str = dh.getColour(colour_id);
		
		if(colour_str != null && colour_id.length() == 6)
			return Response.ok().entity(colour_str).build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Delete a comment connected to a colour
	 * 
	 * @param colour_id colour code (hex code)
	 * @param comment_id comment id (positive integer)
	 * @return HTTP-Response
	 */
	@DELETE
	@Path("/{colour_id}/comment/{comment_id}")
	public Response deleteColourComment(@PathParam("colour_id") String colour_id, @PathParam("comment_id") String comment_id) {
		
		boolean success = dh.deleteColourComment(colour_id, comment_id);
		
		if(success && colour_id.length() == 6)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	/**
	 * Retrieve a list of all comments connected to a colour
	 * 
	 * @param colour_id colour code (hex code)
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{colour_id}/comments")
	@Produces(MediaType.APPLICATION_XML)
	public Response getColourComments(@PathParam("colour_id") String colour_id) {
		
		String colourcomments_str = dh.getColourComments(colour_id);
		
		if(colourcomments_str != null && colour_id.length() == 6)
			return Response.ok().entity(colourcomments_str).build();
		else {
			return Response.status(404).build();
		}
	}
	

	/**
	 * Create a comment resource for a certain colour
	 * 
	 * @param colour_id colour code
	 * @param body XML structure of a given comment connected to a colour
	 * @return HTTP-Response
	 */
	@POST
	@Path("/{colour_id}/comment")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createColourComment(@PathParam("colour_id") String colour_id, String body) {
		
		String colour_comment_id = dh.createColourComment(colour_id, body);
		
		if(colour_comment_id != null && colour_id.length() == 6) {
			String location = Config.hostname + ":" + Config.port + "/colour/" + colour_id + "/comment/" + colour_comment_id;
			return Response.status(201).header("Location", location).build();
		}
		else {
			return Response.status(404).build();
		}
	}
	
}
