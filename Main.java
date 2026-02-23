import java.util.Scanner;

public class Main {

    static Student[] students = new Student[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Smart Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Show Top Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addStudent(input);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent(input);
                    break;
                case 4:
                    deleteStudent(input);
                    break;
                case 5:
                    topStudent();
                    break;
                case 6:
                    System.out.println("Goodbye 👋");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void addStudent(Scanner input) {
        input.nextLine();
        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter ID: ");
        int id = input.nextInt();

        System.out.print("Enter Grade: ");
        double grade = input.nextDouble();

        students[count++] = new Student(name, id, grade);
        System.out.println("Student Added Successfully ✅");
    }

    static void displayStudents() {
        if (count == 0) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }

    static void searchStudent(Scanner input) {
        System.out.print("Enter ID to search: ");
        int id = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (students[i].id == id) {
                students[i].display();
                return;
            }
        }

        System.out.println("Student not found ❌");
    }

    static void deleteStudent(Scanner input) {
        System.out.print("Enter ID to delete: ");
        int id = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (students[i].id == id) {
                students[i] = students[count - 1];
                students[count - 1] = null;
                count--;
                System.out.println("Deleted Successfully 🗑");
                return;
            }
        }

        System.out.println("Student not found ❌");
    }

    static void topStudent() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        Student top = students[0];

        for (int i = 1; i < count; i++) {
            if (students[i].grade > top.grade) {
                top = students[i];
            }
        }

        System.out.println("Top Student ⭐");
        top.display();
    }
}
