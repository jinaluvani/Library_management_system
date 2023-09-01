import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    private static HashMap<String, Book> books = new HashMap<>();
    private static User user;
    public static void main(String[] args) {
        bookList();
        System.out.println("Here is total avilable books: "+ Arrays.asList(books));
//        books.forEach((key, value) -> System.out.println("Avilable books are: "+ key + " " + value));

        int option;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        user = new User(userName);


        while (true){
            System.out.println("\n1. Issue Book\n2. Return Book\n3. Search Book\n4. Exit");
            System.out.println("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    issueBook(scanner);
                    break;
                case 2:
                    returnBook(scanner);
                    break;
                case 3:
                   searchBook(scanner);
                    break;
                case 4:
                    System.out.println("See ya soon!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        }

    }
    private static void bookList(){
        books.put("Id1",new Book("Book 1", "Author 1"));
        books.put("Id2", new Book("Book 2", "Author 2"));
        books.put("Id3", new Book("Book 3", "Author 3"));
        books.put("Id4", new Book("Book 4", "Author 4"));
        books.put("Id5", new Book("Book 5", "Author 5"));
    }
    private static void issueBook(Scanner scanner){
        System.out.println("Enter book id: ");
        String book_id = scanner.nextLine();
        Book book = books.get(book_id);
        if(book != null){
            user.book_issued.add(book);
            System.out.println("New book Issued successfully! " );
        }else{
            System.out.println("Please try again!");
        }

    }

    private static void returnBook(Scanner scanner){
        System.out.println("Enter book id: ");
        String book_id = scanner.nextLine();
        Book book = books.get(book_id);
        if(book != null && user.book_issued.contains(book)){
            user.book_issued.remove(book);
            System.out.println("Book Returned successfully! " );
        }else{
            System.out.println("Please try again!");
        }

    }

    private static void searchBook(Scanner scanner){
        System.out.println("Enter book title to search: ");
        String keyword = scanner.nextLine();
        for (Book book_search : books.values()) {
            if (book_search.title.contains(keyword) || book_search.author.contains(keyword)) {
                System.out.println("Title: " + book_search.title + ", Author: " + book_search.author);
            }
        }
    }
}
