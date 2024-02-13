package com.developer.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishController {

	@GetMapping("/msg")
	public String generateWishMessage() {
		String msg = "Welcome to Restful Services from Effigo...";
		return msg;
	}
}
