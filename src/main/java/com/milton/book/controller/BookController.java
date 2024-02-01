package com.milton.book.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.milton.book.model.Book;
import com.milton.book.repository.BookRepository;
import com.milton.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private BookRepository bookRepository;

	
	@GetMapping("/admin/addBook")
	public String addBook(Book book,Model model) {
		model.addAttribute("book",book);
		return "admin/addBook";
	}
	

	@PostMapping("/addbook")
	public String add_book(@Valid Book book,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "redirect:/admin/addBook";
		}
		
		bookService.addBook(book);
		return "redirect:/admin/addBook";
		
	}
	// search book
	@RequestMapping("/admin/searchBook")
	public String serachBook(Book book,Model model) {
		model.addAttribute("books",bookService.bookList());
		return "admin/searchBook";
	}
	@GetMapping("/search")
	public String serch(Model model,@RequestParam(defaultValue = "")String title) {
		model.addAttribute("books", bookService.findByTitle(title));
		return "admin/searchBook";
	}
	
	//update book
	
	
	@RequestMapping("/admin/updateBook")
	public String updateBook(Book book,Model model) {
		model.addAttribute("books",bookService.bookList());
		return "admin/updateBook";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id,Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book",book);
		return "admin/update";
	}
	
	@PostMapping("/update")
	public String update(@Valid Book book,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			
			return "redirect:/admin/update";
		}
		bookService.addBook(book);
		model.addAttribute("books",bookService.bookList());
		return "admin/updateBook";
	}
	
	//delete book
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id, Model model) {
		Optional<Book>optional = bookRepository.findById(id);
		Book book = optional.get();
		bookRepository.delete(book);
		model.addAttribute("books",bookService.bookList());
		return "admin/updateBook";
	}
	
	@GetMapping("/admin/viewOrder")
	public String viewOrder(Model model) {
		
		//model.addAttribute("bookOrder",bookOrderService.orderList());
		
		return "admin/ViewOrder";
		
	}
	
	
	
	
	
	
	
	
	
}
