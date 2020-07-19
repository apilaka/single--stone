package com.sai.springdemo.dao;

import java.util.List;

import com.sai.springdemo.entity.Email;
import com.sai.springdemo.entity.Phone;

public interface EmailDAO {
	public List<Email> getEmails();

	public List<Email> getByContactId(int contactId);
	
	public void saveEmail(Email theEmail);

	public Email getEmail(int theId);

	public void deleteEmail(int theId);
}
