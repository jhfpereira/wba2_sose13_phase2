package de.fhkoeln.gm.wba2.phase2.rest_webservice.resources;

import java.math.BigInteger;

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

@Path("/colourpalette")
public class ColourPaletteResource {

	private DataHandler dh;
	
	public ColourPaletteResource() {
		dh = DataHandler.getInstance();
	}
	
	/**
	 * Create a colourpalette resource
	 * 
	 * @param body XML structure of a colourpalette to be created
	 * @return HTTP-Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response createColourPalette(String body) {
		
		BigInteger colourpalette_id = dh.createColourPalette(body);
		
		if(colourpalette_id != null) {
			String location = Config.hostname + ":" + Config.port + "/colourpalette/" + colourpalette_id.toString();
			return Response.status(201).header("Location", location).build();
		}
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Retrieve a coloupalette resource identified by an id
	 * 
	 * @param colourpalette_id colourpalette id of the palette to be retrieved
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{colourpalette_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getColourPalette(@PathParam("colourpalette_id") String colourpalette_id) {
		
		String colourpalette_str = dh.getColourPalette(colourpalette_id);
		
		if(colourpalette_str != null)
			return Response.ok().entity(colourpalette_str).build();
		else {
			return Response.status(404).build();
		}
			
	}
	
	
	/**
	 * Delete a comment (by id) connected to a certain colourpalette
	 * 
	 * @param colourpalette_id colourpalette id
	 * @param comment_id comment id
	 * @return HTTP-Response
	 */
	@DELETE
	@Path("/{colourpalette_id}/comment/{comment_id}")
	public Response deleteColourPaletteComment(@PathParam("colourpalette_id") String colourpalette_id, @PathParam("comment_id") String comment_id) {
		
		boolean success = dh.deleteColourPaletteComment(colourpalette_id, comment_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Retrieve a list of all comments connected to a certain colourpalette
	 * 
	 * @param colourpalette_id colourpalette id
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{colourpalette_id}/comments")
	@Produces(MediaType.APPLICATION_XML)
	public Response getColourPaletteComments(@PathParam("colourpalette_id") String colourpalette_id) {
		
		String colourcomments_str = dh.getColourPaletteComments(colourpalette_id);
		
		if(colourcomments_str != null)
			return Response.ok().entity(colourcomments_str).build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Create a new comment connected to a certain colourpalette
	 * 
	 * @param colourpalette_id colourpalette id
	 * @param body XML structure of a given comment connected to a colourpalette
	 * @return HTTP-Response
	 */
	@POST
	@Path("/{colourpalette_id}/comment")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createColourPaletteComment(@PathParam("colourpalette_id") String colourpalette_id, String body) {
		
		String colourpalette_comment_id = dh.createColourPaletteComment(colourpalette_id, body);
		
		if(colourpalette_comment_id != null) {
			String location = Config.hostname + ":" + Config.port + "/colourpalette/" + colourpalette_id + "/comment/" + colourpalette_comment_id;
			return Response.status(201).header("Location", location).build();
		}
		else {
			return Response.status(404).build();
		}
	}
	
}
