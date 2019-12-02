package org.serasmi.learning.weather.controllers;

import org.serasmi.learning.weather.WeatherProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

  @Autowired
  private WeatherProvider weatherProvider;

  @GetMapping("/weather")
  String weather(@RequestParam(name="city", required=false, defaultValue="Moscow") String city,
                 @RequestParam("service") String service,
                 Model model) {
    model.addAttribute("city", city);
    model.addAttribute("service", service);

    String result = "";

    try {
      // TODO: Change API entrypoint. Needs to use API according to 'service' parameter.
      result = weatherProvider.getWeather("http://jsonplaceholder.typicode.com/posts?_limit=10%22");
    } catch (IOException e) {
      e.printStackTrace();
    }

    model.addAttribute("weather", result);

    return "weather";
  }
}
