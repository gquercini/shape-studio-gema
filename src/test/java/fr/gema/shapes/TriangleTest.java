package fr.gema.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import fr.gema.shapes.exceptions.InvalidShapeException;

public class TriangleTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 3);
        Triangle t = new Triangle("T1", a, b, c);
        assertNotNull(t);
        assertEquals("Triangle", t.name());
        String str = t.toString();
        assertTrue(str.contains(a.toString()));
        assertTrue(str.contains(b.toString()));
        assertTrue(str.contains(c.toString()));
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidTriangleThrowsException() throws Exception {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        Point c = new Point(2, 2);
        new Triangle("T2", a, b, c);
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidTriangleANullException() throws Exception {
        Point a = null;
        Point b = new Point(1, 1);
        Point c = new Point(2, 2);
        new Triangle("T2", a, b, c);
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidTriangleBNullException() throws Exception {
        Point a = new Point(1, 1);
        Point b = null;
        Point c = new Point(2, 2);
        new Triangle("T2", a, b, c);
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidTriangleCNullException() throws Exception {
        Point a = new Point(1, 1);
        Point b = null;
        Point c = null;
        new Triangle("T2", a, b, c);
    }

    @Test
    public void testArea() throws Exception {
        Point A = new Point(0, 0);
        Point B = new Point(4, 0);
        Point C = new Point(0, 3);

        Triangle t = new Triangle("T3", A, B, C);
        assertEquals(6.0, t.area(), 0.0001);

        // Make sure this method does not modify the object.
        Point[] vertices = t.getVertices();
        assertEquals(A, vertices[0]);
        assertEquals(B, vertices[1]);
        assertEquals(C, vertices[2]);
    }

    @Test
    public void testPerimeter() throws Exception {
        Point A = new Point(0, 0);
        Point B = new Point(4, 0);
        Point C = new Point(0, 3);
        Triangle t = new Triangle("T4", A, B, C);
        
        double expected = 4.0 + 3.0 + 5.0; // sides: 4, 3, 5
        assertEquals(expected, t.perimeter(), 0.0001);

        // Make sure this method does not modify the object.
        Point[] vertices = t.getVertices();
        assertEquals(A, vertices[0]);
        assertEquals(B, vertices[1]);
        assertEquals(C, vertices[2]);
    }

    @Test
    public void testCenter() throws Exception {
        Point A = new Point(0, 0);
        Point B = new Point(6, 0);
        Point C = new Point(0, 6);
        Triangle t = new Triangle("T5", A, B, C);
        
        Point center = t.center();
        assertEquals(2.0, center.getX(), 0.0001);
        assertEquals(2.0, center.getY(), 0.0001);

        // Make sure this method does not modify the object.
        Point[] vertices = t.getVertices();
        assertEquals(A, vertices[0]);
        assertEquals(B, vertices[1]);
        assertEquals(C, vertices[2]);
    }

    @Test
    public void testMove() throws Exception {
        Point A = new Point(0, 0);
        Point B = new Point(4, 0);
        Point C = new Point(0, 3);
        Triangle t = new Triangle("T6", A, B, C);
        
        t.move(1, 2);
        Point[] vertices = t.getVertices();
        assertEquals(1, vertices[0].getX(), 0.0001);
        assertEquals(2, vertices[0].getY(), 0.0001);

        assertEquals(5, vertices[1].getX(), 0.0001);
        assertEquals(2, vertices[1].getY(), 0.0001);

        assertEquals(1, vertices[2].getX(), 0.0001);
        assertEquals(5, vertices[2].getY(), 0.0001);
    }

    @Test
    public void testRotate() throws Exception {
        Point A = new Point(0, 0);
        Point B = new Point(3, 0);
        Point C = new Point(0, 3);
        Triangle t = new Triangle("T7", A, B, C);
        
        t.rotate(Math.PI); // Rotate 180 degrees
        Point[] vertices = t.getVertices();
        
        assertEquals(2, vertices[0].getX(), 0.0001);
        assertEquals(2, vertices[0].getY(), 0.0001);

        assertEquals(-1, vertices[1].getX(), 0.0001);
        assertEquals(2, vertices[1].getY(), 0.0001);

        assertEquals(2, vertices[2].getX(), 0.0001);
        assertEquals(-1, vertices[2].getY(), 0.0001); 
    }

    @Test
    public void testScale() throws Exception {
        Triangle t = new Triangle("T8", new Point(0, 0), new Point(4, 0), new Point(0, 3));
        Point before = t.center();
        t.scale(2.0);
        Point after = t.center();
        assertEquals(after.getX(), before.getX(), 0.0001);
        assertEquals(after.getY(), before.getY(), 0.0001);
        // Area should be 4 times larger after scaling by 2
        assertEquals(24.0, t.area(), 0.0001);
    }

    @Test
    (expected = IllegalArgumentException.class)
    public void testNegativeScale() throws Exception {
        Triangle t = new Triangle("T8", new Point(0, 0), new Point(4, 0), new Point(0, 3));
        t.scale(-3);
        
    }

    @Test
    (expected = IllegalArgumentException.class)
    public void testZeroScale() throws Exception {
        Triangle t = new Triangle("T8", new Point(0, 0), new Point(4, 0), new Point(0, 3));
        t.scale(0);
        
    }

    @Test
    public void testName() throws Exception {
        Triangle t = new Triangle("T8", new Point(0, 0), new Point(4, 0), new Point(0, 3));
        assertEquals(t.name(), "Triangle");
    }

    @Test
    public void testToString() throws Exception {
        Point A = new Point(1, 2);
        Point B = new Point(2, 1);
        Point C = new Point(1, 4);
        
        Triangle t = new Triangle("T9", A, B, C);
        assertEquals(t.toString(), "T9: [(1.0, 2.0), (2.0, 1.0), (1.0, 4.0)]");

        // Make sure this method does not modify the object.
        Point[] vertices = t.getVertices();
        assertEquals(A, vertices[0]);
        assertEquals(B, vertices[1]);
        assertEquals(C, vertices[2]);
    }
}