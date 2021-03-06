package de.fhkoeln.gm.wba2.phase2.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import de.fhkoeln.gm.wba2.phase2.jaxb.Colour;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourList;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourPalette;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourPalette.UsedColours;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourPaletteList;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourRef;
import de.fhkoeln.gm.wba2.phase2.jaxb.Comment;
import de.fhkoeln.gm.wba2.phase2.jaxb.Comments;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColour;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColourList;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColourPalette;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColourPaletteList;
import de.fhkoeln.gm.wba2.phase2.jaxb.Follower;
import de.fhkoeln.gm.wba2.phase2.jaxb.Followers;
import de.fhkoeln.gm.wba2.phase2.jaxb.ObjectFactory;
import de.fhkoeln.gm.wba2.phase2.jaxb.Ref;
import de.fhkoeln.gm.wba2.phase2.jaxb.User;
import de.fhkoeln.gm.wba2.phase2.jaxb.UserList;

public class RESTConnectionHandler {

    private String username;
    private String hostname;
    private int user_id;
    private int port;
    private WebResource service;

    public RESTConnectionHandler(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Check if a connection can be established
     * 
     * @return success or failed
     */
    public boolean checkConnection() {

        if (this.hostname == null || this.port <= 0)
            return false;

        this.service = Client.create().resource(
                "http://" + this.hostname + ":" + this.port);

        Socket sock = null;
        try {
            sock = new Socket(hostname, port);
            return true;
        } catch (IOException e) {
        } finally {
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException e) {
                }
            }
        }

        return false;
    }

    /**
     * Set the username
     * 
     * @param username username as string
     * @return registration was a success or a failure
     */
    public boolean register(String username) {
        this.username = username;

        User new_user = new User();
        new_user.setUsername(username);

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());

        XMLGregorianCalendar currGregCal;
        try {
            currGregCal = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(c);
            new_user.setDateOfRegistration(currGregCal);
        } catch (DatatypeConfigurationException e) {
        }

        ClientResponse cresp;
        try {
            cresp = service.path("/user").type(MediaType.APPLICATION_XML)
                    .entity(new_user)
                    .post(ClientResponse.class, JAXBTools.marshall(new_user));
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 201) {
            String location = cresp.getLocation().toString();

            ClientResponse subcresp;
            try {
                subcresp = Client.create().resource(location)
                        .accept(MediaType.APPLICATION_XML)
                        .get(ClientResponse.class);
            } catch (ClientHandlerException che) {
                return false;
            }

            if (subcresp.getStatus() == 200) {
                User user_record = subcresp.getEntity(User.class);
                user_id = user_record.getId().intValue();
            } else
                return false;
        } else
            return false;

        return true;
    }

    /**
     * Return a list of all colours (refs) know to the system
     * 
     * @return List of colour-refs
     */
    public List<ColourRef> getAllColours() {
        List<ColourRef> list = new ArrayList<ColourRef>();

        ClientResponse cresp;
        try {
            cresp = service.path("/colours").type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return list;
        }

        if (cresp.getStatus() == 200) {
            list = cresp.getEntity(ColourList.class).getColour();
        }

        return list;
    }

    /**
     * Return a list of all colourpalettes (refs) know to the system
     * 
     * @return List of colourpalette-refs
     */
    public List<Ref> getAllColourpalettes() {
        List<Ref> list = new ArrayList<Ref>();

        ClientResponse cresp;
        try {
            cresp = cresp = service.path("/colourpalettes")
                    .type(MediaType.APPLICATION_XML).get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return list;
        }

        if (cresp.getStatus() == 200) {
            list = cresp.getEntity(ColourPaletteList.class).getColourpalette();
        }

        return list;
    }

    /**
     * Return a list of all favourite colours
     * 
     * @return List of favourite colours
     */
    public List<FavouriteColour> getAllFavColours() {
        List<FavouriteColour> list = new ArrayList<FavouriteColour>();

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + user_id)
                    .path("/favouritecolours").type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return list;
        }

        if (cresp.getStatus() == 200) {
            list = cresp.getEntity(FavouriteColourList.class)
                    .getFavouriteColour();
        }

        return list;
    }

    /**
     * Return a list of all favourite colourpalettes
     * 
     * @return List of favourite colourpalettes
     */
    public List<FavouriteColourPalette> getAllFavColourpalettes() {
        List<FavouriteColourPalette> list = new ArrayList<FavouriteColourPalette>();

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + user_id)
                    .path("/favouritecolourpalettes")
                    .type(MediaType.APPLICATION_XML).get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return list;
        }

        if (cresp.getStatus() == 200) {
            list = cresp.getEntity(FavouriteColourPaletteList.class)
                    .getFavouriteColourpalette();
        }

        return list;
    }

    /**
     * Return a list of all users following the current user
     * 
     * @return List of followers
     */
    public List<Follower> getAllFollower() {
        List<Follower> list = new ArrayList<Follower>();

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + user_id)
                    .path("/followers").type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return list;
        }

        if (cresp.getStatus() == 200) {
            list = cresp.getEntity(Followers.class).getFollower();
        }

        return list;
    }

    /**
     * Return a list of all creations created by a certain user
     * 
     * @param uref Reference of the user
     * @return List of all creations (colourpalettes)
     */
    public List<Ref> getAllUserCreations(Ref uref) {
        ColourPaletteList cpl = new ColourPaletteList();

        ClientResponse cresp;
        try {

            cresp = service.path(uref.getRef()).path("/creations")
                    .type(MediaType.APPLICATION_XML).get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return cpl.getColourpalette();
        }

        if (cresp.getStatus() == 200) {
            cpl = cresp.getEntity(ColourPaletteList.class);
        }

        return cpl.getColourpalette();
    }

    /**
     * Return a colour
     * 
     * @param cref Reference of the colour
     * @return JAXBElement encapsulating the colour data
     */
    public Colour getColour(ColourRef cref) {

        ClientResponse cresp;
        try {
            cresp = service.path(cref.getRef()).type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return null;
        }

        if (cresp.getStatus() == 200) {
            return cresp.getEntity(Colour.class);
        }

        return null;
    }

    /**
     * Return a user
     * 
     * @param uref Reference of the user
     * @return JAXBElement encapsulating the user data
     */
    public User getUser(Ref uref) {

        ClientResponse cresp;
        try {
            cresp = service.path(uref.getRef()).type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return null;
        }

        if (cresp.getStatus() == 200) {
            return cresp.getEntity(User.class);
        }

        return null;
    }

    /**
     * Set a colour as favourite
     * 
     * @param ccode Colourcode
     * @return Success or Failure
     */
    public boolean setColourFavourite(String ccode) {

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + this.user_id)
                    .path("/favouritecolour").path("/" + ccode)
                    .put(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 204) {
            return true;
        }

        return false;
    }

    /**
     * Unset a colour as a favourite
     * 
     * @param ccode Colourcode
     * @return Success or Failure
     */
    public boolean unsetColourFavourite(String ccode) {
        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + this.user_id)
                    .path("/favouritecolour").path("/" + ccode)
                    .delete(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 204) {
            return true;
        }

        return false;
    }

    /**
     * Set a colourpalette as favourite
     * 
     * @param cpid ID of the colourpalette
     * @return Success or Failure
     */
    public boolean setColourPaletteFavourite(String cpid) {

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + this.user_id)
                    .path("/favouritecolourpalette").path("/" + cpid)
                    .put(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 204) {
            return true;
        }

        return false;
    }

    /**
     * Unset a colourpalette as a favourite
     * 
     * @param cpid Id of the colourpalette
     * @return Success or Failure
     */
    public boolean unsetColourPaletteFavourite(String cpid) {

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + this.user_id)
                    .path("/favouritecolourpalette").path("/" + cpid)
                    .delete(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 204) {
            return true;
        }

        return false;
    }

    /**
     * Return a Colourpalette
     * 
     * @param cpref Reference of the colourpalette
     * @return JAXBElement encapsulating the coloupalette data
     */
    public ColourPalette getColourPalette(Ref cpref) {

        ClientResponse cresp;
        try {
            cresp = service.path(cpref.getRef())
                    .type(MediaType.APPLICATION_XML).get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return null;
        }

        if (cresp.getStatus() == 200) {
            return cresp.getEntity(ColourPalette.class);
        }

        return null;
    }

    /**
     * Get the creator of a given colour
     * 
     * @param cref Reference of the colour
     * @return JAXBElement encapsulating the user data
     */
    public User getCreatorOfColour(ColourRef cref) {

        ClientResponse cresp;
        try {
            cresp = service.path(cref.getRef()).type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return null;
        }

        if (cresp.getStatus() == 200) {
            ClientResponse u_cresp;
            try {
                u_cresp = service
                        .path(cresp.getEntity(Colour.class).getCreator()
                                .getRef()).type(MediaType.APPLICATION_XML)
                        .get(ClientResponse.class);
            } catch (ClientHandlerException che) {
                return null;
            }

            if (u_cresp.getStatus() == 200) {
                return u_cresp.getEntity(User.class);
            }
        }

        return null;
    }

    /**
     * Get the creator of a given colourpalette
     * 
     * @param cpref Reference of the colour
     * @return JAXBElement encapsulating the user data
     */
    public User getCreatorOfColourpalette(Ref cpref) {

        ClientResponse cresp;
        try {
            cresp = service.path(cpref.getRef())
                    .type(MediaType.APPLICATION_XML).get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return null;
        }

        if (cresp.getStatus() == 200) {
            ClientResponse u_cresp;
            try {
                u_cresp = service
                        .path(cresp.getEntity(ColourPalette.class).getCreator()
                                .getRef()).type(MediaType.APPLICATION_XML)
                        .get(ClientResponse.class);
            } catch (ClientHandlerException che) {
                return null;
            }

            if (u_cresp.getStatus() == 200) {
                return u_cresp.getEntity(User.class);
            }
        }

        return null;
    }

    /**
     * Follow a given user
     * 
     * @param u JAXBElement of the user to be followed
     * @return Success or Failure
     */
    public boolean followUser(User u) {

        // a user shouldn't be able to follow himself
        if (u.getId().intValue() == this.user_id)
            return false;

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + u.getId())
                    .path("/follower").path("/" + this.user_id)
                    .type(MediaType.APPLICATION_XML).put(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 204) {
            return true;
        }

        return false;
    }

    /**
     * Unfollow a certain user
     * 
     * @param u JAXBElement of the user to be unfollowed
     * @return Success or Failure
     */
    public boolean unfollowUser(User u) {

        ClientResponse cresp;
        try {
            cresp = service.path("/user").path("/" + u.getId())
                    .path("/follower").path("/" + this.user_id)
                    .type(MediaType.APPLICATION_XML)
                    .delete(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 204) {
            return true;
        }

        return false;
    }

    /**
     * Create a new colour
     * 
     * @param colour_code Clourcode
     * @return Success or Failure
     */
    public boolean createColour(String colour_code) {
        Colour c = new Colour();
        Ref ru = new Ref();
        ru.setId(BigInteger.valueOf(this.user_id));
        ru.setRef("/user/" + this.user_id);

        c.setId(colour_code);
        c.setCreator(ru);

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date());
        XMLGregorianCalendar currGregCal;
        try {
            currGregCal = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gc);
            c.setDateOfCreation(currGregCal);
        } catch (DatatypeConfigurationException e) {
        }

        ClientResponse cresp;
        try {
            cresp = service.path("/colour").type(MediaType.APPLICATION_XML)
                    .entity(c)
                    .post(ClientResponse.class, JAXBTools.marshall(c));
        } catch (ClientHandlerException che) {
            return false;
        }

        if (cresp.getStatus() == 201) {
            return true;
        }

        return false;
    }

    /**
     * Create a new colourpalette
     * 
     * @param ccc List of colourcodes
     * @return New Ressource Location
     */
    public String createColourpalette(List<String> ccc) {

        String location = null;

        ColourPalette cp = new ColourPalette();
        Ref ru = new Ref();
        ru.setId(BigInteger.valueOf(this.user_id));
        ru.setRef("/user/" + this.user_id);

        cp.setCreator(ru);

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date());
        XMLGregorianCalendar currGregCal;
        try {
            currGregCal = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gc);
            cp.setDateOfCreation(currGregCal);
        } catch (DatatypeConfigurationException e) {
        }

        ColourPalette.UsedColours uc = new ColourPalette.UsedColours();

        for (int i = 0; i < ccc.size(); i++) {
            ColourRef cref = new ColourRef();
            cref.setId(ccc.get(i));
            cref.setRef("/colour/" + ccc.get(i));

            uc.getColour().add(cref);
        }

        cp.setUsedColours(uc);

        ClientResponse cresp;
        try {
            cresp = service.path("/colourpalette")
                    .type(MediaType.APPLICATION_XML).entity(cp)
                    .post(ClientResponse.class, JAXBTools.marshall(cp));

        } catch (ClientHandlerException che) {
            return null;
        }

        if (cresp.getStatus() == 201) {
            location = cresp.getLocation().toString();
            location = location
                    .substring(("http://" + this.hostname + ":" + this.port)
                            .length());
        }

        return location;
    }

    /**
     * Get all Users know to the system
     * 
     * @return List of users
     */
    public List<Ref> getAllUsers() {
        UserList list = new UserList();

        ClientResponse cresp;
        try {
            cresp = service.path("/users").type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return list.getUser();
        }

        if (cresp.getStatus() == 200) {
            list = cresp.getEntity(UserList.class);
        }

        return list.getUser();
    }

    /**
     * Get all followers for a certain user
     * 
     * @param uref Reference of the user
     * @return List of followers
     */
    public List<Follower> getAllFollowerForAUser(Ref uref) {
        Followers f_list = new Followers();

        ClientResponse cresp;
        try {
            cresp = service.path(uref.getRef()).path("/followers")
                    .type(MediaType.APPLICATION_XML).get(ClientResponse.class);
        } catch (ClientHandlerException che) {
            return f_list.getFollower();
        }

        if (cresp.getStatus() == 200) {
            f_list = cresp.getEntity(Followers.class);
        }

        return f_list.getFollower();
    }

    /**
     * Return the hostname
     * 
     * @return hostname
     */
    public String getHost() {
        return this.hostname;
    }

    /**
     * Return the user id
     * 
     * @return user id
     */
    public String getUserID(String username) {

        if (this.user_id > 0)
            return String.valueOf(this.user_id);
        else {
            if (username != null && username.length() > 0) {
                ClientResponse cresp = service.path("/users")
                        .queryParam("username", username)
                        .type(MediaType.APPLICATION_XML)
                        .get(ClientResponse.class);

                if (cresp.getStatus() == 200) {
                    UserList users_list = cresp.getEntity(UserList.class);

                    if (users_list.getUser().size() == 1) {
                        ClientResponse sub_cresp = service
                                .path(users_list.getUser().get(0).getRef())
                                .type(MediaType.APPLICATION_XML)
                                .get(ClientResponse.class);

                        if (sub_cresp.getStatus() == 200) {
                            User user_record = sub_cresp.getEntity(User.class);
                            user_id = user_record.getId().intValue();

                            return String.valueOf(this.user_id);
                        }
                    }
                }
            }
        }

        return null;
    }

}
