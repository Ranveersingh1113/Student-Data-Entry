package studentdata.exceptions;

/** Thrown when there is no data to display. */
public class NoDataException extends DisplayOperationException {
    public NoDataException(String message) { super(message); }
}
