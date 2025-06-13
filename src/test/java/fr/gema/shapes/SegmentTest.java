package fr.gema.shapes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.gema.shapes.exceptions.InvalidShapeException;

public class SegmentTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Segment segment = new Segment(p1, p2);
        assertEquals(p1, segment.getP1());
        assertEquals(p2, segment.getP2());
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidShapeConstructor() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(1.0, 2.0);
        new Segment(p1, p2);
    }

    @Test(expected = InvalidShapeException.class)
    public void testNullP1Constructor() throws InvalidShapeException {
        new Segment(null, new Point(3., 4.));
    }

    @Test(expected = InvalidShapeException.class)
    public void testNullP2Constructor() throws InvalidShapeException {
        new Segment(new Point(3., 4.), null);
    }


    @Test
    public void testSetP1() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Segment segment = new Segment(p1, p2);

        segment.setP1(new Point(0., 0.));

        assertEquals(new Point(0.0, 0.0), segment.getP1());
        assertEquals(p2, segment.getP2());
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidSetP1() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Segment segment = new Segment(p1, p2);
        segment.setP1(new Point(3., 4.));
    }

    @Test(expected = InvalidShapeException.class)
    public void testSetNullP1() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Segment segment = new Segment(p1, p2);
        segment.setP1(null);
    }

    @Test
    public void testSetP2() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Segment segment = new Segment(p1, p2);

        segment.setP2(new Point(0, 0));

        assertEquals(new Point(0, 0), segment.getP2());
        assertEquals(p1, segment.getP1());
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidSetP2() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Segment segment = new Segment(p1, p2);
        segment.setP2(new Point(1., 2.));
    }

    @Test(expected = InvalidShapeException.class)
    public void testSetNullP2() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);
        Segment segment = new Segment(p1, p2);
        segment.setP2(null);
    }

    @Test
    public void testLengthHorizontal() throws InvalidShapeException {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(5.0, 0.0);
        Segment segment = new Segment(p1, p2);
        assertEquals(5.0, segment.length(), 0.0001);

        // Make sure the segment is not modified by the method.
        assertEquals(p1, segment.getP1());
        assertEquals(p2, segment.getP2());
    }

    @Test
    public void testLengthVertical() throws InvalidShapeException {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(0.0, 7.0);
        Segment segment = new Segment(p1, p2);
        assertEquals(7.0, segment.length(), 0.0001);

        // Make sure the segment is not modified by the method.
        assertEquals(p1, segment.getP1());
        assertEquals(p2, segment.getP2());
    }

    @Test
    public void testLengthDiagonal() throws InvalidShapeException {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(4.0, 6.0);
        Segment segment = new Segment(p1, p2);
        assertEquals(5.0, segment.length(), 0.0001);

        // Make sure the segment is not modified by the method.
        assertEquals(p1, segment.getP1());
        assertEquals(p2, segment.getP2());
    }
}