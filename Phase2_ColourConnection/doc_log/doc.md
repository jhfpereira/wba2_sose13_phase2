Fachhochschule Köln - Campus Gummersbach  
Web-basierte Anwendungen 2: Verteilte Systeme  

<a name="top"></a>

#Dokumentation 

1. [Idee](#idee)  
2. [Szenarien](#szenarien)  
    2.1. [Erstellung einer Farbe](#szenarien_farbe_erstellen)  
    2.2. [Farbe als Lieblingsfarbe festlegen](#szenarien_lieblingsfarbe_festlegen)  
    2.3. [Farbpalette erstellen](#szenarien_farbpalette_erstellen)  
    2.4. [Farbpalette als Lieblingspalette festlegen](#szenarien_lieblingsfarbpalette_festlegen)  
    2.5. [Farbe oder Farbpalette kommentieren](#szenarien_farbe_farbpalette_kommentieren)  
    2.6. [Lieblingsfarben eines Benutzers anzeigen](#szenarien_lieblingsfarben_eines_benutzers_anzeigen)  
    2.7. [Erzeugten Farbpaletten eines Benutzers anzeigen](#szenarien_erzeugten_farbpaletten_eines_benutzers_anzeigen)  
    2.8. [Anderen Benutzer abonnieren](#szenarien_anderen_benutzer_abonnieren)  
3. [URI- und Ressourcen-Design](#uri_ressourcen_design)  
    3.1. [Ressourcen](#uri_ressourcen_design_ressourcen)  
    3.2. [URI-Matrix](#uri_ressourcen_design_uri_matrix)  
4. [XML Schema](#xml_schema)  
    4.1. [Aufbau](#xml_schema_aufbau)  
5. [RESTful Webservice](#restful_webservice)  
    5.1. [Vorüberlegungen](#restful_webservice_vorueberlegungen)  
    5.2. [Aufbau](#restful_webservice_aufbau)  
    5.3. [Code-Ausschnitte](#restful_webservice_code_ausschnitte)  
    5.4. [Besonderheiten](#restful_webservice_besonderheiten)



***

##<a id="idee"></a>1. Idee
Für viele Designarbeiten kann es nötig sein, bestimmte Farbkombinationen und Farbpaletten zu erstellen, die miteinander harmonieren oder zusammen ein bestimmtes Gefühl hervorrufen.
Es gibt fast endlose Möglichkeiten unterschiedliche Farben anzuordnen.
Die Idee ist es nun Menschen die Möglichkeit zu geben, solche Farbkombinationen zu erstellen und mit anderen Farb-Enthusiasten zu teilen. Damit diese Farbkombinationen und Paletten von interessierten Menschen gefunden werden können, soll es für jeden einzelnen Möglich sein, Lieblingsfarben anzugeben.
Diese Lieblingsfarben werden dann herangezogen, um die Benutzer über neue Farbkombinationen, Farbpaletten und evtl. Farbmustern zu informieren, wenn eine oder mehrere dieser Lieblingsfarben für die Zusammenstellung verwendet wurden. Ein Benutzer wird somit immer über neue Kreationen, die ihn interessieren könnten, auf dem Laufenden gehalten.
Wenn einem Benutzer eine Farbpalette oder Muster mit seiner Lieblingsfarbe gefällt, kann dieser diese ebenfalls favorisieren bzw. als eine Lieblingspalette festlegen.
Zudem ist es einem Benutzer ebenfalls gestattet Kommentare zu einer bestimmten Farbe oder Farbpalette zu hinterlassen.
Um dem Projekt zusätzlich eine leichte Note eines sozialen Netzwerks zu verleihen, können Benutzer andere Benutzer folgen und dadurch ihre Erzeugnisse abonnieren.

<a class="right" href="#top">^ top</a>

##<a name="szenarien"></a>2. Szenarien

###<a name="szenarien_farbe_erstellen"></a>2.1 Erstellung einer Farbe
BenutzerIn A bemerkt, dass das die Platform noch über sehr wenige Farbeinträge verfügt. Er/Sie entscheidet sich einige Einträge für bekannte Farben zu erstellen.
Dazu gibt er/sie zu einer Farbe dessen Farbcode ein oder wählt sie über einen Farbwähler aus. Mit dem Absenden des Fabcodes wird auf der Platform ein eindeutiger Eintrag für diese Farbe erzeugt.
Der Eintrag wird mit dem Namen des Erzeugers verknüpft.

**Sequenz-Diagramm**
![Create colour](images/create_colour.png)


###<a name="szenarien_lieblingsfarbe_festlegen"></a>2.2 Farbe als Lieblingsfarbe festlegen
BenutzerIn A möchte gerne eine Farbe als eine Lieblingsfarbe angeben. Dazu gibt er/sie den Farbcode der Farbe an oder wählt sie über einen Farbwähler aus.
Da die Farbe noch nicht bekannt ist und nicht bekannte Farben nicht als Lieblingsfarbe gesetzt werden können, wird für sie vorher ein neuer eindeutiger Eintrag erzeugt und mit dem Namen des Erzeugers verknüpft.
Erst jetzt kann die Farbe als Lieblingsfarbe des/der Benutzers/in gesetzt werden.

**Sequenz-Diagramm**
![Set colour as favourite](images/set_colour_as_favourite.png)


###<a name="szenarien_farbpalette_erstellen"></a>2.3 Farbpalette erstellen
BenutzerIn B möchte eine neue Farbpalette erstellen und legt mindestens 3 Farben fest, da es die Mindestanzahl der Farben einer Farbpalette entspricht.
Für alle drei Farben wird der jeweilige Farbcode eingegeben oder über einen Farbwähler ausgewählt. Nach dem Zusammenstellen der Farbpalette, wird sie der Platform bekannt gemacht. Die Farbpalette wird mit dem Benutezrnamen des Erzeugers verknüpft und erhält eine eindeutige Identifizierungsnummer.
Wenn zu einer der verwendeten Farben noch kein Eintrag existiert, wird dieser automatisch erzeugt und mit dem Namen des Benutzers verknüpft.
Die Platform überprüft, gleichzeitig zum Erstellen der Farbpalette, ob eine der Farben die Lieblingsfarbe mehrerer BenutzerInnen ist und informiert diese über die soeben erzeugte Farbpalette, die deren Lieblingsfarbe verwendet.
In diesem Fall ergab die Überprüfung der verwendeten Faben, dass eine der Farben gleichzeitig die Lieblingsfarbe von BenutzerIn A ist. BenutzerIn A erhält eine Meldung bezüglich der neuen Farbpalette.

**Sequenz-Diagramm**
![Create colour palette](images/create_colour_palette.png)


###<a name="szenarien_lieblingsfarbpalette_festlegen"></a>2.4 Farbpalette als Lieblingspalette festlegen
BenutzerIn A gefällt eine Farbpalette so sehr, dass er/sie zu seinen/ihren Favoriten bzw. Lieblingspaletten hinzufügt.

**Sequenz-Diagramm**
![Set colour palette as favourite](images/set_colour_palette_as_favourite.png)


###<a name="szenarien_farbe_farbpalette_kommentieren"></a>2.5 Farbe oder Farbpalette kommentieren
BenutzerIn A ist von einer Farbpalette von BenutzerIn B so begeistert, dass er/sie ein Kommentar zu dieser verfasst und hinzufügt.

**Sequenz-Diagramm**
![Create comment for colour/palette](images/create_comment_for_colour_colourpalette.png)


###<a name="szenarien_lieblingsfarben_eines_benutzers_anzeigen"></a>2.6 Lieblingsfarben eines Benutzers anzeigen
BenutzerIn B lässt sich alle Lieblingsfarben von BenutzerIn A anzeigen.

**Sequenz-Diagramm**
![Get favourite colours](images/get_favourite_colours.png)


###<a name="szenarien_erzeugten_farbpaletten_eines_benutzers_anzeigen"></a>2.7. Erzeugten Farbpaletten eines Benutzers anzeigen
BenutzerIn A vermutet, dass BenutzerIn B neben einer ihrer Lieblingspaletten auch weitere schöne Farbpaletten erzeugt hat. Deshalb lässt sie sich alle von BenutzerIn B erzeugten Farbpaletten anzeigen.

**Sequenz-Diagramm**
![Get created palettes](images/get_created_palettes.png)


###<a name="szenarien_anderen_benutzer_abonnieren"></a>2.8. Anderen Benutzer abonnieren
Benutzer A ist von den von BenutzerIn B erzeugeten Paletten so sehr begeistert, dass sie auch in Zukunft über Farbpaletten von BenutzerIn B benachrichtig werden will.
Deshalb abonniert sie alle Erzeugnisse von BenutzerIn B. 

**Sequenz-Diagramm**
![Set user as follower](images/set_user_as_follower.png)


<a href="#top">^ top</a>


##<a name="uri_ressourcen_design"></a>3. URI- und Ressourcen-Design


###<a name="uri_ressourcen_design_ressourcen"></a>3.1. Ressourcen
Zu aller erst ist es wichtig zu wissen, dass für Farbe-Ressourcen ihr direkter Farbcode (HTML-Farbcode) als ID verwendet werden. Die Idee dahinter ist die, dass dadurch die API besser zu verstehen und zu überblicken ist. Für sich ist ein Farbcode eindeutig und wird über mehrere Bereiche hinweg als Identifizierungsmerkmal für eine Farbe verwendet.
Für jede Farbpalette muss aber hingegen eine neue eindeutige ID vergeben werden, da sie nur umständlich anhand ihrere natürlichen Merkmale identifiziert werden kann.  
Anhand der zuvor erstellten Szenarien kann man schon einige grundlegende Ressourcen festlegen.
Darunter fallen die Ressourcen `user`, `colour` sowie `colourpalette`.
Basierend auf diesen drei Ressourcen bilden sich weitere abgewandelte Ressourcen aber auch untergeordnete Ressourcen.
Als abgewandelte Ressourcen werden die Listen gezählt. Über die Ressource `users` würde man zu einer Liste aller exitierenden Benutzer gelangen. Eine Listen-Ressource ist an dem angehangenen `s` zu erkennen.
Zu der `users`-Ressource würden sich somit noch die beiden weiteren Listen-Ressourcen `colours` und `colourpalettes` hinzugesellen.  
Da es ganz hilfreich sein kann sich alle von einem Benutzer erstellten Farbpaletten geben zu lassen, wird der Ressource `user` die Unterressource `creations` vergeben, die sich auf einen bestimmten Benutzer bezieht. Folgende URI bietet sich an `/user/<user_id>/creations`. Das `s` gibt wieder an, dass es sich um eine Listen-Ressource handelt.  
Um eine Farbe als Favorit zu setzen, würde es sich weniger anbieten dafür eine eigene First-Level-Ressource einzuführen. Es macht viel mehr Sinn das Setzen einer Lieblingsfarbe mit dem entsprechenden Benutzer zu verbinden bzw. die Verbindung zu belassen.
Hierzu wird der `user`-Ressource eine untergeordnete Ressource mit dem Namen `favouritecolour` bzw. `favouritecolour` gegeben.
Zum Hinzufügen oder Löschen einer Favorisierung, muss dennoch die ID der favorisierten Farbe oder der Farbpalette angegeben werden. Dies sieht dann wie folgt aus: `PUT /user/42/favouritecolour/333333` bzw. `PUT /user/42/favouritecolourpalette/20` oder `DELETE /user/42/favouritecolour/333333` bzw. `DELETE /user/42/favouritecolourpalette/20`.
Aber auch hier soll es möglich sein sich eine Liste von allen Lieblingsfarben und Lieblingsfarbpaletten eines Benutzers geben zu lassen. Somit würde `/user/<user_id>/favourite/colours` bzw. `/user/<user_id>/favourite/colourpalettes` eine Liste aller Lieblingsfarben bzw. -farbpaletten liefern.
Mit der Möglichkeit Kommentare zu einer Farbe oder einer Farbpalette zu verfassen, kann auch hier eine neue untergeordnete Ressource mit dem Namen "comment" eingeführt werden. Auch hier würde ein `/color/<colour_id>/comments` eine Liste aller zu der Farbe verfassten Kommentare zurückgegeben werden. Das selbe auch mit `/colourpalette/<colour_palette_id>/comments`.  
Zuletzt können Benutzer von anderen Benutzern gefolgt werden. Dazu wird die untergeordnete Ressource `follower` eingeführt, die sich auf den angegebenen Benutzer bezieht. `followers` wäre somit wieder eine Listen-Ressource, die alle Benutzer auflistet, die den besagten Benutzer folgen. `follower` erlaubt es jetzt Benutzer als Follower hinzufügen und auch wieder zu entfernen. Dazu muss die ID des Benutzers aber mit angegeben werden wie z.B. wie folgt: `PUT /user/42/follower/23` sowie `DELETE /user/42/follower/23`. 

![Resource-Hierarchie](images/resource_hierarchie.png)


<a href="#top">^ top</a>


###<a name="uri_ressourcen_design_uri_matrix"></a>3.1. URI-Matrix

|  | GET | PUT | POST | DELETE |
| :------- | :----------: | :--------------: | :---------------: | :-----------------: |
| /user | - | - | Benutzer erstellen | - |  
| /user/&lt;user&#95;id> | Benutzerinformationen zurückgeben | Benutzerangaben aktualisieren | - | Benutzer löschen |
| /user/&lt;user&#95;id>/creations | Liste aller Farbpaletten zurückgeben | - | - | - |  
| /user/&lt;user&#95;id>/follower/&lt;user&#95;id> | - | Benutzer als Follower hinzufügen | - | Benutzer als Follower entfernen |  
| /user/&lt;user&#95;id>/followers | Liste aller Follower zurückgeben | - | - | - |  
| /user/&lt;user&#95;id>/favouritecolour/&lt;colour&#95;id> | - | Farbe als Lieblingsfarbe setzen | - | Farbe als Lieblingsfarbe entfernen |  
| /user/&lt;user&#95;id>/favouritecolours | Liste aller Lieblingsfarben des Benutzers zurückgeben | - | - | - |  
| /user/&lt;user&#95;id>/favouritecolourpalette/&lt;colourpalette_id> | - | Farbpalette als Lieblingsfarbpalette setzen | - | Farbpalette als Lieblingsfarbpalette entfernen |  
| /user/&lt;user&#95;id>/favouritecolourpalettes | Liste aller Lieblingsfarbpaletten zurückgeben | - | - | - |  
| /users | Liste aller Benutzer zurückgeben | - | - | - |  
|  | **GET** | **PUT** | **POST** | **DELETE** |  
| /colour | - | - | Farbe erstellen | - |  
| /colour/&lt;colour&#95;id> | Angaben über die Farbe zurückgeben | - | - | - |  
| /colour/&lt;colour&#95;id>/comment | - | - | Kommentar erstellen | - |  
| /colour/&lt;colour&#95;id>/comment/&lt;comment&#95;id> | - | - | - | Kommentar löschen |  
| /colour/&lt;colour&#95;id>/comments | Liste aller Kommentare zu einer Farbe zurückgeben | - | - | - |  
| /colours | Liste aller Farben zurückgeben | - | - | - |  
|  | **GET** | **PUT** | **POST** | **DELETE** |  
| /colourpalette | - | - | Farbpalette erstellen | - |  
| /colourpalette/&lt;colourpalette&#95;id> | Informationen über die Farbpalette zurückgeben | - | - | - |  
| /colourpalette/&lt;colourpalette&#95;id>/comment | - | - | Kommentar erstellen | - |  
| /colourpalette/&lt;colourpalette&#95;id>/comment/&lt;comment&#95;id> | - | - | - | Kommentar löschen |  
| /colourpalette/&lt;colourpalette&#95;id>/comments | Liste aller Kommentare zu einer Farbpalette zurückgeben | - | - | - |  
| /colourpalettes | Liste aller Farbpaletten zurückgeben | - | - | - |   


<a href="#top">^ top</a>



##<a name="xml_schema"></a>4. XML Schema

Neben dem URI- und Ressourcen Design, muss auch das XML Schema, auf welches im Projekt sehr stark gesetzt wird, wohlüberlegt konzipiert werden.
Deshalb bietet es sich an das Schema Schritt für Schritt eine solide Basis zu definieren, auf die die restliche Struktur aufsetzt. Konkret sieht das so aus, dass die im Unterpunkt 3.1 identifizierten grundlegenden Ressourcen `user`, `colour` sowie `colourpalette` als zuvor erwähnte Basis herangezogen werden.
Sie bilden die grundlegenden Ressourcen, aus denen sich Variationen bilden. Speziell sei das Beispiel `colour` und `favourite_colour` genannt. `favourite_colour` ist an sich ebenfalls eine Ressource, die eine Ableitung von `colour` darstellt. Der einzige Unterschied besteht nur in der zusätzlichen Angabe des Zeitpunkts wann eine Farbe als Lieblingsfarbe gesetzt wurde.
Hier kann man sich leicht der Objektorientierung bedienen, speziell der Vererbung. Dies bietet sich auch sehr gut an, da ein XML Schema einem ähnliche Möglichkeiten zur Strukturierung bzw. Aufbau bietet. Hier sei auf die Möglichkeiten der Erweiterung (`extension`) und der Restriktion (`restriction`) von komplexen Typen hingewiesen. In diesem Fall setzt man aber konkret nur auf die Möglichkeit der Erweiterung, um Typen gezielt zu spezialisieren.
Neben Spezialisierungen von Typen bzw. Elementen, wird auch das Zusammenfassen von solchen Elementen zu Mengen betrachtet. Damit ist gemeint, dass ein übergeodnetes Element existiert, welches als Container fungiert. Dies kann man ganz gut mittels der Ressource `users` verdeutlichen. Die Ressource repräsentiert eine Liste die aus mehreren User-Ressourcen (`user`) besteht. Dadurch, dass es über die REST-Schnittstelle möglich ist eine Liste aller Benutzer anzufordern, bietet es sich auch an auf Seiten von XML ein Listen- bzw. Container-Element einzuführen.
Listen gibt es nicht nur für Benutzer (`users`), sondern auch zur Auflistung von Farben (`colours`), Lieblingsfarben (`favourite_colours`), Lieblingsfarbpaletten (`favourite_colourpalettes`) aber auch von Benutzern die einen bestimmten Benutzer folgen, sognannte Follower (`followers`).  
Eine Besonderheit des XML Schemas ist es, dass es Dokumente mit unterschiedlichen Wurzelelementen erfolgreich validiert. Im Gegensatz zur Phase 1, wo das konzipierte Schema nur ein Wurzelelement vorsah, ist dieses Schema der Phase 2 sehr viel flexibler gestaltet. In Phase 1 wurden die Daten so modelliert, dass eine Dokumenteninstanz wirklich alle aufgekommenen Daten enthielt. Für den Anwendungsfall ist dies sicherlich die beste herangehensweise, doch für Phase 2 nicht mehr. Hier sollten nur Daten zwischen einem Clienten und einem Server transportiert werden, die entsprechend des Kontexts relevant sind.
Mit Kontext ist hiermit die Semantik der HTTP-Operationen gemeint. Es ist somit weniger sinnvoll wenn ein Request wie z.B. `GET /user/1` einem Clienten neben den Informationen zum Benutzer mit der ID 1, auch alle anderen Informationen bzw. Daten des Systems liefert, die nichts mit der klar identifizierten Ressource zu tun hat. Es würde völlig ausreichen nur den relevanten Teil der kompletten Datenstruktur zurückzugeben. Dafür muss das Schema mit den Anwendungsfällen im Hinterkopf entsprechend ausgearbeitet werden.  
Generell ist das Schema dieses Projekts sehr modular aufgebaut und stützt sich verstärkt auf Referenzierung von Elementen. Die Idee der Referenzierung hat sich auch in die Struktur einer Dokumenteninstanz ausgebreitet. Als Beispiel soll die Ressource `colour` angeführt werden. Ein Request wie z.B. `GET /color/333333` würde sämtliche Informationen über die Farbe mit dem Farbcode `333333` liefern. Darunter fallen der Zeitpunkt wann die Ressource im System erstellt wurde, aber auch von welchem Benutzer. Anstatt sich bei einem Request neben den Farbinformationen auch alle Infromationen des Benutzers liefern zu lassen,
würde es völlig ausreichen, wenn der Benutzer nur über eine ID referenziert wird. Interessiert sich ein Client dann noch näher für den Benutzer, dann würde ein zusätzlicher Request initiiert werden, um die Benutzer-Ressource anhand der ID anzusprechen. Der Vorteil dabei ist, dass nicht unnötig Daten übertragen werden, die evtl. garnicht benötigt werden. Der Nachteil könnte in den zusätzlichen Requests gesehen werden, die das Liefern der relevanten Daten, je nach Gegebenheit des Netzes, spürbar verzögert. Es wurde sich aber bewusst für die Referenzierung bzw. "Verlinkung" von Ressourcen untereinander entschieden,
da dessen Vorteile für sich sprechen. Kleinere Datenmengen führen zu schnelleren und effizienteren Datenübertragungen. Zusätzlich erhält der Client nur die für die Operation relevanten Daten und muss sie nicht vorher in einer wohlmöglich sehr großen Datenstruktur finden und aus ihr dann noch extrahieren.  
Neben der Möglichkeit einzelne Element-Fragmente erfolgreich zu validieren, wurde das Schema um die Möglichkeit erweitert, eine größere zusammenhängende XML-Struktur zu validieren. Mit großer XML-Struktur ist eine Struktur gemeint, die alle relevanten Daten des Systems auf einmal führen kann. Die Möglichkeit der Bildung einer solchen allumfassenden Struktur, ist für die komplette Datenaufnahme wichtig. Somit gibt es auf sietens des Servers eine einzige XML-Dokumenten-Instanz, die alle Daten enthält. Es müssen somit nicht unnötig viele kleine XML-Dokumente mit Datenfragementen auf dem Data Layer organisiert werden.
Es können Vergleiche zwischen der großen XML-Dokumenten-Instanz und einer Datenbank bzw. Datenbankdatei (sqlite) gezogen werden.  
Das Hinzufügen von Daten ist so gesehen die einfachste Operation, die man implementieren kann. Schwieriger wird es dann aber, wenn es um das Löschen von Daten bzw. Datensätzen geht. Speziell Datensätze, die an einer anderern Stelle referenziert werden. Es stellt sich nun die Frage, wie mit solchen Elementen umgegangen werden soll, die nicht mehr auf ein existierendes Element referenzieren, geschweige sie als erstes zu suchen und auch zu finden. In der momentanen Form bietet es sich nur an die komplette Struktur zu traversieren und wirklich alle Elemente auf eventuelle Referenzen zu prüfen und sie ggf. zu löschen.

###<a name="xml_schema_aufbau"></a>4.1 Aufbau

```
<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <xsd:annotation>
        <xsd:documentation xml:lang="DE">
            ColourConnection
            Jorge H. F. Pereira
            FH-Köln - Campsus GM / Web-basierte Anwendungen 2 / 2013
        </xsd:documentation>
    </xsd:annotation>
	
	
	
	<xsd:complexType name="Ref">
    	<xsd:attribute name="id" type="xsd:positiveInteger" />
		<xsd:attribute name="ref" type="xsd:string" />
    </xsd:complexType>
	
	<xsd:simpleType name="ColourID">
		<xsd:restriction base="xsd:string">
			<xsd:pattern value="[0-9a-fA-F]{6}" />
		</xsd:restriction>
	</xsd:simpleType>
	
    <xsd:complexType name="User">
    	<xsd:sequence>
    		<xsd:element name="username" type="xsd:string" minOccurs="1" maxOccurs="1" />
    		<xsd:element name="date_of_registration" type="xsd:dateTime" minOccurs="1" maxOccurs="1" />
    	</xsd:sequence>
    	<xsd:attribute name="id" type="xsd:positiveInteger" />
    </xsd:complexType>
    
    <xsd:complexType name="ColourRef">
		<xsd:attribute name="id" type="ColourID" />
		<xsd:attribute name="ref" type="xsd:string" />
    </xsd:complexType>
    
    <xsd:complexType name="Colour">
    	<xsd:sequence>
    		<xsd:element name="creator" type="Ref" minOccurs="1" maxOccurs="1" />
    		<xsd:element name="date_of_creation" type="xsd:dateTime" minOccurs="1" maxOccurs="1" />
    	</xsd:sequence>
    	<xsd:attribute name="id" type="ColourID" />
    </xsd:complexType>
    
	<xsd:complexType name="ColourPalette">
    	<xsd:sequence>
    		<xsd:element name="creator" type="Ref" minOccurs="1" maxOccurs="1" />
    		<xsd:element name="date_of_creation" type="xsd:dateTime" minOccurs="1" maxOccurs="1" />
    		<xsd:element name="used_colours" minOccurs="1">
    			<xsd:complexType>
    				<xsd:sequence>
    					<xsd:element name="colour" type="ColourRef" minOccurs="2" maxOccurs="10"/>
    				</xsd:sequence>
    			</xsd:complexType>
    		</xsd:element>
    	</xsd:sequence>
    	<xsd:attribute name="id" type="xsd:positiveInteger" />
    </xsd:complexType>
    
    <xsd:complexType name="FavouriteColour">
		<xsd:complexContent>
			<xsd:extension base="ColourRef">
				<xsd:sequence>
					<xsd:element name="favourite_since" type="xsd:dateTime" minOccurs="1" maxOccurs="1" />
				</xsd:sequence>
			</xsd:extension>
		</xsd:complexContent>
    </xsd:complexType>
    
	<xsd:complexType name="FavouriteColourPalette">
		<xsd:complexContent>
			<xsd:extension base="Ref">
				<xsd:sequence>
					<xsd:element name="favourite_since" type="xsd:dateTime" minOccurs="1" maxOccurs="1" />
				</xsd:sequence>
			</xsd:extension>
		</xsd:complexContent>
    </xsd:complexType>
    
    
    
    <xsd:complexType name="UserList">
    	<xsd:sequence>
    		<xsd:element name="user" type="Ref" minOccurs="0" maxOccurs="unbounded" />
    	</xsd:sequence>
    </xsd:complexType>
    
    <xsd:complexType name="ColourList">
    	<xsd:sequence>
    		<xsd:element name="colour" type="ColourRef" minOccurs="0" maxOccurs="unbounded">
    		</xsd:element>
    	</xsd:sequence>
    </xsd:complexType>
    
    <xsd:complexType name="ColourPaletteList">
    	<xsd:sequence>
    		<xsd:element name="colourpalette" type="Ref" minOccurs="0" maxOccurs="unbounded" />
    	</xsd:sequence>
    </xsd:complexType>
 
    <xsd:complexType name="FavouriteColourList">
    	<xsd:sequence>
    		<xsd:element name="favourite_colour" type="FavouriteColour" minOccurs="0" maxOccurs="unbounded" />
    	</xsd:sequence>
    </xsd:complexType>
    
    <xsd:complexType name="FavouriteColourPaletteList">
    	<xsd:sequence>
    		<xsd:element name="favourite_colourpalette" type="FavouriteColourPalette" minOccurs="0" maxOccurs="unbounded" />
    	</xsd:sequence>
    </xsd:complexType>
    
    
    
    <xsd:complexType name="Follower">
    	<xsd:complexContent>
    		<xsd:extension base="Ref">
    			<xsd:all>
    				<xsd:element name="following_since" type="xsd:dateTime" minOccurs="1" />
    			</xsd:all>
    		</xsd:extension>
    	</xsd:complexContent>
    </xsd:complexType>
    
    <xsd:complexType name="Followers">
    	<xsd:sequence>
    		<xsd:element name="follower" type="Follower" minOccurs="0" maxOccurs="unbounded"/>
    	</xsd:sequence>
    </xsd:complexType>
    
    <xsd:complexType name="Comment">
    	<xsd:sequence>
    		<xsd:element name="creator" type="Ref" minOccurs="1" maxOccurs="1" />
    		<xsd:element name="date_of_creation" type="xsd:dateTime" maxOccurs="1"/>
    		<xsd:element name="message" type="xsd:string" minOccurs="1" maxOccurs="1" />
    	</xsd:sequence>
    	<xsd:attribute name="id" type="xsd:positiveInteger" />
    </xsd:complexType>
    
	<xsd:complexType name="Comments">
		<xsd:sequence>
			<xsd:element name="comment" type="Comment" minOccurs="0" maxOccurs="unbounded"/>
		</xsd:sequence>
	</xsd:complexType>
	
    
    
    <xsd:complexType name="ColourConnection">
    	<xsd:sequence>
    		<xsd:element name="users" minOccurs="1" maxOccurs="1">
    			<xsd:complexType>
    				<xsd:sequence>
    					<xsd:element name="user" minOccurs="0" maxOccurs="unbounded">
    						<xsd:complexType>
    							<xsd:complexContent>
    								<xsd:extension base="User">
    									<xsd:sequence>
    										<xsd:element ref="favourite_colours" minOccurs="1" maxOccurs="1"/>
    										<xsd:element ref="favourite_colourpalettes" minOccurs="1" maxOccurs="1"/>
    										<xsd:element ref="followers" minOccurs="1" maxOccurs="1" />
    										<xsd:element name="creations" type="ColourPaletteList" minOccurs="1" maxOccurs="1" />
    									</xsd:sequence>
    								</xsd:extension>
    							</xsd:complexContent>
    						</xsd:complexType>
    					</xsd:element>
    				</xsd:sequence>
    			</xsd:complexType>
    		</xsd:element>
    		<xsd:element name="colours" minOccurs="1" maxOccurs="1">
    		    <xsd:complexType>
    		    	<xsd:sequence>
    					<xsd:element name="colour" minOccurs="0" maxOccurs="unbounded">
    						<xsd:complexType>
    							<xsd:complexContent>
    								<xsd:extension base="Colour">
    									<xsd:sequence>
    										<xsd:element name="comments" minOccurs="1" maxOccurs="1">
    											<xsd:complexType>
    												<xsd:sequence>
    													<xsd:element ref="comment" minOccurs="0" maxOccurs="unbounded" />
    												</xsd:sequence>
    											</xsd:complexType>
    										</xsd:element>
    									</xsd:sequence>
    								</xsd:extension>
    							</xsd:complexContent>
    						</xsd:complexType>
    					</xsd:element>
    				</xsd:sequence>
    			</xsd:complexType>
    		</xsd:element>
    		<xsd:element name="colourpalettes" minOccurs="1" maxOccurs="1">
    		    <xsd:complexType>
    		    	<xsd:sequence>
    					<xsd:element name="colourpalette" minOccurs="0" maxOccurs="unbounded">
							<xsd:complexType>
    							<xsd:complexContent>
    								<xsd:extension base="ColourPalette">
    									<xsd:sequence>
    										<xsd:element name="comments" minOccurs="1" maxOccurs="1">
    											<xsd:complexType>
    												<xsd:sequence>
    													<xsd:element ref="comment" minOccurs="0" maxOccurs="unbounded" />
    												</xsd:sequence>
    											</xsd:complexType>
    										</xsd:element>
    									</xsd:sequence>
    								</xsd:extension>
    							</xsd:complexContent>
    						</xsd:complexType>
    					</xsd:element>
    				</xsd:sequence>
    			</xsd:complexType>
    		</xsd:element>
    	</xsd:sequence>
    </xsd:complexType>
    
    
    
    <xsd:element name="user" type="User" />
    <xsd:element name="colour" type="Colour" />
    <xsd:element name="colourpalette" type="ColourPalette" />
    <xsd:element name="favourite_colour" type="FavouriteColour" />
    <xsd:element name="favourite_colourpalette" type="FavouriteColourPalette" />
    
    <xsd:element name="users" type="UserList" />
    <xsd:element name="colours" type="ColourList" />
    <xsd:element name="colourpalettes" type="ColourPaletteList" />
    <xsd:element name="favourite_colours" type="FavouriteColourList" />
    <xsd:element name="favourite_colourpalettes" type="FavouriteColourPaletteList" />
    
    <xsd:element name="followers" type="Followers" />
    <xsd:element name="comment" type="Comment"/>
    <xsd:element name="comments" type="Comments" />

	<xsd:element name="colour_connection" type="ColourConnection" />    
    
</xsd:schema>
```


<a href="#top">^ top</a>




##<a name="restful_webservice"></a>5. RESTful Webservice  
Schon in Punkt 3 wird auf das Thema `Resource` leicht eingegangen. Konkret in die Erstellung, dem Löschen und dem Zurückgeben einer Resource, oder allgemein der Verwaltung dieser.  
Der RESTful Webservice soll nun über die zuvor in Punkt 4 ausgearbeiteten HTTP-Operationen den Zugriff auf dieser Resourcen ermöglichen. Das bedeutet, dass die HTTP-Operationen in konkreten Code überführt, oder besser gesagt, Handler erzeugt werden müssen, die eingehende Requests im Sinne von z.B. "GET /user/1" erkennen und die damit symbolisierte Operation auf den Bestand der Resourcen ausführt.  
Für die Umsetzung des RESTful Webservice wird auf Jersey als Referenzimplementation von JAX-RS (Java API for Restful Web Services) und Grizzly als HTTP-Server gesetzt. Jersey ermöglicht auf der Seite des Servers die Abbildung eines Requests (abhängig von dem HTTP-Verb, URI und akzeptierten MIME-Types) auf Java-eigene Klassen bzw. Methoden. Vor allem das Abgreifen von Path- und Query-Parametern gestaltet die Umsetzung des Webservice einfacher.
Im Falle von Path-Parametern werden zu einer Resource relevante eindeutige Identifizierungsinformationen (evtl. eine ID) im Pfad eingebettet (`localhost/user/1`, wobei 1 die Identifizierungsinformation darstellt). Query-Parameter werden hingegen im Bereich des Query-Strings mitgereicht, wobei hier die Reihenfolge der Parameter keine Rolle spielt, da der mitgereichte Wert über einen zusätzlichen Schlüssel identifiziert wird (`...?key=value`).  
Doch zu aller erst werden mit dem Programm `xcj` aus dem entwickelten XML-Schema die nötigen Java-Klassen generiert, um sie zum marshallen und unmarshallen der übertragenden Daten zu nutzen. Jersey und JAXB werden somit zusammen eingesetzt, zumal sie beide sehr gut miteinander arbeiten.

<a href="#top">^ top</a>


###<a name="restful_webservice_vorueberlegungen"></a>5.1. Vorüberlegungen  
Vor der Umsetzung des Webservice, sollte überlegt werden, wie die Prozesse auf seitens des Servers ablaufen sollen. Zudem ist es sinnvoll eine klare Trennung der Vorgänge zu gewährleisten, um den Code im Nachhinein besser und einfacher warten zu können oder komplett zu ersetzen. Hier sollten die Vorteile einer einheitlichen Schnittstelle hervorgehoben werden.  
Für diese Phase ist es vorgesehen, dass die ganzen dem System bekannten Daten innerhalb von XML-Dokument-Instanzen, bzw. einer einzigen Instanz, gelagert werden. Angenommen es wird sich irgendwann später dafür entschieden die Datensätze in entsprechende externe Datenbanken zu verlagern, kann durch den evtl. modular aufgebauten Code und der einheitlichen Schnitttstelle gewährleistet werden, dass die Anpassung des Codes sich nur auf den Bereich des Datahandlings beschränkt. Die Logik bezüglich des Requesthandlings bleibt somit unangetastet.  
Man hat hier schon einen Schritt in Richtung klarer Trennung unterschiedlicher Vorgänge gemacht. Diese Trennung wurde leicht von Punkt 2 (Szenarien) mitgenommen. Wie in den dortigen Sequenz-Diagrammen zu sehen, herrschte schon bei der Entwicklung der Szenarien eine klare logische Trennung der Vorgänge. Es ergaben sich Rollen. Zum einen der Client der sich außerhalb des Servers befindet, der Request-Handler welcher sich um die Annahme von Request bzw. der Beatnwortung dieser kümmert und dem eigentlichen Data-Handling, wo die Daten, in diesem Fall, in eine exitierende XML-Struktur einpflegt bzw. aus dieser Daten entnimmt.
Der grobe Aufbau sieht wie folgt aus:  


**Client**  <--->  **Request-Handler**  <--->  **Data-Handler**
  

Jede Rolle kommuniziert nur mit einer seiner Nachbar-Rollen. Das bedeutet, dass z.B. der Client keine direkte Kommunikation mit dem Data-Handler führen kann, sondern den Weg über den Request-Handler gehen muss und erst dieser mit dem Data-Handler kommuniziert bzw. der Rolle/Instanz eine Nachricht schickt.  

Eine weitere wichtige Überlegung betrifft die Statuscodes. Nach jedem Request muss mit einem entsprechenden Repsonse geantwortet werden. Je nach Erfolg oder Misserfolg der Operation, muss ein entsprechender HTTP-Statuscode zurückgegeben werden.
Nach Betrachtung der HTTP-Operationen, wurde sich für die folgenden Statuscodes entschieden:  


| Statuscode | Bedeutung | Einsatz |
| :---: | :---: | :--- |
| **200** | OK | Rückgabe einer Ressource bzw. von Daten (Benutzer-, Farb-, Farbpaletteninformationen usw.) |  
| **201** | Created | Die Erstellung einer Ressource war erfolgreich und der Ort der neuen Resource wird im Header mitgegeben |  
| **204** | No Content | Ressource wird aktualisiert oder gelöscht; keine nennenswerten Daten als Rückgabe |  
| **404** | Not Found | Resource nicht gefunden; Sammelcode für wenn ein HTTP-Operation nicht erfolgreich war |  
  

<a href="#top">^ top</a>


###<a name="restful_webservice_aufbau"></a>5.2. Aufbau  

![Code Diagramm](images/code_diagram.png)  

Das Diagramm zeigt die im src-Baum existierenden Klassen (JAXB-Klassen nicht betrachtet, da sie generiert werden).  
Der Haupteinstieg befindet sich in der Klasse `RestWebserviceMain`. Hier wird der HTTP-Server Grizzly gestartet und Jersey initialisiert. Der Pfeil in Richtung `RequestLayer` deutet an, dass die Ressourcen-Klassen von Jersey (Name des Packages, wo Jersy nach entsprechenden Klassen suchen soll, wird als Initialisierungsparameter mitgereicht) gefunden und für das "Matchen" der Request-URIs eingebunden werden.  
Die `RequestLayer`-Gruppe enthält alle von Jersey gefundenen Klassen, die sich um die Abwicklung der Requests kümmern. In diesen werden die gesendeten Daten abgefangen und dem DataHandler weitergereicht. Sie entscheiden auch darüber was für ein Response auf ein Request an ein Client zurückgesandt wird. Wichtig ist hierbei der Statuscode (200, 201, 404, etc.), der auf der Clientseite als Fehlercode verwendet werden soll, um auf bestimmte Fehler entsprechend reagieren zu können.  
Die Klasse `DataHandler` kümmert sich um das marshallen bzw. unmarshallen aller XML-Dokumente, aber auch um das Einbetten von neuen Datensätzen bzw. Löschen dieser in der datentragenden XML-Struktur, die alle vom System bekannten Daten führt. Wird ein bestimmter Datensatz von einer Klasse aus der `RequestLayer`-Gruppe angefordert, kümmert sich die `DataHandler` darum diesen speziellen Datensatz aus der XML-Struktur zu extrahieren und in eine Struktur umzubetten, die für die Übertragung der Daten vorgesehen ist.
Das Besondere an der `DataHandler`-Klasse ist, dass es von ihr nur eine einzige Instanz zu jedem Zeitpunkt geben kann. Hier sei das das Stichwort `Singleton-Pattern` gennant. Der Vorteil hierbei ist der, dass sich nicht mehrere unnötige Instanzen der Klasse im Speicher befinden, da alle Objekte so oder so immer auf den selben Datenbestand zugreifen würden. Somit wären mehrere Instanzen unnötig.  
Zuletzt gibt es noch die Klasse `Config`, die nur statische Attribute besitzt. In ihr sind Daten wie der `Hostname` un die verwendete `Portnummer` angegeben. Diese Daten sind für das Aufbauen eines URI-Strings, aber auch für die Initialisierung des Grizzly-Servers nötig. Deshalb auch die beiden Verbindungen aus beiden Richtungen hin zur `Config`-Klasse.

<a href="#top">^ top</a>


###<a name="restful_webservice_code_ausschnitte"></a>5.4. Code-Ausschnitte  

Die Methode `deleteUserFollower` aus ***src/de/fhkoeln/gm/wba2/phase2/rest_webservice/resources/UserResource.java***
```
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
```  

Diese Methode wird aufgerufen, wenn ein Request des Formats `DELETE /user/1/follower/2` gesendet wird.
Als Path-Parameter werden die beiden IDs der Benutzer mitgegeben. Die erste ID ist die ID des gefolgten Benutzers und die zweite ID ist die ID des Benutzers welcher folgt.  
Über die Methode `deleteUserFollower` werden dem DataHandler beide IDs als Parameter mitgereicht. Wurde die Ressource erfolgreich gelöscht, gibt die Methode ein `true` zurück, ansonsten ein `false`.
Je nach Wert wird ein entsprechendes Response-Objekt mit entsprechendem Statuscode "gebaut", welcher dann zurückgegeben wird. 
  
  

Die Methode `deleteUserFollower` aus ***src/de/fhkoeln/gm/wba2/phase2/rest_webservice/DataHandler.java***
```
/**
 * Delete the entry representing a follwoing user
 * 
 * @param user_id id of the user being followed
 * @param follower_id id of the user following
 * @return success or failure
 */
public boolean deleteUserFollower(String user_id, String follower_id) {
	
	BigInteger bi_user_id = BigInteger.valueOf(Long.parseLong(user_id));
	BigInteger bi_follower_id = BigInteger.valueOf(Long.parseLong(follower_id));

	if(getFollowerObj(bi_user_id, bi_follower_id) != null) {
		
		ColourConnection.Users.User user_followed = getUserObj(bi_user_id);
		
		for(Follower curr_follower: user_followed.getFollowers().getFollower()) {
			if(curr_follower.getId().equals(bi_follower_id)) {
				user_followed.getFollowers().getFollower().remove(curr_follower);
				marshall_cc();
				return true;
			}
		}
	}
	
	return false;
}
```

Diese Methode, die über die gleichnamige Methode `deleteUserFollower` der Klasse `UserResource` aufgerufen wird, kümmert sich zum einen darum den Eintrag zu finden,
der die Verbindung zwischen den beiden Benutzern verdeutlicht und zum anderen auch darum diesen Eintrag dann zu löschen, sofern er ihn findet.
Wurde der Eintrag erfolgreich gelöscht, wird der Inhalt der XML-Struktur mit dem gesamten Datenbestand marshalled. Somit enthält die XML-Dokumenten-Instanz ("Datenbankdatei") ebenfalls den momentan aktuellen Stand.
Zuletzt wird `true` zurückgegeben, um der aufrufenden Methode mittzuteilen, dass das Löschen erfolgreich war. War es nicht erfolgreich, wird dementsprechend `false` zurückgegeben.

<a href="#top">^ top</a>


###<a name="restful_webservice_besonderheiten"></a>5.4. Besonderheiten  

Neben der Methode `deleteUserFollower` wurde auch eine alternative Methode mit dem Namen `deleteUserFollowerByQueryParam` geschrieben, um den Einsatz von Query-Parametern zu zeigen.
Beide Methoden sind identisch bis auf, dass diese Methode die ID des Benutzers der folgt nicht aus der Pfadangabe, sondern über den Query-String bezieht. 
Die URI würde wie folgt aussehen:  
`/localhost/user/1/follower?follower_id=2`


```
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
```

<a href="#top">^ top</a>


