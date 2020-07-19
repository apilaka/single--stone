package com.sai.springdemo.dao;
import java.util.List;

import com.sai.springdemo.entity.Address;
 

public interface AddressDAO {

	public List<Address> getAddresses();
	
	public List<Address> getByContactId(int contactId);

	public void saveAddress(Address theAddress);

	public Address getAddress(int theId);

	public void deleteAddress(int theId);
	
}
