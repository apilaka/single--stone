package com.sai.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.springdemo.dao.AddressDAO;
import com.sai.springdemo.dao.CustomerDAO;
import com.sai.springdemo.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDAO addressDAO;
	@Override
	@Transactional
	public List<Address> getAddresses() {
		return addressDAO.getAddresses();
	}
	@Override
	@Transactional
	public void saveAddress(Address theAddress) {
		addressDAO.saveAddress(theAddress);
	}
	@Override
	@Transactional
	public Address getAddress(int theId) {
		return addressDAO.getAddress(theId);
	}
	@Override
	@Transactional
	public void deleteAddress(int theId) {
		addressDAO.deleteAddress(theId);
	}

}
