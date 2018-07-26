package com.bluewine.magichashtag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

      
	@GetMapping("/upload")
    public String index( Model model) {
    	System.out.println("i am reached here ");
    	  model.addAttribute("name", "midhun");
          return "greeting";
    }
    
    
    
}

