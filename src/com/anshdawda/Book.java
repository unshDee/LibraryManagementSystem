/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anshdawda;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Ansh Dawda
 */
public class Book {

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private float price;
    private boolean isAvailable;
    private String borrowedBy;
    private File cover;

    public Book(String title, String author, String publisher, String isbn, float price) {
        // TODO add default image part instead of null
        this(
                title,
                author,
                publisher,
                isbn,
                price,
                new File("src/com/anshdawda/resources/defaultCover.jpg")
        );
//        System.out.println(cover.getAbsolutePath());
    }

    public Book(String title, String author, String publisher, String isbn, float price, File cover) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
        this.cover = cover;
        this.isAvailable = true;
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

    public String getIsbn() {
        return isbn;
    }

    public float getPrice() {
        return price;
    }
    
    public boolean isAvailable() {
        return isAvailable;
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }
    
    public void setBorrower(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
