package com.sai.springdemo.dao;
import java.util.List;

import com.sai.springdemo.entity.Phone;
 
public interface PhoneDAO {

	public List<Phone> getPhones();
	
	public List<Phone> getByContactId(int contactId);

	public void savePhone(Phone thePhone);

	public Phone getPhone(int theId);

	public void deletePhone(int Phone);
	
}
