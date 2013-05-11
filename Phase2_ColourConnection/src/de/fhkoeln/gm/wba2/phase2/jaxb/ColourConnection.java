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
 * <p>Java-Klasse für ColourConnection complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ColourConnection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="users">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="user" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{}User">
 *                           &lt;sequence>
 *                             &lt;element ref="{}favourite_colours"/>
 *                             &lt;element ref="{}favourite_colourpalettes"/>
 *                             &lt;element ref="{}followers"/>
 *                             &lt;element name="creations" type="{}ColourPaletteList"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="colours">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="colour" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{}Colour">
 *                           &lt;sequence>
 *                             &lt;element name="comments">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="colourpalettes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="colourpalette" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{}ColourPalette">
 *                           &lt;sequence>
 *                             &lt;element name="comments">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColourConnection", propOrder = {
    "users",
    "colours",
    "colourpalettes"
})
public class ColourConnection {

    @XmlElement(required = true)
    protected ColourConnection.Users users;
    @XmlElement(required = true)
    protected ColourConnection.Colours colours;
    @XmlElement(required = true)
    protected ColourConnection.Colourpalettes colourpalettes;

    /**
     * Ruft den Wert der users-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ColourConnection.Users }
     *     
     */
    public ColourConnection.Users getUsers() {
        return users;
    }

    /**
     * Legt den Wert der users-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ColourConnection.Users }
     *     
     */
    public void setUsers(ColourConnection.Users value) {
        this.users = value;
    }

    /**
     * Ruft den Wert der colours-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ColourConnection.Colours }
     *     
     */
    public ColourConnection.Colours getColours() {
        return colours;
    }

    /**
     * Legt den Wert der colours-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ColourConnection.Colours }
     *     
     */
    public void setColours(ColourConnection.Colours value) {
        this.colours = value;
    }

    /**
     * Ruft den Wert der colourpalettes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ColourConnection.Colourpalettes }
     *     
     */
    public ColourConnection.Colourpalettes getColourpalettes() {
        return colourpalettes;
    }

    /**
     * Legt den Wert der colourpalettes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ColourConnection.Colourpalettes }
     *     
     */
    public void setColourpalettes(ColourConnection.Colourpalettes value) {
        this.colourpalettes = value;
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
     *         &lt;element name="colourpalette" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{}ColourPalette">
     *                 &lt;sequence>
     *                   &lt;element name="comments">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "colourpalette"
    })
    public static class Colourpalettes {

        protected List<ColourConnection.Colourpalettes.Colourpalette> colourpalette;

        /**
         * Gets the value of the colourpalette property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the colourpalette property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getColourpalette().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ColourConnection.Colourpalettes.Colourpalette }
         * 
         * 
         */
        public List<ColourConnection.Colourpalettes.Colourpalette> getColourpalette() {
            if (colourpalette == null) {
                colourpalette = new ArrayList<ColourConnection.Colourpalettes.Colourpalette>();
            }
            return this.colourpalette;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{}ColourPalette">
         *       &lt;sequence>
         *         &lt;element name="comments">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "comments"
        })
        public static class Colourpalette
            extends ColourPalette
        {

            @XmlElement(required = true)
            protected ColourConnection.Colourpalettes.Colourpalette.Comments comments;

            /**
             * Ruft den Wert der comments-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link ColourConnection.Colourpalettes.Colourpalette.Comments }
             *     
             */
            public ColourConnection.Colourpalettes.Colourpalette.Comments getComments() {
                return comments;
            }

            /**
             * Legt den Wert der comments-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link ColourConnection.Colourpalettes.Colourpalette.Comments }
             *     
             */
            public void setComments(ColourConnection.Colourpalettes.Colourpalette.Comments value) {
                this.comments = value;
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
             *         &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
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
                "comment"
            })
            public static class Comments {

                protected List<Comment> comment;

                /**
                 * Gets the value of the comment property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the comment property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getComment().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Comment }
                 * 
                 * 
                 */
                public List<Comment> getComment() {
                    if (comment == null) {
                        comment = new ArrayList<Comment>();
                    }
                    return this.comment;
                }

            }

        }

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
     *         &lt;element name="colour" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{}Colour">
     *                 &lt;sequence>
     *                   &lt;element name="comments">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
    public static class Colours {

        protected List<ColourConnection.Colours.Colour> colour;

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
         * {@link ColourConnection.Colours.Colour }
         * 
         * 
         */
        public List<ColourConnection.Colours.Colour> getColour() {
            if (colour == null) {
                colour = new ArrayList<ColourConnection.Colours.Colour>();
            }
            return this.colour;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{}Colour">
         *       &lt;sequence>
         *         &lt;element name="comments">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "comments"
        })
        public static class Colour
            extends de.fhkoeln.gm.wba2.phase2.jaxb.Colour
        {

            @XmlElement(required = true)
            protected ColourConnection.Colours.Colour.Comments comments;

            /**
             * Ruft den Wert der comments-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link ColourConnection.Colours.Colour.Comments }
             *     
             */
            public ColourConnection.Colours.Colour.Comments getComments() {
                return comments;
            }

            /**
             * Legt den Wert der comments-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link ColourConnection.Colours.Colour.Comments }
             *     
             */
            public void setComments(ColourConnection.Colours.Colour.Comments value) {
                this.comments = value;
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
             *         &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
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
                "comment"
            })
            public static class Comments {

                protected List<Comment> comment;

                /**
                 * Gets the value of the comment property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the comment property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getComment().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Comment }
                 * 
                 * 
                 */
                public List<Comment> getComment() {
                    if (comment == null) {
                        comment = new ArrayList<Comment>();
                    }
                    return this.comment;
                }

            }

        }

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
     *         &lt;element name="user" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{}User">
     *                 &lt;sequence>
     *                   &lt;element ref="{}favourite_colours"/>
     *                   &lt;element ref="{}favourite_colourpalettes"/>
     *                   &lt;element ref="{}followers"/>
     *                   &lt;element name="creations" type="{}ColourPaletteList"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "user"
    })
    public static class Users {

        protected List<ColourConnection.Users.User> user;

        /**
         * Gets the value of the user property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the user property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUser().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ColourConnection.Users.User }
         * 
         * 
         */
        public List<ColourConnection.Users.User> getUser() {
            if (user == null) {
                user = new ArrayList<ColourConnection.Users.User>();
            }
            return this.user;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{}User">
         *       &lt;sequence>
         *         &lt;element ref="{}favourite_colours"/>
         *         &lt;element ref="{}favourite_colourpalettes"/>
         *         &lt;element ref="{}followers"/>
         *         &lt;element name="creations" type="{}ColourPaletteList"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "favouriteColours",
            "favouriteColourpalettes",
            "followers",
            "creations"
        })
        public static class User
            extends de.fhkoeln.gm.wba2.phase2.jaxb.User
        {

            @XmlElement(name = "favourite_colours", required = true)
            protected FavouriteColourList favouriteColours;
            @XmlElement(name = "favourite_colourpalettes", required = true)
            protected FavouriteColourPaletteList favouriteColourpalettes;
            @XmlElement(required = true)
            protected Followers followers;
            @XmlElement(required = true)
            protected ColourPaletteList creations;

            /**
             * Ruft den Wert der favouriteColours-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link FavouriteColourList }
             *     
             */
            public FavouriteColourList getFavouriteColours() {
                return favouriteColours;
            }

            /**
             * Legt den Wert der favouriteColours-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link FavouriteColourList }
             *     
             */
            public void setFavouriteColours(FavouriteColourList value) {
                this.favouriteColours = value;
            }

            /**
             * Ruft den Wert der favouriteColourpalettes-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link FavouriteColourPaletteList }
             *     
             */
            public FavouriteColourPaletteList getFavouriteColourpalettes() {
                return favouriteColourpalettes;
            }

            /**
             * Legt den Wert der favouriteColourpalettes-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link FavouriteColourPaletteList }
             *     
             */
            public void setFavouriteColourpalettes(FavouriteColourPaletteList value) {
                this.favouriteColourpalettes = value;
            }

            /**
             * Ruft den Wert der followers-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Followers }
             *     
             */
            public Followers getFollowers() {
                return followers;
            }

            /**
             * Legt den Wert der followers-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Followers }
             *     
             */
            public void setFollowers(Followers value) {
                this.followers = value;
            }

            /**
             * Ruft den Wert der creations-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link ColourPaletteList }
             *     
             */
            public ColourPaletteList getCreations() {
                return creations;
            }

            /**
             * Legt den Wert der creations-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link ColourPaletteList }
             *     
             */
            public void setCreations(ColourPaletteList value) {
                this.creations = value;
            }

        }

    }

}
