package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Book;
import com.demo.model.MyBooks;
import com.demo.service.BookService;
import com.demo.service.MyBooksService;


@Controller
public class BookController {
	
		@Autowired
		private BookService bookService;
		
		@Autowired
		private MyBooksService myBooksService;
	
		//display home section..
		@GetMapping("/")
		public String home() {
			return "home";
		}
		
		//display book reg section..
		@GetMapping("/book_register")
		public String bookRegister() {
			return "bookRegister";
		}
		
//		to retrive available books....
//		@GetMapping("/available_book")
//		public String getAllBook() {
//			return "availableBook";
//		}
		
		//to insert book into available book section....
		@PostMapping("/save")
		public String addBook(@ModelAttribute Book b) {
			bookService.save(b);
			return "redirect:/available_book"; 
		}
		
		//to display all record in available book section...
		@GetMapping("/available_book")
		public ModelAndView getAllBook() {
			List<Book> list=bookService.getAllBook();
//			ModelAndView m=new ModelAndView();
//			m.setViewName("availableBook");
//			m.addObject("book",list);
//			OR---------
			return new ModelAndView("availableBook","book",list);
		}
		
		
//		to display my book section....		
//		@GetMapping("/my_books")
//		public String getMyBooks() {
//			return "myBooks";
//		}
		
//		to insert book from available book to mybook section ....		
		@RequestMapping("/mylist/{id}")
		public String getMyList(@PathVariable("id")int id) {
			Book b=bookService.getBookById(id);
			MyBooks mb=new MyBooks(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
			myBooksService.saveMyBook(mb);
			return "redirect:/my_books";
		}
		
//		to get all books from mybook section
		@GetMapping("/my_books")
		public String getMyBooks(Model model) {
			List<MyBooks> list=myBooksService.getAllMyBooks();
			model.addAttribute("book",list);
			return "myBooks";
		}
		
//		edit books		
		@RequestMapping("/editBook/{id}")
		public String editBook(@PathVariable("id") int id, Model model) {
			Book b=bookService.getBookById(id);
			model.addAttribute("book",b);
			return "bookEdit";
		}
		
//		delete book
		@RequestMapping("/deleteBook/{id}")
		public String deleteBook(@PathVariable("id") int id, Model model) {
			bookService.deleteBookById(id);
			return "redirect:/available_book";
		}
}
