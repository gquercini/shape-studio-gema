package fr.gema.shapes.exceptions;

/**
 * Exception thrown when an invalid color is specified for a shape.
 */
public class InvalidColorException extends Exception {

    /**
     * Constructs a new InvalidColorException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidColorException(String message) {
        super(message);
    }
    
}
