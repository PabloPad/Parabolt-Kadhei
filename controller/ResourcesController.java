package com.parabolt.academyHackaton.back1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/site")
public class ResourcesController {

		@GetMapping("/login")
		public String getIndex() {
			
			return "admin_login.html";
		}
		
}
