package com.app.service;

import java.util.List;

import com.app.model.Books;
import com.app.repo.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
	
	@Autowired
	public BooksRepository booksRepository;

	public Books getAll(Books book) {
		
		Books s1=booksRepository.save(book);
		
		return s1;
		
	}
	
	public Books getBooksById(int id) { 
		
	return booksRepository.findById(id).get();
	
	}  
	
	public List<Books> showAllBooks() {
		
		return (List<Books>) booksRepository.findAll();
	}
	
	public void Delete(int id) {
		
		booksRepository.deleteById(id);
		
	}
	
	public Books UpdateData(int id,Books book) {
		Books b = booksRepository.findById(id).get();
		b.setAuthor(book.getAuthor());
		b.setBookName(book.getBookName());
		b.setPrice(book.getPrice());
		return booksRepository.save(b);
		
	}
		
}
