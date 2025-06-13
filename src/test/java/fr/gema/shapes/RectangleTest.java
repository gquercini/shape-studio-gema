package fr.gema.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import fr.gema.shapes.exceptions.InvalidShapeException;

public class RectangleTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Point ul = new Point(1, 5);
        Point br = new Point(6, 1);
        Rectangle r = new Rectangle("R1", ul, br);
        assertEquals(ul, r.getUpperLeft());
        assertEquals(br, r.getBottomRight());
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidRectangleThrowsException() throws Exception {
        Point ul = new Point(6, 1);
        Point br = new Point(1, 5);
        new Rectangle("R2", ul, br);
    }

    @Test(expected = InvalidShapeException.class)
    public void testUpperLeftThrowsException() throws Exception {
        Point ul = null;
        Point br = new Point(1, 5);
        new Rectangle("R2", ul, br);
    }

    @Test(expected = InvalidShapeException.class)
    public void testBottomRightThrowsException() throws Exception {
        Point ul = new Point(6, 1);
        Point br = null;
        new Rectangle("R2", ul, br);
    }

    @Test
    public void testArea() throws Exception {
        Rectangle r = new Rectangle("R3", new Point(1, 5), new Point(6, 1));
        assertEquals(20.0, r.area(), 0.0001);

        // Make sure the method does not modify the rectangle.
        assertEquals(r.getUpperLeft(), new Point(1, 5));
        assertEquals(r.getBottomRight(), new Point(6, 1));
    }

    @Test
    public void testPerimeter() throws Exception {
        Rectangle r = new Rectangle("R4", new Point(1, 5), new Point(6, 1));
        assertEquals(18.0, r.perimeter(), 0.0001);

        // Make sure the method does not modify the rectangle.
        assertEquals(r.getUpperLeft(), new Point(1, 5));
        assertEquals(r.getBottomRight(), new Point(6, 1));
    }

    @Test
    public void testCenter() throws Exception {
        Rectangle r = new Rectangle("R5", new Point(1, 5), new Point(5, 1));
        Point center = r.center();
        assertEquals(3.0, center.getX(), 0.0001);
        assertEquals(3.0, center.getY(), 0.0001);

        // Make sure the method does not modify the rectangle.
        assertEquals(r.getUpperLeft(), new Point(1, 5));
        assertEquals(r.getBottomRight(), new Point(5, 1));
    }

    @Test
    public void testMove() throws Exception {
        Rectangle r = new Rectangle("R6", new Point(1, 5), new Point(6, 1));
        r.move(2, -1);
        assertEquals(3.0, r.getUpperLeft().getX(), 0.0001);
        assertEquals(4.0, r.getUpperLeft().getY(), 0.0001);
        assertEquals(8.0, r.getBottomRight().getX(), 0.0001);
        assertEquals(0.0, r.getBottomRight().getY(), 0.0001);
    }

    @Test
    public void testMoveWithoutArguments() throws Exception {
        Rectangle r = new Rectangle("R12", new Point(1, 5), new Point(6, 1));
        r.move();
        assertEquals(-2.5, r.getUpperLeft().getX(), 0.0001);
        assertEquals(2, r.getUpperLeft().getY(), 0.0001);
        assertEquals(2.5, r.getBottomRight().getX(), 0.0001);
        assertEquals(-2, r.getBottomRight().getY(), 0.0001);
    }

    @Test
    public void testRotate() throws Exception {
        Rectangle r = new Rectangle("R7", new Point(1, 2), new Point(5, 0));
        r.rotate(Math.PI / 2); // rotation by 90 degrees counterclockwise
        assertEquals(r.getUpperLeft().getX(), 2, 0.0001);
        assertEquals(r.getUpperLeft().getY(), 3, 0.0001);

        assertEquals(r.getBottomRight().getX(), 4, 0.0001);
        assertEquals(r.getBottomRight().getY(), -1, 0.0001);
    }

    @Test
    public void testScale() throws Exception {
        Rectangle r = new Rectangle("R7", new Point(1, 8), new Point(7, 2));
        double areaBefore = r.area();
        double widthBefore = r.width();
        double heightBefore = r.height();

        double scaleFactor = 2.;

        r.scale(scaleFactor);
        
        assertEquals(areaBefore*Math.pow(scaleFactor, 2), r.area(), 0.0001);
        assertEquals(widthBefore*scaleFactor, r.width(), 0.0001);
        assertEquals(heightBefore*scaleFactor, r.height(), 0.0001);

    }

    @Test
    (expected = IllegalArgumentException.class)
    public void testNegativeScale() throws Exception {
        Rectangle r = new Rectangle("R7", new Point(1, 8), new Point(7, 2));
        r.scale(-3);
        
    }

    @Test
    (expected = IllegalArgumentException.class)
    public void testZeroScale() throws Exception {
        Rectangle r = new Rectangle("R7", new Point(1, 8), new Point(7, 2));
        r.scale(0);
        
    }

    @Test
    public void testName() throws Exception {
        Rectangle r = new Rectangle("R8", new Point(1, 5), new Point(6, 1));
        assertEquals("Rectangle", r.name());

        // Make sure the method does not modify the rectangle.
        assertEquals(r.getUpperLeft(), new Point(1, 5));
        assertEquals(r.getBottomRight(), new Point(6, 1));
    }

    @Test
    public void testToString() throws Exception {
        Rectangle r = new Rectangle("R9", new Point(1, 5), new Point(6, 1));
        String str = r.toString();
        
        String expectedString = "R9: [(1.0, 5.0), (6.0, 5.0), (6.0, 1.0), (1.0, 1.0)]";
        
        assertTrue(str.equals(expectedString));

        // Make sure the method does not modify the rectangle.
        assertEquals(r.getUpperLeft(), new Point(1, 5));
        assertEquals(r.getBottomRight(), new Point(6, 1));
    }


    @Test
    public void testWidthAndHeight() throws Exception {
        Rectangle r = new Rectangle("R11", new Point(1, 5), new Point(6, 1));
        assertEquals(5.0, r.width(), 0.0001);
        assertEquals(4.0, r.height(), 0.0001);

        // Make sure the method does not modify the rectangle.
        assertEquals(r.getUpperLeft(), new Point(1, 5));
        assertEquals(r.getBottomRight(), new Point(6, 1));
    }
}