package studentdata.exceptions;


public class AddOperationException extends Exception {
    public AddOperationException(String message) { super(message); }
    public AddOperationException(String message, Throwable cause) { super(message, cause); }
}
