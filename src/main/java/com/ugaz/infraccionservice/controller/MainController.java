package com.ugaz.infraccionservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	@GetMapping("/infraciones")
	public String getInfraccion() {
		return "infraccion";
	}
	@GetMapping("/user")
	public String getUser() {
		return "user";
	}
}