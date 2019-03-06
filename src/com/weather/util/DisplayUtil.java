package com.weather.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * This is Util class which is used to print the data
 * @author tekurala
 *
 */
public class DisplayUtil {
	/**
	 * This method is used to print the required data in console
	 * @param jsonArray
	 */
	public static void print(JSONArray jsonArray) {
		double coolestTemperature = 0.0f;
		String coolestHour = null;
		String unit = "";
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
			double value = (Double) temperature.get("Value");
			if (coolestTemperature == 0 || coolestTemperature > value) {
				coolestTemperature = value;
				coolestHour = dateString;
				unit = (String) temperature.get("Unit");
			}
			System.out.println("Date :" + dateString + ", Temperature :" + temperature.get("Value") + " "
					+ temperature.get("Unit"));
		}

		System.out.println("Coolest Hour of the day:" + coolestHour + ", Coolest Temperature of the day:"
				+ coolestTemperature + " " + unit);
	}

	public static void printErrorMessage(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		System.out.println("Error : " + jsonObject.get("Code"));
		System.out.println("Message : " + jsonObject.get("Message"));
	}
}
