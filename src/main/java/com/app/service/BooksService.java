package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.app.DTO.BookDTO;
import com.app.model.Books;
import com.app.repo.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
	
	@Autowired
	public BooksRepository booksRepository;
	
	
	public List<BookDTO>getBookInfo(){
		
		return ((List<Books>)booksRepository.findAll()).stream().map(this::convertDataIntoDTO).collect(Collectors.toList());
				
	}
	
	private BookDTO convertDataIntoDTO(Books book) {
		
		BookDTO dto = new BookDTO();
		
		dto.setBookId(book.getBookId());
		dto.setBookName(book.getBookName());
		dto.setAuthor(book.getAuthor());
		dto.setCreated_at(book.getCreated_at());
		dto.setUpdated_at(book.getUpdated_at());
		
		return dto;
		
	}

	public Books createdAllDetails(Books book) {
		book.setCreated_at(LocalDateTime.now());
		book.setUpdated_at(LocalDateTime.now());
		
		return booksRepository.save(book);
		
		
	}
	
	public Books getBooksById(Long id) { 
		
	return booksRepository.findById(id).orElseThrow();
	
	}  
	
	public List<Books> showAllBooks() {
		
		return (List<Books>) booksRepository.findAll();
	}
	
	public void Delete(Long bookid) {
		
		booksRepository.deleteById(bookid);
		
	}
	
	public Books UpdateData(Long id,Books book) {
		Books b = booksRepository.findById(id).get();
		try {
			if(b!=null) {
				b.setAuthor(book.getAuthor());
				b.setBookName(book.getBookName());
				b.setCreated_at(b.getCreated_at());
				b.setUpdated_at(LocalDateTime.now());
			}	
		} 
		catch(Exception e) {
			System.out.println("No Data Present with this id");
		}
		
		
		
		return booksRepository.save(b);
		
	}

	
		
}
