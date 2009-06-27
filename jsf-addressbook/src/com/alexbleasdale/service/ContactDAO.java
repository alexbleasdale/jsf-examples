package com.alexbleasdale.service;

import java.util.List;
import java.util.logging.Level;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.alexbleasdale.beans.Person;
import com.alexbleasdale.exception.DataNotFound;
import com.alexbleasdale.hibernate.HibernateUtil;

/**
 * DAO for all Person (contact) information
 * 
 * @author alexbleasdale
 * 
 */

public class ContactDAO extends DAO {

	// public ContactDAO{}

	public List<Person> getContacts() throws DataNotFound {

		try {
			Session s = HibernateUtil.beginTransaction();
			List<Person> results = s.createQuery("from Person").list();
			return results;
		} catch (HibernateException e) {
			log.log(Level.SEVERE, "The DAO could not retrieve the named user",
					e);
			throw new DataNotFound("The DAO could not retrieve the named user",
					e);
		}
	}
}
