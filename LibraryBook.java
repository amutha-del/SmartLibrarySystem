
package smartlibrary;

public class LibraryBook {

    private int bookId;
    private String bookName;
    private String author;
    private boolean issued;

    // Constructor
    public LibraryBook(int bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.issued = false;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    // Setter
    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    // Display details
    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (issued ? "Issued" : "Available"));
        System.out.println("-------------------------");
    }
}