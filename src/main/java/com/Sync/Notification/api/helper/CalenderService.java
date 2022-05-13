package com.Sync.Notification.api.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.UUID;

public class CalenderService {
	private JavaMailSender mailSender;

	public CalenderService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendCalendarInvite(String fromEmail, CalenderRequest calendarRequest) throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		mimeMessage.addHeaderLine("method=REQUEST");
		mimeMessage.addHeaderLine("charset=UTF-8");
		mimeMessage.addHeaderLine("component=VEVENT");
		mimeMessage.setFrom(new InternetAddress(fromEmail));
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(calendarRequest.getToEmail()));
		mimeMessage.setSubject(calendarRequest.getSubject());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
		StringBuilder builder = new StringBuilder();
		builder.append("BEGIN:VCALENDAR\n" +
                "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
                "VERSION:2.0\n" +
                "METHOD:REQUEST\n" +
                "BEGIN:VTIMEZONE\n" + 
                "TZID:Asia/Kolkata\n" + 
                "END:VTIMEZONE\n" +
                "BEGIN:VEVENT\n" +
                "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:"+calendarRequest.getToEmail()+"\n" +
                "ORGANIZER:MAILTO:"+fromEmail+"\n" +
                "DTSTART:"+ formatter.format(calendarRequest.getMeetingStartTime()).replace(" ", "T") + "\n" +
                "DTEND:"+ formatter.format(calendarRequest.getMeetingEndTime()).replace(" ","T") + "\n" +
                "LOCATION;LANGUAGE=en-US:AIS Office\n" +
                "TRANSP:OPAQUE\n" +
                "SEQUENCE:0\n" +
                "UID:" + calendarRequest.getUid() + "\n" +
                "DESCRIPTION:\n\n" +
                "SUMMARY:Interview Allotted\n" +
                "PRIORITY:5\n" +
                "CLASS:PUBLIC\n" +
                "BEGIN:VALARM\n" +
                "TRIGGER:PT1440M\n" +
                "ACTION:DISPLAY\n" +
                "DESCRIPTION:Reminder\n" +
                "END:VALARM\n" +
                "END:VEVENT\n" +
                "END:VCALENDAR");

		BodyPart messageCalendar = new MimeBodyPart();

		messageCalendar.setHeader("Content-Class", "urn:content-classes:calendarmessage");
		messageCalendar.setHeader("Content-ID", "calendar_message");
		messageCalendar.setContent(calendarRequest.getBody(), "String");
		messageCalendar.setDataHandler(new DataHandler(
				new ByteArrayDataSource(builder.toString(), "text/calendar")));
		MimeBodyPart bc = new MimeBodyPart();
        bc.setContent(calendarRequest.getBody(),"text/html");
        BodyPart messageBody = bc;
  
        //for attachment
        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile(calendarRequest.getFile());
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBody);
		multipart.addBodyPart(attachPart);
		multipart.addBodyPart(messageCalendar);
		mimeMessage.setContent(multipart);
		System.out.println(builder.toString());
		mailSender.send(mimeMessage);
		System.out.println("Calendar invite sent");

	}
}
