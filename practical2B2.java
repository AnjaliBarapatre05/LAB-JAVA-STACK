abstract class Employee {

    abstract void calculateBonus();

    void displayDetail() {
        System.out.println("Employee Details");
    }
}

class Manager extends Employee {

    @Override
    void calculateBonus() {
        System.out.println("Manager Bonus: 20% of salary");
    }
}

class Developer extends Employee {

    @Override
    void calculateBonus() {
        System.out.println("Developer Bonus: 10% of salary");
    }
}

public class practical2B2{

    public static void main(String[] args) {

        Employee e;

        e = new Manager();
        e.displayDetail();
        e.calculateBonus();

        System.out.println();

        e = new Developer();
        e.displayDetail();
        e.calculateBonus();
    }
}