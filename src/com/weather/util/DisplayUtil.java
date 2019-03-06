package com.weather.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class DisplayUtil {
	
	public static void print(JSONArray jsonArray) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		for (Object obj : jsonArray) {
			JSONObject temperature = (JSONObject) ((JSONObject) obj).get("Temperature");
			String dateString = (String) ((JSONObject) obj).get("DateTime");
			Date date = null;
			try {
				date = inputFormat.parse(dateString);
				dateString = outputFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Date :" + dateString + ", Temperature :" + temperature.get("Value") + " "
					+ temperature.get("Unit"));
		}
	}

	public static void printErrorMessage(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		System.out.println("Error : " + jsonObject.get("Code"));
		System.out.println("Message : " + jsonObject.get("Message"));
	}
}
