package com.milton.book.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.milton.book.model.Book;
import com.milton.book.model.Order;
import com.milton.book.model.User;
import com.milton.book.repository.OrderRepository;
import com.milton.book.service.BookService;
import com.milton.book.service.OrderService;
import com.milton.book.service.UserService;

@Controller
public class UserController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/info")
	public String userInfo(Principal principal,Model model) {
		String name = principal.getName();
		User user = userService.findByName(name);
		model.addAttribute("user",user);
		
		return "user/userInfo";
		
	}
	
	@GetMapping("/user/edit/{id}")
	public String editUser(@PathVariable("id")long id,Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "user/userInfo";
		
	}
	@PostMapping("/user/update")
	public String update(User user,Model model) {
		userService.createUser(user);
		return "redirect:/user/info";
	}
	
	@GetMapping("/user/booklist")
	public String bookList(Book book,Model model) {
		model.addAttribute("book",bookService.bookList());
		
		return "user/bookList";
		
	}
	
	@GetMapping("/searchBook")
	public String serachBook(Model model,@RequestParam(defaultValue = "")String title) {
		model.addAttribute("book", bookService.findByTitle(title));
		return "user/bookList";
	}
	
	
	@RequestMapping("/user/viewDateInfo")
	public String dateInfo(Principal principal,Model model) {
		
		String name = principal.getName();
		
		User user = userService.findByName(name);
		String username = user.getName();
		Long id = user.getId();
		
		model.addAttribute("name", username);
		model.addAttribute("id", id);
		
		
		return "user/dateInfo";
	}
		
		@GetMapping("/searchOrder")
		public String serachOrder(Model model,@RequestParam(defaultValue = "")long userid) {
			Order order =  orderService.findByuserid(userid);
			
			String name = order.getUsername();
			model.addAttribute("name", name);
			
			Date issue = order.getIssuedate();
			model.addAttribute("issue",issue);
			Date expiry = order.getExpirydate();
			model.addAttribute("expiry",expiry);
			Date currentDate = new Date();
			
			long difference = 0;
			long days = 0; 
			long fine = 0;
			if(currentDate.compareTo(expiry)>0) {
				difference = currentDate.getTime() - expiry.getTime();
				days = (difference/(1000*60*60*24));
				fine = days * 5;
			}
			else if(currentDate.compareTo(expiry)<0) {
				
				days = 0;
				fine = days * 5;
			}
			
			model.addAttribute("days", days);
			model.addAttribute("fine", fine);
			return "user/dateInfo";
		}
		
		
		
		@RequestMapping("/user/returnBook")
		public String returnBook(Principal principal,Model model) {
			String name = principal.getName();
			User user = userService.findByName(name);
			Long id = user.getId();
			model.addAttribute("id", id);
			
			Order order = orderService.findByuserid(id);
			String bookname = order.getBookname();
			model.addAttribute("bookname", bookname);
			
			String authorname = order.getAuthorname();
			model.addAttribute("authorname", authorname);
			
			
			
			return "user/returnBook";
		}
		@RequestMapping("/user/return")
		public String retrn(Principal principal,Model model) {
			String name = principal.getName();
			User user = userService.findByName(name);
			Long userid = user.getId();
		
			Order order = orderService.findByuserid(userid);
			orderRepository.delete(order);
			return "user/returnBook";
		}
		
}
