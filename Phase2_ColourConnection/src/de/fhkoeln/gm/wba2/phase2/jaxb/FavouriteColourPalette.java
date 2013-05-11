//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.11 um 08:59:45 PM CEST 
//


package de.fhkoeln.gm.wba2.phase2.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für FavouriteColourPalette complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FavouriteColourPalette">
 *   &lt;complexContent>
 *     &lt;extension base="{}Ref">
 *       &lt;sequence>
 *         &lt;element name="favourite_since" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FavouriteColourPalette", propOrder = {
    "favouriteSince"
})
public class FavouriteColourPalette
    extends Ref
{

    @XmlElement(name = "favourite_since", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar favouriteSince;

    /**
     * Ruft den Wert der favouriteSince-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFavouriteSince() {
        return favouriteSince;
    }

    /**
     * Legt den Wert der favouriteSince-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFavouriteSince(XMLGregorianCalendar value) {
        this.favouriteSince = value;
    }

}
