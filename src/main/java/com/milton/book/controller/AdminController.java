package com.milton.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.milton.book.model.Book;
import com.milton.book.service.BookService;
import com.milton.book.service.OrderService;

@Controller
public class AdminController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private BookService bookService;
	
	@GetMapping("/admin/view")
	public String view(Model model) {
		model.addAttribute("order", orderService.listOrder());
		return "admin/ViewOrder";
		
	}
	
	@GetMapping("/order/search")
	public String orderSerach(Model model,@RequestParam(defaultValue = "")String bookname) {
		
		
		long count = 0;
		long quantity = 0;
		long available = 0;
	
			count = orderService.countBybookname(bookname);
			if(count>0) {
				model.addAttribute("count", count);
				
				Book book =  bookService.findBytitle(bookname);
				quantity = book.getQuantity();
				
				if(quantity>count) {
					available = quantity-count;
				}
				model.addAttribute("avail", available);
		
			}else {
				count = 0;
				model.addAttribute("count", count);
				model.addAttribute("avail", " Not ordered yet!!");
			}
		
		
		
		
		
		
		model.addAttribute("order", orderService.listOrder());
		return "admin/ViewOrder";
		
	}
	
}
