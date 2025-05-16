package com.example.finalproject.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.Payload.AuthorPayload;
import com.example.finalproject.json.AuthorListJson;
import com.example.finalproject.model.Author;
import com.example.finalproject.service.AuthorService;

@Service
public class AuthorBusiness {
	@Autowired
	AuthorService authorService;
	
	public List<AuthorListJson>getListAuthor(){
		return AuthorListJson.packJsons(authorService.findAll());
	}
	public AuthorListJson getAuthorById(long id) {
		return AuthorListJson.packJson(authorService.findById(id));
	}
	public List<AuthorListJson> getAuthorbyName(String authorname) {
		return AuthorListJson.packJsons(authorService.findByAuthorName(authorname));
	}
	public void saveAuthor(AuthorPayload payload) {
		Author author = new Author(
				payload.getAuthorname(),
				payload.getBiography());
		authorService.save(author);
	}
	public void updateAuthor(long id,AuthorPayload payload) {
		Author authorData = authorService.findById(id);
		authorData.setAuthorName(payload.getAuthorname());
		authorData.setBiography(payload.getBiography());
		authorService.save(authorData);
	}
	public void deleteAuthor(long id) {
		authorService.deleteById(id);
	}
}
