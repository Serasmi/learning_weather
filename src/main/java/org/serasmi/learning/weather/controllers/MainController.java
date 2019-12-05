package org.serasmi.learning.weather.controllers;

import org.serasmi.learning.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping("/weather")
  String weather(@RequestParam(name="city", required=false, defaultValue="Moscow") String city,
                 @RequestParam("service") String service,
                 Model model) throws Exception {

    String result = weatherService.getWeather(city, service).toString();

    model.addAttribute("city", city);
    model.addAttribute("service", service);
    model.addAttribute("weather", result);

    return "weather";
  }
}
