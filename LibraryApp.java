
package smartlibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<LibraryBook> books = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== SMART LIBRARY SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (LibraryBook b : books) {
                        if (b.getBookId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Book ID already exists!");
                    } else {
                        System.out.print("Enter Book Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();

                        LibraryBook book = new LibraryBook(id, name, author);
                        books.add(book);

                        System.out.println("Book added successfully!");
                    }
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available!");
                    } else {
                        for (LibraryBook b : books) {
                            b.displayBook();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (LibraryBook b : books) {
                        if (b.getBookId() == searchId) {
                            b.displayBook();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();

                    found = false;

                    for (LibraryBook b : books) {
                        if (b.getBookId() == issueId) {
                            found = true;

                            if (!b.isIssued()) {
                                b.setIssued(true);
                                System.out.println("Book issued successfully!");
                            } else {
                                System.out.println("Book is already issued!");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();

                    found = false;

                    for (LibraryBook b : books) {
                        if (b.getBookId() == returnId) {
                            found = true;

                            if (b.isIssued()) {
                                b.setIssued(false);
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("Book was not issued!");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Smart Library System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}

