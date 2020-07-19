package com.sai.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.springdemo.dao.PhoneDAO;
import com.sai.springdemo.entity.Phone;

@Service
public class PhoneServiceImpl implements PhoneService {
	@Autowired
	private PhoneDAO phoneDAO;
	
	@Override
	@Transactional
	public List<Phone> getPhones() {
		 
		return phoneDAO.getPhones();
	}

	@Override
	@Transactional
	public void savePhone(Phone thePhone) {
		phoneDAO.savePhone(thePhone);
	}

	@Override
	@Transactional
	public Phone getPhone(int theId) {
		// TODO Auto-generated method stub
		return phoneDAO.getPhone(theId);
	}

	@Override
	@Transactional
	public void delete(int Phone) {
		phoneDAO.deletePhone(Phone);

	}

}
