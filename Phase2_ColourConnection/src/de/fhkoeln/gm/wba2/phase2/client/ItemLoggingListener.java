package de.fhkoeln.gm.wba2.phase2.client;


import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class ItemLoggingListener implements ItemEventListener<Item> {

    public ItemLoggingListener() {
    }

    @Override
    public void handlePublishedItems(ItemPublishEvent<Item> event) {
        for (Item curr : event.getItems()) {
            //((PayloadItem<SimplePayload>) curr).getPayload().toXML()
            System.out.println("Message!");
        }
    }
}
