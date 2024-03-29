package com.alexbleasdale.service;

import java.util.List;
import java.util.logging.Level;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	/**
	 * Returns a list of all Contacts in the database
	 */
	public List<Person> getContacts() throws DataNotFound {

		try {
			Session s = HibernateUtil.beginTransaction();
			List<Person> results = s.createQuery("from Person").list();
			return results;
		} catch (HibernateException e) {
			log
					.log(Level.SEVERE,
							"The DAO could not retrieve the user list", e);
			throw new DataNotFound("The DAO could not retrieve the user list",
					e);
		}
	}

	public Person getPersonBySurname(String name) throws DataNotFound {

		try {
			Session s = HibernateUtil.beginTransaction();
			Query q = s.createQuery("from Person p where p.surName = :name");
			q.setString("name", name);
			List<?> results = q.list();
			Person p = null;
			if (results.size() == 1) {
				p = (Person) results.get(0);
			}
			return p;

		} catch (HibernateException e) {
			log.log(Level.SEVERE, "The DAO could not retrieve the named user",
					e);
			throw new DataNotFound("The DAO could not retrieve the named user",
					e);
		}
	}

	/**
	 * Saves or updates a Contact (Person)
	 * 
	 * @param p
	 * @throws Exception
	 */
	public void saveOrUpdatePerson(Person p) throws Exception {
		try {
			Session s = HibernateUtil.beginTransaction();
			s.saveOrUpdate(p);
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			log.log(Level.SEVERE,
					"The DAO could not save or update the Contact", e);
			HibernateUtil.rollbackTransaction();
			throw new DataNotFound(
					"The DAO could not save or update the Contact", e);
		}

	}

	/**
	 * Deletes a contact (Person)
	 * 
	 * @param p
	 * 
	 * @throws Exception
	 */
	public void deletePerson(Person p) throws Exception {
		try {
			Session s = HibernateUtil.beginTransaction();
			s.delete(p);
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			log.log(Level.SEVERE, "The DAO could not delete the Contact", e);
			HibernateUtil.rollbackTransaction();
			throw new DataNotFound("The DAO could not delete the Contact", e);
		}
	}

}
