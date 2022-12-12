package com.app.controller;

import java.util.List;
import java.util.Map;

import com.app.DTO.BookDTO;
import com.app.model.Books;
import com.app.service.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	
	@Autowired
	public BooksService booksService;
	
	
	@GetMapping("/Books")
	private List<BookDTO> getBookInfo(){
		
		return booksService.getBookInfo();
	}
	
	@PostMapping("/Books")
	public ResponseEntity<String> createBookDetails(@RequestBody Books book){

		 return new ResponseEntity<>("Data Createds ", HttpStatus.OK);
	}

	@GetMapping("/Books/{bookid}")
	private  BookDTO getSingleBookDetails(@PathVariable("bookid")Long bookid) {
		return booksService.getBooksById(bookid);

	}

	@DeleteMapping("/Books/{id}")
	private ResponseEntity<String> deleteBookDetails(@PathVariable("id") Long bookid) {
		
		booksService.Delete(bookid);
		 return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
	}
	
	@PutMapping("/Books/{id}")
	private  ResponseEntity<String> updateBookDetails(@PathVariable("id")Long id, @RequestBody  Books book) {
		
		booksService.UpdateData(id, book);
		 return new ResponseEntity<>("Success ", HttpStatus.OK);
	}
	
	

}
