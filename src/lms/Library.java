/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class Library {
 private List<Book> books = new ArrayList<>();
 private List<Patron> patrons = new ArrayList<>()  ;
 private List<Loan> loans = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
 
    //add book to the library
    public void addBook(Book book){
      books.add(book);
        System.out.println("Books added successfully");
}
    
    //remove book from the library
    public void removeBook(int bookID){
       books.removeIf(book -> book.getBookID() == bookID); 
    }
    
    
    public void registerPatron(Patron patron){
        patrons.add(patron);
        System.out.println("Patron added");
    }
    
    //issue loan
    public Loan issueLoan(int bookId, int patronId) {
        Book book = findBookById(bookId);
        Patron patron = findPatronById(patronId);

        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return null;
        }
        if (patron == null) {
            System.out.println("Patron with ID " + patronId + " not found.");
            return null;
        }
        if (!book.isIsAvailable()) {
            System.out.println("Book is already issued.");
            return null;
        }
        
        if (!patron.canBorrow()) {
            System.out.println("Patron has reached the borrowing limit or has overdue loans.");
            return null;
        }

        // Generate loanId, issueDate, and dueDate
        int loanId = generateLoanId();
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(14);

        // Create the loan object
        Loan loan = new Loan(loanId, bookId, patronId, issueDate, dueDate, null);

        // Update book availability and patron's loans
        book.setIsAvailable(false);
        patron.addLoan(loan);

        // Add the loan to the library's loan list
        loans.add(loan);

        System.out.println("Loan issued successfully to patron ID: " + patronId);
        return loan;
    }

    public void returnBook(int loanID, LocalDate returnDate) {
        Loan loanToReturn = null;

        // Find the loan by its ID
        for (Loan loan : loans) {
            if (loan.getLoanID() == loanID) {
                loanToReturn = loan;
                break;
            }
        }

        // If no matching loan is found, print an error and exit
        if (loanToReturn == null) {
            System.out.println("Loan with ID " + loanID + " not found.");
            return;
        }

        // Update the return date in the loan
        loanToReturn.setReturnDate(returnDate);

        // Find the book and mark it as available
        for (Book book : books) {
            if (book.getBookID() == loanToReturn.getBookID()) {
                book.setIsAvailable(true);
                break;
            }
        }

        // Calculate the fine if returned late
        loanToReturn.calculateFine();

        // Print success message
        System.out.println("Book with ID " + loanToReturn.getBookID() + " has been successfully returned.");
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookID() == bookId) {
                return book;
            }
        }
        return null;
    }

    private Patron findPatronById(int patronId) {
        for (Patron patron : patrons) {
            if (patron.getPatronID() == patronId) {
                return patron;
            }
        }
        return null;
    }
    
    private int generateLoanId() {
    return loans.size() + 1; // Incremental based on the current number of loans
}

}


