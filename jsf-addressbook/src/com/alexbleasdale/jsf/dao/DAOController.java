package com.alexbleasdale.jsf.dao;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;

import com.alexbleasdale.beans.Address;
import com.alexbleasdale.beans.ContactDetails;
import com.alexbleasdale.beans.Location;
import com.alexbleasdale.beans.Person;
import com.alexbleasdale.http.HttpClientExecutor;
import com.alexbleasdale.json.JsonParserTools;
import com.alexbleasdale.service.ContactDAO;
import com.alexbleasdale.url.StringParserTools;

public class DAOController {

	ContactDAO cd;

	public DAOController() {
		Logger.getAnonymousLogger().log(Level.INFO,
				"DAOController :: in DAOController Constructor");
		cd = new ContactDAO();
	}

	/**
	 * Returns result if save to db took place
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doAddContact() {

		// TODO - this method now persists the bean, but should set a google
		// maps url too. e.g.
		// http://maps.google.com/?q=Your+text+here@37.4219720,-122.0841430
		// (long / lat)

		Map<?, ?> pm = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap();
		Person p = (Person) pm.get("PersonBean");
		Address a = (Address) pm.get("AddressBean");
		ContactDetails c = (ContactDetails) pm.get("ContactDetailsBean");

		// Now create the Google Maps link

		String url = StringParserTools.buildGmapsUrlFromAddress(a);
		/**
		 * This should be managed through jsf? Maybe something like a managed
		 * bean with a load of getters and setters which is kicked off in the
		 * faces-config.xml
		 */
		HttpClientExecutor hce = new HttpClientExecutor();
		String gMapsMetadata = hce.httpGet(url);
		Location l = new Location();
		l.setgMapsServiceMetadata(gMapsMetadata);
		l = JsonParserTools.parseGmapsJsonForLatAndLong(gMapsMetadata, l);

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
