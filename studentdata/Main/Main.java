package studentdata;

import java.util.List;
import java.util.Scanner;
import studentdata.exceptions.*;

/**
 * Main application class for Student Data Entry System.
 *
 * Name: Ranveer Singh
 * PRN : 23070126102
 * Batch: 23-27
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=== Student Data Entry System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid choice. Enter a number between 1 and 6.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter PRN: ");
                        String prn = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter DOB (YYYY-MM-DD): ");
                        String dob = scanner.nextLine();
                        System.out.print("Enter marks (comma-separated): ");
                        String[] marksStr = scanner.nextLine().split(",");
                        double[] marks = new double[marksStr.length];
                        for (int i = 0; i < marksStr.length; i++) {
                            marks[i] = Double.parseDouble(marksStr[i].trim());
                        }
                        manager.addStudent(new Student(prn, name, dob, marks));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        manager.displayAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter PRN: ");
                        System.out.println("Found: " + manager.searchByPRN(scanner.nextLine()));
                        break;

                    case 4:
                        System.out.print("Enter PRN of student to update: ");
                        String upPrn = scanner.nextLine();
                        System.out.print("Enter new Name: ");
                        String upName = scanner.nextLine();
                        System.out.print("Enter new DOB (YYYY-MM-DD): ");
                        String upDob = scanner.nextLine();
                        System.out.print("Enter new marks (comma-separated): ");
                        String[] upMarksStr = scanner.nextLine().split(",");
                        double[] upMarks = new double[upMarksStr.length];
                        for (int i = 0; i < upMarksStr.length; i++) {
                            upMarks[i] = Double.parseDouble(upMarksStr[i].trim());
                        }
                        manager.updateStudentByPRN(upPrn, new Student(upPrn, upName, upDob, upMarks));
                        System.out.println("Student updated successfully.");
                        break;

                    case 5:
                        System.out.print("Enter PRN of student to delete: ");
                        manager.deleteStudentByPRN(scanner.nextLine());
                        System.out.println("Student deleted successfully.");
                        break;

                    case 6:
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.err.println("Invalid choice. Please select 1-6.");
                }
            } catch (StudentDataException | NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
