package com.example.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalproject.Payload.GenrePayload;
import com.example.finalproject.business.GenreBusiness;
import com.example.finalproject.exception.BaseException;
import com.example.finalproject.json.GenreListJson;
import com.example.finalproject.model.Genre;
import com.example.finalproject.service.GenreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    
	private final GenreService genreService;
	
	@Autowired
	GenreBusiness genrebusiness;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<GenreListJson>> getAllGenre() throws BaseException{
       return ResponseEntity.ok(genrebusiness.getListGenre());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreListJson> getGenreById(@PathVariable("id")long id) throws BaseException {
        return ResponseEntity.ok(genrebusiness.getGenreId(id));
    }

    @PostMapping
    public ResponseEntity<Void> createGenre(@RequestBody GenrePayload payload)throws BaseException {
        genrebusiness.saveGenre(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreListJson> updateGenre(@PathVariable("id")long id, @RequestBody GenrePayload payload) {
       
    	Optional<Genre> genredata = genreService.findOptionalById(id);
    	
    	if(genredata.isPresent()) {
    		
    		genrebusiness.updateGenre(genredata.get().getId(), payload);
    		return new ResponseEntity<>(HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGenre(@PathVariable("id") Long id) {
       
    	try {
			genrebusiness.deleteGenre(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}

