package fr.gema.shapes;

/**
 * Interface for geometric shapes, providing methods for area, perimeter, movement, rotation, scaling, and naming.
 */
public interface Shape extends Cloneable{


    /**
     * Calculates the area of the shape.
     *
     * @return the area of the shape
     */
    public double area();

    /**
     * Calculates the perimeter of the shape.
     *
     * @return the perimeter of the shape
     */
    public double perimeter();

    /**
     * Returns the center point of the shape.
     *
     * @return the center as a Point
     */
    public Point center();

    /**
     * Moves the shape by the specified deltas in X and Y directions.
     *
     * @param deltaX the amount to move in the X direction
     * @param deltaY the amount to move in the Y direction
     */
    public void move(double deltaX, double deltaY);

    /**
     * Moves the shape to the origin or a default position.
     */
    public void move();

    /**
     * Rotates the shape by the specified angle (in radians).
     *
     * @param angle the angle in radians
     */
    public void rotate(double angle);

    /**
     * Scales the shape by the specified factor.
     *
     * @param factor the scaling factor
     */
    public void scale(double factor);

    /**
     * Returns the name of the shape.
     *
     * @return the name of the shape
     */
    public String name();

}

