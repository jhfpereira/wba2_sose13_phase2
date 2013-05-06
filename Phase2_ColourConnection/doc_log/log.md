Fachhochschule Köln - Campus Gummersbach  
Web-basierte Anwendungen 2: Verteilte Systeme  

<a name="top"></a>

#Logbuch  

* [2013-04-15 | **Kickoff: Ideen- / Problemfindung**](#2013_04_15)
* [2013-04-22 | **Konzeptioneller Meilensein - Kommunikationsabläufe und Interaktionen**](#2013_04_22)
* [2013-04-27 | Benutzerauthentifizierung bezogen auf ein RESTful Webservice](#2013_04_27)
* [2013-04-29 | Ressourcen und URI Design](#2013_04_29)
* [2013-05-04 | Ressourcen-Identifizierung, Ausarbeitung der Semantik und Umsetzung eines XML-Schema](#2013_05_04)  
* [2013-05-06 | **Meilenstein 1 + 2 - Projektspezifisches XML Schema, Ressourcen/Semantik der HTTP-Operationen**](#2013_05_06)
* [2013-05-13 | **Meilenstein 3 - RESTful Webservice**](#2013_05_13)
* [2013-06-03 | **Meilenstein 4 + 5 - Konzeption asynchrone Kommunikation + XMPP - Client**](#2013_06_03)
* [2013-06-17 | **Meilenstein 6 - Client - Entwicklung**](#2013_06_17)




***

<a name="2013_04_15"></a>**2013-04-15** | Kickoff: Ideen- / Problemfindung  
Es stellte sich heraus, dass es nicht so leicht war zu einer guten und interessanten Idee zu kommen. Viele Ideen mussten verworfen werden, weil sie schon von anderen Gruppen aufgegriffen wurden.
Es sehr spät ergab sich die Überlegung, angelehnt an die Seite [ColourLovers](http://www.colourlovers.com), eine kleine Platform zu realisieren, wo Farben den Mittelpunkt darstellten. Alles soll sich um Farben drehen. Farben sollen geteilt und aufgegriffen werden, um neue Erzeugnisse zu kreiern.
Dies soll zu einer großen Variation an Farbpaletten führen, die für eventuelle Medienerzeugnisse herangezogen werden können. Darunter fallen Farbschemen, an die sich orientiet werden kann, wenn z.B. eine gute Farbkombination für die Gestaltung einer Webseite benötigt wird.
Es soll auch als Anlaufstelle dienen, um sich von frischen und dem Trend folgenden Farbkombinationen inspirieren zu lassen. 

<a href="#top">^ top</a>  


<a name="2013_04_22"></a>**2013-04-22** | Konzeptioneller Meilensein - Kommunikationsabläufe und Interaktionen  
Bevor es zur eigentlichen Umsetzung des Projekts kommt, sollte man sich im klaren sein, wie die Kommunikations- sowie Interaktionsabläufe aufgebaut sein sollten. Dies ist empfehlenswert, um schon im Vorfeld eventuell auftretende Probleme sowie Unstimmigkeiten identifizieren zu können.
Es wurde sich dazu entschlossen kleine simple Szenarien zu verfassen, die die wichtigsten Kommunikationsabläufe verdeutlichen sollen. Darunter fielen die Schritte zum Erstellen eines Farberessource, dem Festlegen einer Lieblingsfarbe, aber auch der Vorgang des Abonnierens einer bestimmten Farbe. Speziell bei Letzterem kann parallel zueinander ein synchroner und asynchroner Kommunikationsablauf festgestellt werden.
Solch ein Ablauf ist nicht nur beim Setzen einer Lieblingsfarbe relevant, sondern auch beim "Folgen" eines Benutzers und seiner Erzeugnisse. Der asynchrone Aspekt ist dadurch gegeben, dass ein Benutzer nicht immer wieder selbst überprüfen muss, ob ein anderer Benutzer, den er folgt, neue Farbpaletten erzeugt hat, sondern eine entsprechende Benachrichtigung erhält. Hier muss eins dieser Erzeugnisse nicht einmal eine der eigenen Lieblingsfarben verwenden. Dies kann somit als Möglichkeit dienen, neue interessante Farben zu finden, die dann evtl. als Lieblingsfarben festgelegt werden können.
Sonst wäre man nur auf die zusätzlichen Farben einer Farbpalette beschränkt, die unter anderem eine Farbe verwendet zu der man angegeben hat, dass sie die Lieblingsfarbe von einem selbst ist.

<a href="#top">^ top</a>  


<a name="2013_04_27"></a>**2013-04-27** | Benutzerauthentifizierung bezogen auf ein RESTful Webservice  
Als ein sehr interessantes Thema bezüglich RESTful Webservices empfinde ich die Möglichkeiten der Benutzerauthentifizierung. Bezogen auf das Projekt der Phase2, könnte es relevant sein, eine Benutzerauthentifizierungsschnittstelle einzuführen, um die Rechte eines Benutzers konkret zu bestimmen.
Obwohl solche Authentifizierungs-Mechanismen in den Vorlesungen noch nicht behandelt wurden, war das Interesse so groß, dass ich nach solchen auf eigene Faust recherchiert habe.
Generell wird immer gesagt, dass Kommunikationsabläufe die einen Benutzer authentifizieren, über SSL/TLS (Secure Socket Layer bzw. Transport Layer Security) laufen sollten. Somit würde man hier direkt auf HTTPS setzen. Dies erlaubt es sensible Daten (Passwörter), die normalerweise im quasi Klartext übertragen werden, geschützt zu übertragen. Der Einsatz von SSL/TLS würde das Risiko extrem minimieren, Opfer einer `Man-In-The-Middle`-Attacke zu werden.
Als Beispiel für eine Authentifizierung per Klartext, könnte das "Basic Authentication"-Verfahren genannt werden, welches direkter Bestandteil des `Hyptertext Transfer Protocol` ist. Hier werden Benutzername und Passwort mittels eines `Authorization-Headers` im Klartext übertragen. Das Mitlesen dieser sensiblen Daten ist sehr leicht möglich. Mit dem Einsatz von SSL/TLS kann aber eine sichere Übertragung durch eine schützende Kapselung der Daten gewährleistet werden.
Als Alternative zum "Basic Authentication"-Verfahren, bietet sich das "Digest Access Authenticaon"-Verfahren an. Hier werden nie wirklich sensible Daten verschickt, es wird anstattdessen ein Hashcode versendet, welcher zuvor mittels einer Hashfunktion, angedwandt auf die sensiblen Daten sowie weiteren vom Server gegebenen Daten, errechnet wurde. Die Gegenstelle muss demnach den Hashcode dann nur noch mit einem selbst berechneten Hashcode auf Übereinstimmung prüfen.
Bevor ich mich für eines dieser Verfahren entscheide, und anhand dieser Entscheidung das Projekt für Phase 2 weiter ausarbeite, werde ich warten, bis das Thema Authentifizierung in einer Vorlesung behandelt wird und auch bekannt gegeben wird, welches Verfahren letztendlich verwendet werden soll. Evtl. können wir auch frei entscheiden, auf welches Verfahren wir schlussendlich setzen.


<a href="#top">^ top</a>  


<a name="2013_04_29"></a>**2013-04-29** | Ressourcen und URI Design  
Ein wichtiger Punkt, welcher in Phase 2 näher betrachtet wird und sicherlich auch ausschlaggebend für die Qualität einer API, ist das Design der URI als Identifizierungsmechanismus für Ressourcen.
Nach einigen Recherchen bezüglich dem Entwickeln einer guten und sauberen Semantik, kristallisiert sich eine klare Faustregel, an die man sich idealerweise richten sollte. Nomen sind gut und Verben sind schlecht. Konkret bedeutet dies, dass Ressourcen über Nomen addressiert werden.
Sie repräsentieren ja eine Entität bzw. eine Liste von Entitäten. Als Verben setzen man nur die HTTP-Verben `GET`, `PUT`, `POST` und `DELETE` ein, die für grundlegende Operationen völlig ausreichen.
Für ColourConnection würde eine Beispiel-URI evtl. wie folgt aussehen:  
`/user/42`  
`/color/333333`  
`/user/followers`  
`/user/followers/42`  
`/colorpalettes`  
`/colorpalette/815`  
`/user/favourite/colors`  
Wie zu sehen ist, werden in keinster Weise Verben verwendet, sondern explizit nur Nomen.  
Ein `GET /user/42` würde man grob mit "hole mir die Ressource vom Benutzer mit der ID 42" übersetzen.
Obwohl `PUT` und `POST` eine ähnliche Operation suggestieren, unterscheiden sie sich doch in einem kleinen Detail.
Der `PUT`-Verb wird verwendet, wenn man eine neue Ressource erstellen bzw. eine bereits existierende Ressource aktualisieren will.
Der `POST`-Verb hingegen setzt man ein, wenn man eine untergeordnete Ressource erstellen will. Evtl. ein neues Element einer Liste.  
Als Beispiel:  
`POST /colorpalettes` würde eine untergeordnete Ressource erstellen. In diesem Fall eine Ressource für eine neue Farbpalette.
Ob ich die Erstellung einer neuen Ressource wirklich so gestalten werde, muss ich noch entscheiden, denn es würde sich auch folgender Requestaufruf anbieten: `POST /colorpalette`. Hier sei auf das fehlende "s" hingewiesen.
Dies würde sich meiner Meinung sogar eher anbieten, da `/colorpalettes` nur auf ein `GET`-Request reagieren sollte um eine Liste zurückzugeben und `POST /colorpalette` schon mit der zuvor aufgegriffenen Semantik von `POST` klarer ausdrückt, dass man eine untergeordnete Ressource erstellen will. Einer der Enität `colorpalette` untergeordnete Ressource.



<a href="#top">^ top</a> 


<a name="2013_05_04"></a>**2013-05-04** | Ressourcen-Identifizierung, Ausarbeitung der Semantik und Umsetzung eines XML-Schema  
Für die Identifizierung der Ressourcen, habe ich mir erstmal klar gemacht, was im System alles eine grundlegende Entität repräsentiert. Nach einer kurzen Zeit stand fest, dass es drei grundlegende Entitäten gibt. Ein Benutzer (`user`), eine Farbe (`colour`) und eine Farbpalette (`colourpalette`).
Von diesen drei Basis-Entitäten bzw. -Ressourcen, leiten sich dann leicht abweichende/erweiterte Ressourcen ab. Alle anderen Ressourcen stehen zuletzt nur im Zusammenhang mit den Basis-Ressourcen. Diese Abhängigkeiten und Abwandlungen, basierend auf die Basis-Ressourcen, ermöglichen die Einführung von einer Art Referenz. Referenzen können dazu genutzt werden um anzugeben, mit welchem anderen Element sie in Beziehung stehen. Sei es, dass es eine Spezialisierung einer Ressource ist,
oder die Ressource nur im Kontext mit der referenzierten Ressource Sinn macht bzw. nur im Zusammenspiel mit dieser an Relevanz gewinnt. Diese Idee hat sich im Endeffekt auch komplett auf den Aufbau des XML-Schemas ausgewirkt. Elemente nutzen Referenzen, um andere Elemente im System zu referenzieren.  
Auch die Ausarbeitung der Semantik der HTTP-Operationen hat von Identifizierung der Ressourcen profitiert. Aufbauend auf die zuvor idetifizierten Basis-Ressourcen, konnte eine Hierarchie aufgebaut werden.

<a href="#top">^ top</a> 


<a name="2013_05_06"></a>**2013-05-06** | Meilenstein 1 + 2 - Projektspezifisches XML Schema, Ressourcen und die Semantik der HTTP-Operationen  
Die Abnahme des ersten und zweiten Meilensteins verlief recht gut. Fragen bezüglich der eventuellen Löschung von Elementen mit noch existierenden Refernezen auf dieses Element, wurde damit beantwortet, dass es mehrere Möglichkeiten gibt. Meine Idee, alle Elemente in einer allumfassenden Struktur zu traversieren, und Elemente mit übereinstimmenden Referenzen löschen, wäre eine Möglichkeit.
So wird höchstwahrscheinlich auch meine Vorgehensweise aussehen. Evtl. lasse ich die Lösch-Operationen auch komplett unimplementiert. Dies werde ich erst im Verlauf der Umsetzung des REST Webservice entscheiden, je nachdem wie sich der Zeitdruck bemerkbar macht.  
Heute habe ich zudem das Schema um die Möglichkeit erweitert, eine allumfassende Struktur zu validieren (auch Java-Klassen mittels JAXB generieren zu lassen), die es erlaubt alle Daten des Systems aufzunehmen. Dies wird für die Umsetzung des REST Webservice wichtig sein, da irgendwo die Daten gespeichert sein müssen. Idealerweise in nur einer einzigen XML-Dokumenten-Instanz, anstatt viele kleine XML-Dokumente zu organisieren, die die jeweiligen Ressourcen wiederspiegeln.

<a href="#top">^ top</a>  


<a name="2013_05_13"></a>**2013-05-13** | Meilenstein 3 - RESTful Webservice  


<a href="#top">^ top</a>  


<a name="2013_06_03"></a>**2013-06-03** | Meilenstein 4 + 5 - Konzeption asynchrone Kommunikation + XMPP - Client  


<a href="#top">^ top</a>  


<a name="2013_06_17"></a>**2013-06-17** | Meilenstein 6 - Client - Entwicklung


<a href="#top">^ top</a>