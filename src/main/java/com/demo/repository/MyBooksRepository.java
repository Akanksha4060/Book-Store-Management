package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.MyBooks;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBooks,Integer>{

}
