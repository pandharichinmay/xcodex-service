package com.rns.XCodeX.XCodeX_Product.domain;

import java.util.List;

public class CodexNotification {

	private List<String> registration_ids;
	private String to;
	private CodexNotificationObject notification;
	
	public List<String> getRegistration_ids() {
		return registration_ids;
	}
	public void setRegistration_ids(List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public void setNotification(CodexNotificationObject notification) {
		this.notification = notification;
	}
	public CodexNotificationObject getNotification() {
		return notification;
	}
	
}