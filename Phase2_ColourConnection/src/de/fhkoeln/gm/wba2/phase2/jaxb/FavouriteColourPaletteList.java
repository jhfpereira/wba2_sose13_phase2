//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.11 um 08:59:45 PM CEST 
//


package de.fhkoeln.gm.wba2.phase2.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für FavouriteColourPaletteList complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FavouriteColourPaletteList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="favourite_colourpalette" type="{}FavouriteColourPalette" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FavouriteColourPaletteList", propOrder = {
    "favouriteColourpalette"
})
public class FavouriteColourPaletteList {

    @XmlElement(name = "favourite_colourpalette")
    protected List<FavouriteColourPalette> favouriteColourpalette;

    /**
     * Gets the value of the favouriteColourpalette property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the favouriteColourpalette property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavouriteColourpalette().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FavouriteColourPalette }
     * 
     * 
     */
    public List<FavouriteColourPalette> getFavouriteColourpalette() {
        if (favouriteColourpalette == null) {
            favouriteColourpalette = new ArrayList<FavouriteColourPalette>();
        }
        return this.favouriteColourpalette;
    }

}
