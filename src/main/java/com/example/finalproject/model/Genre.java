package com.example.finalproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "genres")
public class Genre {
    
	@Id
	@Column(name = "genreid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "genre_name", nullable = false)
    private String genreName;

//    public Long getGenreID() {
//        return id;
//    }
//
//    public void setGenreID(Long genreID) {
//        this.id = genreID;
//    }
//
//    public String getGenreName() {
//        return genreName;
//    }
//
//    public void setGenreName(String genreName) {
//        this.genreName = genreName;
//    }

	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}
	public Genre() {
		;
	}
    
}

