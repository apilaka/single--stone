package com.sai.springdemo.service;
import java.util.List;

import com.sai.springdemo.entity.Phone;
 
public interface PhoneService {

	public List<Phone> getPhones();

	public void savePhone(Phone thePhone);

	public Phone getPhone(int theId);

	public void delete(int Phone);
	
}
