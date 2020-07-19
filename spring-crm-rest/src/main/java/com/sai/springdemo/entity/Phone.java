package com.sai.springdemo.entity;

import java.io.Serializable;

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
@Table(name="phone")
public class Phone implements Serializable {
	
	@Id
	@Column(name="phoneId")
	private int phoneId;
	@Column(name="phonetype")
	private String phonetype;
	@Column(name="phone")
	private String phone;
	@Column(name="contactId")
	private	int contactId;
	
	
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "contactId" , insertable = false, updatable = false)
	private Contact contact;

public Phone() {
	
}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phonetype=" + phonetype + ", phone=" + phone + "]";
	}


	public Phone(int phoneId, String phonetype, String phone, int contactId) {
		this.phoneId = phoneId;
		this.phonetype = phonetype;
		this.phone = phone;
		this.contactId = contactId;
	}

	 
	/**
	 * @return the phoneId
	 */
	public int getPhoneId() {
		return phoneId;
	}


	/**
	 * @param contactid the phoneId to set
	 */
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}


	/**
	 * @return the phonetype
	 */
	public String getPhonetype() {
		return phonetype;
	}


	/**
	 * @param phonetype the phonetype to set
	 */
	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

 
	 
}
