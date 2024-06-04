package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.MyBooks;
import com.demo.repository.MyBooksRepository;

@Service
public class MyBooksService {

	@Autowired
	private MyBooksRepository mbr;

	// to save book into my book
	public void saveMyBook(MyBooks book) {
		mbr.save(book);
	}

	// to display books on my book
	public List<MyBooks> getAllMyBooks() {
		return mbr.findAll();
	}

	// to delete record from mybook section
	public void deleteById(int id) {
		mbr.deleteById(id);
	}
}
