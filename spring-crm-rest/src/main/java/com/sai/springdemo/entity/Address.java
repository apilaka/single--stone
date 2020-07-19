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

import com.sun.xml.txw2.annotation.XmlElement;



@Entity
@Table(name="address")
public class Address  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="addressId")
	private int addressId;
	@Column(name="street")
	private	String street;
	@Column(name="city")
	private	String city;
	@Column(name="state")
	private	String state;
	@Column(name="zip")
	private	String zip;
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
	@JoinColumn(name="contactid", insertable = false, updatable = false)
	private Contact contact;
	
	
	 public Address( ){
		 
	 }

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address(int addressId, String street, String city, String state, String zip, int contactId) {
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.contactId=contactId;
	}
	

@Override
public String toString() {
	return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state + ", zip="
			+ zip + "]";
}

	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public String getZip() {
		return zip;
	}

	
	public void setZip(String zip) {
		this.zip = zip;
	}

 


}



