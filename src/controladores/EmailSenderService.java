package controladores;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.activation.MailcapCommandMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSenderService {
	private final Properties properties = new Properties();
	private Session session;
	private String Texto;
	private String receptor;
	private String subject;

	private void init() {

		
//		properties.put("mail.smtp.host", "mail.ec.aseyco.com");
//		properties.put("mail.smtp.starttls.enable", "false");
//		properties.put("mail.smtp.port", 25);
//		properties.put("mail.smtp.mail.sender", "buxis@ec.aseyco.com");
//		properties.put("mail.smtp.auth", "false");
//		session = Session.getDefaultInstance(properties);
		
		properties.put("mail.smtp.host", "mail.onewayec.com");
		properties.put("mail.smtp.starttls.enable", "false");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.mail.sender", "soporte@onewayec.com");
		properties.put("mail.smtp.user", "soporte@onewayec.com");
		properties.put("mail.smtp.auth", "true");
		session = Session.getDefaultInstance(properties);
	}

	public void sendEmail() {
		init();
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String) properties
					.get("mail.smtp.mail.sender")));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
//					receptor));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(
					receptor));
			message.setSubject(subject);
			message.setText(Texto, "ISO-8859-1", "html");
			Transport t = session.getTransport("smtp");
			System.out.println("---------------------------------------------------");
			System.out.println("host:"+(String) properties.get("mail.smtp.host"));
			System.out.println("Usuario:"+(String) properties.get("mail.smtp.user"));
			System.out.println("PAsswd:"+"Usuario2005$");
			System.out.println("---------------------------------------------------");
//			t.connect();
			t.connect((String) properties.get("mail.smtp.user"),"Usuario2005$");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (MessagingException me) {
			// Aqui se deberia o mostrar un mensaje de error o en lugar
			// de no hacer nada con la excepcion, lanzarla para que el modulo
			// superior la capture y avise al usuario con un popup, por ejemplo.
			System.out
					.println("Error de envio de mail: -------------------------------------------------------------------------");
			me.printStackTrace();
			return;
		}
	}

	public void sendMeeting() {
		init();
		try {
			// register the text/calendar mime type
			MimetypesFileTypeMap mimetypes = (MimetypesFileTypeMap) MimetypesFileTypeMap
					.getDefaultFileTypeMap();
			mimetypes.addMimeTypes("text/calendar ics ICS");
			// register the handling of text/calendar mime type
			MailcapCommandMap mailcap = (MailcapCommandMap) MailcapCommandMap
					.getDefaultCommandMap();
			mailcap.addMailcap("text/calendar;; x-java-content-handler=com.sun.mail.handlers.text_plain");
	
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String) properties
					.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					receptor));
			message.setSubject(subject);
			// Create an alternative Multipart
			Multipart multipart = new MimeMultipart("alternative");
			// part 1, html text
			BodyPart messageBodyPart = buildHtmlTextPart();
			multipart.addBodyPart(messageBodyPart);
	
			// Add part two, the calendar
			BodyPart calendarPart = buildCalendarPart();
			multipart.addBodyPart(calendarPart);
	
			// Put the multipart in message
			message.setContent(multipart);
	
			// send the message
			Transport transport = session.getTransport("smtp");
			transport.connect((String) properties.get("mail.smtp.user"), "synchro.2014");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	private BodyPart buildHtmlTextPart() throws MessagingException {
        MimeBodyPart descriptionPart = new MimeBodyPart();

        //Note: even if the content is spcified as being text/html, outlook won't read correctly tables at all
        // and only some properties from div:s. Thus, try to avoid too fancy content
        String content = "<font size= 2>Mensaje enviado desde JAVA para Meeting Request</font>";
        descriptionPart.setContent(content, "text/html; charset=utf-8");
 
        return descriptionPart;
    }
 
    //define somewhere the icalendar date format
    private static SimpleDateFormat iCalendarDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmm'00'");
 
    private BodyPart buildCalendarPart() throws Exception {
 
        BodyPart calendarPart = new MimeBodyPart();
 
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date start = cal.getTime();
        cal.add(Calendar.HOUR_OF_DAY, 3);
        Date end = cal.getTime();
 
        //check the icalendar spec in order to build a more complicated meeting request
        String calendarContent =
                "BEGIN:VCALENDAR\n" +
                        "METHOD:REQUEST\n" +
                        "PRODID: BCP - Meeting\n" +
                        "VERSION:2.0\n" +
                        "BEGIN:VEVENT\n" +
                        "DTSTAMP:" + iCalendarDateFormat.format(start) + "\n" +
                        "DTSTART:" + iCalendarDateFormat.format(start)+ "\n" +
                        "DTEND:"  + iCalendarDateFormat.format(end)+ "\n" +
                        "SUMMARY:JAVA - Meeting Edison Sosa\n" +
                        "UID:324\n" +
                        "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:MAILTO:edison.sosa@ec.aseyco.com\n" +
                        "ORGANIZER:MAILTO:soporte@grupoconfia.com\n" +
                        "LOCATION:Tanda - Plaza del Rancho\n" +
                        "DESCRIPTION:Pruebas envio Meeting Request\n" +
                        "SEQUENCE:0\n" +
                        "PRIORITY:5\n" +
                        "CLASS:PUBLIC\n" +
                        "STATUS:CONFIRMED\n" +
                        "TRANSP:OPAQUE\n" +
                        "BEGIN:VALARM\n" +
                        "ACTION:DISPLAY\n" +
                        "DESCRIPTION:REMINDER\n" +
                        "TRIGGER;RELATED=START:-PT00H15M00S\n" +
                        "END:VALARM\n" +
                        "END:VEVENT\n" +
                        "END:VCALENDAR";
 
        calendarPart.addHeader("Content-Class", "urn:content-classes:calendarmessage");
        calendarPart.setContent(calendarContent, "text/calendar;method=CANCEL");
 
        return calendarPart;
    }

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
