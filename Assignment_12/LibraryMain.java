import library.Book;

public class LibraryMain {
    public static void main(String[] args) {
        Book firstBook = new Book(101, "Effective Java", "Joshua Bloch", 3200.0);
        Book secondBook = new Book(102, "Head First Java", "Kathy Sierra", 1850.0);

        System.out.println("Library Book Information");
        System.out.println("========================");

        firstBook.display();
        System.out.println();
        secondBook.display();
    }
}
