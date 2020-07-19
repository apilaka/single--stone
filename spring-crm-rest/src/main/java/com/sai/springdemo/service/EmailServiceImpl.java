package com.sai.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.springdemo.dao.EmailDAO;
import com.sai.springdemo.entity.Email;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDAO emailtDAO;
	@Override
	@Transactional
	public List<Email> getEmails() {
		return emailtDAO.getEmails();
	}
	@Override
	@Transactional
	public void saveEmail(Email theEmail) {
		emailtDAO.saveEmail(theEmail);
	}
	@Override
	@Transactional
	public Email getEmail(int theId) {
		return emailtDAO.getEmail(theId);
	}
	@Override
	@Transactional
	public void deleteEmail(int theId) {
		emailtDAO.deleteEmail(theId);
	}
}
