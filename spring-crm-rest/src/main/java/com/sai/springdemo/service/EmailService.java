package com.sai.springdemo.service;

import java.util.List;

import com.sai.springdemo.entity.Email;

public interface EmailService {
	public List<Email> getEmails();

	public void saveEmail(Email theEmail);

	public Email getEmail(int theId);

	public void deleteEmail(int theId);
}
