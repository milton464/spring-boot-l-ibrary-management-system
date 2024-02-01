package com.milton.book.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.milton.book.model.Book;
import com.milton.book.model.Order;
import com.milton.book.model.User;
import com.milton.book.service.BookService;
import com.milton.book.service.OrderService;
import com.milton.book.service.UserService;

@Controller
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/order/{id}")
	public String order(@PathVariable("id")Long id,Model model,Order order,BindingResult bindingResult,Principal principal) {
		
		
		
		Book book = bookService.findById(id);
		model.addAttribute("book",book);
		String bookName = book.getTitle();
		String authorname = book.getAuthor();
		
		model.addAttribute("bookname",bookName);
		model.addAttribute("authorname",authorname);
		
		
		String name = principal.getName();
		
		User user = userService.findByName(name);
		String username = user.getName();
		Long userid = user.getId();
		
		model.addAttribute("name", username);
		model.addAttribute("id", userid);
		
		Date currentDate = new Date();
		model.addAttribute("issuedate", currentDate);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date expirydate = calendar.getTime();
		model.addAttribute("expirydate", expirydate);
		
		
		return "user/bookOrder";
	}

	@PostMapping("/orderBook")
	public String orderBook(@Valid Order order,BindingResult bindingResult,Model model) {
		model.addAttribute("order", new Order());
		if(bindingResult.hasErrors()) {
			return "user/bookOrder";
		}
		orderService.saveOrder(order);
		
		return "user/bookOrder";
	}
}
