package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend {

	public void details(RegisterEnp registerEnp) throws IOException {
		System.out.print("check");
		String message = "First Name" + registerEnp.getFirstName() +
				"\n  LastName" + registerEnp.getLastName() + "\n Password " + registerEnp.getPassword() + "\n Address "
				+ registerEnp.getAddress() + "\n City " + registerEnp.getCity() + "\n Zip Code " + registerEnp.getZip()
				+ "\n State " + registerEnp.getState() + "\n Country " + registerEnp.getCountry();
		String to = registerEnp.getEmail();
		String subject = "Confirmation";
		Properties properties1 = new Properties();

		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\BHASKAR\\Desktop\\internship\\AdvProject2\\SaveFile2.Properties");
		properties1.load(fileInputStream);
		String from = properties1.getProperty("email");
		String password = properties1.getProperty("password");

		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, password);
			}
		});
		MimeMessage message2 = new MimeMessage(session);
		try {
			// from
			message2.setFrom(from);

			message2.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message2.setSubject(subject);

			message2.setText(message);

			Transport.send(message2);
			System.out.println("sent sucessfull");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
