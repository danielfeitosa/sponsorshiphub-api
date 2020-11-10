package org.comfort.comfortapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sponsored")
public class SponsoredController {
	
   @GetMapping
	public String listaAll() {
		return "Hello Sponsored";
	}

}
