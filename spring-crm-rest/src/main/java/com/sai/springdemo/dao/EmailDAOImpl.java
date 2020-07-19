package com.sai.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.springdemo.entity.Address;
import com.sai.springdemo.entity.Email;

@Repository
public class EmailDAOImpl implements EmailDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Email> getEmails() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Email> theQuery = 
				currentSession.createQuery("from Email order by emailType",
											Email.class);
		
		// execute query and get result list
		List<Email> emails = theQuery.getResultList();
				
		// return the results		
		return emails;
	}
	
	@Override
	public List<Email> getByContactId(int contactId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Email> theQuery = 
				currentSession.createQuery("from Email where contactId = " + contactId + "order by emailId",
											Email.class);
		
		// execute query and get result list
		List<Email> emails = theQuery.getResultList();
				
		// return the results		
		return emails;
	}

	@Override
	public void saveEmail(Email theEmail) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the email ... finally LOL
		currentSession.saveOrUpdate(theEmail);
		
	}

	@Override
	public Email getEmail(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Email theEmail = currentSession.get(Email.class, theId);
		
		return theEmail;
	}

	@Override
	public void deleteEmail(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Email where id=:contactId");
		theQuery.setParameter("contactId", theId);
		
		theQuery.executeUpdate();		
	}

}











