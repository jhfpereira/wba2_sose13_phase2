package de.fhkoeln.gm.wba2.phase2.rest_webservice.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.fhkoeln.gm.wba2.phase2.rest_webservice.Config;
import de.fhkoeln.gm.wba2.phase2.rest_webservice.DataHandler;

@Path("/user")
public class UserResource {

	private DataHandler dh;
	
	public UserResource() {
		dh = DataHandler.getInstance();
	}
	
	
	/**
	 * Create a new user
	 * 
	 * @param body XML structure with data of given user to be created
	 * @return HTTP-Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response createUser(String body) {
		
		String user_id = dh.createUser(body);
		
		if(user_id != null) {
			
			String location = Config.hostname + ":" + Config.port + "/user/" + user_id;
			
			return Response.status(201).header("Location", location).build();
		}
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Retrieve a user
	 * 
	 * @param user_id user id
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{user_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUser(@PathParam("user_id") String user_id) {
		
		String user_str = dh.getUser(user_id);
		
		if(user_str != null)
			return Response.ok().entity(user_str).type(MediaType.APPLICATION_XML).build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Update a users information/data
	 * 
	 * @param user_id user id
	 * @param body XML structure of data to be used to update a certain users information by
	 * @return HTTP-Response
	 */
	@PUT
	@Path("/{user_id}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateUser(@PathParam("user_id") String user_id, String body) {
		
		boolean success = dh.updateUser(user_id, body);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
		
	}
	
	
	/**
	 * Delete a user
	 * 
	 * @param user_id user id
	 * @return HTTP-Response
	 */
	@DELETE
	@Path("/{user_id}")
	public Response deleteUser(@PathParam("user_id") String user_id) {
		
		boolean success = dh.deleteUser(user_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
		
	}
	
	
	/**
	 * Retrieve all creations by a user
	 * 
	 * @param user_id user id
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{user_id}/creations")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserCreations(@PathParam("user_id") String user_id) {
		
		String creations_str = dh.getUserCreations(user_id);
		
		if(creations_str != null)
			return Response.ok().entity(creations_str).type(MediaType.APPLICATION_XML).build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	
	/* #### Unterressource -> follower ##### */
	
	/**
	 * Set a user as a follower of a certain user
	 * 
	 * @param user_id id if the user being followed
	 * @param follower_id id of the user following
	 * @return HTTP-Response
	 */
	@PUT
	@Path("/{user_id}/follower/{follower_id}")
	public Response putUserFollower(@PathParam("user_id") String user_id, @PathParam("follower_id") String follower_id) {
		
		// a user should not be able to follow himself
		boolean success = (user_id.equals(follower_id)) ? false: dh.putUserFollower(user_id, follower_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Let a user unfollow a certain user
	 * 
	 * @param user_id id of the user being followed
	 * @param follower_id id of the user following
	 * @return HTTP-Response
	 */
	@DELETE
	@Path("/{user_id}/follower/{follower_id}")
	public Response deleteUserFollower(@PathParam("user_id") String user_id, @PathParam("follower_id") String follower_id) {
		
		boolean success = dh.deleteUserFollower(user_id, follower_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/* An example how an user can be unfollowed by giving the id of a follower through QueryParam instead of PathParam */
	
	/**
	 * Let a user unfollow a certain user (QueryParam is used instead of PathParam)
	 * 
	 * @param user_id id of the user being followed
	 * @param follower_id id of the user following
	 * @return HTTP-Response
	 */
	@DELETE
	@Path("/{user_id}/follower")
	public Response deleteUserFollowerByQueryParam(@PathParam("user_id") String user_id, @QueryParam("follower_id") String follower_id) {
		
		boolean success = dh.deleteUserFollower(user_id, follower_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Retrieve a list of all users following a certain user
	 * 
	 * @param user_id user id
	 * @returnLet a user unfollow a certain user
	 */
	@GET
	@Path("/{user_id}/followers")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserFollowers(@PathParam("user_id") String user_id) {
		
		String followers_str = dh.getUserFollowers(user_id);
		
		if(followers_str != null)
			return Response.ok().entity(followers_str).type(MediaType.APPLICATION_XML).build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	
	/* #### Unterressource -> favouritecolour ##### */
	
	/**
	 * Create a new favourite colour resource
	 * 
	 * @param user_id user id
	 * @param colour_id code of the colour to be set as a favourite
	 * @returnLet a user unfollow a certain user
	 */
	@PUT
	@Path("/{user_id}/favouritecolour/{colour_id}")
	public Response putUserFavouriteColour(@PathParam("user_id") String user_id, @PathParam("colour_id") String colour_id) {
		
		boolean success = dh.putUserFavouriteColour(user_id, colour_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Delete a favourite colour resource
	 * 
	 * @param user_id user id
	 * @param colour_id colour code
	 * @return
	 */
	@DELETE
	@Path("/{user_id}/favouritecolour/{colour_id}")
	public Response deleteUserFavouriteColour(@PathParam("user_id") String user_id, @PathParam("colour_id") String colour_id) {
		
		boolean success = dh.deleteUserFavouriteColour(user_id, colour_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Retrieve a list of all favourite colours of a certain user
	 * 
	 * @param user_id user id
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{user_id}/favouritecolours")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserFavouriteColours(@PathParam("user_id") String user_id) {
		
		String favouritecolours_str = dh.getUserFavouriteColours(user_id);
		
		if(favouritecolours_str != null)
			return Response.ok().entity(favouritecolours_str).type(MediaType.APPLICATION_XML).build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/* #### Unterressource -> favouritecolourpalette ##### */
	
	/**
	 * Create a new favourite colourpalette resource
	 * 
	 * @param user_id user id
	 * @param colourpalette_id colourpalette id
	 * @return
	 */
	@PUT
	@Path("/{user_id}/favouritecolourpalette/{colourpalette_id}")
	public Response putUserFavouriteColourPalette(@PathParam("user_id") String user_id, @PathParam("colourpalette_id") String colourpalette_id) {
		
		boolean success = dh.putUserFavouriteColourPalette(user_id, colourpalette_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Delete a existing favourite colourpalette resource
	 * 
	 * @param user_id user id
	 * @param colourpalette_id colourpalette id
	 * @return HTTP-Response
	 */
	@DELETE
	@Path("/{user_id}/favouritecolourpalette/{colourpalette_id}")
	public Response deleteUserFavouriteColourPalette(@PathParam("user_id") String user_id, @PathParam("colourpalette_id") String colourpalette_id) {
		
		boolean success = dh.deleteUserFavouriteColourPalette(user_id, colourpalette_id);
		
		if(success)
			return Response.noContent().build();
		else {
			return Response.status(404).build();
		}
	}
	
	
	/**
	 * Retrieve a list of all favourite colourpalettes of a certain user
	 * 
	 * @param user_id user id
	 * @return HTTP-Response
	 */
	@GET
	@Path("/{user_id}/favouritecolourpalettes")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUserFavouriteColourPalettes(@PathParam("user_id") String user_id) {
		
		String favouritecolourpalettes_str = dh.getUserFavouriteColourPalettes(user_id);
		
		if(favouritecolourpalettes_str != null)
			return Response.ok().entity(favouritecolourpalettes_str).type(MediaType.APPLICATION_XML).build();
		else {
			return Response.status(404).build();
		}
	}
}
