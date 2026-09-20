import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class prac51 extends JFrame implements ActionListener {

    JLabel nameLabel, rollLabel, marksLabel, resultLabel;
    JTextField nameField, rollField, marksField;
    JButton submitButton;

    public prac51() {

        setTitle("Student Registration");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 5));

        nameLabel = new JLabel("Student Name:");
        rollLabel = new JLabel("Roll No:");
        marksLabel = new JLabel("Marks:");
        resultLabel = new JLabel("Result:");

        nameField = new JTextField();
        rollField = new JTextField();
        marksField = new JTextField();

        submitButton = new JButton("Submit");

        submitButton.addActionListener(this);

        add(nameLabel);
        add(nameField);

        add(rollLabel);
        add(rollField);

        add(marksLabel);
        add(marksField);

        add(submitButton);
        add(new JLabel(""));

        add(resultLabel);
        add(new JLabel(""));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText().trim();
        String rollNo = rollField.getText().trim();
        String marksText = marksField.getText().trim();

        if (name.isEmpty() || rollNo.isEmpty() || marksText.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please fill all the fields.",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            double marks = Double.parseDouble(marksText);

            if (marks < 0 || marks > 100) {
                JOptionPane.showMessageDialog(
                    this,
                    "Marks must be between 0 and 100.",
                    "Invalid Marks",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            String grade;

            if (marks >= 90) {
                grade = "A+";
            } else if (marks >= 80) {
                grade = "A";
            } else if (marks >= 70) {
                grade = "B";
            } else if (marks >= 60) {
                grade = "C";
            } else if (marks >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            resultLabel.setText(
                "<html>Name: " + name +
                "<br>Roll No: " + rollNo +
                "<br>Marks: " + marks +
                "<br>Grade: " + grade + "</html>"
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number for marks.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new prac51());
    }
}