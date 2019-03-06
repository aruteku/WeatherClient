package com.weather;

import com.weather.service.ForecastService;
import com.weather.service.LocationService;


import java.util.Scanner;
import java.util.regex.Pattern;

public class WeatherClient {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter zipcode :");
			String postalCode = scanner.next();
			Pattern postalCodePattern = Pattern.compile("\\d{5}");
			if(postalCode == null || !(postalCodePattern.matcher(postalCode).matches())) {
				System.out.println("Invalid zipcode");
				System.exit(1);
			}
			System.out.print("Please choose next 12/24 hours :");
			String hours = scanner.next();
			scanner.close();
			String locationKey = LocationService.getLocationKeyByPostalCode(postalCode);
			if (locationKey != null) {
				ForecastService.getTemperatureByLocationKey(locationKey, hours);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
