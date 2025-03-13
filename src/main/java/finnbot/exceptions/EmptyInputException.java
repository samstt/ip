package finnbot.exceptions;

/**
 * Represents an exception that is thrown when the input provided is empty.
 * This exception extends the {@link Exception} class and is used to indicate
 * that the input provided by the user or system is empty and cannot be processed.
 */
public class EmptyInputException extends Exception {

    /**
     * Constructs a new {@code EmptyInputException} with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public EmptyInputException(String message) {
        super(message);
    }
}
