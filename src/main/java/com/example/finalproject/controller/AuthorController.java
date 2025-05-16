package com.example.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.Payload.AuthorPayload;
import com.example.finalproject.business.AuthorBusiness;
import com.example.finalproject.json.AuthorListJson;
import com.example.finalproject.service.AuthorService;
@RestController
@RequestMapping("/api/authors")
public class AuthorController{
	@Autowired
	AuthorService authorService;
	
	@Autowired
	AuthorBusiness authorBusiness;
	
	public AuthorController(AuthorService authorService) {
		this.authorService=authorService;
	}
	
	@GetMapping
    public ResponseEntity<List<AuthorListJson>> getAllAuthors() {
        return ResponseEntity.ok(authorBusiness.getListAuthor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorListJson> getAuthorById(@PathVariable("id") long id) {
        AuthorListJson author = authorBusiness.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/search/{authorname}")
    public ResponseEntity<List<AuthorListJson>> getAuthorsByName(@RequestParam("authorname") String authorname) {
        return ResponseEntity.ok(authorBusiness.getAuthorbyName(authorname));
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody AuthorPayload payload) {
        authorBusiness.saveAuthor(payload);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable("id") long id, @RequestBody AuthorPayload payload) {
        authorBusiness.updateAuthor(id, payload);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") long id) {
        authorBusiness.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
	
	
}