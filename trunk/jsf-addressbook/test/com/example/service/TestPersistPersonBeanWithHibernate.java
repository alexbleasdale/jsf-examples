package com.example.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.hibernate.HibernateUtil;
import com.example.jsf.beans.Address;
import com.example.jsf.beans.Location;
import com.example.jsf.beans.Person;

public class TestPersistPersonBeanWithHibernate {

	@BeforeClass
	public void GenerateTables() throws Exception {
		Configuration config;
		config = HibernateUtil.getInitializedConfiguration();
		new SchemaExport(config).create(true, true);
	}

	@Test
	public void PersistOnePersonToDb() throws Exception {

		Session s = HibernateUtil.beginTransaction();

		Person p = new Person();
		p.setFirstName("Test");
		p.setMiddleName("A");
		p.setSurName("Person");
		p.setDateOfBirth(new Date());

		Address a = new Address();
		a.setCity("London");
		a.setCountry("England");
		p.setAddress(a);

		Location l = new Location();
		l.setLongitude(10.0);
		l.setLatitude(10.0);
		p.setLocation(l);

		s.saveOrUpdate(p);

		HibernateUtil.commitTransaction();

	}
}
