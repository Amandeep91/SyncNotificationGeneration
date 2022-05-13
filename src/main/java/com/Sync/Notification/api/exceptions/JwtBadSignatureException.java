package com.Sync.Notification.api.exceptions;


@SuppressWarnings("serial")
public class JwtBadSignatureException extends RuntimeException {
    public JwtBadSignatureException(String message) {
        super(message);
    }
}
