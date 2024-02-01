package com.milton.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milton.book.model.User;
import com.milton.book.repository.UserRepository;
import com.milton.book.service.UserService;



@Controller
public class RegisterController {

	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/signin")
	public String signin(Model model) {
		model.addAttribute("user",new User());
		return "signin";
	}
	
	@PostMapping("/sign")
	public String sign(@Valid User user,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "signin";
		}
		
		userService.createUser(user);
		
		return "signin";
	}
}
