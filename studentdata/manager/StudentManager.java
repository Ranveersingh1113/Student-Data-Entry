package studentdata;

import java.util.ArrayList;
import java.util.List;
import studentdata.exceptions.*;

/**
 * Manages student records and operations.
 */
public class StudentManager {
    private List<Student> students = new ArrayList<>();

    /**
     * Adds a new student after checking for duplicates.
     */
    public void addStudent(Student student) throws InvalidDataException, OperationFailedException {
        if (student == null) {
            throw new InvalidDataException("Student object cannot be null.");
        }
        for (Student s : students) {
            if (s.getPrn().equals(student.getPrn())) {
                throw new InvalidDataException("Duplicate PRN: " + student.getPrn());
            }
        }
        try {
            students.add(student);
        } catch (Exception e) {
            throw new OperationFailedException("Failed to add student.", e);
        }
    }

    /**
     * Displays all students.
     */
    public void displayAllStudents() throws DataNotFoundException {
        if (students.isEmpty()) {
            throw new DataNotFoundException("No student records available to display.");
        }
        System.out.println("--- Student List ---");
        students.forEach(System.out::println);
    }

    /**
     * Searches student by PRN.
     */
    public Student searchByPRN(String prn) throws InvalidDataException, DataNotFoundException {
        if (prn == null || prn.isEmpty()) {
            throw new InvalidDataException("PRN cannot be null or empty.");
        }
        return students.stream()
                       .filter(s -> s.getPrn().equals(prn))
                       .findFirst()
                       .orElseThrow(() -> new DataNotFoundException("No student found with PRN: " + prn));
    }

    /**
     * Updates a student's data by PRN.
     */
    public void updateStudentByPRN(String prn, Student newData)
            throws InvalidDataException, DataNotFoundException, OperationFailedException {
        if (newData == null) {
            throw new InvalidDataException("New student data cannot be null.");
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPrn().equals(prn)) {
                students.set(i, newData);
                return;
            }
        }
        throw new DataNotFoundException("Cannot update; no student found with PRN: " + prn);
    }

    /**
     * Deletes a student by PRN.
     */
    public void deleteStudentByPRN(String prn) throws InvalidDataException, DataNotFoundException {
        if (prn == null || prn.isEmpty()) {
            throw new InvalidDataException("PRN cannot be null or empty.");
        }
        boolean removed = students.removeIf(s -> s.getPrn().equals(prn));
        if (!removed) {
            throw new DataNotFoundException("Cannot delete; no student found with PRN: " + prn);
        }
    }
}
