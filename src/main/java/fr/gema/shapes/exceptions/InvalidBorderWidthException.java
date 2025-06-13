package fr.gema.shapes.exceptions;

/**
 * Exception thrown when an invalid border width is specified for a shape.
 */
public class InvalidBorderWidthException extends Exception {

    /**
     * Constructs a new InvalidBorderWidthException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidBorderWidthException(String message) {
        super(message);
    }
    
}
