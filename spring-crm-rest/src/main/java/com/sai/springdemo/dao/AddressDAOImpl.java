package com.sai.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.springdemo.entity.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Address> getAddresses() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Address> theQuery = 
				currentSession.createQuery("from Address order by addressId",
											Address.class);
		
		// execute query and get result list
		List<Address> addresss = theQuery.getResultList();
				
		// return the results		
		return addresss;
	}
		
	@Override
	public List<Address> getByContactId(int contactId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Address> theQuery = 
				currentSession.createQuery("from Address where contactId = " + contactId + "order by addressId",
											Address.class);
		
		// execute query and get result list
		List<Address> addresss = theQuery.getResultList();
				
		// return the results		
		return addresss;
	}

	@Override
	public void saveAddress(Address theAddress) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the address ... finally LOL
		currentSession.saveOrUpdate(theAddress);
		
	}

	@Override
	public Address getAddress(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Address theAddress = currentSession.get(Address.class, theId);
		
		return theAddress;
	}

	@Override
	public void deleteAddress(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Address where id=:contactId");
		theQuery.setParameter("contactId", theId);
		
		theQuery.executeUpdate();		
	}

}











