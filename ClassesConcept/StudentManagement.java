
package ClassesConcept;

import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String course;

    static int studentsCount = 0;

    Student(int id,String name,int age,String course){
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        studentsCount++;
        System.out.println("Student  " + name + " has create.");
    }

    public void getStudentDetails(){
        System.out.println(" ====== Details ======");
        System.out.println("id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: "+age);
        System.out.println("Course Taken: "+course);
        System.out.println(" ====== Details ======");
    }

    public void getStudentsCount(){
        System.out.println("Students Count:" +studentsCount);
    }
}

public class StudentManagement {

    static Scanner sc = new Scanner(System.in);
    static int size;
    static Student students[];   // ✅ STATIC so data is retained

    public static void insertStudents() {
        System.out.print("Enter the number of students that you want to insert: ");
        size = sc.nextInt();

        students = new Student[size];

        for (int i = 0; i < size; i++) {
            System.out.println("\nEnter the Student Details " + (i + 1));

            System.out.print("Enter the id: ");
            int id = sc.nextInt();

            System.out.print("Enter name of student: ");
            String name = sc.next();

            System.out.print("Enter the age: ");
            int age = sc.nextInt();

            System.out.print("Enter the course: ");
            String course = sc.next();

            students[i] = new Student(id, name, age, course);
        }
    }

    public static void getStudentDetails() {
        if (students == null || size == 0) {
            System.out.println("No students found. Please insert students first.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println("\nStudent Details " + (i + 1));
            students[i].getStudentDetails();
        }
    }

    public static void getStudentsCount() {
        System.out.println("Total Students: " + Student.studentsCount);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n====== Student Menu ======");
            System.out.println("1. Create Students");
            System.out.println("2. Get Student Details");
            System.out.println("3. Get Student Count");
            System.out.println("4. Exit");
            System.out.print("Enter the option: ");

            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    insertStudents();
                    break;

                case 2:
                    getStudentDetails();
                    break;

                case 3:
                    getStudentsCount();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
 

