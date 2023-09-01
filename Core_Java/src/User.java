import java.util.ArrayList;

public class User {

    String name;
    ArrayList<Book> book_issued ;

    public User(String name)
    {
        this.name = name;
        this.book_issued = new ArrayList<>();
    }

}
