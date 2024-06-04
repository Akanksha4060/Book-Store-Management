package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.MyBooksService;

@Controller
public class MyBooksController {
	
	@Autowired
	private MyBooksService myBookService;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		myBookService.deleteById(id);
		return "redirect:/my_books";
	}
}
