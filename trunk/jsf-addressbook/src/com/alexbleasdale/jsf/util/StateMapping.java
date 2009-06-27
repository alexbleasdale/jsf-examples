package com.alexbleasdale.jsf.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import com.alexbleasdale.exception.IsoCountryCodeError;

/**
 * 
 * Maps the standard 2-digit State and Province codes (US/CA only) against State
 * and province names
 * 
 * @author alexbleasdale
 * 
 */
public class StateMapping {

	private HtmlSelectOneMenu stateSelectOneMenu;

	private final Map<String, String> USStateMapping = new HashMap<String, String>() {

		private static final long serialVersionUID = 878045909051468915L;

		{
			put("AL", "Alabama");
			put("AK", "Alaska");
			put("AZ", "Arizona");
			put("AR", "Arkansas");
			put("CA", "California");
			put("CO", "Colorado");
			put("CT", "Connecticut");
			put("DE", "Delaware");
			put("DC", "District of Columbia");
			put("FL", "Florida");
			put("GA", "Georgia");
			put("GU", "Guam");
			put("HI", "Hawaii");
			put("ID", "Idaho");
			put("IL", "Illinois");
			put("IN", "Indiana");
			put("IA", "Iowa");
			put("KS", "Kansas");
			put("KY", "Kentucky");
			put("LA", "Louisiana");
			put("ME", "Maine");
			put("MD", "Maryland");
			put("MA", "Massachusetts");
			put("MI", "Michigan");
			put("MN", "Minnesota");
			put("MS", "Mississippi");
			put("MO", "Missouri");
			put("MT", "Montana");
			put("NE", "Nebraska");
			put("NV", "Nevada");
			put("NH", "New Hampshire");
			put("NJ", "New Jersey");
			put("NM", "New Mexico");
			put("NY", "New York");
			put("NC", "North Carolina");
			put("ND", "North Dakota");
			put("OH", "Ohio");
			put("OK", "Oklahoma");
			put("OR", "Oregon");
			put("PA", "Pennyslvania");
			put("PR", "Puerto Rico");
			put("RI", "Rhode Island");
			put("SC", "South Carolina");
			put("SD", "South Dakota");
			put("TN", "Tennessee");
			put("TX", "Texas");
			put("UT", "Utah");
			put("VT", "Vermont");
			put("VA", "Virginia");
			put("VI", "Virgin Islands");
			put("WA", "Washington");
			put("WV", "West Virginia");
			put("WI", "Wisconsin");
			put("WY", "Wyoming");
		}
	};

	// Canadian Territories
	private final Map<String, String> CAStateMapping = new HashMap<String, String>() {

		private static final long serialVersionUID = -3297656017017122144L;

		{
			put("AB", "Alberta");
			put("BC", "British Columbia");
			put("MB", "Manitoba");
			put("NB", "New Brunswick");
			put("NL", "Newfoundland and Labrador");
			put("NT", "Northwest Territories");
			put("NS", "Nova Scotia");
			put("NU", "Nunavut");
			put("PE", "Prince Edward Island");
			put("SK", "Saskatchewan");
			put("ON", "Ontario");
			put("QC", "Quebec");
			put("YT", "Yukon");
		}
	};

	// private Map<String, String> getUSStateMapping() {
	// return USStateMapping;
	// }
	//
	// private Map<String, String> getCAStateMapping() {
	// return CAStateMapping;
	// }

	/**
	 * Takes a Postal Abbreviation State Code for US / Canada and returns the
	 * Region Common Name
	 * 
	 * @param code
	 * @return
	 * @throws IsoCountryCodeError
	 */
	public String getStateNameFromCode(String code) throws IsoCountryCodeError {

		if (USStateMapping.containsKey(code)) {
			return USStateMapping.get(code);
		} else if (CAStateMapping.containsKey(code)) {
			return CAStateMapping.get(code);
		} else {
			throw new IsoCountryCodeError(
					"Unrecognised / unsupported US / Canadian State Code : "
							+ code);
		}

	}

	/**
	 * Returns a Sorted Map of all US States (POSTAL ABBREVIATION(K), COMMON
	 * NAME(V))
	 * 
	 * @see: http://en.wikipedia.org/wiki/ISO_3166-2_codes_for_the_United_States
	 * @return TreeMap<String, String>
	 */
	public Map<String, String> getUSStates() {
		SortedMap<String, String> tm = new TreeMap<String, String>();

		for (String o : USStateMapping.keySet()) {
			tm.put(o, USStateMapping.get(o));
		}

		return tm;
	}

	/**
	 * Returns a Sorted Map of all CA States (POSTAL ABBREVIATION(K), COMMON
	 * NAME(V))
	 * 
	 * @return TreeMap<String, String>
	 */
	public Map<String, String> getCAStates() {
		SortedMap<String, String> tm = new TreeMap<String, String>();

		for (String o : CAStateMapping.keySet()) {
			tm.put(o, CAStateMapping.get(o));
		}

		return tm;
	}

	/**
	 * Returns an htmlSelectOneMenu for a country selection drop-down in JSF
	 * 
	 * @see: http://www.coderanch.com/t/211197/JSF/java/JSF-drop-down
	 */
	public HtmlSelectOneMenu getUsStateMappingSelectOneMenu() {
		stateSelectOneMenu = new HtmlSelectOneMenu();
		final Collection<SelectItem> list = new ArrayList<SelectItem>();

		Map<String, String> m = getUSStates();
		for (Object o : m.keySet()) {
			list.add(new SelectItem(o, m.get(o)));
		}

		final UISelectItems items = new UISelectItems();
		items.setValue(list);
		stateSelectOneMenu.getChildren().add(items);
		return stateSelectOneMenu;
	}

	public void setUsStateMappingSelectOneMenu(HtmlSelectOneMenu h) {
		stateSelectOneMenu = h;
	}

}
