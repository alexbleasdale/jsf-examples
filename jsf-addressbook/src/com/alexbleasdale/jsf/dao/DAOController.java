package com.alexbleasdale.jsf.dao;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;

import com.alexbleasdale.beans.Person;
import com.alexbleasdale.service.ContactDAO;

public class DAOController {

	public DAOController() {
		Logger.getAnonymousLogger().log(Level.INFO, "DAOController - present");
		System.out.println("does this show up?");
	}

	/**
	 * Returns result if save to db took place
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doAddContact() throws Exception {

		Map parameterMap = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		System.out.println("param map" + parameterMap.toString());

		Map parameterMap2 = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestMap();
		System.out.println("param map2" + parameterMap2.toString());
		Person p = new Person();
		for (Object o : parameterMap2.keySet()) {
			if (o.equals("PersonBean")) {
				p = (Person) parameterMap2.get(o);
			}
		}
		System.out.println(p.getFirstName() + " | " + p.getSurName());
		ContactDAO cd = new ContactDAO();
		cd.saveOrUpdatePerson(p);
		// Person p = (Person) parameterMap.get(PersonBean);
		// System.out.println(p.toString());
		// Person p = parameterMap2.get();
		// System.out.println(p.toString());
		// TODO - if this is a managed bean, it should instantiate all the
		// pieces it needs once and only once
		Logger.getAnonymousLogger().log(Level.INFO,
				"DAOController - handling Add");
		System.out
				.println("****** ******** *********  WE ARE HERE!! ***** *****  ***** ");

		return ("result");
	}
}
