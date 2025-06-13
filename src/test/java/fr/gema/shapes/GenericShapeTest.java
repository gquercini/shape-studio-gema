package fr.gema.shapes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.gema.shapes.exceptions.InvalidBorderWidthException;
import fr.gema.shapes.exceptions.InvalidColorException;

public class GenericShapeTest {

    // Minimal concrete subclass for testing
    private static class TestShape extends GenericShape {
        private Point center = new Point(0, 0);
        public TestShape(String label) { super(label); }
        public TestShape(String label, float bw, String bc, String fc) throws InvalidColorException, InvalidBorderWidthException {
            super(label, bw, bc, fc);
        }
        @Override public String name() { return "TestShape"; }
        @Override public Point center() { return center; }
        @Override public void move(double dx, double dy) {
            center = new Point(center.getX() + dx, center.getY() + dy);
        }
        @Override public double area() { return 0; }
        @Override public double perimeter() { return 0; }
        @Override public void scale(double f) { }
        @Override public void rotate(double a) { }
    }

    @Test
    public void testLabel() {
        GenericShape s = new TestShape("label");
        assertEquals("label", s.getLabel());
        s.setLabel("new");
        assertEquals("new", s.getLabel());
    }

    @Test
    public void testBorderWidth() throws Exception {
        GenericShape s = new TestShape("label");
        s.setBorderWidth(2.5f);
        assertEquals(2.5f, s.getBorderWidth(), 0.0001);
    }

    @Test(expected = InvalidBorderWidthException.class)
    public void testInvalidBorderWidth() throws Exception {
        new TestShape("label", -1f, "#000000", "#FFFFFF");
    }

    @Test
    public void testBorderColor() throws Exception {
        GenericShape s = new TestShape("label");
        s.setBorderColor("#ABCDEF");
        assertEquals("#ABCDEF", s.getBorderColor());
    }

    @Test(expected = InvalidColorException.class)
    public void testInvalidBorderColor() throws Exception {
        new TestShape("label", 1f, "red", "#FFFFFF");
    }

    @Test
    public void testFillColor() throws Exception {
        GenericShape s = new TestShape("label");
        s.setFillColor("#123456");
        assertEquals("#123456", s.getFillColor());
    }

    @Test(expected = InvalidColorException.class)
    public void testInvalidFillColor() throws Exception {
        new TestShape("label", 1f, "#000000", "blue");
    }
  
}