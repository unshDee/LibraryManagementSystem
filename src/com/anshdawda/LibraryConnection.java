/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anshdawda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshd
 */
public class LibraryConnection {
    
    private ArrayList<Book> books;
    
    public static LibraryConnection connection;

    private LibraryConnection() {
        books = new ArrayList<>();
        books.add(new Book("The Hunger Games", "Suzanne Collins", "Scholastic Press", "9780439023481", 34.99f));
        books.add(new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling", "Bloomsbury", "9780439358064", 48.00f));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", "9780810385665", 1.37f));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", "9781853260001", 23.99f));
        books.add(new Book("The Book Thief", "Mark Zusak", "2005 Picador", "9780375842207", 6.99f));
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
