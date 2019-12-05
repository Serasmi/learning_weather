package org.serasmi.learning.weather.provider;

import org.serasmi.learning.weather.WeatherData;

public interface WeatherProvider {
  WeatherData getWeather() throws Exception;
}
