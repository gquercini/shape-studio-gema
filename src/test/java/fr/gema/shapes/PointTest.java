package fr.gema.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PointTest {

    @Test
    public void testDefaultConstructor() {
        Point p = new Point();
        assertEquals(0.0, p.getX(), 0.0001);
        assertEquals(0.0, p.getY(), 0.0001);
    }

    @Test
    public void testParameterizedConstructor() {
        Point p = new Point(3.5, -2.1);
        assertEquals(3.5, p.getX(), 0.0001);
        assertEquals(-2.1, p.getY(), 0.0001);
    }

    @Test
    public void testSetX() {
        Point p = new Point(3.0, 4.0);
        double yBefore = p.getY();
        p.setX(5.0);
        assertEquals(5.0, p.getX(), 0.0001);
        assertEquals(yBefore, p.getY(), 0.0001);
    }

    @Test
    public void testSetY() {
        Point p = new Point(3.0, 4.0);
        double xBefore = p.getX();

        p.setY(-7.2);
        assertEquals(-7.2, p.getY(), 0.0001);
        assertEquals(xBefore, p.getX(), 0.0001);
    }

    @Test
    public void testEquals() {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(1.0, 2.0);
        Point p3 = new Point(2.0, 1.0);

        Point p1Copy = new Point(p1.getX(), p1.getY());
        Point p2Copy = new Point(p2.getX(), p2.getY());
        Point p3Copy = new Point(p3.getX(), p3.getY());

        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));

        // Make sure the method does not modify the input objects.
        assertEquals(p1Copy, p1);
        assertEquals(p2Copy, p2);
        assertEquals(p3Copy, p3);
    }

    @Test
    public void testToString() {
        Point p = new Point(1.5, 2.5);

        Point pCopy = new Point(p.getX(), p.getY());

        String str = p.toString();
        assertTrue(str.equals("(1.5, 2.5)"));

        // Make sure the method does not modify the input objects.
        assertEquals(pCopy, p);
    }

    @Test
    public void testMove() {
        Point p = new Point(1.5, 2.5);
        p.move(3, 1);
        assertEquals(p.getX(), 4.5, 0.0001);
        assertEquals(p.getY(), 3.5, 0.0001);
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(5, 7);

        Point p1Copy = new Point(p1.getX(), p1.getY());
        Point p2Copy = new Point(p2.getX(), p2.getY());

        assertEquals(p1.distance(p1), 0., 0.0001);
        assertEquals(p2.distance(p2), 0., 0.0001);
        assertEquals(p1.distance(p2), 5., 0.0001);

        // Make sure the method does not modify the input objects.
        assertEquals(p1Copy, p1);
        assertEquals(p2Copy, p2);
    }

    @Test
    public void testRotate() {
        Point center = new Point(1, 0);
        
        // Counterclockwise rotation
        Point p = new Point(2, 3);
        p.rotate(center, Math.PI / 4);
        assertEquals(p.getX(), 1-Math.sqrt(2), 0.0001);
        assertEquals(p.getY(), 2*Math.sqrt(2), 0.0001);

        // Clockwise rotation
        Point p1 = new Point(2, 3);
        p1.rotate(center, -Math.PI / 4);
        assertEquals(p1.getX(), 1+ 2*Math.sqrt(2), 0.0001);
        assertEquals(p1.getY(), Math.sqrt(2), 0.0001);
    }
}