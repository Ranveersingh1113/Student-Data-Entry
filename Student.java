package studentdata;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import studentdata.exceptions.InvalidDataException;


public class Student {
    private String prn;
    private String name;
    private LocalDate dob;
    private double[] marks;

    
    public Student(String prn, String name, String dobStr, double[] marks) throws InvalidDataException {
        if (prn == null || prn.isEmpty()) {
            throw new InvalidDataException("PRN cannot be null or empty.");
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidDataException("Name cannot be null or empty.");
        }
        LocalDate date;
        try {
            date = LocalDate.parse(dobStr);
        } catch (DateTimeParseException e) {
            throw new InvalidDataException("Invalid date format (expected YYYY-MM-DD).", e);
        }
        if (marks == null || marks.length == 0) {
            throw new InvalidDataException("Marks array cannot be null or empty.");
        }
        this.prn = prn;
        this.name = name;
        this.dob = date;
        this.marks = marks;
    }

    // Getters and setters
    public String getPrn() { return prn; }
    public String getName() { return name; }
    public LocalDate getDob() { return dob; }
    public double[] getMarks() { return marks; }

    
    public double getTotalMarks() {
        double sum = 0;
        for (double m : marks) sum += m;
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRN: ").append(prn)
          .append(", Name: ").append(name)
          .append(", DOB: ").append(dob)
          .append(", Total Marks: ").append(getTotalMarks());
        return sb.toString();
    }
}
