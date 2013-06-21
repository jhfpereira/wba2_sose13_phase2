package de.fhkoeln.gm.wba2.phase2.client;


import javax.swing.JFrame;

import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

import de.fhkoeln.gm.wba2.phase2.jaxb.ColourConnection.Colourpalettes.Colourpalette;
import de.fhkoeln.gm.wba2.phase2.jaxb.ColourPalette;

public class ItemLoggingListener implements ItemEventListener<Item> {
    
    private ClientFrame jf;
    
    public ItemLoggingListener(ClientFrame jf) {
        this.jf = jf;
    }

    @Override
    public void handlePublishedItems(ItemPublishEvent<Item> event) {
        for (Item curr : event.getItems()) {
            
            String marshalled_str = ((PayloadItem<SimplePayload>) curr).getPayload().toXML();
            marshalled_str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + marshalled_str;
            
            ColourPalette cp = (ColourPalette) JAXBTools.unmarshall(marshalled_str, ColourPalette.class);
            
            jf.receivedNewCPNotification(cp);
        }
    }
}
