package org.serasmi.learning.weather;

public class WeatherData {

  private String city;
  private String temperature;
  private String humidity;

  public WeatherData(String city, String temperature, String humidity) {
    this.city = city;
    this.temperature = temperature;
    this.humidity = humidity;
  }

  public String getCity() {
    return city;
  }

  public String getTemperature() {
    return temperature;
  }

  public String getHumidity() {
    return humidity;
  }
}
