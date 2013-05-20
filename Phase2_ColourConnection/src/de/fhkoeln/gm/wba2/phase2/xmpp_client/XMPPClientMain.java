package de.fhkoeln.gm.wba2.phase2.xmpp_client;

import javax.swing.*;

public class XMPPClientMain {

    /**
     * @author Jorge H. F. Pereira
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    // set system L&F
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                } catch (UnsupportedLookAndFeelException e) {
                } catch (ClassNotFoundException e) {
                } catch (InstantiationException e) {
                } catch (IllegalAccessException e) {
                }

                new ConnectionFrame();
            }
        });

    }

}
