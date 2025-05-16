//package com.example.finalproject.model;
//
//import java.time.LocalDate;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "comments")
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long commentID;
//
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Book book;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    private String commentContent;
//    private LocalDate commentDate;
//
//    // getters and setters
//    public Long getCommentID() {
//        return commentID;
//    }
//
//    public void setCommentID(Long commentID) {
//        this.commentID = commentID;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getCommentContent() {
//        return commentContent;
//    }
//
//    public void setCommentContent(String commentContent) {
//        this.commentContent = commentContent;
//    }
//
//    public LocalDate getCommentDate() {
//        return commentDate;
//    }
//
//    public void setCommentDate(LocalDate commentDate) {
//        this.commentDate = commentDate;
//    }
//}



