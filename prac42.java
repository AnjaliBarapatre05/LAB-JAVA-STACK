
import java.util.*;

public class prac42 {

    public static void main(String[] args) {

        ArrayList<String> books = new ArrayList<>();

        books.add("Java Programming");
        books.add("Database Management");
        books.add("Computer Networks");
        books.add("Operating System");
        books.add("Data Structures");

        System.out.println("===== Book Names =====");

        for (String book : books) {
            System.out.println(book);
        }

        TreeSet<Double> prices = new TreeSet<>();

        prices.add(450.0);
        prices.add(300.0);
        prices.add(550.0);
        prices.add(250.0);
        prices.add(400.0);

        System.out.println("\n===== Book Prices in Ascending Order =====");

        for (Double price : prices) {
            System.out.println(price);
        }

        HashMap<Integer, String> bookMap = new HashMap<>();

        bookMap.put(201, "Java Programming");
        bookMap.put(202, "Database Management");
        bookMap.put(203, "Computer Networks");
        bookMap.put(204, "Operating System");
        bookMap.put(205, "Data Structures");

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Book ID to search: ");

        int id = sc.nextInt();

        if (bookMap.containsKey(id)) {
            System.out.println("Book Found: " + bookMap.get(id));
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\n===== All Book Records =====");

        for (Map.Entry<Integer, String> entry : bookMap.entrySet()) {
            System.out.println("Book ID: " + entry.getKey()
                    + ", Book Title: " + entry.getValue());
        }

        sc.close();

    }
}