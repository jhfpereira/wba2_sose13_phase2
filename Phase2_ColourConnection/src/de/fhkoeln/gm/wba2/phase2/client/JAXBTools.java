package de.fhkoeln.gm.wba2.phase2.client;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import de.fhkoeln.gm.wba2.phase2.jaxb.Colour;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourList;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourPalette;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourPaletteList;
import de.fhkoeln.gm.wba2.phase2.jaxb.Comment;
import de.fhkoeln.gm.wba2.phase2.jaxb.Comments;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColour;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColourList;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColourPalette;
import de.fhkoeln.gm.wba2.phase2.jaxb.FavouriteColourPaletteList;
import de.fhkoeln.gm.wba2.phase2.jaxb.Followers;
import de.fhkoeln.gm.wba2.phase2.jaxb.ObjectFactory;
import de.fhkoeln.gm.wba2.phase2.jaxb.User;
import de.fhkoeln.gm.wba2.phase2.jaxb.UserList;

public final class JAXBTools {
    
    private JAXBTools(){}
    
    /**
     * Unmarshall given xml data
     * 
     * @param str raw xml data
     * @param c class used as base to unmarshall the data
     * @return JAXBElement
     */
    public static Object unmarshall(String str, Class<?> c) {
        
        Object element = null;
        
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller um = context.createUnmarshaller();
            element = um.unmarshal(new StreamSource(new StringReader(str)), c).getValue();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return element;
    }
    
    /**
     * Marshall a xml structure (JAXBElement)
     * 
     * @param instance instance of a JAXBElement
     * @return marshalled structure
     */
    public static String marshall(Object instance) {
        
        if(instance == null)
            return null;
        
        String str = null;
        
        ObjectFactory of = new ObjectFactory();
        JAXBElement<?> jaxbe = null;
        
        switch(instance.getClass().getSimpleName()) {
            case "Colour":
                jaxbe = of.createColour((Colour)instance);
                break;
            case "UserList":
                jaxbe = of.createUsers((UserList)instance);
                break;
            case "ColourPalette":
                jaxbe = of.createColourpalette((ColourPalette)instance);
                break;
            case "ColourPaletteList":
                jaxbe = of.createColourpalettes((ColourPaletteList)instance);
                break;
            case "Followers":
                jaxbe = of.createFollowers((Followers)instance);
                break;
            case "FavouriteColourPaletteList":
                jaxbe = of.createFavouriteColourpalettes((FavouriteColourPaletteList)instance);
                break;
            case "FavouriteColourPalette":
                jaxbe = of.createFavouriteColourpalette((FavouriteColourPalette)instance);
                break;
            case "FavouriteColourList":
                jaxbe = of.createFavouriteColours((FavouriteColourList)instance);
                break;
            case "FavouriteColour":
                jaxbe = of.createFavouriteColour((FavouriteColour)instance);
                break;
            case "Comment":
                jaxbe = of.createComment((Comment)instance);
                break;
            case "Comments":
                jaxbe = of.createComments((Comments)instance);
                break;
            case "User":
                jaxbe = of.createUser((User)instance);
                break;
            case "ColourList":
                jaxbe = of.createColours((ColourList)instance);
                break;
            default:
                return null;
        }
        
        try {
            JAXBContext context = JAXBContext.newInstance(instance.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            ByteArrayOutputStream string_out = new ByteArrayOutputStream();
            
            m.marshal(jaxbe, string_out);
            
            str = string_out.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return str;
    }
    
}
