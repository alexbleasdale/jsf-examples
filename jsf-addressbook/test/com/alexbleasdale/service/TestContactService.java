package com.alexbleasdale.service;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alexbleasdale.beans.Person;
import com.alexbleasdale.exception.DataNotFound;

public class TestContactService {

	@Test
	public void testGetContactList() throws DataNotFound {
		ContactDAO cd = new ContactDAO();
		List<Person> l = cd.getContacts();
		Assert.assertTrue(l.size() >= 1);

		for (Person p : l) {
			System.out.println(p.getFirstName() + " | " + p.getSurName());
		}

	}

}
