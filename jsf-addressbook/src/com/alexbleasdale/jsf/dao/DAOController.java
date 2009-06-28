package com.alexbleasdale.jsf.dao;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;

import com.alexbleasdale.beans.Address;
import com.alexbleasdale.beans.ContactDetails;
import com.alexbleasdale.beans.Location;
import com.alexbleasdale.beans.Person;
import com.alexbleasdale.service.ContactDAO;

public class DAOController {

	ContactDAO cd;

	public DAOController() {
		Logger.getAnonymousLogger().log(Level.INFO,
				"DAOController :: in Constructor");
		cd = new ContactDAO();
	}

	/**
	 * Returns result if save to db took place
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doAddContact() {

		// Map parameterMap = FacesContext.getCurrentInstance()
		// .getExternalContext().getRequestParameterMap();
		// System.out.println("param map" + parameterMap.toString());
		//
		Map pm = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap();

		// TODO - can this method make a call to google maps and get the lat /
		// long values?

		Person p = (Person) pm.get("PersonBean");
		Address a = (Address) pm.get("AddressBean");
		ContactDetails c = (ContactDetails) pm.get("ContactDetailsBean");
		Location l = (Location) pm.get("LocationBean");

		p.setAddress(a);
		p.setContactDetails(c);
		p.setLocation(l);

		try {
			cd.saveOrUpdatePerson(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ("error");
		}

		return ("result");
	}
}
