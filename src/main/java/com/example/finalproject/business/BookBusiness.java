package com.example.finalproject.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.finalproject.Payload.BookPayload;
import com.example.finalproject.json.BookListJson;
import com.example.finalproject.model.Book;
import com.example.finalproject.service.BookService;
@Component
public class BookBusiness {
	@Autowired
	BookService bookService;
	
	public List<BookListJson> getListBook(){
		return BookListJson.packJsons(bookService.findAll());
	}
	public BookListJson getBookById(Long id) {
		
		return BookListJson.packJson(bookService.findById(id));
	}
	 public List<BookListJson> getBookByTitle(String title) {
	        return BookListJson.packJsons(bookService.findByTitle(title));
	    }
	 public List<BookListJson> getBookByGenre(String genre) {
	        return BookListJson.packJsons(bookService.findByGenre(genre));
	    }
	 public List<BookListJson> getBookByAuthor(String author) {
	        return BookListJson.packJsons(bookService.findByAuthor(author));
	    }
	 public List<BookListJson> getBookByOther(String other) {
	        return BookListJson.packJsons(bookService.findByOther(other));
	    }
	 public void saveBook(BookPayload bookPayload) {
	       	        Book book = new Book(
	                bookPayload.getTitle(),
	                bookPayload.getDescription(),
	                bookPayload.getPublication_date(),
	                bookPayload.getAuthor_id(),
	                bookPayload.getGenre_id(),
	                bookPayload.getCover_image_url(),
	                bookPayload.getStory()
	        );
	       	        bookService.save(book);
	    }
	 public void updateBook(long id, BookPayload payload) {
		 Book bookData = bookService.findById(id);
		 if (bookService != null) {
	           bookData.setTitle(payload.getTitle());
			 bookData.setDescription(payload.getDescription());
			 bookData.setPublicationDate(payload.getPublication_date());
			 bookData.setAuthor(payload.getAuthor_id());
			 bookData.setGenre(payload.getGenre_id());
			 bookData.setCoverImageUrl(payload.getCover_image_url());
			 bookService.save(bookData);
	        } else {
	          
	        }
	 }

	 
	 public void deleteBook(long id) {
			bookService.deleteById(id);
		}
	 
}