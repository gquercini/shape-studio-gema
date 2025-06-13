package fr.gema.shapes;

import fr.gema.shapes.exceptions.InvalidBorderWidthException;
import fr.gema.shapes.exceptions.InvalidColorException;
import fr.gema.shapes.exceptions.InvalidShapeException;

/**
 * Represents a rectangle shape defined by its upper left and bottom right
 * points.
 * Provides methods for geometric operations and property access.
 */
public class Rectangle extends GenericShape {
    /** The upper left corner of the rectangle. */
    private Point upperLeft;
    /** The bottom right corner of the rectangle. */
    private Point bottomRight;

    /**
     * Constructs a rectangle with the specified label, upper left, and bottom right points.
     *
     * @param label the label of the rectangle
     * @param upperLeft the point representing the upper left corner
     * @param bottomRight the point representing the bottom right corner
     * @throws InvalidColorException if the color is invalid
     * @throws InvalidBorderWidthException if the border width is invalid
     * @throws InvalidShapeException if the points do not form a valid rectangle
     */
    public Rectangle(String label,
            Point upperLeft,
            Point bottomRight) throws InvalidColorException, InvalidBorderWidthException, InvalidShapeException {
        // TODO
    }

    /**
     * Constructs a rectangle with all specified properties.
     *
     * @param label the label of the rectangle
     * @param borderWidth the border width
     * @param borderColor the border color
     * @param fillColor the fill color
     * @param upperLeft the point representing the upper left corner
     * @param bottomRight the point representing the bottom right corner
     * @throws InvalidColorException if the color is invalid
     * @throws InvalidBorderWidthException if the border width is invalid
     * @throws InvalidShapeException if the points do not form a valid rectangle
     */
    public Rectangle(String label,
            float borderWidth,
            String borderColor,
            String fillColor,
            Point upperLeft,
            Point bottomRight) throws InvalidColorException, InvalidBorderWidthException, InvalidShapeException {
        // TODO
    }

    /**
     * Returns the point representing the upper left corner of the rectangle.
     *
     * @return the upper left corner
     */
    public Point getUpperLeft() {
        // TODO
        return null;
    }

    /**
     * Returns the point representing the bottom right corner of the rectangle.
     *
     * @return the bottom right corner
     */
    public Point getBottomRight() {
        // TODO
        return null;
    }

    /**
     * Returns the point representing the upper right corner of the rectangle.
     *
     * @return the upper right corner
     */
    public Point getUpperRight() {
        // TODO
        return null;
    }

    /**
     * Returns the point representing the bottom left corner of the rectangle.
     *
     * @return the bottom left corner
     */
    public Point getBottomLeft() {
        // TODO
        return null;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width
     */
    public double width() {
        // TODO
        return 0;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height
     */
    public double height() {
        // TODO
        return 0;
    }

    /**
     * Returns the center point of the rectangle.
     *
     * @return the center of the rectangle
     */
    @Override
    public Point center() {
        // TODO
        return null;
    }


    /**
     * Returns the name of the shape.
     *
     * @return the string "Rectangle"
     */
    @Override
    public String name() {
        // TODO
        return null;
    }

    /**
     * Calculates and returns the area of the rectangle.
     *
     * @return the area of the rectangle
     */
    @Override
    public double area() {
        // TODO
        return 0;
    }

    /**
     * Calculates and returns the perimeter of the rectangle.
     *
     * @return the perimeter of the rectangle
     */
    @Override
    public double perimeter() {
        // TODO
        return 0;
    }

    
    /**
     * Moves the rectangle by the specified values.
     *
     * @param deltaX movement in the X direction
     * @param deltaY movement in the Y direction
     */
    @Override
    public void move(double deltaX, double deltaY) {
        // TODO
    }

    /**
     * Rotates the rectangle around its center.
     *
     * @param angle the rotation angle in radians
     */
    @Override
    public void rotate(double angle) {
        // TODO
    }

    /**
     * Scales the rectangle by the specified factor.
     *
     * @param factor the scaling factor
     */
    @Override
    public void scale(double factor) {
        // TODO
    }

    /**
     * Returns a string representation of the rectangle, listing its four corners.
     *
     * @return a string describing the rectangle
     */
    @Override
    public String toString() {
        return String.format("%s: [%s, %s, %s, %s]",
                this.getLabel(),
                upperLeft,
                getUpperRight(),
                bottomRight,
                getBottomLeft());
    }

    
}