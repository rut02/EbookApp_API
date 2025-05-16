package com.example.finalproject.model;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "books")
public class Book {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid",nullable = false)
    private Long id;
    
    @Column(name = "title", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String title;
    
    @Column(name = "description", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String description;
    
    private LocalDateTime  publicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id" , referencedColumnName = "authorid" , nullable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id" , referencedColumnName = "genreid" , nullable = false)
    private Genre genre;
    
    @Column(name = "cover_image_url", columnDefinition = "MEDIUMTEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String coverImageUrl;
    
    @Column(name = "stroy", columnDefinition = "MEDIUMTEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String story;
    
    

 
//    public Long getBookID() {
//        return id;
//    }
//
//    public void setBookID(Long bookID) {
//        this.id = bookID;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//    	return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDateTime  getPublicationDate() {
//        return publicationDate;
//    }
//
//    public void setPublicationDate(LocalDateTime  publicationDate) {
//        this.publicationDate = publicationDate;
//    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
//
//    public Genre getGenre() {
//        return genre;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }
//
//    public String getCoverImageUrl() {
//        return coverImageUrl;
//    }
//
//    public void setCoverImageUrl(String coverImageUrl) {
//        this.coverImageUrl = coverImageUrl;
//    }

	public Book(String title, String description, LocalDateTime publicationDate, Author author, Genre genre,String coverImageUrl,String story) {
		super();
		this.title = title;
		this.description = description;
		this.publicationDate = publicationDate;
		this.author = author;
		this.genre = genre;
		this.coverImageUrl = coverImageUrl;
		this.story=story;
	}
	public Book() {
		;
	}
    
    


}
