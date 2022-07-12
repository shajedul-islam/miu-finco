package notification.impl;

import ioc.IComponent;
import notification.INotification;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailNotification implements INotification, IComponent {
    private String username;
    private String password;
    private String host;
    private String port;
    private String auth;
    private String tlsEnabled;


    @Override
    public void send(String to, String content) {
        System.out.println("Sending Email from: " + username + " to: " + to + " content: " + content);

        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", auth);
        prop.put("mail.smtp.starttls.enable", tlsEnabled); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject("MIU ASD Bank Application");
            message.setText("Dear Customer,"
                    + "\n\n You have a notification: \n\n" + content);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getTlsEnabled() {
        return tlsEnabled;
    }

    public void setTlsEnabled(String tlsEnabled) {
        this.tlsEnabled = tlsEnabled;
    }
}
