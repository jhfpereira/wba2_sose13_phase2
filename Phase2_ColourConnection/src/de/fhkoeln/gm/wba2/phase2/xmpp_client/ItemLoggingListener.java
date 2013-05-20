package de.fhkoeln.gm.wba2.phase2.xmpp_client;

import javax.swing.JTextPane;

import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class ItemLoggingListener implements ItemEventListener<Item> {

    private JTextPane logger_field;

    public ItemLoggingListener(JTextPane logger_field) {
        this.logger_field = logger_field;
    }

    @Override
    public void handlePublishedItems(ItemPublishEvent<Item> event) {
        for (Item curr : event.getItems()) {
            logger_field.setText(logger_field.getText()
                    + ((PayloadItem<SimplePayload>) curr).getPayload().toXML()
                    + "\n");
        }
    }
}
