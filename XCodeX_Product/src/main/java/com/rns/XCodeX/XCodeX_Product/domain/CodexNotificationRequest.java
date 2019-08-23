package com.rns.XCodeX.XCodeX_Product.domain;

import java.util.List;

public class CodexNotificationRequest {

	private List<Long> users;
	private String title;
	private String body;
	
	public List<Long> getUsers() {
		return users;
	}
	public void setUsers(List<Long> users) {
		this.users = users;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
