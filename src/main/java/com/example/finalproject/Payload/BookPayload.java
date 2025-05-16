package com.example.finalproject.Payload;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.finalproject.model.Author;
import com.example.finalproject.model.Book;
import com.example.finalproject.model.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookPayload {
	
	private LocalDateTime publication_date;
	private String cover_image_url;
	private String description;
	private String title;
	private Author author_id;
//	private Long bookid;
	private Genre genre_id;
	private String story;
}
