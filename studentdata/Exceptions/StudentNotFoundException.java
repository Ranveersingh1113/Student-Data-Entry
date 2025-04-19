package studentdata.exceptions;

/** Thrown when a student is not found in search. */
public class StudentNotFoundException extends SearchOperationException {
    public StudentNotFoundException(String message) { super(message); }
}
