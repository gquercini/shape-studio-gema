package fr.gema.shapes;

import fr.gema.shapes.exceptions.InvalidBorderWidthException;
import fr.gema.shapes.exceptions.InvalidColorException;
import fr.gema.shapes.exceptions.InvalidShapeException;

/**
 * Represents a circle shape defined by a center point and a radius.
 * <p>
 * This class provides methods to access and modify the circle's properties,
 * as well as to compute its area, perimeter, and perform geometric transformations
 * such as scaling, moving, and rotating.
 * </p>
 */
public class Circle extends GenericShape {

    
    /**
     * The center of this circle.
     */
    private Point center;

    /**
     * The radius of this circle.
     */
    private double radius;

    /**
     * Constructs a circle with the specified label, center, and radius.
     *
     * @param label  the label of the circle
     * @param center the center of the circle
     * @param radius the radius of the circle
     * 
     * @throws InvalidShapeException is center is null or radius <= 0.
     */
    public Circle(String label, Point center, double radius) throws InvalidShapeException {
        // TODO
    }

    /**
     * Constructs a circle with all properties specified.
     *
     * @param label       the label of the circle
     * @param borderWidth the border width
     * @param borderColor the border color in hexadecimal format
     * @param fillColor   the fill color in hexadecimal format
     * @param center      the center point of the circle
     * @param radius      the radius of the circle
     * @throws InvalidColorException if the color values are invalid
     * @throws InvalidBorderWidthException if the border width is invalid
     * @throws InvalidShapeException if the shape parameters are invalid
     */
    public Circle(String label,
            float borderWidth,
            String borderColor,
            String fillColor,
            Point center,
            double radius) throws InvalidColorException, InvalidBorderWidthException, InvalidShapeException {
        // TODO
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius
     */
    public double getRadius() {
        // TODO
        return 0;
    }

    /**
     * Returns the center point of the circle.
     *
     * @return the center point
     */
    @Override
    public Point center() {
        // TODO
        return null;
    }

    /**
     * Returns the name of the shape.
     *
     * @return the string "Circle"
     */
    @Override
    public String name() {
        // TODO
        return null;
    }

    /**
     * Returns the area of the circle.
     *
     * @return the area
     */
    @Override
    public double area() {
        // TODO
        return 0;
    }

    /**
     * Returns the perimeter (circumference) of the circle.
     *
     * @return the perimeter
     */
    @Override
    public double perimeter() {
        // TODO
        return 0;
    }

    /**
     * Moves the center of the circle by the specified deltas.
     *
     * @param deltaX the amount to move in the X direction
     * @param deltaY the amount to move in the Y direction
     */
    @Override
    public void move(double deltaX, double deltaY) {
        // TODO
    }

    /**
     * Rotates the circle around its center.
     * <p>
     * Rotating a circle around its center has no visible effect, so this method does nothing.
     * </p>
     *
     * @param angle the angle in radians
     */
    @Override
    public void rotate(double angle) {
        // TODO
    }


    /**
     * Scales the circle's radius by the specified factor.
     *
     * @param factor the scaling factor (must be positive)
     * @throws IllegalArgumentException if the factor is not positive
     */
    @Override
    public void scale(double factor) {
        // TODO
    }
    
    /**
     * Returns a string representation of the circle.
     *
     * @return a string describing the circle
     */
    @Override
    public String toString() {
        return String.format("%s: [center=%s, radius=%s]", 
            this.getLabel(),
            this.center,
            this.radius
        );
    }
    
}