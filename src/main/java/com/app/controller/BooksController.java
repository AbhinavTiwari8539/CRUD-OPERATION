package com.app.controller;

import java.util.List;

import com.app.Response;
import com.app.DTO.BookDTO;
import com.app.model.Books;
import com.app.service.BooksService;

import org.json.JSONObject;
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
	private ResponseEntity<List<BookDTO>> getBookInfo(){
		
		return new ResponseEntity<>(booksService.getBookInfo(),HttpStatus.OK);
	}
	
	@PostMapping("/Books")
	public ResponseEntity< Response> createBookDetails(@RequestBody Books book){
	 booksService.createdAllDetails(book);
		Response r=new Response();
		r.setResponse("Sucess");
	return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@GetMapping("/Books/{bookid}")
	private  ResponseEntity<BookDTO> getSingleBookDetails(@PathVariable("bookid")Long bookid) {
		return new ResponseEntity<>(booksService.getBooksById(bookid), HttpStatus.OK);

	}

	@DeleteMapping("/Books/{id}")
	private ResponseEntity< Response> deleteBookDetails(@PathVariable("id") Long bookid) {
		
		booksService.Delete(bookid);
		Response r=new Response();
		r.setResponse("Data Deleted");
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
	
	@PutMapping("/Books/{id}")
	private  ResponseEntity<Response> updateBookDetails(@PathVariable("id")Long id, @RequestBody  Books book) {
		
		 booksService.UpdateData(id, book);
		 Response r=new Response();
			r.setResponse("Data Updated");
		 return new ResponseEntity<>(r, HttpStatus.OK);
	}
	
	

}
