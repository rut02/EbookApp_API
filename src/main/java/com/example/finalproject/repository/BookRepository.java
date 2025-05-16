package com.example.finalproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.finalproject.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
	Book findById(long id);
    Optional<Book>findOptionalById(long id);
    @Query("SELECT b FROM Book b WHERE b.author.authorName like %:authorName%")
    List<Book> findByAuthorName(@Param("authorName") String authorName);
    
    @Query("SELECT b FROM Book b WHERE b.genre.genreName like %:genreName%")
    List<Book> findByGenreName(@Param("genreName") String genreName);
    
    @Query("SELECT b FROM Book b WHERE b.title like %:title%")
    List<Book> findBytitle(@Param("title") String title);
    
    @Query("SELECT b FROM Book b WHERE b.title like %:Other% or b.author.authorName like %:Other% or b.genre.genreName like %:Other%")
    List<Book> findByOther(@Param("Other") String Other);
    
//    List<Book> findByAuthorName(String authorName);
//    List<Book> findByAuthor_AuthorName(String authorName);
//    List<Book> findByGenre(String Genre);
//    List<Book> findBytitle(String title);    
//    List<Book> findByOther(String other);
    
    
}