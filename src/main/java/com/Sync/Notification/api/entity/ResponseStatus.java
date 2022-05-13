package com.Sync.Notification.api.entity;

public class ResponseStatus<T> {
	private boolean status;
	private T Body;
	private String Description;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public T getBody() {
		return Body;
	}

	public void setBody(T body) {
		Body = body;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
