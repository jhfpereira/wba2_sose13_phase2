package de.fhkoeln.gm.wba2.phase2.rest_webservice.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.fhkoeln.gm.wba2.phase2.rest_webservice.DataHandler;

@Path("/colours")
public class ColoursResource {

	private DataHandler dh;
	
	public ColoursResource() {
		dh = DataHandler.getInstance();
	}
	
	/**
	 * Return a list of all existing colours
	 * 
	 * @return HTTP-Response
	 */
	@GET
	public Response getColours() {
		
		String colours_str = dh.getColours();
		
		return Response.ok().entity(colours_str).type(MediaType.APPLICATION_XML).build();
			
	}
	
}
