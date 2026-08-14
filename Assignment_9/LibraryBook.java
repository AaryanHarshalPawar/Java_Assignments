package Assignment_9;

public class LibraryBook {
    static class Book {
        final String isbn;
        String title;
        String author;
        double price;

        Book(String isbn, String title, String author, double price) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.price = price;
        }

        void display() {
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: Rs. " + price);
        }
    }

    public static void main(String[] args) {
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 3200.0);

        System.out.println("Library Book Details");
        System.out.println("--------------------");
        book.display();

        System.out.println();
        book.price = 2850.0;
        System.out.println("Price revised after discount.");

        System.out.println();
        System.out.println("Updated Book Details");
        System.out.println("--------------------");
        book.display();

        System.out.println();
        System.out.println("ISBN remains: " + book.isbn);
        System.out.println("ISBN is declared final and cannot be changed once assigned.");
    }
}
