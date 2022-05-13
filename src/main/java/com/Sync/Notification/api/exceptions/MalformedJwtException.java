package com.Sync.Notification.api.exceptions;


@SuppressWarnings("serial")
public class MalformedJwtException extends RuntimeException {
    public MalformedJwtException(String message) {
        super(message);
    }
}
