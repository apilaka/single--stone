package com.sai.springdemo.entity;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sai.springdemo.dao.ContactDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.xml.txw2.annotation.XmlElement;

//@NamedQueries(  
//	    {  
//	    	@NamedQuery(name = "listContactDetails", query = "SELECT DISTINCT o "  
//	    			+" FROM Contact c, Address a, Phone p, Email e " 
//	    			+" JOIN a.street street " 
//	    			+" JOIN p.phone phone "
//	    			+" JOIN e.email email "
//	    			+" WHERE c.contactId = a.contactId AND p.contactId = e.contactId AND p.contactId :contactId"
//
//	        )  
//	    }  
//	)  
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

	@Id
	@Column(name = "contactId")
	private int contactId;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "middleName")
	private String middleName;
	@Column(name = "lastName")
	private String lastName;

	public Contact() {

	}

	@OneToMany(mappedBy = "addressId")
	private List<Address> addresses;

	@OneToMany(mappedBy = "phoneId")
	private List<Phone> phones;

	@OneToMany(mappedBy = "emailId")
	private List<Email> emails;

	public Contact(int contactId, String firstName, String middleName, String lastName) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public Contact(int i, String string, String string2, String string3, Address a) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + "]";
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}



	public static void main(String[] args)  {
		

	}
}
