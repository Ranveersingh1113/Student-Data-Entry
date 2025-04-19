package studentdata.exceptions;

/** Thrown when search criteria are invalid. */
public class InvalidSearchCriteriaException extends SearchOperationException {
    public InvalidSearchCriteriaException(String message) { super(message); }
}
