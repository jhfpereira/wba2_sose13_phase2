package de.fhkoeln.gm.wba2.phase2.rest_webservice.resources;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.fhkoeln.gm.wba2.phase2.rest_webservice.DataHandler;

@Path("/users")
public class UsersResource {

	private DataHandler dh;
	
	public UsersResource() {
		dh = DataHandler.getInstance();
	}
	
	/**
	 * Return a list of all existing users
	 * 
	 * @return HTTP-Response
	 */
	@GET
	public Response getUsers(@DefaultValue("") @QueryParam("username") String username) {
		
	    if(username.length() == 0)
	        username = null;
	    
		String users_str = dh.getUsers(username);
		
		return Response.ok().entity(users_str).type(MediaType.APPLICATION_XML).build();
			
	}
	
}
