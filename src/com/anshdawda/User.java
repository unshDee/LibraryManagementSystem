/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anshdawda;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author anshd
 */
public class User {

    // 0 = member
    // 1 = staff
    // 2 = admin
    private int PRIVILEGE;
    private String username;
    private String firstName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private String address;
    private String password;
    private boolean isLoggedIn;
    private File avatar;
    private ArrayList<Book> borrowedBooks;

    private static User user;

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
            user.isLoggedIn = false;
        }
        return user;
    }

    public int getPRIVILEGE() {
        return PRIVILEGE;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public File getAvatar() {
        return avatar;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public ImageIcon getAvatarImage(int width, int height) {
        try {
            final URL url = avatar.toURI().toURL();
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }
    
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void setUser(int PRIVILEGE, String username, String firstName, String lastName, String gender, String maritalStatus, String address, String password) {
        setUser(
                PRIVILEGE,
                username,
                firstName,
                lastName,
                gender,
                maritalStatus,
                address,
                password,
                new File("src/com/anshdawda/resources/defaultAvatar.png")
        );
    }

    /*public void setUser(int PRIVILEGE, String username, String firstName, String lastName, String gender, String maritalStatus, String address, String password, File avatar) {
    setUser(
    PRIVILEGE,
    username,
    firstName,
    lastName,
    gender,
    maritalStatus,
    address,
    password,
    avatar
    );
    }*/
    
    public void setUser(int PRIVILIGE, String username, String firstName, String lastName, String gender, String maritalStatus, String address, String password, File avatar) {
        this.PRIVILEGE = PRIVILIGE;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.password = password;
        this.avatar = avatar;
        this.isLoggedIn = true;
        this.borrowedBooks = new ArrayList<>();
    }

    public void logout() {
        isLoggedIn = false;
    }
}
