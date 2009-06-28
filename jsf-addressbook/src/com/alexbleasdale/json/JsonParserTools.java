package com.alexbleasdale.json;

import java.util.ArrayList;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.alexbleasdale.beans.Location;

public class JsonParserTools {

	public static Location parseGmapsJsonForLatAndLong(String gMapsMetadata,
			Location l) {

		JSONObject jo = JSONObject.fromObject(gMapsMetadata);
		Iterator<?> k = null;
		String internalJson = null;
		JSONArray ja = (JSONArray) jo.get("Placemark");
		k = ja.iterator();

		while (k.hasNext()) {
			Object o = k.next();
			internalJson = o.toString();
		}
		jo = JSONObject.fromObject(internalJson);
		jo = (JSONObject) jo.get("Point");

		ja = (JSONArray) jo.get("coordinates");
		k = ja.iterator();

		ArrayList<Double> list = new ArrayList<Double>();

		while (k.hasNext()) {
			Object o = k.next();
			if (!"0".equals(o.toString())) {
				list.add(Double.parseDouble(o.toString()));
			}
		}
		l.setLongitude(list.get(0));
		l.setLatitude(list.get(1));
		return l;
	}
}
