/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anshdawda;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author bhavya-gohil
 */
public class Book {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private int bid;
    private boolean isAvailable;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String borrowedBy;
    private File cover;
    private boolean isIssued;
    private boolean isReturned;
    
    private static Book book;
    
    private Book(){
    
    }
    
    public static Book getInstance() {
        if (book == null) {
            book = new Book();
        }
        return book;
    }

    public Book(String title, String author, String publisher, int price) {
        // TODO add default image part instead of null
        this(
                title,
                author,
                publisher,
                price,
                new File("src/lms/images/defaultCover.jpg")
          
        );
//        System.out.println(cover.getAbsolutePath());
    }

    public Book(String title, String author, String publisher, int price, File cover) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.cover = cover;
        this.bid = count.incrementAndGet();  
        this.isAvailable = true;
        this.isIssued = false;
        this.isReturned = false;
    }
    
    public void setBook(String title, String author, String publisher, int price, File cover){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.cover = cover;
    }
    
    public void setBook(String title, String author, String publisher, int price){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.cover = new File("src/lms/images/defaultCover.jpg");
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }
    
    public File getCover() {
        return cover;
    }
    
    public String getBorrower() {
        return borrowedBy;
    }

    public ImageIcon getCoverImage(int width, int height) {
        try {
            final URL url = cover.toURI().toURL();
            final Image image = ImageIO.read(url);
            final Image scaledImage = image.getScaledInstance(
                    width,
                    height,
                    Image.SCALE_SMOOTH
            );
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            return scaledIcon;
        } catch (final IOException e) {
//            e.printStackTrace();
        }
        return null;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setCover(File cover) {
        this.cover = cover;
    }
    
    public void setBorrower(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
    
    public boolean getAvailability(){
        return this.isAvailable;
    }
    
    public void setIssued(){
        this.isIssued = true;
        this.isReturned = false;
    } 
    
    public void setReturned(){
        this.isReturned = true;
        this.isIssued = false;
    }
    
    public void setAvailability(){
        if(this.isIssued && this.isAvailable){
            this.isAvailable = false;
        }else if(this.isReturned && !this.isAvailable){
            this.isAvailable = true;
        }
    }
}
