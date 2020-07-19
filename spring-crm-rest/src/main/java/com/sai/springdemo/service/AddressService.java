package com.sai.springdemo.service;
import java.util.List;

import com.sai.springdemo.entity.Address;
 

public interface AddressService {

	public List<Address> getAddresses();

	public void saveAddress(Address theAddress);

	public Address getAddress(int theId);

	public void deleteAddress(int theId);
	
}
