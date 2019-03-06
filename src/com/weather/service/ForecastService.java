package com.weather.service;

import org.json.JSONArray;
import org.json.JSONException;

import com.weather.config.ConfigurationUtil;
import com.weather.service.util.ServiceUtil;
import com.weather.util.DisplayUtil;

public class ForecastService {
	
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
