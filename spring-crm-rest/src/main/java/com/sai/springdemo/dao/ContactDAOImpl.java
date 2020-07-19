package com.sai.springdemo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.springdemo.entity.Address;
import com.sai.springdemo.entity.Contact;
import com.sai.springdemo.entity.Email;
import com.sai.springdemo.entity.Phone;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mchange.v2.codegen.bean.Property;

@Repository
public class ContactDAOImpl implements ContactDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Contact> getContacts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Contact> theQuery = 
				currentSession.createQuery("from Contact order by lastName",
											Contact.class);
		
		// execute query and get result list
		List<Contact> contacts = theQuery.getResultList();
				
		// return the results		
		return contacts;
	}

	@Override
	public void saveContact(Contact theContact) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the contact ... finally LOL
		currentSession.saveOrUpdate(theContact);
		
	}

	@Override
	public Contact getContact(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Contact theContact = currentSession.get(Contact.class, theId);
		
		return theContact;
	}

	@Override
	public void deleteContact(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Contact where id=:contactId");
		theQuery.setParameter("contactId", theId);
		theQuery.executeUpdate();		
	}
	
	
	
	
	
	@Override
	public Map<Contact, Address>   extractEmployeeAttribute111s() {
	  	
   	 Map<Contact,Address> contactAddresses = new HashMap();
   	 
   	 Map<Contact,Address> fullList = new HashMap<>();
		
	    try {
	    	Session currentSession = sessionFactory.getCurrentSession();   	
	    	Query<Contact> contactsQuery = 
					currentSession.createQuery("from Contact order by contactId");
	    	List <Contact> contacts = contactsQuery.getResultList();
	    	Query<Address> addrssesQuery = 
					currentSession.createQuery("from Address order by contactId");
	    	List <Address> addresses = addrssesQuery.getResultList();
	    	Query<Phone> phoneQuery = 
					currentSession.createQuery("from Phone order by contactId");
	    	List <Phone> phones = phoneQuery.getResultList();
	    	Query<Email> emailQuery = 
					currentSession.createQuery("from Email order by contactId");
	    	List <Email> emails = emailQuery.getResultList();
	    
	  

			for (Address a : addresses) {
				for (Contact c : contacts) {
					if (c.getContactId() == a.getContactId()) {
						fullList.put(c, a);
					}
					//continue;
				}

			}
	    	 
	    	 
		 	 for(Entry<Contact, Address> entry : contactAddresses.entrySet())
		       {
		 	String jsonObj = new ObjectMapper().writeValueAsString(fullList);
		      //  System.out.println("1Key : " +jsonObj.toString());
		 	fullList.put(entry.getKey(), entry.getValue()) ;
		       } 	 
		 	


	    } catch (RuntimeException re) {
	     
	        throw re;

	    } catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return fullList;
	
	}
	@Override
	public List<Object>  extractEmployeeAttributes ()  {
		 System.out.println(" Don with Saibaba");
							  return null;
						  

	}

	@Override
	public String createNestedJasonObject() {	
		Session currentSession = sessionFactory.getCurrentSession();   	
    	Query<Contact> contactsQuery = 
				currentSession.createQuery("from Contact order by contactId");
    	List <Contact> contactList = contactsQuery.getResultList();
    	Query<Address> addrssesQuery = 
				currentSession.createQuery("from Address order by contactId");
    	List <Address> addressList = addrssesQuery.getResultList();
    	Query<Phone> phoneQuery = 
				currentSession.createQuery("from Phone order by contactId");
    	List <Phone> phoneList = phoneQuery.getResultList();
    	Query<Email> emailQuery = 
				currentSession.createQuery("from Email order by contactId");
    	List <Email> emailList = emailQuery.getResultList();
    	
    	JsonArray contactArray = new JsonArray();
		for (Contact c : contactList) {

			JsonObject jcontact = new JsonObject();
			jcontact.addProperty("Contact contactId", c.getContactId());
			jcontact.addProperty("firstName", c.getFirstName());
			jcontact.addProperty("middleName", c.getMiddleName());
			jcontact.addProperty("lastName", c.getLastName());

			// System.out.println(jcontact.toString());

			for (Address a : addressList) {
				JsonArray jaddressArray = new JsonArray();
				if (a.getContactId() == c.getContactId()) {
					JsonObject jaddress = new JsonObject();
					jaddress.addProperty("Address contactId", a.getAddressId());
					jaddress.addProperty("street", a.getStreet());
					jaddress.addProperty("city", a.getCity());
					jaddress.addProperty("state", a.getState());

					jaddressArray.add(jaddress);
					jcontact.add("address", jaddressArray);
				}
				for (Phone p : phoneList) {
					JsonArray phoneArray = new JsonArray();
					if (p.getContactId() == c.getContactId()) {
						JsonObject jphone = new JsonObject();
						jphone.addProperty("phone contactId", p.getPhoneId());
						jphone.addProperty("phoneType", p.getPhonetype());
						jphone.addProperty("phone", p.getPhone());
						phoneArray.add(jphone);
						jcontact.add("phone", phoneArray);

					}
					for (Email e : emailList) {
						JsonArray emailArray = new JsonArray();
						if (e.getContactId() == c.getContactId()) {
							JsonObject email = new JsonObject();
							email.addProperty("email contactId", e.getEmailId());
							email.addProperty("emailType", e.getEmailType());
							email.addProperty("email", e.getEmail());

							emailArray.add(email);
							jcontact.add("phone", emailArray);
							;

						}

					}

				}

			}

			contactArray.add(jcontact);
			
		}
		return contactArray.toString();
    	
    	

	}

	@Override
	public String getNestedJasonObject(int contactId) {
		
	
		
		
		Session currentSession = sessionFactory.getCurrentSession();   	
    	Query<Contact> contactsQuery = 
				currentSession.createQuery("from Contact where contactId ="+contactId+"  order by contactId");
    	List <Contact> contactList = contactsQuery.getResultList();
    	Query<Address> addrssesQuery = 
				currentSession.createQuery("from Address where contactId ="+contactId+"  order by contactId");
    	List <Address> addressList = addrssesQuery.getResultList();
    	Query<Phone> phoneQuery = 
				currentSession.createQuery("from Phone  where contactId ="+contactId+"   order by contactId");
    	List <Phone> phoneList = phoneQuery.getResultList();
    	Query<Email> emailQuery = 
				currentSession.createQuery("from Email  where contactId ="+contactId+"  order by contactId");
    	List <Email> emailList = emailQuery.getResultList();
    	
    	
    	
    	
    	JsonArray contactArray = new JsonArray();
		for (Contact c : contactList) {

			JsonObject jcontact = new JsonObject();
			jcontact.addProperty("Contact contactId", c.getContactId());
			jcontact.addProperty("firstName", c.getFirstName());
			jcontact.addProperty("middleName", c.getMiddleName());
			jcontact.addProperty("lastName", c.getLastName());

			// System.out.println(jcontact.toString());

			for (Address a : addressList) {
				JsonArray jaddressArray = new JsonArray();
				if (a.getContactId() == c.getContactId()) {
					JsonObject jaddress = new JsonObject();
					jaddress.addProperty("Address contactId", a.getAddressId());
					jaddress.addProperty("street", a.getStreet());
					jaddress.addProperty("city", a.getCity());
					jaddress.addProperty("state", a.getState());

					jaddressArray.add(jaddress);
					jcontact.add("address", jaddressArray);
				}
				for (Phone p : phoneList) {
					JsonArray phoneArray = new JsonArray();
					if (p.getContactId() == c.getContactId()) {
						JsonObject jphone = new JsonObject();
						jphone.addProperty("phone contactId", p.getPhoneId());
						jphone.addProperty("phoneType", p.getPhonetype());
						jphone.addProperty("phone", p.getPhone());
						phoneArray.add(jphone);
						jcontact.add("phone", phoneArray);

					}
					for (Email e : emailList) {
						JsonArray emailArray = new JsonArray();
						if (e.getContactId() == c.getContactId()) {
							JsonObject email = new JsonObject();
							email.addProperty("email contactId", e.getEmailId());
							email.addProperty("emailType", e.getEmailType());
							email.addProperty("email", e.getEmail());

							emailArray.add(email);
							jcontact.add("phone", emailArray);
							;

						}

					}

				}

			}

			contactArray.add(jcontact);
			
		}
		return contactArray.toString();

	}

	@Override
	public void deleteNestedJasonObject(int contactId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Address where id=:contactId");
		theQuery.setParameter("contactId", contactId);
		theQuery.executeUpdate();
		
		
		  theQuery = 
				currentSession.createQuery("delete from Phone where id=:contactId");
		theQuery.setParameter("contactId", contactId);
		theQuery.executeUpdate();
		
		  theQuery = 
				currentSession.createQuery("delete from Email where id=:contactId");
		theQuery.setParameter("contactId", contactId);
		theQuery.executeUpdate();
		
		currentSession.createQuery("delete from Contact where id=:contactId");
		theQuery.setParameter("contactId", contactId);
		theQuery.executeUpdate();
		
		 
	}

	@Override
	public void saveNestedJasonObject(Contact theContact) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();	
			
				
				Query<Address> addrssesQuery = 
						currentSession.createQuery("from Address where contactId ="+theContact.getContactId()+"  order by contactId");
		    	List <Address> addressList = addrssesQuery.getResultList();
		    	Query<Phone> phoneQuery = 
						currentSession.createQuery("from Phone  where contactId ="+theContact.getContactId()+"   order by contactId");
		    	List <Phone> phoneList = phoneQuery.getResultList();
		    	Query<Email> emailQuery = 
						currentSession.createQuery("from Email  where contactId ="+theContact.getContactId()+"  order by contactId");
		    	List <Email> emailList = emailQuery.getResultList();
				
				for(Address a : addressList)
				{
				currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(a);
				}
				
				
				for(Phone p : phoneList)
				{
				currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(p);
				}
				for(Email e  : emailList)
				{
				currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(e);
				}	
				currentSession.saveOrUpdate(theContact);
				
	
	}
	

}



