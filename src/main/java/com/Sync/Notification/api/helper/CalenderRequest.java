package com.Sync.Notification.api.helper;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;

@Builder
public class CalenderRequest {
	private String uid = UUID.randomUUID().toString();
    private String toEmail;
    private String subject;
    private String body;
    private LocalDateTime meetingStartTime;
    private LocalDateTime meetingEndTime;
    private File file;
 
   
    public String getUid() {
        return uid;
    }
 
    public String getToEmail() {
        return toEmail;
    }
 
    public String getSubject() {
        return subject;
    }
 
    public String getBody() {
        return body;
    }
 
    public LocalDateTime getMeetingStartTime() {
        return meetingStartTime;
    }
 
    public LocalDateTime getMeetingEndTime() {
        return meetingEndTime;
    }

	public File getFile() {
		return file;
	}

 
}
