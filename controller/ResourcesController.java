package com.parabolt.academyHackaton.back1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resources")
public class ResourcesController {

	
		@GetMapping("/login")
		public String getIndex() {
			
			return "admin_login.html";
		}
	
		
		@GetMapping("/testpage/{stg}")
		public String getTestIndex(Model model, @PathVariable Integer stg) {
			
			
			
			model.addAttribute("stage", stg);
			return "test_index";
		}
}
