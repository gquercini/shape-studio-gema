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

    public Rectangle(String label,
            Point upperLeft,
            Point bottomRight) throws InvalidColorException, InvalidBorderWidthException, InvalidShapeException {
        // TODO
    }

    public Rectangle(String label,
            float borderWidth,
            String borderColor,
            String fillColor,
            Point upperLeft,
            Point bottomRight) throws InvalidColorException, InvalidBorderWidthException, InvalidShapeException {
        // TODO
    }

    public Point getUpperLeft() {
        // TODO
        return null;
    }

    public Point getBottomRight() {
        // TODO
        return null;
    }

    @Override
    public double area() {
        // TODO
        return 0;
    }

    @Override
    public double perimeter() {
        // TODO
        return 0;
    }

    @Override
    public Point center() {
        // TODO
        return null;
    }

    @Override
    public void move(double deltaX, double deltaY) {
        // TODO
    }

    @Override
    public void rotate(double angle) {
        // TODO
    }

    @Override
    public void scale(double factor) {
        // TODO
    }

    @Override
    public String name() {
        // TODO
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s: [%s, %s, %s, %s]",
                this.getLabel(),
                upperLeft,
                getUpperRight(),
                bottomRight,
                getBottomLeft());
    }

    public Point getUpperRight() {
        // TODO
        return null;
    }

    public Point getBottomLeft() {
        // TODO
        return null;
    }

    public double width() {
        // TODO
        return 0;
    }

    public double height() {
        // TODO
        return 0;
    }
}