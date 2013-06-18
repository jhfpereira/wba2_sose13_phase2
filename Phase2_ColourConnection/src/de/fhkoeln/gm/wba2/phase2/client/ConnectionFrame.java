package de.fhkoeln.gm.wba2.phase2.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import de.fhkoeln.gm.wba2.phase2.xmpp_client.ConnectionHandler;

public class ConnectionFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private ClientFrame cf;

    private JPanel contentPane;
    private JTextField textHostname;
    private JTextField textXMPPPort;
    private JTextField textHTTPPort;
    private JTextField textUsername;
    private JPasswordField passwordPassword;
    private JLabel lblStatus;

    public ConnectionFrame() {
        setTitle("Anmelden");
        setResizable(false);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 280);
        setLocationRelativeTo(null);
        
        cf = new ClientFrame(this);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblHostname = new JLabel("Hostname");
        lblHostname.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHostname.setBounds(80, 40, 82, 15);
        contentPane.add(lblHostname);
        
        JLabel lblXMPPPort = new JLabel("XMPP-Port");
        lblXMPPPort.setHorizontalAlignment(SwingConstants.RIGHT);
        lblXMPPPort.setBounds(80, 67, 82, 15);
        contentPane.add(lblXMPPPort);
        
        JLabel lblHTTPPort = new JLabel("HTTP-Port");
        lblHTTPPort.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHTTPPort.setBounds(80, 95, 82, 15);
        contentPane.add(lblHTTPPort);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(80, 123, 82, 15);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setBounds(80, 151, 82, 15);
        contentPane.add(lblPassword);

        textHostname = new JTextField();
        textHostname.setText(Config.hostname);
        textHostname.setBounds(180, 34, 144, 25);
        contentPane.add(textHostname);
        textHostname.setColumns(10);
        
        textXMPPPort = new JTextField();
        textXMPPPort.setText(String.valueOf(Config.xmpp_port));
        textXMPPPort.setBounds(180, 61, 144, 25);
        contentPane.add(textXMPPPort);
        textXMPPPort.setColumns(10);
        
        textHTTPPort = new JTextField();
        textHTTPPort.setText(String.valueOf(Config.http_port));
        textHTTPPort.setBounds(180, 89, 144, 25);
        contentPane.add(textHTTPPort);
        textHTTPPort.setColumns(10);

        textUsername = new JTextField();
        textUsername.setBounds(180, 117, 144, 25);
        contentPane.add(textUsername);
        textUsername.setColumns(10);

        passwordPassword = new JPasswordField();
        passwordPassword.setBounds(180, 145, 144, 25);
        contentPane.add(passwordPassword);

        JButton btnRegistrieren = new JButton("Registrieren");
        btnRegistrieren.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String hostname = textHostname.getText();
                int xmpp_port = -1;
                int http_port = -1;
                String username = textUsername.getText();
                String password = passwordPassword.getText();
                
                xmpp_port = Integer.parseInt(textXMPPPort.getText());
                http_port = Integer.parseInt(textHTTPPort.getText());
                
                if (hostname.length() > 3 && xmpp_port > 0 && xmpp_port <= 65536
                        && http_port > 0 && http_port <= 65536
                        && username.length() > 0 && password.length() > 0) {

                    /* XMPP-Connection */
                    ConnectionHandler ch = new ConnectionHandler();
                    
                    /* HTTP-Connection */
                    RESTConnectionHandler rch = new RESTConnectionHandler(hostname, http_port);
                    
                    if (ch.connect(hostname, xmpp_port) && rch.checkConnection()) {

                        if (rch.register(username) && ch.register(username, password)) {
                            // success
                            System.out.println("Connection and Registration Success!");
                            lblStatus.setText("Erfolgreich registriert!");
                        } else {
                            lblStatus.setText("Registrierung fehlgeschlagen!");
                        }
                    } else {
                        // failed
                        lblStatus.setText("Verbindungsherstellung fehlgeschlagen!");
                    }
                }

            }
        });

        btnRegistrieren.setBounds(60, 175, 104, 25);
        contentPane.add(btnRegistrieren);

        JButton btnVerbinden = new JButton("Verbinden");
        btnVerbinden.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String hostname = textHostname.getText();
                int xmpp_port = -1;
                int http_port = -1;
                String username = textUsername.getText();
                String password = passwordPassword.getText();
                
                xmpp_port = Integer.parseInt(textXMPPPort.getText());
                http_port = Integer.parseInt(textHTTPPort.getText());
                
                if (hostname.length() > 3 && xmpp_port > 0 && xmpp_port <= 65536
                        && http_port > 0 && http_port <= 65536
                        && username.length() > 0 && password.length() > 0) {
                    
                    /* XMPP-Connection */
                    ConnectionHandler ch = new ConnectionHandler();
                    
                    /* HTTP-Connection */
                    RESTConnectionHandler rch = new RESTConnectionHandler(hostname, http_port);
                    
                    if (ch.connect(hostname, xmpp_port) && rch.checkConnection()) {

                        if (rch.getUserID(username) != null && ch.login(username, password)) {
                            System.out.println("ID: " + rch.getUserID(null));
                            
                            // success
                            System.out.println("Connection and Login Success!");
                            
                            cf.setVisible(true);
                            cf.setEnabled(true);
                            cf.setConnectionHandlers(ch, rch);
                            setVisible(false);
                            textUsername.setText("");
                            passwordPassword.setText("");
                            lblStatus.setText("");
                            
                        } else {
                            lblStatus.setText("Anmeldung fehlgeschlagen!");
                        }
                    } else {
                        // failed
                        lblStatus.setText("Verbindungsherstellung fehlgeschlagen!");
                    }
                }

            }
        });

        btnVerbinden.setBounds(180, 175, 144, 25);
        contentPane.add(btnVerbinden);

        lblStatus = new JLabel("");
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblStatus.setBounds(90, 215, 245, 25);
        contentPane.add(lblStatus);

        setVisible(true);
    }

}
