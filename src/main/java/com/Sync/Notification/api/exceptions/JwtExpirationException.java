package com.Sync.Notification.api.exceptions;


@SuppressWarnings("serial")
public class JwtExpirationException extends RuntimeException {
    public JwtExpirationException(String message) {
        super(message);
    }
}
