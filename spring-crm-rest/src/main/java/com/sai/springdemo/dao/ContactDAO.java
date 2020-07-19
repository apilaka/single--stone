package com.sai.springdemo.dao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonArray;
import com.sai.springdemo.entity.Address;
import com.sai.springdemo.entity.Contact;
 

public interface ContactDAO {

	public List<Contact> getContacts();
	public void saveContact(Contact theContact);
	public Contact getContact(int theId);
	public void deleteContact(int theId);
	public List<Object> extractEmployeeAttributes();
	public Map<Contact, Address> extractEmployeeAttribute111s();
	
	public String createNestedJasonObject();
	
	public String getNestedJasonObject(int contactId);
	
	public void deleteNestedJasonObject(int contactId);
	
	public void saveNestedJasonObject(Contact contact);
 
	
}
