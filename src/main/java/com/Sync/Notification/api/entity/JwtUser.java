package com.Sync.Notification.api.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class JwtUser implements UserDetails {

    private String username;

    private Collection<? extends GrantedAuthority> authorities;

    @SuppressWarnings("unused")
	private Date creationDate;

    @SuppressWarnings("unchecked")
	public JwtUser(String username, Date creationDate) {
        this(username, creationDate, Collections.EMPTY_LIST);
    }

    public JwtUser(String username, Date creationDate, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.creationDate = creationDate;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        // no password inside JWT token.
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // A token is never locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // == token expiration
        // TODO
        return true;
    }

    @Override
    public boolean isEnabled() {
        // always enabled in JWT case.
        return true;
    }
}
