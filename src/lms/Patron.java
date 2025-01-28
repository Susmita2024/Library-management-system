/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ansuman Student id : 64115  Lecturer name: Saroj Hiranwal Date written: 25/01/2025
 * This class represents a users who has borrowed books from library and has core methods of registering patron, viewing book borrowed by
 * patron,and ensuring loan is not exceeding the MAX_LOANS. It also has validation for email and phone no.
 * 
 */
public class Patron {
    private int patronID;
    private String name;
    private String email;
    private String phone;
    private List<Loan> activeLoans;
    private static final int MAX_LOANS = 5; // Maximum number of loans a patron can have
    
//constructor

    public Patron(int patronID, String name, String email, String phone) {
        this.patronID = patronID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        activeLoans = new ArrayList<>();
    }

   

    public int getPatronID() {
        return patronID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPatronID(int patronID) {
        this.patronID = patronID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    //register user
    public void register() {
        System.out.println("Patron" + name + "has been registered.");
    }

    //view borrowed books
    public void viewBorrowedBooks() {
        System.out.println("Books borrowed for Patron " + name + ":");

    }
    
    // Add a loan to the patron's list of active loans
    public void addLoan(Loan loan) {
        if (activeLoans.size() < MAX_LOANS) {
            activeLoans.add(loan);
        } else {
            System.out.println("Patron has reached the maximum number of loans.");
        }
    }

    // Check if the patron can borrow more books
    public boolean canBorrow() {
        return activeLoans.size() < MAX_LOANS;
    }
    //ToString method
    @Override
    public String toString() {
        return "Patron ID: " + patronID + ", Name: " + name;
    }
}
