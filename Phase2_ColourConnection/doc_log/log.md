Fachhochschule Köln - Campus Gummersbach  
Web-basierte Anwendungen 2: Verteilte Systeme  

<a name="top"></a>

#Logbuch  

* [2013-04-15 | **Kickoff: Ideen- / Problemfindung**](#2013_04_15)
* [2013-04-22 | **Konzeptioneller Meilensein - Kommunikationsabläufe und Interaktionen**](#2013_04_22)
* [2013-04-27 | Benutzerauthentifizierung bezogen auf ein RESTful Webservice](#2013_04_27)
* [2013-05-08 | **Meilenstein 1 + 2 - Projektspezifisches XML Schema, Ressourcen/Semantik der HTTP-Operationen**](#2013_05_08)
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
Bevor ich mich für eines dieser Verfahren entscheide, und anhand dieser Entscheidung das Proejkt für Phase 2 weiter ausarbeite, werde ich warten, bis das Thema Authentifizierung in einer Vorlesung behandelt wird und auch bekannt gegeben wird, welches Verfahren letztendlich verwendet werden soll. Evtl. können wir auch frei entscheiden, auf welches Verfahren wir setzen wollen.


<a href="#top">^ top</a>  


<a name="2013_05_08"></a>**2013-05-08** | Meilenstein 1 + 2 - Projektspezifisches XML Schema, Ressourcen und die Semantik der HTTP-Operationen


<a href="#top">^ top</a>  


<a name="2013_05_13"></a>**2013-05-13** | Meilenstein 3 - RESTful Webservice


<a href="#top">^ top</a>  


<a name="2013_06_03"></a>**2013-06-03** | Meilenstein 4 + 5 - Konzeption asynchrone Kommunikation + XMPP - Client


<a href="#top">^ top</a>  


<a name="2013_06_17"></a>**2013-06-17** | Meilenstein 6 - Client - Entwicklung


<a href="#top">^ top</a>