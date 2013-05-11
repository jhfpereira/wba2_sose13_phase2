//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.11 um 08:59:45 PM CEST 
//


package de.fhkoeln.gm.wba2.phase2.jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für ColourPalette complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ColourPalette">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creator" type="{}Ref"/>
 *         &lt;element name="date_of_creation" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="used_colours">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="colour" type="{}ColourRef" maxOccurs="10" minOccurs="2"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColourPalette", propOrder = {
    "creator",
    "dateOfCreation",
    "usedColours"
})
@XmlSeeAlso({
	de.fhkoeln.gm.wba2.phase2.jaxb.ColourConnection.Colourpalettes.Colourpalette.class
})
public class ColourPalette {

    @XmlElement(required = true)
    protected Ref creator;
    @XmlElement(name = "date_of_creation", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfCreation;
    @XmlElement(name = "used_colours", required = true)
    protected ColourPalette.UsedColours usedColours;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;

    /**
     * Ruft den Wert der creator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Ref }
     *     
     */
    public Ref getCreator() {
        return creator;
    }

    /**
     * Legt den Wert der creator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Ref }
     *     
     */
    public void setCreator(Ref value) {
        this.creator = value;
    }

    /**
     * Ruft den Wert der dateOfCreation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * Legt den Wert der dateOfCreation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfCreation(XMLGregorianCalendar value) {
        this.dateOfCreation = value;
    }

    /**
     * Ruft den Wert der usedColours-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ColourPalette.UsedColours }
     *     
     */
    public ColourPalette.UsedColours getUsedColours() {
        return usedColours;
    }

    /**
     * Legt den Wert der usedColours-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ColourPalette.UsedColours }
     *     
     */
    public void setUsedColours(ColourPalette.UsedColours value) {
        this.usedColours = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="colour" type="{}ColourRef" maxOccurs="10" minOccurs="2"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "colour"
    })
    public static class UsedColours {

        @XmlElement(required = true)
        protected List<ColourRef> colour;

        /**
         * Gets the value of the colour property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the colour property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getColour().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ColourRef }
         * 
         * 
         */
        public List<ColourRef> getColour() {
            if (colour == null) {
                colour = new ArrayList<ColourRef>();
            }
            return this.colour;
        }

    }

}
