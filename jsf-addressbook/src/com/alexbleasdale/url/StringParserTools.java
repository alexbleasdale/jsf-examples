package com.alexbleasdale.url;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.alexbleasdale.beans.Address;

public class StringParserTools {

	public static String buildGmapsUrlFromAddress(Address a) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://maps.google.com/maps/geo?q=");
		sb.append(gMapEncodeString(a.getStreetAddress1()));
		sb.append("+");
		sb.append(gMapEncodeString(a.getPostalCode()));
		sb.append("+");
		sb.append(a.getCountry());
		sb.append("&output=json&oe=utf8");

		Logger.getAnonymousLogger().log(Level.INFO,
				"Fully escaped URL is: " + sb.toString());
		return sb.toString();
	}

	private static String gMapEncodeString(String s) {
		s = s.replaceAll(" ", "+");
		return s;
	}
}
