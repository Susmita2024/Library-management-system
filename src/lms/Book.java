/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author acer
 */
public class Book {
    private int bookID; 
    private String title;
    private String author;
    private String publisher;
    private boolean isAvailable;
//constructor
    public Book(int bookID, String title, String author,String publisher, boolean IsAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isAvailable = IsAvailable;
    }

    
//getters
    public int getBookID() {
        return bookID;
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

    public boolean isIsAvailable() {
        return isAvailable;
    }
    
//setters
    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    public void setIsAvailable(boolean IsAvailable) {
        this.isAvailable = IsAvailable;
    }
   //displaying Book details 
    public void getDetails(){
        System.out.println("Book Details:");
        System.out.println("Title:"+ title);
        System.out.println("Author:" + author);
        System.out.println("BookID:" + bookID);
    }
    //update availability of Books
    public void updateAvailability(boolean isAvailable){
         this.isAvailable = isAvailable;
        System.out.println("Availability updated:" + this.isAvailable );
    }
    
    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author;
    }
}
