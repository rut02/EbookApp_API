package com.example.finalproject.model;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private User user;
    
    @Column(name="rating", nullable = false)
    private int rating;
   
    public Rating() {
    	
    }
    public Rating(Book book,User user,int rating) {
    	super();
    	this.book=book;
    	this.user=user;
    	this.rating=rating;
    }

  
}
 


