package de.fhkoeln.gm.wba2.phase2.rest_webservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.fhkoeln.gm.wba2.phase2.rest_webservice.DataHandler;

@Path("/colourpalettes")
public class ColourPalettesResource {

	private DataHandler dh;
	
	public ColourPalettesResource() {
		dh = DataHandler.getInstance();
	}
	
	/**
	 * Return a list of all existing colourpalettes
	 * 
	 * @return HTTP-Response
	 */
	@GET
	public Response getColourPalettes() {
		
		String colourpalettes_str = dh.getColourPalettes();
		
		return Response.ok().entity(colourpalettes_str).type(MediaType.APPLICATION_XML).build();
			
	}
	
}
