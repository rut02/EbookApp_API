package com.example.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.model.Book;
import com.example.finalproject.repository.BookRepository;
import com.example.finalproject.service.impl.IBook;

//import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBook{
    
	private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> findByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return bookRepository.findByAuthorName(authorName);
	}

	@Override
	public List<Book> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return bookRepository.findByGenreName(genre);
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return bookRepository.findBytitle(title);
	}

	@Override
	public List<Book> findByOther(String other) {
		// TODO Auto-generated method stub
		return bookRepository.findByOther(other);
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void deleteById(long id) {
		bookRepository.deleteById(id);
		// TODO Auto-generated method stub
		;
	}
	public Optional<Book> findOptionalById(long id){
	    return bookRepository.findOptionalById(id);
	}

   
}

