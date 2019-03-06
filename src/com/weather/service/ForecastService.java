package com.weather.service;

import org.json.JSONArray;
import org.json.JSONException;

import com.weather.config.ConfigurationUtil;
import com.weather.service.util.ServiceUtil;
import com.weather.util.DisplayUtil;
/**
 * This class will handle forecast Api
 * @author tekurala
 *
 */
public class ForecastService {
	/**
	 * This method will get the forecast and display the forecast
	 * @param locationKey this key is based on zipcode entered
	 * @param hours this is based on hours entered by user
	 */
	public static void getTemperatureByLocationKey(String locationKey, String hours) throws Exception {
		String jsonResponse = ServiceUtil.getDataFromService(ConfigurationUtil.getForecastUrl(locationKey, hours)); 
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(jsonResponse);
			DisplayUtil.print(jsonArray);
		} catch (JSONException exception) {
			exception.printStackTrace();
			DisplayUtil.printErrorMessage(jsonResponse);
		}
	}

}
