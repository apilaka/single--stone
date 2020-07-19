package com.sai.springdemo.entity;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.xml.txw2.annotation.XmlElement;

import antlr.collections.List;
@Entity
@Table(name="contact2")

public class Contact2  implements Serializable{
	
	@Id
	@Column(name="contactId")
	private int contactId;	
	@Column(name="firstName")
	private String firstName;
	@Column(name="middleName")
	private String middleName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="email")
	private String email;

	    
	public Contact2( ) {
 
	}
//	@OneToMany(mappedBy="addressId")
//	private Set<Address> addresses;
	

	public Contact2(int contactId, String firstName, String middleName, String lastName, String email) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", email=" + email + "]";
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

 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}


	public static void main(String[] args) throws SQLException, JsonProcessingException {
//		Contact2 contact = new Contact2();
//		Map<Contact2,Address> fullList = new HashMap<>();
//		ArrayList<Contact2> contactList = new ArrayList<Contact2>();
//		ArrayList<Address> addressList = new ArrayList<Address>();
//				 String url= "jdbc:oracle:thin:@//localhost:1521/XE";
//				 java.sql.Connection con =DriverManager.getConnection(url, "hr", "hr");
//				 String query1 = "Select * from contact ";
//				 String query2 = "Select * from contact "; 
//				 java.sql.PreparedStatement stmt = con.prepareStatement(query1); 
//				 ResultSet rs = stmt.executeQuery(query1);
//				 if(rs!=null)
//				 {
//					 while(rs.next()) {
//						  contact = new Contact2
//								 (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
//						 contactList.add(contact);
//						
//						 }
//				 }
//				 
//				 stmt = con.prepareStatement(query2); 
//				  rs = stmt.executeQuery(query2);
//				 
//				 if(rs!=null)
//				 {
//					 while(rs.next()) {
//						 
//					 
//						 Address address = new Address
//								 (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
//						 addressList.add(address);
//						 }
//				 }
//				 
//				 
//			 	
//			 	  for (Contact2 c: contactList)
//			 	  {
//			 		 for (Address a: addressList) {
//			 			 if(c.getContactId()==a.getAddressId()) {
//			 			 	fullList.put(c, a) ;  	
//			 		 }
//			 	  }
//			 		
//			
//		 	  }
//			 	 for(Map.Entry<Contact2, Address> entry : fullList.entrySet())
//			       {
//			 		String jsonObj = new ObjectMapper().writeValueAsString(fullList);
//			           System.out.println("1Key : " +jsonObj.toString());
//			       } 
//			 	
//			 	 
//			 	
//			 	  
//			 	  
//	
 
	}		 
}		 
		 

