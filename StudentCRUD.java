import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentCRUD {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "anjali05";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(
                    url, user, password);

            System.out.println("Database connected successfully!");

            int choice;

            do {
                System.out.println("\n===== STUDENT MENU =====");
                System.out.println("1. Insert Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // Insert Student

                        System.out.print("Enter roll number: ");
                        int rollNo = sc.nextInt();

                        System.out.print("Enter student name: ");
                        String name = sc.next();

                        System.out.print("Enter marks: ");
                        double marks = sc.nextDouble();

                        String insertSql =
                                "INSERT INTO student VALUES (?, ?, ?)";

                        PreparedStatement insertPs =
                                con.prepareStatement(insertSql);

                        insertPs.setInt(1, rollNo);
                        insertPs.setString(2, name);
                        insertPs.setDouble(3, marks);

                        int insertRows =
                                insertPs.executeUpdate();

                        if (insertRows > 0) {
                            System.out.println(
                                    "Student inserted successfully!");
                        }

                        insertPs.close();
                        break;


                    case 2:
                        // View Students

                        String selectSql =
                                "SELECT * FROM student";

                        PreparedStatement selectPs =
                                con.prepareStatement(selectSql);

                        ResultSet rs =
                                selectPs.executeQuery();

                                

                        System.out.println(
                                "\n===== STUDENT DETAILS =====");

                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt("roll_no") + " " +
                                    rs.getString("name") + " " +
                                    rs.getDouble("marks")
                            );
                        }

                        rs.close();
                        selectPs.close();
                        break;


                    case 3:
    // Update Student

    System.out.print("Enter roll number: ");
    int updateRollNo = sc.nextInt();

    System.out.print("Enter new marks: ");
    double newMarks = sc.nextDouble();

    String updateSql =
            "UPDATE student SET marks = ? WHERE roll_no = ?";

    PreparedStatement updatePs =
            con.prepareStatement(updateSql);

    updatePs.setDouble(1, newMarks);
    updatePs.setInt(2, updateRollNo);

    int updateRows =
            updatePs.executeUpdate();

    if (updateRows > 0) {
        System.out.println(
                "Student updated successfully!");
    } else {
        System.out.println(
                "Student not found.");
    }

    updatePs.close();
    break;


                    case 4:
    // Delete Student

    System.out.print("Enter roll number: ");
    int deleteRollNo = sc.nextInt();

    String deleteSql =
            "DELETE FROM student WHERE roll_no = ?";

    PreparedStatement deletePs =
            con.prepareStatement(deleteSql);

    deletePs.setInt(1, deleteRollNo);

    int deleteRows =
            deletePs.executeUpdate();

    if (deleteRows > 0) {
        System.out.println(
                "Student deleted successfully!");
    } else {
        System.out.println(
                "Student not found.");
    }

    deletePs.close();
    break;


                    case 5:
                        System.out.println("Exiting...");
                        break;


                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 5);

            con.close();
            sc.close();

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }
}