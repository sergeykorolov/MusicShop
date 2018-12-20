package com.torrens.musicshop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private Integer instrumentId;
    private String filename;

    public Comment() {
    }

    public Comment(String text, Date date, User user, Integer instrumentId) {
        this.text = text;
        this.date = date;
        this.author = user;
        this.instrumentId = instrumentId;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<никто>";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
