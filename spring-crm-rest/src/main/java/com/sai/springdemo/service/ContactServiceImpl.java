package com.sai.springdemo.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonArray;
import com.sai.springdemo.dao.AddressDAO;
import com.sai.springdemo.dao.ContactDAO;
import com.sai.springdemo.entity.Address;
import com.sai.springdemo.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	@Override
	@Transactional
	public List<Contact> getContacts() {
		return contactDAO.getContacts();
	}
	@Override
	@Transactional
	public void saveContact(Contact theContact) {
		contactDAO.saveContact(theContact);
	}
	@Override
	@Transactional
	public Contact getContact(int theId) {
		return contactDAO.getContact(theId);
	}
	
	@Override
	@Transactional
	public void deleteContact(int theId) {
		
		contactDAO.deleteContact(theId);
	}
	@Override
	@Transactional
	public List<Object> extractEmployeeAttributes() {
		return contactDAO.extractEmployeeAttributes();
	}
	@Override
	@Transactional
	public   Map<Contact, Address> extractEmployeeAttribute111s() {
		return contactDAO.extractEmployeeAttribute111s();
	}
	@Override
	@Transactional
	public String createNestedJasonObject()  {
	
		return  contactDAO.createNestedJasonObject();
	}
	@Override
	@Transactional
	public String getNestedJasonObject(int theId) {
		 
		return  contactDAO.createNestedJasonObject();
	}
	@Override
	@Transactional
	public void deleteNestedJasonObject(int theId) {
		contactDAO.deleteContact(theId);
	}
	@Override
	@Transactional
	public void saveNestedJasonObject(Contact  contact) {
		contactDAO.saveNestedJasonObject(contact);
	}

}
