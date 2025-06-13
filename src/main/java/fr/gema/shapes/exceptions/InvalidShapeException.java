package fr.gema.shapes.exceptions;

/**
 * Exception thrown when an invalid shape is specified or detected.
 */
public class InvalidShapeException extends Exception {

    /**
     * Constructs a new InvalidShapeException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidShapeException(String message) {
        super(message);
    }
    
}
