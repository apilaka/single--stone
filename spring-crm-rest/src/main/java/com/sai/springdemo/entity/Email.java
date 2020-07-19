package com.sai.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@XmlRootElement
@Entity
@Table(name="email")
public class Email {
	@Id
	@Column(name="emailId")
	private int emailId;
	@Column(name="emailtype")
	private String emailType;
	@Column(name="email")
	private String email;
	@Column(name="contactId" )
	private int contactId;
	
	
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "contactId" , insertable = false, updatable = false )
	private Contact contact;
	
	public Email() {
		
	}
	public int getEmailId() {
		return emailId;
	}
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Email(int emailId, String emailType, String email, int contactId) {
		super();
		this.emailId = emailId;
		this.emailType = emailType;
		this.email = email;
		this.contactId = contactId;
	}
	@Override
	public String toString() {
		return "Email [emailId=" + emailId + ", emailType=" + emailType + ", email=" + email + "]";
	}
	 
	 

}
