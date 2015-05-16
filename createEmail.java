import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import javax.activation.*;

public class createEmail
{
	private String recipient;
	private String sender;
	private String host = "localhost";
	private String subject;
	private String body;
	private Properties props;
	private Session session;
	private MimeMessage message;
	
	
	public String getHost()
	{
		return this.host;
	}
	
	public String getRecipient()
	{
		return this.recipient;
	}
	
	public String getSender()
	{
		return this.sender;
	}

	public void getInformation() 
	{
		recipient = JOptionPane.showInputDialog("Who is the email for?");
		sender = JOptionPane.showInputDialog("Where is the email coming from?");
		props = System.getProperties();
		props.setProperty("mail.smtp.host", this.getHost());
		session = Session.getDefaultInstance(props);
		
	
		
	}

	public void setSubject() 
	{
		subject = JOptionPane.showInputDialog("What is the subject of the message?");	
	}
	public String getSubject()
	{
		return this.subject;
	}
	public String getBody()
	{
		return this.body;
	}

	public void attachScan(Object scan) 
	{
	
		
	}

	public void composeMessage() 
	{
		body = JOptionPane.showInputDialog("What is the body of the message?");
	
		
	}

	public void sendMessage() 
	{
		try
		{
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(this.getSender()));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(this.getRecipient()));
			this.setSubject();
			message.setSubject(this.getSubject());
			BodyPart messageBody = new MimeBodyPart();
			this.composeMessage();
			messageBody.setText(this.getBody());
			Multipart parts = new MimeMultipart();
			parts.addBodyPart(messageBody);
			
			messageBody = new MimeBodyPart();
			String fileName = "newScan.jpg";
			DataSource src = new FileDataSource(fileName);
			messageBody.setDataHandler(new DataHandler(src));
			parts.addBodyPart(messageBody);
			
			message.setContent(parts);
			Transport.send(message);
			System.out.println("\n\t\tMessage sent");
			
		}
		catch(MessagingException ex)
		{
			
		}
	
		
	}

}
