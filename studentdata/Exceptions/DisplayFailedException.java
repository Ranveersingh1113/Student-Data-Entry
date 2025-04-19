package studentdata.exceptions;

/** Thrown when display operation fails unexpectedly. */
public class DisplayFailedException extends DisplayOperationException {
    public DisplayFailedException(String message) { super(message); }
}
