package com.xworkz.springmvc.dto;

public class MailDto {

	private String mailId;
	private String subject;
	private String message;

	public MailDto() {

	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MailDto [mailId=" + mailId + ", subject=" + subject + ", message=" + message + "]";
	}

}
