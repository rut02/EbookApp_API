package com.example.finalproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserException extends BaseException{
	
	public UserException(String code , HttpStatus status) {
		super("user" + code , status);
	}
	public static UserException emptyUser() {
		return new UserException("findUser.notFound" , HttpStatus.BAD_REQUEST);
	}
	
}
