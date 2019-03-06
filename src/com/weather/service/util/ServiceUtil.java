package com.weather.service.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceUtil {

	public static String getDataFromService(URL url) throws Exception {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		BufferedReader bufferedReader;
		if (conn.getResponseCode() != 200) {
			bufferedReader = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		}

		StringBuilder stringBuilder = new StringBuilder();
		String output;
		while ((output = bufferedReader.readLine()) != null) {
			stringBuilder.append(output);
		}
		conn.disconnect();

		return stringBuilder.toString();
	}
}
