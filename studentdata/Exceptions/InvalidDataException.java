package studentdata.exceptions;


public class InvalidDataException extends AddOperationException {
    public InvalidDataException(String message) { super(message); }
    public InvalidDataException(String message, Throwable cause) { super(message, cause); }
}
