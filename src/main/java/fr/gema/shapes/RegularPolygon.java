package fr.gema.shapes;

import fr.gema.shapes.exceptions.InvalidBorderWidthException;
import fr.gema.shapes.exceptions.InvalidColorException;
import fr.gema.shapes.exceptions.InvalidShapeException;

/**
 * Represents a regular polygon defined by its number of sides, center, and radius.
 * <p>
 * This class provides methods to access and modify the polygon's properties,
 * compute its area and perimeter, scale and rotate the polygon, and retrieve its vertices.
 * </p>
 */
public class RegularPolygon extends GenericShape {

    private int nSides;
    private Point center;
    private double radius;
    private double rotationAngle;

    /**
     * Constructs a regular polygon with the specified label, number of sides, center, and radius.
     *
     * @param label  the label of the polygon
     * @param nSides the number of sides (must be at least 3)
     * @param center the center point of the polygon
     * @param radius the radius (distance from center to a vertex, must be > 0)
     * @throws InvalidShapeException if nSides < 3 or radius <= 0
     */
    public RegularPolygon(String label, int nSides, Point center, double radius) throws InvalidShapeException {
        // TODO
    }

    /**
     * Constructs a regular polygon with all properties specified.
     *
     * @param label       the label of the polygon
     * @param borderWidth the border width
     * @param borderColor the border color in hexadecimal format
     * @param fillColor   the fill color in hexadecimal format
     * @param nSides      the number of sides (must be at least 3)
     * @param center      the center point of the polygon
     * @param radius      the radius (must be > 0)
     * @throws InvalidColorException if the color values are invalid
     * @throws InvalidBorderWidthException if the border width is invalid
     * @throws InvalidShapeException if nSides < 3 or radius <= 0
     */
    public RegularPolygon(String label,
            float borderWidth,
            String borderColor,
            String fillColor,
            int nSides, Point center, double radius)
            throws InvalidColorException, InvalidBorderWidthException, InvalidShapeException {
        // TODO
    }

    /**
     * Returns the number of sides of the polygon.
     *
     * @return the number of sides
     */
    public int getNSides() {
        // TODO
        return 0;
    }

    /**
     * Returns the radius of the polygon (distance from center to a vertex).
     *
     * @return the radius
     */
    public double getRadius() {
        // TODO
        return 0;
    }

    /**
     * Returns the current rotation angle of the polygon in radians.
     *
     * @return the rotation angle
     */
    public double getRotationAngle() {
        // TODO
        return 0;
    }

    /**
     * Returns the vertices of the polygon as an array of {@link Point} objects.
     *
     * @return an array of vertices
     */
    public Point[] getVertices() {
        // TODO
        return null;
    }

    /**
     * Scales the polygon by the specified factor (applies to the radius).
     *
     * @param factor the scaling factor (must be positive)
     * @throws IllegalArgumentException if the factor is not positive
     */
    @Override
    public void scale(double factor) {
        // TODO
    }

    /**
     * Rotates the polygon by the specified angle (in radians).
     *
     * @param angle the angle in radians
     */
    @Override
    public void rotate(double angle) {
        // TODO
    }

    /**
     * Returns the area of the polygon.
     *
     * @return the area
     */
    @Override
    public double area() {
        // TODO
        return 0;
    }

    /**
     * Returns the perimeter of the polygon.
     *
     * @return the perimeter
     */
    @Override
    public double perimeter() {
        // TODO
        return 0;
    }

    /**
     * Returns the name of the shape.
     *
     * @return the string "RegularPolygon"
     */
    @Override
    public String name() {
        // TODO
        return null;
    }

    /**
     * Returns the center point of the polygon.
     *
     * @return the center point
     */
    @Override
    public Point center() {
        // TODO
        return null;
    }

    /**
     * Moves the center of the polygon by the specified deltas.
     *
     * @param deltaX the amount to move in the X direction
     * @param deltaY the amount to move in the Y direction
     */
    @Override
    public void move(double deltaX, double deltaY) {
        // TODO
    }

    /**
     * Returns a string representation of the polygon, listing its vertices.
     *
     * @return a string describing the polygon
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getLabel()).append(": [");
        Point[] vertices = getVertices();
        sb.append(vertices[0]);
        for (int i = 1; i < vertices.length; i += 1) {
            sb.append(", ").append(vertices[i].toString());
        }
        sb.append("]");

        return sb.toString();
    }
}