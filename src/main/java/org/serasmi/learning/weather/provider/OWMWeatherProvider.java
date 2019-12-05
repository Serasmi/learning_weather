package org.serasmi.learning.weather.provider;

import org.serasmi.learning.weather.WeatherData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OWMWeatherProvider implements WeatherProvider {

  // TODO: needs to use real API
  private static final String API_URI = "http://jsonplaceholder.typicode.com/posts?_limit=10%22";

  private String city;

  public OWMWeatherProvider(String city) {
    this.city = city;
  }

  @Override
  public WeatherData getWeather() throws IOException {
    System.out.println("Get weather from API");

    URL url = new URL(API_URI);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("Content-Type", "application/json");

    try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
      String inputLine;
      final StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      return new WeatherData(this.city, content.toString(), "humidity");
    } catch (final Exception ex) {
      ex.printStackTrace();
      return new WeatherData(this.city, null, null);
    }
  }
}
