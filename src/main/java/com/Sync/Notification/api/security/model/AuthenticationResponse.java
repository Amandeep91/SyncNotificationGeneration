package com.Sync.Notification.api.security.model;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

	private String token;
	private String ais_id;
	private String email;
	private boolean status;
	private String message;
	private Collection<? extends GrantedAuthority> authorities;

}