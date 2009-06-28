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

import org.apache.commons.collections.bidimap.TreeBidiMap;

public class CountryMapping {

	/**
	 * Handles mappings to ISO 3166-1 Alpha 2 Codes for a complete list of
	 * Territorial/ISO code mappings
	 * 
	 * @see http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
	 */

	private HtmlSelectOneMenu countrySelectOneMenu;

	private final Map<String, String> countryMapping = new HashMap<String, String>() {

		private static final long serialVersionUID = -6780405953812445040L;

		{
			put("AC", "Ascension Island");
			put("AD", "Andorra");
			put("AE", "United Arab Emirates");
			put("AF", "Afghanistan");
			put("AG", "Antigua and Barbuda");
			put("AI", "Anguilla");
			put("AL", "Albania");
			put("AM", "Armenia");
			put("AN", "Netherlands Antilles");
			put("AO", "Angola");
			put("AQ", "Antarctica");
			put("AR", "Argentina");
			put("AS", "American Samoa");
			put("AT", "Austria");
			put("AU", "Australia");
			put("AW", "Aruba");
			put("AX", "Åland Islands");
			put("AZ", "Azerbaijan");
			put("BA", "Bosnia and Herzegovina");
			put("BB", "Barbados");
			put("BD", "Bangladesh");
			put("BE", "Belgium");
			put("BF", "Burkina Faso");
			put("BG", "Bulgaria");
			put("BH", "Bahrain");
			put("BI", "Burundi");
			put("BJ", "Benin");
			put("BM", "Bermuda");
			put("BN", "Brunei Darussalam");
			put("BO", "Bolivia");
			put("BR", "Brazil");
			put("BS", "Bahamas");
			put("BT", "Bhutan");
			put("BV", "Bouvet Island");
			put("BW", "Botswana");
			put("BY", "Belarus");
			put("BZ", "Belize");
			put("CA", "Canada");
			put("CC", "Cocos (Keeling) Islands");
			put("CD", "Democratic Republic of the Congo");
			put("CF", "Central African Republic");
			put("CG", "Congo (Republic of the Congo)");
			put("CH", "Switzerland");
			put("CI", "Côte d'Ivoire");
			put("CK", "Cook Islands");
			put("CL", "Chile");
			put("CM", "Cameroon");
			put("CN", "China");
			put("CO", "Colombia");
			put("CR", "Costa Rica");
			put("CS", "Serbia and Montenegro");
			put("CU", "Cuba");
			put("CV", "Cape Verde");
			put("CX", "Christmas Island");
			put("CY", "Cyprus");
			put("CZ", "Czech Republic");
			put("DE", "Germany");
			put("DJ", "Djibouti");
			put("DK", "Denmark");
			put("DM", "Dominica");
			put("DO", "Dominican Republic");
			put("DZ", "Algeria");
			put("EC", "Ecuador");
			put("EE", "Estonia");
			put("EG", "Egypt");
			put("EH", "Western Sahara");
			put("ER", "Eritrea");
			put("ES", "Spain (Espa&ntilde;a)");
			put("ET", "Ethiopia");
			put("FI", "Finland");
			put("FJ", "Fiji");
			put("FK", "Falkland Islands");
			put("FM", "Federated States of Micronesia");
			put("FO", "Faroe Islands");
			put("FR", "France");
			put("GA", "Gabon");
			put("GB", "United Kingdom");
			put("GD", "Grenada");
			put("GE", "Georgia");
			put("GF", "French Guiana");
			put("GH", "Ghana");
			put("GI", "Gibraltar");
			put("GL", "Greenland");
			put("GM", "Gambia");
			put("GN", "Guinea");
			put("GP", "Guadeloupe");
			put("GQ", "Equatorial Guinea");
			put("GR", "Greece");
			put("GS", "South Georgia and the South Sandwich Islands");
			put("GT", "Guatemala");
			put("GU", "Guam");
			put("GW", "Guinea-Bissau");
			put("GY", "Guyana");
			put("HK", "Hong Kong");
			put("HM", "Heard Island and McDonald Islands");
			put("HN", "Honduras");
			put("HR", "Croatia (Hrvatska)");
			put("HT", "Haiti");
			put("HU", "Hungary");
			put("ID", "Indonesia");
			put("IE", "Ireland");
			put("IL", "Israel");
			put("IN", "India");
			put("IO", "British Indian Ocean Territory");
			put("IQ", "Iraq");
			put("IR", "Iran");
			put("IS", "Iceland");
			put("IT", "Italy");
			put("JM", "Jamaica");
			put("JO", "Jordan");
			put("JP", "Japan");
			put("KE", "Kenya");
			put("KG", "Kyrgyzstan");
			put("KH", "Cambodia");
			put("KI", "Kiribati");
			put("KM", "Comoros");
			put("KN", "Saint Kitts and Nevis");
			put("KP", "Democratic People's Republic of Korea (North Korea)");
			put("KR", "Republic of Korea (South Korea)");
			put("KW", "Kuwait");
			put("KY", "Cayman Islands");
			put("KZ", "Kazakhstan");
			put("LA", "Lao People's Democratic Republic (Laos)");
			put("LB", "Lebanon");
			put("LC", "Saint Lucia");
			put("LI", "Liechtenstein");
			put("LK", "Sri Lanka");
			put("LR", "Liberia");
			put("LS", "Lesotho");
			put("LT", "Lithuania");
			put("LU", "Luxembourg");
			put("LV", "Latvia");
			put("LY", "Libyan Arab Jamahiriya (Libya)");
			put("MA", "Morocco");
			put("MC", "Monaco");
			put("MD", "Moldova");
			put("MG", "Madagascar");
			put("MH", "Marshall Islands");
			put("MK", "Former Yugoslav Republic of Macedonia");
			put("ML", "Mali");
			put("MM", "Myanmar (Burma)");
			put("MN", "Mongolia");
			put("MO", "Macao (Macau)");
			put("MP", "Northern Mariana Islands");
			put("MQ", "Martinique");
			put("MR", "Mauritania");
			put("MS", "Montserrat");
			put("MT", "Malta");
			put("MU", "Mauritius");
			put("MV", "Maldives");
			put("MW", "Malawi");
			put("MX", "Mexico");
			put("MY", "Malaysia");
			put("MZ", "Mozambique");
			put("NA", "Namibia");
			put("NC", "New Caledonia");
			put("NE", "Niger");
			put("NF", "Norfolk Island");
			put("NG", "Nigeria");
			put("NI", "Nicaragua");
			put("NL", "Netherlands");
			put("NO", "Norway");
			put("NP", "Nepal");
			put("NR", "Nauru");
			put("NU", "Niue");
			put("NZ", "New Zealand");
			put("OM", "Oman");
			put("PA", "Panama");
			put("PE", "Peru");
			put("PF", "French Polynesia");
			put("PG", "Papua New Guinea");
			put("PH", "Philippines");
			put("PK", "Pakistan");
			put("PL", "Poland");
			put("PM", "Saint-Pierre and Miquelon");
			put("PN", "Pitcairn Islands");
			put("PR", "Puerto Rico");
			put("PS", "Occupied Palestinian Territories");
			put("PT", "Portugal");
			put("PW", "Palau");
			put("PY", "Paraguay");
			put("QA", "Qatar");
			put("RE", "Réunion");
			put("RO", "Romania");
			put("RU", "Russia");
			put("RW", "Rwanda");
			put("SA", "Saudi Arabia");
			put("SB", "Solomon Islands");
			put("SC", "Seychelles");
			put("SD", "Sudan");
			put("SE", "Sweden");
			put("SG", "Singapore");
			put("SH", "Saint Helena");
			put("SI", "Slovenia");
			put("SJ", "Svalbard and Jan Mayen Islands");
			put("SK", "Slovakia");
			put("SL", "Sierra Leone");
			put("SM", "San Marino");
			put("SN", "Senegal");
			put("SO", "Somalia");
			put("SR", "Suriname");
			put("ST", "São Tomé and Príncipe");
			put("SV", "El Salvador");
			put("SY", "Syrian Arab Republic (Syria)");
			put("SZ", "Swaziland");
			put("TC", "Turks and Caicos Islands");
			put("TD", "Chad (Tchad)");
			put("TF", "French Southern Territories");
			put("TG", "Togo");
			put("TH", "Thailand");
			put("TJ", "Tajikistan");
			put("TK", "Tokelau");
			put("TL", "Timor-Leste (East Timor)");
			put("TM", "Turkmenistan");
			put("TN", "Tunisia");
			put("TO", "Tonga");
			put("TR", "Turkey");
			put("TT", "Trinidad and Tobago");
			put("TV", "Tuvalu");
			put("TW", "Taiwan, Province of China");
			put("TZ", "United Republic of Tanzania");
			put("UA", "Ukraine");
			put("UG", "Uganda");
			put("UM", "United States Minor Outlying Islands");
			put("US", "United States");
			put("UY", "Uruguay");
			put("UZ", "Uzbekistan");
			put("VA", "Holy See (Vatican City State)");
			put("VC", "Saint Vincent and the Grenadines");
			put("VE", "Venezuela");
			put("VG", "British Virgin Islands");
			put("VI", "U.S. Virgin Islands");
			put("VN", "Viet Nam (Vietnam)");
			put("VU", "Vanuatu");
			put("WF", "Wallis and Futuna");
			put("WS", "Samoa");
			put("YE", "Yemen");
			put("YT", "Mayotte");
			put("YU", "Yugoslavia");
			put("ZA", "South Africa");
			put("ZM", "Zambia");
			put("ZW", "Zimbabwe");
		}
	};

	private Map<String, String> getCountryMap() {
		return countryMapping;
	}

	/**
	 * Returns a Sorted Map (by Key) of all Countries
	 * 
	 * @return TreeMap<String, String>
	 */
	public Map<String, String> getKeySortedCountryMap() {
		SortedMap<String, String> tm = new TreeMap<String, String>();

		Map<String, String> m = getCountryMap();
		for (String o : m.keySet()) {
			tm.put(o, m.get(o));
		}
		return tm;
	}

	/**
	 * Returns an htmlSelectOneMenu for a country selection drop-down in JSF
	 * 
	 * @see: http://www.coderanch.com/t/211197/JSF/java/JSF-drop-down
	 */
	public HtmlSelectOneMenu getCountryMappingSelectOneMenu() {
		// Logger.getAnonymousLogger().log(Level.INFO, "** Country Mapping **");
		countrySelectOneMenu = new HtmlSelectOneMenu();
		final Collection<SelectItem> list = new ArrayList<SelectItem>();

		// Get the values from the countryMapping HashMap in inverse order; with
		// values *as* keys. This ensures the values listed in the dropdown are
		// ordered correctly

		TreeBidiMap tbm = new TreeBidiMap(countryMapping);
		for (Object o : tbm.inverseOrderedBidiMap().keySet()) {
			list.add(new SelectItem(tbm.getKey(o), o.toString()));
		}

		final UISelectItems items = new UISelectItems();
		items.setValue(list);
		countrySelectOneMenu.getChildren().add(items);
		return countrySelectOneMenu;
	}

	public void setCountryMappingSelectOneMenu(HtmlSelectOneMenu h) {
		countrySelectOneMenu = h;
	}
}
