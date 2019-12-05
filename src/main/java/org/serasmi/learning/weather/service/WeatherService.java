package org.serasmi.learning.weather.service;

import org.serasmi.learning.weather.WeatherData;
import org.serasmi.learning.weather.provider.GismeteoWeatherProvider;
import org.serasmi.learning.weather.provider.OWMWeatherProvider;
import org.serasmi.learning.weather.provider.WeatherProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  @Cacheable(value = "weather", key = "#city")
  public WeatherData getWeather(String city, String service) throws Exception {
    WeatherProvider weatherProvider;

    switch (service) {
      case "owm":
        weatherProvider = new OWMWeatherProvider(city);
        break;
      case "gismeteo":
      default:
        weatherProvider = new GismeteoWeatherProvider(city);
    }

    return weatherProvider.getWeather();
  }
}
