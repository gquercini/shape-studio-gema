package fr.gema.shapes;

/**
 * Represents a point in 2D Cartesian coordinates.
 */
public class Point {

    /** The X coordinate of the point. */
    private double X;
    
    /** The Y coordinate of the point. */
    private double Y;

    /**
     * Constructs a point at the origin (0, 0).
     */
    public Point() {
        // TODO
    }

    /**
     * Constructs a point with the specified coordinates.
     * @param X the X coordinate
     * @param Y the Y coordinate
     */
    public Point(double X, double Y) {
        // TODO
    }

    /**
     * Returns the X coordinate of the point.
     * @return the X coordinate
     */
    public double getX() {
        // TODO
        return 0;
    }

    /**
     * Sets the X coordinate of the point.
     * @param X the new X coordinate
     */
    public void setX(double X) {
        // TODO
    }

    /**
     * Returns the Y coordinate of the point.
     * @return the Y coordinate
     */
    public double getY() {
        // TODO
        return 0;
    }

    /**
     * Sets the Y coordinate of the point.
     * @param Y the new Y coordinate
     */
    public void setY(double Y) {
        // TODO
    }

    /**
     * Calculates the Euclidean distance between this point and another point.
     * @param other the other point
     * @return the distance between the two points
     */
    public double distance(Point other) {
        // TODO
        return 0;
    }

    /**
     * Returns a string representation of the point in the form (X, Y).
     * 
     * @return a string representation of the point in the form "(X, Y)".
     * For both X and Y, make sure to use only one decimal place (e.g., (1.0, 4.5).
     */
    @Override
    public String toString() {
        // TODO
        return null;
    }

    /**
     * Moves the point by the specified deltas.
     * @param deltaX the amount to move in the X direction
     * @param deltaY the amount to move in the Y direction
     */
    public void move(double deltaX, double deltaY) {
        // TODO
    }

    /**
     * Rotates the point around a given center by a specified angle (in radians).
     * @param center the center of rotation
     * @param angle the angle in radians
     */
    public void rotate(Point center, double angle) {
        // TODO
    }

    /**
     * Checks if this point is equal to another point (same coordinates).
     * @param other the other point
     * @return true if the points have the same coordinates, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return Math.abs(this.X - other.X) < 0.0001 && Math.abs(this.Y - other.Y) < 0.0001;
    }   

    @Override
    public int hashCode() {
        long xBits = Double.doubleToLongBits(Math.round(X * 10000.0) / 10000.0);
        long yBits = Double.doubleToLongBits(Math.round(Y * 10000.0) / 10000.0);
        return (int)(xBits ^ (xBits >>> 32)) * 31 + (int)(yBits ^ (yBits >>> 32));
    }
}