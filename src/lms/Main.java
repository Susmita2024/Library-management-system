/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lms;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Susmita
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Library library = new Library(); // Initialize the library
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Register a Patron");
            System.out.println("3. Issue a Loan");
            System.out.println("4. Return a Book");
            System.out.println("5. Display Books");
            System.out.println("6. Display Patrons");
            System.out.println("7. Display Loans");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Publisher Name: ");
                    String publisher = scanner.nextLine();
                    library.addBook(new Book(bookID, title, author, publisher, true));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Patron ID: ");
                    int patronID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Patron Name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter Patron Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Patron Phone: ");
                    String phone = scanner.nextLine();
                    library.registerPatron(new Patron(patronID, patronName, email, phone));
                    System.out.println("Patron registered successfully.");
                    break;

                case 3:

                    // Input for Patron ID
                    System.out.print("Enter Patron ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Error: Please enter Patron ID.");
                        scanner.next(); // Discard the invalid input
                        System.out.print("Enter Patron ID: ");
                    }
                    int loanPatronID = scanner.nextInt();

                    // Input for Book ID
                    System.out.print("Enter Book ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Error: Please enter Book ID.");
                        scanner.next(); // Discard the invalid input
                        System.out.print("Enter Book ID: ");
                    }
                    int loanBookID = scanner.nextInt();

                    // Proceed if the IDs are valid (greater than 0)
                    if (loanPatronID > 0 && loanBookID > 0) {
                        // Assuming library.issueLoan(bookID, patronID) is a method to issue a loan
                        library.issueLoan(loanBookID, loanPatronID);
                        System.out.println("Loan issued successfully.");
                    } else {
                        System.out.println("Error: IDs must be positive integers.");
                    }
                    
                    break;

                case 4:
                    System.out.print("Enter Loan ID: ");
                    int returnLoanID = scanner.nextInt();
                    System.out.print("Enter Return Date (YYYY-MM-DD): ");
                    String returnDateString = scanner.next();
                    LocalDate returnDate = LocalDate.parse(returnDateString);
                    library.returnBook(returnLoanID, returnDate);
                    break;

                case 5:
                    System.out.println("\nBooks in the Library:");
                    System.out.println("Books:");
                    for (Book book : library.getBooks()) {
                        System.out.println(book);
                    }
                    break;

                case 6:
                    System.out.println("\nRegistered Patrons:");
                    for (Patron patron : library.getPatrons()) {
                        System.out.println(patron);
                    }
                    break;

                case 7:
                    System.out.println("\nActive Loans:");
                    for (Loan loan : library.getLoans()) {
                        System.out.println(loan);
                    }
                    break;

                case 8:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

}
