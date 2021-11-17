package com.example.alphacar.DTOS;

import java.util.Date;

public class ReviewDTO {

    private int review_id,store_number, readcnt;
    private String customer_email,title, content,  filename;
    private Date notice_writedate;

    public ReviewDTO(int review_id, int store_number, int readcnt, String customer_email, String title, String content, String filename) {
        this.review_id = review_id;
        this.store_number = store_number;
        this.readcnt = readcnt;
        this.customer_email = customer_email;
        this.title = title;
        this.content = content;
        this.filename = filename;
    }

    public ReviewDTO() {

    }

    public ReviewDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getStore_number() {
        return store_number;
    }

    public void setStore_number(int store_number) {
        this.store_number = store_number;
    }

    public int getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getNotice_writedate() {
        return notice_writedate;
    }

    public void setNotice_writedate(Date notice_writedate) {
        this.notice_writedate = notice_writedate;
    }
}
