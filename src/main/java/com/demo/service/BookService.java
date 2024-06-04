package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Book;
import com.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository br;
	
	//to insert book
	public void save(Book b) {
		 br.save(b);
	}
	
	//to get all books
	public List<Book> getAllBook(){
		return br.findAll();
	}
	
	//to get book by id
	public Book getBookById(int id) {
		return br.findById(id).get();
	}
	
	public void deleteBookById(int id) {
		br.deleteById(id);
	}
}
