package com.app.DTO;

import com.app.model.Books;

public class BookDTO {
	
	private Long bookId;
	
	private String bookName;
	
	private String author;
	
	

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setData(Books book) {
		// TODO Auto-generated method stub
		
	}
	
}
