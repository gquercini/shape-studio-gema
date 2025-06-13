package fr.gema.shapes;

import fr.gema.shapes.exceptions.InvalidShapeException;

/**
 * Represents a line segment defined by two points in 2D space.
 */
public class Segment {

    /** The first endpoint of the segment. */
    private Point P1;
    /** The second endpoint of the segment. */
    private Point P2;

    /**
     * Constructs a segment with the specified endpoints.
     * @param P1 the first endpoint
     * @param P2 the second endpoint
     * 
     * @throws InvalidShapeException when P1 = P2.
     */
    public Segment(Point P1, Point P2) throws InvalidShapeException {

        if (P1 == null || P2 == null)
            throw new InvalidShapeException("Both endpoints of a segment must be non-null");

        if (P1.equals(P2))
            throw new InvalidShapeException("The two endpoints of a segment must be distinct");
        this.P1 = P1;
        this.P2 = P2;
    }

    /**
     * Returns the first endpoint of the segment.
     * @return the first endpoint
     */
    public Point getP1() {
        return this.P1;
    }

    /**
     * Returns the second endpoint of the segment.
     * @return the second endpoint
     */
    public Point getP2() {
        return this.P2;
    }

    /**
     * Sets the value of the first endpoint
     * 
     * @param P1 value of the first endpoint
     * 
     * @throws InvalidShapeException when P1 = P2.
     */
    public void setP1(Point P1) throws InvalidShapeException {

        if (P1 == null) 
            throw new InvalidShapeException("Point P1 must not be null");

        if (P1.equals(this.P2))
            throw new InvalidShapeException("The two endpoints of a segment must be distinct");
        this.P1 = P1;
    }

    /**
     * Sets the value of the second endpoint
     * 
     * @param P2 value of the second endpoint
     * 
     * @throws InvalidShapeException when P1 = P2.
     */
    public void setP2(Point P2) throws InvalidShapeException {

        if (P2 == null) 
            throw new InvalidShapeException("Point P2 must not be null");

        if (P2.equals(this.P1))
            throw new InvalidShapeException("The two endpoints of a segment must be distinct");
        this.P2 = P2;
    }

    
    /**
     * Calculates the length of the segment.
     * @return the length of the segment
     */
    public double length() {
        return Math.sqrt(Math.pow(this.P1.getX() - this.P2.getX(), 2) + Math.pow(this.P1.getY() - this.P2.getY(), 2));
    }
    
}
