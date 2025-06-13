package fr.gema.shapes;

import fr.gema.shapes.exceptions.InvalidBorderWidthException;
import fr.gema.shapes.exceptions.InvalidColorException;
import fr.gema.shapes.exceptions.InvalidShapeException;

/**
 * Represents a triangle defined by three points in 2D space.
 * Provides geometric operations and property access.
 */
public class Triangle extends GenericShape {

    /** The first vertex of the triangle. */
    private Point A;
    /** The second vertex of the triangle. */
    private Point B;
    /** The third vertex of the triangle. */
    private Point C;

    /**
     * Constructs a triangle with the specified label and vertices.
     *
     * @param label the label for the triangle
     * @param A     the first vertex
     * @param B     the second vertex
     * @param C     the third vertex
     * @throws InvalidShapeException if the vertices do not form a valid triangle
     */
    public Triangle(String label, Point A, Point B, Point C) throws InvalidShapeException {
        // TODO
    }

    /**
     * Returns the vertices of this triangle.
     *
     * @return The vertices of this triangle.
     */
    public Point[] getVertices() {
        // TODO
        return null;
    }

    /**
     * Constructs a triangle with the specified label, border properties, and
     * vertices.
     *
     * @param label       the label for the triangle
     * @param borderWidth the border width
     * @param borderColor the border color
     * @param fillColor   the fill color
     * @param A           the first vertex
     * @param B           the second vertex
     * @param C           the third vertex
     * @throws InvalidColorException      if a color is invalid
     * @throws InvalidBorderWidtException if the border width is invalid
     * @throws InvalidShapeException      if the vertices do not form a valid
     *                                    triangle
     */
    public Triangle(String label,
            float borderWidth,
            String borderColor,
            String fillColor,
            Point A, Point B, Point C)
            throws InvalidColorException, InvalidBorderWidthException, InvalidShapeException {
        // TODO
    }

    /**
     * Calculates the area of the triangle using Heron's formula.
     * 
     * @return the area of the triangle
     */
    @Override
    public double area() {
        // TODO
        return 0;
    }

    /**
     * Calculates the perimeter of the triangle.
     * 
     * @return the perimeter of the triangle
     */
    @Override
    public double perimeter() {
        // TODO
        return 0;
    }

    /**
     * Returns the centroid (center) of the triangle.
     * 
     * @return the centroid as a Point
     */
    @Override
    public Point center() {
        // TODO
        return null;
    }

    /**
     * Moves the triangle by the specified deltas.
     * 
     * @param deltaX the amount to move in the X direction
     * @param deltaY the amount to move in the Y direction
     */
    @Override
    public void move(double deltaX, double deltaY) {
        // TODO
    }

    /**
     * Rotates the triangle around its centroid by the specified angle (in radians).
     * 
     * @param angle the angle in radians
     */
    @Override
    public void rotate(double angle) {
        // TODO
    }

    /**
     * Scales the triangle with respect to its centroid by the specified factor.
     * 
     * @param factor the scaling factor
     * @throws IllegalArgumentException if the scale factor is 0 or negative. 
     */
    @Override
    public void scale(double factor) {
        // TODO
    }

    /**
     * Returns the name of the shape.
     * 
     * @return the string "Triangle"
     */
    @Override
    public String name() {
        // TODO
        return null;
    }

    /**
     * Returns a string representation of the triangle as a list of its three
     * vertices.
     * 
     * @return a string representation of the triangle
     */
    @Override
    public String toString() {
        return String.format(
                "%s: [%s, %s, %s]",
                this.getLabel(),
                A,
                B,
                C);
    }

}