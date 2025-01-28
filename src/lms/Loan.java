/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Lahiru Student id : 64187  Lecturer name: Saroj Hiranwal Date written: 27/01/2025
 * Loan class represents the loan which associates book and patron. It has method to calculate fine for overdue books.
 */
public class Loan {
    private int loanID;
    private int bookID;
    private int patronID;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    
   //constructor
    public Loan(int loanID, int bookID, int patronID, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.loanID = loanID;
        this.bookID = bookID;
        this.patronID = patronID;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;  
    }

    public int getLoanID() {
        return loanID;
    }

    public int getBookID() {
        return bookID;
    }

    public int getPatronID() {
        return patronID;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setPatronID(int patronID) {
        this.patronID = patronID;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    //methods
   public void calculateFine(){
       double fine;
       double dailyFineRate = 2.0;
       if (returnDate == null){
       System.out.println("The book has not been returned.");
       return;
       } 
       if (returnDate.isAfter(dueDate)){
           
           Period period = Period.between(dueDate, returnDate); 
           int overdueDays = period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365);
           fine = overdueDays * dailyFineRate;
           System.out.println("The total fine amount is:" + fine);
       }
       else{
           System.out.println("Book has returned on time");
       }
   }
   
   
   
    @Override
    public String toString() {
        return "Loan ID: " + loanID;
    }

}
