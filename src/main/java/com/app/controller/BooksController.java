package com.app.controller;

import java.util.List;

import com.app.model.Books;
import com.app.service.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	
	@Autowired
	public BooksService booksService;
	
	@PostMapping("/Books")
	public Books getAl(@RequestBody Books book){
		return (Books) booksService.getAll(book);
	}
	
	@GetMapping("/Books")
	private List<Books> getAllBooks(){
		
		return booksService.showAllBooks();
	}
	
	@GetMapping("/Books/{bookid}")
	private Books getBooks(@PathVariable("bookid")int bookid) {
		
		return booksService.getBooksById(bookid);
		
	}
	
	@DeleteMapping("/Books/{id}")
	private void deleteBook(@PathVariable("id") int bookid) {
		
		booksService.Delete(bookid);
	}
	
	@PutMapping("/Books/{id}")
	private Books updateBook(@PathVariable("id")int id, @RequestBody  Books book) {
		
		return booksService.UpdateData(id, book);
	}
	
	

}
