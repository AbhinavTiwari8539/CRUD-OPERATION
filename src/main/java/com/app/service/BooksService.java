package com.app.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.app.DTO.BookDTO;
import com.app.model.Books;

import com.app.repo.BooksRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.protocol.Message;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BooksService<Success> {

	@Autowired
	public BooksRepository booksRepository;

	public List<BookDTO> getBookInfo() {

		return ((List<Books>) booksRepository.findAll()).stream().map(this::convertDataIntoDTO)
				.collect(Collectors.toList());

	}

	private BookDTO convertDataIntoDTO(Books book) {

		BookDTO dto = new BookDTO();

		dto.setBookId(book.getBookId());
		dto.setBookName(book.getBookName());
		dto.setAuthor(book.getAuthor());

		return dto;

	}

	public BookDTO createdAllDetails(Books book) {
		Books bk = booksRepository.save(book);
		BookDTO bt = new BookDTO();
		bt.setBookId(bk.getBookId());
		bt.setAuthor(bk.getAuthor());
		bt.setBookName(bk.getBookName());

		return bt;

	}

	public BookDTO getBooksById(Long id) {

		Books book = booksRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("No Book Id Present = " + id));

		BookDTO responce = new BookDTO();
		responce.setBookId(book.getBookId());
		responce.setAuthor(book.getAuthor());
		responce.setBookName(book.getBookName());
		return responce;

	}

	public void Delete(Long bookid) {

		booksRepository.deleteById(bookid);

	}

	public BookDTO UpdateData(Long id, Books book) {
		Books b = booksRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("No Book Id Present = " + id));
		BookDTO bookdto = new BookDTO();

		b.setAuthor(book.getAuthor());
		b.setBookName(book.getBookName());
		b.setPrice(book.getPrice());
		booksRepository.save(b);
		return bookdto;

	}

}
