//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.11 um 08:59:45 PM CEST 
//


package de.fhkoeln.gm.wba2.phase2.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Colour_QNAME = new QName("", "colour");
    private final static QName _Users_QNAME = new QName("", "users");
    private final static QName _Colourpalettes_QNAME = new QName("", "colourpalettes");
    private final static QName _Followers_QNAME = new QName("", "followers");
    private final static QName _ColourConnection_QNAME = new QName("", "colour_connection");
    private final static QName _FavouriteColourpalettes_QNAME = new QName("", "favourite_colourpalettes");
    private final static QName _Colourpalette_QNAME = new QName("", "colourpalette");
    private final static QName _FavouriteColourpalette_QNAME = new QName("", "favourite_colourpalette");
    private final static QName _FavouriteColours_QNAME = new QName("", "favourite_colours");
    private final static QName _FavouriteColour_QNAME = new QName("", "favourite_colour");
    private final static QName _Comment_QNAME = new QName("", "comment");
    private final static QName _User_QNAME = new QName("", "user");
    private final static QName _Comments_QNAME = new QName("", "comments");
    private final static QName _Colours_QNAME = new QName("", "colours");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ColourPalette }
     * 
     */
    public ColourPalette createColourPalette() {
        return new ColourPalette();
    }

    /**
     * Create an instance of {@link ColourConnection }
     * 
     */
    public ColourConnection createColourConnection() {
        return new ColourConnection();
    }

    /**
     * Create an instance of {@link ColourConnection.Colourpalettes }
     * 
     */
    public ColourConnection.Colourpalettes createColourConnectionColourpalettes() {
        return new ColourConnection.Colourpalettes();
    }

    /**
     * Create an instance of {@link ColourConnection.Colourpalettes.Colourpalette }
     * 
     */
    public ColourConnection.Colourpalettes.Colourpalette createColourConnectionColourpalettesColourpalette() {
        return new ColourConnection.Colourpalettes.Colourpalette();
    }

    /**
     * Create an instance of {@link ColourConnection.Colours }
     * 
     */
    public ColourConnection.Colours createColourConnectionColours() {
        return new ColourConnection.Colours();
    }

    /**
     * Create an instance of {@link ColourConnection.Colours.Colour }
     * 
     */
    public ColourConnection.Colours.Colour createColourConnectionColoursColour() {
        return new ColourConnection.Colours.Colour();
    }

    /**
     * Create an instance of {@link ColourConnection.Users }
     * 
     */
    public ColourConnection.Users createColourConnectionUsers() {
        return new ColourConnection.Users();
    }

    /**
     * Create an instance of {@link generated.Colour }
     * 
     */
    public de.fhkoeln.gm.wba2.phase2.jaxb.Colour createColour() {
        return new de.fhkoeln.gm.wba2.phase2.jaxb.Colour();
    }

    /**
     * Create an instance of {@link Followers }
     * 
     */
    public Followers createFollowers() {
        return new Followers();
    }

    /**
     * Create an instance of {@link ColourPaletteList }
     * 
     */
    public ColourPaletteList createColourPaletteList() {
        return new ColourPaletteList();
    }

    /**
     * Create an instance of {@link UserList }
     * 
     */
    public UserList createUserList() {
        return new UserList();
    }

    /**
     * Create an instance of {@link FavouriteColourPaletteList }
     * 
     */
    public FavouriteColourPaletteList createFavouriteColourPaletteList() {
        return new FavouriteColourPaletteList();
    }

    /**
     * Create an instance of {@link FavouriteColourList }
     * 
     */
    public FavouriteColourList createFavouriteColourList() {
        return new FavouriteColourList();
    }

    /**
     * Create an instance of {@link FavouriteColourPalette }
     * 
     */
    public FavouriteColourPalette createFavouriteColourPalette() {
        return new FavouriteColourPalette();
    }

    /**
     * Create an instance of {@link FavouriteColour }
     * 
     */
    public FavouriteColour createFavouriteColour() {
        return new FavouriteColour();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link generated.User }
     * 
     */
    public de.fhkoeln.gm.wba2.phase2.jaxb.User createUser() {
        return new de.fhkoeln.gm.wba2.phase2.jaxb.User();
    }

    /**
     * Create an instance of {@link generated.Comments }
     * 
     */
    public de.fhkoeln.gm.wba2.phase2.jaxb.Comments createComments() {
        return new de.fhkoeln.gm.wba2.phase2.jaxb.Comments();
    }

    /**
     * Create an instance of {@link ColourList }
     * 
     */
    public ColourList createColourList() {
        return new ColourList();
    }

    /**
     * Create an instance of {@link Ref }
     * 
     */
    public Ref createRef() {
        return new Ref();
    }

    /**
     * Create an instance of {@link Follower }
     * 
     */
    public Follower createFollower() {
        return new Follower();
    }

    /**
     * Create an instance of {@link ColourRef }
     * 
     */
    public ColourRef createColourRef() {
        return new ColourRef();
    }

    /**
     * Create an instance of {@link ColourPalette.UsedColours }
     * 
     */
    public ColourPalette.UsedColours createColourPaletteUsedColours() {
        return new ColourPalette.UsedColours();
    }

    /**
     * Create an instance of {@link ColourConnection.Colourpalettes.Colourpalette.Comments }
     * 
     */
    public ColourConnection.Colourpalettes.Colourpalette.Comments createColourConnectionColourpalettesColourpaletteComments() {
        return new ColourConnection.Colourpalettes.Colourpalette.Comments();
    }

    /**
     * Create an instance of {@link ColourConnection.Colours.Colour.Comments }
     * 
     */
    public ColourConnection.Colours.Colour.Comments createColourConnectionColoursColourComments() {
        return new ColourConnection.Colours.Colour.Comments();
    }

    /**
     * Create an instance of {@link ColourConnection.Users.User }
     * 
     */
    public ColourConnection.Users.User createColourConnectionUsersUser() {
        return new ColourConnection.Users.User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link generated.Colour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "colour")
    public JAXBElement<de.fhkoeln.gm.wba2.phase2.jaxb.Colour> createColour(de.fhkoeln.gm.wba2.phase2.jaxb.Colour value) {
        return new JAXBElement<de.fhkoeln.gm.wba2.phase2.jaxb.Colour>(_Colour_QNAME, de.fhkoeln.gm.wba2.phase2.jaxb.Colour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "users")
    public JAXBElement<UserList> createUsers(UserList value) {
        return new JAXBElement<UserList>(_Users_QNAME, UserList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColourPaletteList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "colourpalettes")
    public JAXBElement<ColourPaletteList> createColourpalettes(ColourPaletteList value) {
        return new JAXBElement<ColourPaletteList>(_Colourpalettes_QNAME, ColourPaletteList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Followers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "followers")
    public JAXBElement<Followers> createFollowers(Followers value) {
        return new JAXBElement<Followers>(_Followers_QNAME, Followers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColourConnection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "colour_connection")
    public JAXBElement<ColourConnection> createColourConnection(ColourConnection value) {
        return new JAXBElement<ColourConnection>(_ColourConnection_QNAME, ColourConnection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FavouriteColourPaletteList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "favourite_colourpalettes")
    public JAXBElement<FavouriteColourPaletteList> createFavouriteColourpalettes(FavouriteColourPaletteList value) {
        return new JAXBElement<FavouriteColourPaletteList>(_FavouriteColourpalettes_QNAME, FavouriteColourPaletteList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColourPalette }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "colourpalette")
    public JAXBElement<ColourPalette> createColourpalette(ColourPalette value) {
        return new JAXBElement<ColourPalette>(_Colourpalette_QNAME, ColourPalette.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FavouriteColourPalette }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "favourite_colourpalette")
    public JAXBElement<FavouriteColourPalette> createFavouriteColourpalette(FavouriteColourPalette value) {
        return new JAXBElement<FavouriteColourPalette>(_FavouriteColourpalette_QNAME, FavouriteColourPalette.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FavouriteColourList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "favourite_colours")
    public JAXBElement<FavouriteColourList> createFavouriteColours(FavouriteColourList value) {
        return new JAXBElement<FavouriteColourList>(_FavouriteColours_QNAME, FavouriteColourList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FavouriteColour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "favourite_colour")
    public JAXBElement<FavouriteColour> createFavouriteColour(FavouriteColour value) {
        return new JAXBElement<FavouriteColour>(_FavouriteColour_QNAME, FavouriteColour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "comment")
    public JAXBElement<Comment> createComment(Comment value) {
        return new JAXBElement<Comment>(_Comment_QNAME, Comment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link generated.User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "user")
    public JAXBElement<de.fhkoeln.gm.wba2.phase2.jaxb.User> createUser(de.fhkoeln.gm.wba2.phase2.jaxb.User value) {
        return new JAXBElement<de.fhkoeln.gm.wba2.phase2.jaxb.User>(_User_QNAME, de.fhkoeln.gm.wba2.phase2.jaxb.User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link generated.Comments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "comments")
    public JAXBElement<de.fhkoeln.gm.wba2.phase2.jaxb.Comments> createComments(de.fhkoeln.gm.wba2.phase2.jaxb.Comments value) {
        return new JAXBElement<de.fhkoeln.gm.wba2.phase2.jaxb.Comments>(_Comments_QNAME, de.fhkoeln.gm.wba2.phase2.jaxb.Comments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColourList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "colours")
    public JAXBElement<ColourList> createColours(ColourList value) {
        return new JAXBElement<ColourList>(_Colours_QNAME, ColourList.class, null, value);
    }

}
