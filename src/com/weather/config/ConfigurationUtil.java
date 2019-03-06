package com.weather.config;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * This class will create a url for location and forecast services
 * @author tekurala
 */
public class ConfigurationUtil extends Configuration {
	
	public static URL getLocationUrl(String postalCode) {

		try {
			return new URL(Configuration.LOCATION_URL + Configuration.API_KEY + "&q=" + postalCode);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL getForecastUrl(String locationKey , String hours) {

		try {
			return new URL(Configuration.FORECAST_URL + hours + "hour/" + locationKey
					+ "?apikey=" + Configuration.API_KEY);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
