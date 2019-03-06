package com.weather.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.weather.config.ConfigurationUtil;
import com.weather.service.util.ServiceUtil;
import com.weather.util.DisplayUtil;
/**
 * This class will handle Location Api
 * @author tekurala
 *
 */
public class LocationService {
	/**
	 * This method will get the LocationKey for the provided zipcode
	 * @param postalCode this is the zipcode
	 */
	public static String getLocationKeyByPostalCode(String postalCode) throws Exception {
		String jsonResponse = ServiceUtil.getDataFromService(ConfigurationUtil.getLocationUrl(postalCode));
		String value = null;
		try {
			JSONArray jsonArray = new JSONArray(jsonResponse);
			if(!jsonArray.isEmpty()) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(0);
				value = jsonObject.get("Key").toString();
				//System.out.println("Location : " + jsonObject.get("EnglishName").toString());	
			}
		} catch (JSONException exception) {
			exception.printStackTrace();
			DisplayUtil.printErrorMessage(jsonResponse);
		}

		return value;
	}

}
