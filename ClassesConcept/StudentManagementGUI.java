package ClassesConcept;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagementGUI extends JFrame {

    private JTextField idField, nameField, ageField, courseField;
    private JTextArea outputArea;
    private ArrayList<Student> studentsList = new ArrayList<>();

    public StudentManagementGUI() {
        setTitle("Student Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // ------ Input Panel ------
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Course:"));
        courseField = new JTextField();
        inputPanel.add(courseField);

        // ------ Button Panel ------
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Add Student");
        JButton showButton = new JButton("Show All Students");
        JButton countButton = new JButton("Show Count");
        JButton clearButton = new JButton("Clear Output");

        buttonPanel.add(addButton);
        buttonPanel.add(showButton);
        buttonPanel.add(countButton);
        buttonPanel.add(clearButton);

        // ------ Output Area ------
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // ------ Layout ------
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // ------ Button Actions ------

        // Add Student
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        // Show all students
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStudents();
            }
        });

        // Show count
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCount();
            }
        });

        // Clear output
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
            }
        });
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String course = courseField.getText().trim();

            if (name.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Course cannot be empty.");
                return;
            }

            // Use your existing Student class
            Student s = new Student(id, name, age, course);
            studentsList.add(s);

            outputArea.append("Student " + name + " added successfully.\n");

            // Clear fields
            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            courseField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID and Age must be numbers.");
        }
    }

    private void showStudents() {
        if (studentsList.isEmpty()) {
            outputArea.append("No students to show.\n");
            return;
        }

        outputArea.append("\n===== All Students =====\n");
        int i = 1;
        for (Student s : studentsList) {
            outputArea.append("Student " + (i++) + ":\n");
            outputArea.append("id: " + s.id + "\n");
            outputArea.append("Name: " + s.name + "\n");
            outputArea.append("Age: " + s.age + "\n");
            outputArea.append("Course Taken: " + s.course + "\n");
            outputArea.append("-------------------------\n");
        }
    }

    private void showCount() {
        // Uses your static variable from Student class
        outputArea.append("\nTotal Students (using Student.studentsCount): " 
                          + Student.studentsCount + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentManagementGUI().setVisible(true);
        });
    }
}
