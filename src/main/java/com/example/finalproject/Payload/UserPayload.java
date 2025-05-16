package com.example.finalproject.Payload;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.finalproject.model.Favorite;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class UserPayload {
	
	private String email;
	private String password;
	private String username;
	private String profile;
}
