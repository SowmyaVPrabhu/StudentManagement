package studentmanagment;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin extends User {
    private ArrayList<Student> students;
    private Scanner scanner;

    public Admin(String name, String USN) {
        super(name, USN);
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\nStudent Management Menu");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student By USN");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.out.println("Exiting the System...");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Student Name: ");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();

        System.out.print("Enter USN: ");
        String USN = scanner.nextLine();

        System.out.print("Enter the number of Subjects: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];
        System.out.println("Enter the Marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        Student s = new Student(name, USN, marks);
        students.add(s);
        System.out.println("Student Added Successfully");
    }

    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Student Records Found");
        } else {
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }

    private void searchStudent() {
        System.out.print("Enter USN to search: ");
        scanner.nextLine(); // consume leftover newline
        String roll = scanner.nextLine();
        boolean found = false;

        for (Student s : students) {
            if (Objects.equals(s.getUSN(), roll)) {
                s.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found With USN: " + roll);
        }
    }
}
