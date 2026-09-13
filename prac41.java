import java.util.*;

public class prac41 {

    public static void main(String[] args) {

        ArrayList<String> employees = new ArrayList<>();

        employees.add("Krutika");
        employees.add("Shruti");
        employees.add("Akansha");
        employees.add("Anjali");
        employees.add("Disha");

        System.out.println("===== Employee Names =====");
        for (String name : employees) {
            System.out.println(name);
        }

        TreeSet<Double> salaries = new TreeSet<>();

        salaries.add(45000.0);
        salaries.add(55000.0);
        salaries.add(40000.0);
        salaries.add(60000.0);
        salaries.add(50000.0);

        System.out.println("\n===== Salaries in Ascending Order =====");
        for (Double salary : salaries) {
            System.out.println("₹" + salary);
        }

        HashMap<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(101, "Krutika");
        employeeMap.put(102, "Shruti");
        employeeMap.put(103, "Akansha");
        employeeMap.put(104, "Anjali");
        employeeMap.put(105, "Disha");

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Employee ID to search: ");
        int id = sc.nextInt();

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee Found: " + employeeMap.get(id));
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\n===== All Employee Records =====");

        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey()
                    + ", Employee Name: " + entry.getValue());
        }

        sc.close();
    }
}
