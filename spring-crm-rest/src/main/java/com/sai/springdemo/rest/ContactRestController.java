package com.sai.springdemo.rest;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.sai.springdemo.entity.Address;
import com.sai.springdemo.entity.Contact;
import com.sai.springdemo.entity.Customer;
import com.sai.springdemo.entity.Email;
import com.sai.springdemo.entity.Phone;
import com.sai.springdemo.service.AddressService;
import com.sai.springdemo.service.ContactService;
import com.sai.springdemo.service.CustomerService;
import com.sai.springdemo.service.EmailService;
import com.sai.springdemo.service.PhoneService;

@RestController
@RequestMapping("/api")
public class ContactRestController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts")
	public java.util.List<Contact> getContacts() {
		return contactService.getContacts();
	}

	@GetMapping("/contacts/{contactId}")
	public Contact getContact(@PathVariable int contactId) {
		Contact theContact = contactService.getContact(contactId);
		if (theContact == null) {
			throw new ContactNotFoundException();
		}
		return theContact;
	}

	@PostMapping("/contacts")
	public Contact addContact(@RequestBody Contact theContact) {
		theContact.setContactId(11);
		contactService.saveContact(theContact);
		return theContact;
	}

	@PutMapping("/contacts")
	public Contact updateContact(@RequestBody Contact theContact) {
		theContact.setContactId(0);
		contactService.saveContact(theContact);
		return theContact;
	}

	@DeleteMapping("/contacts/{contactId}")
	public String deleteContact(@PathVariable int contactId) {
		
		Contact thetempContact = contactService.getContact(contactId);
		if (thetempContact == null) {
			throw new ContactNotFoundException();
		}
		contactService.deleteContact(contactId);
		return "Deleted " + contactService.getContact(contactId);
	}
	
	
	
	@Autowired
	private AddressService addressService;
	@GetMapping("/addresses")
	public java.util.List<Address> getAddresses() {
		return addressService.getAddresses();
	}
	
	@Autowired
	private PhoneService phoneService;
	@GetMapping("/phones")
	public java.util.List<Phone> getPhones() {
		return phoneService.getPhones();
	}
	
	@Autowired
	private EmailService emailService;
	@GetMapping("/emails")
	public java.util.List<Email> getEmails() {
		return emailService.getEmails();
	}
	

	@GetMapping("/India")
	public java.util.List<Object> getAAll()  {
		return contactService.extractEmployeeAttributes();
	}
	

	@GetMapping("/allRecords")
	public Map<Contact, Address> extractEmployeeAttribute111s()  {
		return contactService.extractEmployeeAttribute111s();
	}
;
	@GetMapping("/AllContactDetailsRecords")
	public String createNestedJasonObject()  {
		return contactService.createNestedJasonObject();
	}
	@GetMapping("/saveContactDetailsRecords")
	public void saveNestedJasonObject(Contact theContact)  {
		  contactService.saveNestedJasonObject( theContact);
	}
	@GetMapping("/deleteContactDetailsRecords/{contactId}")
	public void deleteNestedJasonObject(@PathVariable int contactId)  {
		  contactService.deleteNestedJasonObject(contactId);
	}
	
	@GetMapping("/findContactDetailsRecords/{contactId}")
	public String findNestedJasonObject(@PathVariable int contactId)  {
		return contactService.getNestedJasonObject(contactId);
	}
	
	
	
	 
}
