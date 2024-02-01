package com.milton.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.milton.book.model.Message;
import com.milton.book.repository.MessageRepository;

@Controller
public class HomeController {

	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("msg", messageRepository.findAll());
		return "userhome";
	}
	@PostMapping("/messages")
	public String saveMessage(Message message) {
		messageRepository.save(message);
		return "redirect:/home";
	}
	
}
