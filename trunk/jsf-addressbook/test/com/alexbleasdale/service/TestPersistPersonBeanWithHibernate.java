package com.alexbleasdale.service;

import java.util.Date;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alexbleasdale.beans.Address;
import com.alexbleasdale.beans.ContactDetails;
import com.alexbleasdale.beans.Location;
import com.alexbleasdale.beans.Person;
import com.alexbleasdale.exception.DataNotFound;
import com.alexbleasdale.hibernate.HibernateUtil;

public class TestPersistPersonBeanWithHibernate {

	private ContactDAO cd;

	@BeforeClass
	public void GenerateTables() throws Exception {
		Configuration config;
		config = HibernateUtil.getInitializedConfiguration();
		new SchemaExport(config).create(true, true);

		// Create a new Contact
		Person p = new Person();
		p.setFirstName("Test");
		p.setMiddleName("A");
		p.setSurName("Person");
		p.setDateOfBirth(new Date());

		Address a = new Address();
		a.setCity("London");
		a.setCountry("England");
		p.setAddress(a);

		ContactDetails c = new ContactDetails();
		c.setEmail("test@example.com");
		p.setContactDetails(c);

		Location l = new Location();
		l.setLongitude(10.0);
		l.setLatitude(10.0);
		p.setLocation(l);

		cd = new ContactDAO();
		cd.saveOrUpdatePerson(p);

	}

	@Test
	public void testDAOFunctionality() throws DataNotFound {
		List<Person> l = cd.getContacts();
		Assert.assertTrue(l.size() >= 1);
	}

	@Test
	public void testGetPersonBySurname() throws DataNotFound {
		Person p = cd.getPersonBySurname("Person");
		Assert.assertEquals("Test", p.getFirstName());
	}

	@Test
	public void testGetPersonBySurameThenUpdateRecord() throws Exception {
		Person p = cd.getPersonBySurname("Person");
		Assert.assertEquals("Test", p.getFirstName());
		Assert.assertEquals("test@example.com", p.getContactDetails()
				.getEmail());

		ContactDetails c = p.getContactDetails();
		c.setHomeTelephone("1234567890");
		c.setMobileTelephone("0987654321");
		p.setContactDetails(c);

		Assert.assertEquals("0987654321", p.getContactDetails()
				.getMobileTelephone());

		cd.saveOrUpdatePerson(p);

		Person p2 = cd.getPersonBySurname("Person");
		Assert.assertEquals("1234567890", p2.getContactDetails()
				.getHomeTelephone());
		Assert.assertEquals("0987654321", p2.getContactDetails()
				.getMobileTelephone());

	}

	@Test
	public void testCreatePersonThenGetPersonBySurnameThenDeletePerson()
			throws Exception {

		Person p = new Person();
		p.setFirstName("Bar");
		p.setSurName("Foo");
		cd.saveOrUpdatePerson(p);
		Person p2 = cd.getPersonBySurname("Foo");
		p2.setMiddleName("Test");
		Assert.assertEquals("Foo", p2.getSurName());
		cd.saveOrUpdatePerson(p2);
		Person p3 = cd.getPersonBySurname("Foo");
		Assert.assertEquals("Test", p3.getMiddleName());
		cd.deletePerson(p3);

		List<Person> l = cd.getContacts();
		Assert.assertTrue(l.size() == 1);

	}
}
