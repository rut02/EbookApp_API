package com.example.finalproject.Payload;

import com.example.finalproject.model.Book;
import com.example.finalproject.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FavoritePayload {
	
	private User user;
	private Book book;
}
