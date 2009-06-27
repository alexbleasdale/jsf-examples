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
		cd = new ContactDAO();
	}

	@Test
	public void testAddOnePersonToDb() throws Exception {

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

		cd.saveOrUpdatePerson(p);
	}

	@Test
	public void testDAOFunctionality() throws DataNotFound {
		ContactDAO cd = new ContactDAO();
		List<Person> l = cd.getContacts();

		for (Person p : l) {
			System.out.println(p.getFirstName() + " " + p.getSurName());
		}

		Assert.assertTrue(l.size() == 1);
	}
}
