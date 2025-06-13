package fr.gema.shapes;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.gema.shapes.exceptions.InvalidShapeException;

public class CircleTest {

    @Test
    public void testConstructorWithLabelCenterRadius() throws InvalidShapeException {
        Point center = new Point(2.0, 3.0);
        Circle c = new Circle("C1", center, 5.0);
        assertEquals("C1", c.getLabel());
        assertEquals(center, c.center());
        assertEquals(5.0, c.getRadius(), 0.0001);
    }

    @Test
    public void testConstructorWithAllProperties() throws Exception {
        Point center = new Point(1.0, 1.0);
        Circle c = new Circle("C2", 2.0f, "#000000", "#FFFFFF", center, 4.0);
        assertEquals("C2", c.getLabel());
        assertEquals(2.0f, c.getBorderWidth(), 0.0001);
        assertEquals("#000000", c.getBorderColor());
        assertEquals("#FFFFFF", c.getFillColor());
        assertEquals(center, c.center());
        assertEquals(4.0, c.getRadius(), 0.0001);
    }

    @Test(expected = InvalidShapeException.class)
    public void testConstructorNullCenter() throws Exception {
        new Circle("C1", null, 5.0);
    }

    @Test(expected = InvalidShapeException.class)
    public void testConstructorZeroRadius() throws Exception {
        new Circle("C1", new Point(3, 4), 0);
    }

    @Test
    public void testScale() throws Exception {
        Circle c = new Circle("C5", new Point(0, 0), 2.0);
        c.scale(3.0);
        
        assertEquals(6.0, c.getRadius(), 0.0001);
        assertEquals(c.center(), new Point(0, 0));
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScaleWithZeroFactor() throws Exception {
        Circle c = new Circle("C6", new Point(0, 0), 2.0);
        c.scale(0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScaleWithNegativeFactor() throws Exception {
        Circle c = new Circle("C6", new Point(0, 0), 2.0);
        c.scale(-2);
    }

    @Test
    public void testRotateDoesNothing() throws Exception {
        Circle c = new Circle("C7", new Point(1, 1), 2.0);
        Point centerBefore = c.center();
        double radiusBefore = c.getRadius();

        c.rotate(Math.PI);
        assertEquals(centerBefore, c.center());
        assertEquals(radiusBefore, c.getRadius(), 0.0001);
    }

    @Test
    public void testArea() throws Exception {
        Circle c = new Circle("C8", new Point(0, 0), 3.0);
        Point centerBefore = c.center();
        double radiusBefore = c.getRadius();

        assertEquals(Math.PI * Math.pow(radiusBefore, 2), c.area(), 0.0001);

        // Make sure the method does not modify the object.
        assertEquals(centerBefore, c.center());
        assertEquals(radiusBefore, c.getRadius(), 0.0001);
    }

    @Test
    public void testPerimeter() throws Exception {
        Circle c = new Circle("C9", new Point(0, 0), 2.0);
        Point centerBefore = c.center();
        double radiusBefore = c.getRadius();

        assertEquals(2 * Math.PI * radiusBefore, c.perimeter(), 0.0001);

        // Make sure the method does not modify the object.
        assertEquals(centerBefore, c.center());
        assertEquals(radiusBefore, c.getRadius(), 0.0001);
    }

    @Test
    public void testName() throws Exception {
        Circle c = new Circle("C10", new Point(0, 0), 1.0);
        Point centerBefore = c.center();
        double radiusBefore = c.getRadius();

        assertEquals("Circle", c.name());

        // Make sure the method does not modify the object.
        assertEquals(centerBefore, c.center());
        assertEquals(radiusBefore, c.getRadius(), 0.0001);
    }

    @Test
    public void testCenterMethod() throws Exception {
        Point center = new Point(7.0, 8.0);
        Circle c = new Circle("C11", center, 2.0);
        double radiusBefore = c.getRadius();
        
        assertEquals(center, c.center());
        assertEquals(radiusBefore, c.getRadius(), 0.0001);
    }

    @Test
    public void testMove() throws Exception {
        Circle c = new Circle("C12", new Point(1.0, 2.0), 3.0);
        double radiusBefore = c.getRadius();
        
        c.move(2.0, 3.0);
        
        assertEquals(new Point(3.0, 5.0), c.center());
        assertEquals(radiusBefore, c.getRadius(), 0.0001);
    }

    @Test
    public void testToString() throws Exception {
        Circle c = new Circle("C13", new Point(1.0, 2.0), 3.0);
        String str = c.toString();
        assertEquals(str, "C13: [center=(1.0, 2.0), radius=3.0]");

        assertEquals(new Point(1.0, 2.0), c.center());
        assertEquals(3.0, c.getRadius(), 0.0001);
        
    }
}