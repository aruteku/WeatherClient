package com.weather.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	private static Properties properties = null;
	static {
		 properties = new Properties();
		try {
			ClassLoader loader =Thread.currentThread().getContextClassLoader();
			properties.load(loader.getResourceAsStream("weatherClient.properties"));
			//properties.load(new FileInputStream(new File("weatherClient.properties")));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    protected static final String API_KEY = properties.getProperty("API_KEY");
    protected static final String LOCATION_URL = properties.getProperty("LOCATION_URL");
    protected static final String FORECAST_URL = properties.getProperty("FORECAST_URL");
}