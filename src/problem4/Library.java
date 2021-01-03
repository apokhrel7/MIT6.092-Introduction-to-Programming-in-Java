package problem4;

import java.util.ArrayList;

public class Library {

    static String openingHours = "Libraries are open daily from 9am to 5pm.";
    String address;
    ArrayList<Book> bookList;


    public Library(String address) {
        this.address = address;
        bookList = new ArrayList<>();
    }


    static void printOpeningHours() {
        System.out.println(openingHours);
    }


    public void printAddress() {
        System.out.println(address);
    }


    public void addBook(Book books) {
        bookList.add(books);
    }


    public void borrowBook(String bookTitle) {
        Book booksInLibrary;
        String libraryBookTitle = "";
        byte available = 0;


        for (Book book : bookList) {

            booksInLibrary = book;
            libraryBookTitle = booksInLibrary.getTitle();

            if (libraryBookTitle.equals(bookTitle)) {  // if the library has the book provided by user

                if (!booksInLibrary.isBorrowed()) {  // if user book has not been borrowed
                    booksInLibrary.borrowed();  // allow user to borrow book
                    available = 1;  // 1 means book is now borrowed

                }

                else {              // if book has already been borrowed
                    available = -1;
                }
                break;
            }
        }

        if (available == 1) {
            System.out.println("You have successfully borrowed " + libraryBookTitle);
        }

        else if (available == -1) {
            System.out.println("Sorry, the book is already borrowed");
        }

        else {      // if available = 0
            System.out.println("Sorry, the book is not in the catalog");
        }

    }


    public void printAvailableBooks() {
        Book booksInLibrary;
        String libraryBookTitle;

        if (bookList.size() != 0) {  // if the library of books is not empty (must contain at least a book)

            for (Book book : bookList) {

                booksInLibrary = book;
                libraryBookTitle = booksInLibrary.getTitle();

                if (!booksInLibrary.isBorrowed()) {  // if book has not been borrowed
                    System.out.println(libraryBookTitle);  // print title of books that haven't been borrowed
                }
            }
        }

        else {
            System.out.println("No book in catalog.");
        }

    }


    public void returnBook(String bookTitle) {
        Book booksInLibrary;
        String libraryBookTitle;
        boolean wasBorrowed = false;

        for (Book book : bookList) {

            booksInLibrary = book;
            libraryBookTitle = booksInLibrary.getTitle();

            // if user's book is in the library and book has been borrowed
            if (libraryBookTitle.equals(bookTitle) && booksInLibrary.isBorrowed()) {

                wasBorrowed = true;   // book has been borrowed before, good to return
                booksInLibrary.returned();
                break;

            }
        }

        if (wasBorrowed) {
            System.out.println("You successfully returned " + bookTitle);
        }
        else {
            System.out.println("You tried to return a book that does not belong to the library");
        }

    }


    public static void main(String[] args) {

        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");

        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

//        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        String number = "1234";
        System.out.println(number.charAt(number.length() - 1));
    }
}





