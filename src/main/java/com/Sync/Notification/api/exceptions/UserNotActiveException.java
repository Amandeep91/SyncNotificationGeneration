package com.Sync.Notification.api.exceptions;

@SuppressWarnings("serial")
public class UserNotActiveException extends RuntimeException {
	public UserNotActiveException(String message) {
		super(message);
	}
}
