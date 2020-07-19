package com.sai.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.springdemo.entity.Email;
import com.sai.springdemo.entity.Phone;

@Repository
public class PhoneDAOImpl implements PhoneDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Phone> getPhones() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Phone> theQuery = 
				currentSession.createQuery("from Phone order by phoneType",
											Phone.class);
		
		// execute query and get result list
		List<Phone> phones = theQuery.getResultList();
				
		// return the results		
		return phones;
	}
	
	@Override
	public List<Phone> getByContactId(int contactId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Phone> theQuery = 
				currentSession.createQuery("from Phone where contactId = " + contactId + "order by contactId",
						Phone.class);
		
		// execute query and get result list
		List<Phone> phones = theQuery.getResultList();
				
		// return the results		
		return phones;
	}

	@Override
	public void savePhone(Phone thePhone) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the phone ... finally LOL
		currentSession.saveOrUpdate(thePhone);
		
	}

	@Override
	public Phone getPhone(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Phone thePhone = currentSession.get(Phone.class, theId);
		
		return thePhone;
	}

	@Override
	public void deletePhone(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Email where id=:contactId");
		theQuery.setParameter("contactId", theId);
		
		theQuery.executeUpdate();		
	}

}











