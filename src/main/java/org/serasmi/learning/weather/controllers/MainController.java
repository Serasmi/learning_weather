package org.serasmi.learning.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @GetMapping("/weather")
  String weather(@RequestParam(name="city", required=false, defaultValue="Moscow") String city,
                 @RequestParam("service") String service,
                 Model model) {
    model.addAttribute("city", city);
    model.addAttribute("service", service);

    return "weather";
  }
}
