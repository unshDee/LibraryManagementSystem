/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anshdawda;

import java.util.ArrayList;

/**
 *
 * @author anshd
 */
public class LibraryConnection {
    
    private ArrayList<Book> books;
    
    public static LibraryConnection connection;

    private LibraryConnection() {
        books = new ArrayList<>();
        books.add(new Book("The Hunger Games", "Suzanne Collins", "Scholastic Press", 34));
        books.add(new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling", "Bloomsbury", 48));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", 18));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", 24));
        books.add(new Book("The Book Thief", "Mark Zusak", "2005 Picador", 7));
    }
    
    public static LibraryConnection getInstance() {
        if (connection == null) {
            connection = new LibraryConnection();
        }
        return connection;
    }
    
    public ArrayList<Book> getBooks() {
        return books;
    }
    
    public void updateBook(int index, Book book) {
        books.set(index, book);
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void removeBook(int index) {
        books.remove(index);
    }
    
    public void removeBook(Book book) {
        books.remove(book);
    }
}
