package com.example.finalproject.json;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import com.example.finalproject.model.Author;
import com.example.finalproject.model.Book;
import com.example.finalproject.model.Genre;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookListJson {
	private Long bookid;
	private LocalDateTime publication_date;
	private String cover_image_url;
	private String description;
	private String title;
	private Author author_id;
	private Genre genre_id;
	private String story;
	
	public static BookListJson packJson(Book book) {
		BookListJson bookListJson = new BookListJson();
		bookListJson.setAuthor_id(book.getAuthor());
		bookListJson.setCover_image_url(book.getCoverImageUrl());
		bookListJson.setDescription(book.getDescription());
		bookListJson.setGenre_id(book.getGenre());
		bookListJson.setPublication_date(book.getPublicationDate());
		bookListJson.setBookid(book.getId());
		bookListJson.setTitle(book.getTitle());
		bookListJson.setStory(book.getStory());
		
		return bookListJson;
	}
	
		
	public static List<BookListJson>packJsons(List<Book> books){
		List<BookListJson> bookListJson=new ArrayList<BookListJson>();
		for(Book book:books) {
			bookListJson.add(packJson(book));
		}
		return bookListJson;
	}
		
		
	
}