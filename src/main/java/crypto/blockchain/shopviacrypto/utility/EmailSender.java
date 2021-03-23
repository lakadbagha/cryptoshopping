package crypto.blockchain.shopviacrypto.utility;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import crypto.blockchain.shopviacrypto.bean.EmailMessage;

public class EmailSender {

	private String username;
	private String password;

	public EmailSender() {
		username = "shopviacrypto@gmail.com";
		password = "ShiningStar0224";
	}

	public String createAccount(String url, String e_address) {
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setSubject("Please Confirm Your Account on shopviacrypto");
		emailMessage.setBody(MessageTemplate.CreateAccountMessage(url));
		emailMessage.setTo_address(e_address);
		try {
			sendEmail(emailMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return "Successfully send";
	}

	public String sendEmail(EmailMessage emailmessage) throws Exception {
		sendmail(emailmessage);
		return null;
	}

	private void sendmail(EmailMessage emailmessage) throws AddressException, MessagingException, IOException {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		System.out.println("username >>" + username);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username, false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailmessage.getTo_address()));
		msg.setSubject(emailmessage.getSubject());
		msg.setContent(emailmessage.getBody(), "text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(emailmessage.getBody(), "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);
		// sends the e-mail
		Transport.send(msg);

	}
}