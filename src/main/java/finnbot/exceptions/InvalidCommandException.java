package finnbot.exceptions;

/**
 * Represents an exception that is thrown when an invalid command is encountered.
 * This exception extends the {@link Exception} class and is used to indicate
 * that the command provided is not recognized or is not valid within the current context.
 */
public class InvalidCommandException extends Exception {

    /**
     * Constructs a new {@code InvalidCommandException} with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}
