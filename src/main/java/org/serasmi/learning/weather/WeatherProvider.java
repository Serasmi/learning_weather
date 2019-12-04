package org.serasmi.learning.weather;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WeatherProvider {

  // TODO: Needs to configure cache expired time.
  @Cacheable(value = "weather", key = "#sUrl")
  public String getWeather(String sUrl) throws IOException {
    URL url = new URL(sUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("Content-Type", "application/json");

    try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
      String inputLine;
      final StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      return content.toString();
    } catch (final Exception ex) {
      ex.printStackTrace();
      return null;
    }
  }
}
