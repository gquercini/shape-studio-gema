package fr.gema.shapes;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.gema.shapes.exceptions.InvalidShapeException;

public class RegularPolygonTest {

    @Test
    public void testConstructorWithLabelNSidesCenterRadius() throws Exception {
        RegularPolygon poly = new RegularPolygon("P1", 5, new Point(0, 0), 10.0);
        assertEquals("P1", poly.getLabel());
        assertEquals(5, poly.getNSides());
        assertEquals(new Point(0, 0), poly.center());
        assertEquals(10.0, poly.getRadius(), 0.0001);
        assertEquals(0.0, poly.getRotationAngle(), 0.0001);
    }

    @Test
    public void testConstructorWithAllProperties() throws Exception {
        RegularPolygon poly = new RegularPolygon("P2", 6, new Point(1, 2), 5.0f);
        poly = new RegularPolygon("P2", 2.0f, "#000000", "#FFFFFF", 6, new Point(1, 2), 5.0);
        assertEquals("P2", poly.getLabel());
        assertEquals(6, poly.getNSides());
        assertEquals(new Point(1, 2), poly.center());
        assertEquals(5.0, poly.getRadius(), 0.0001);
        assertEquals(2.0f, poly.getBorderWidth(), 0.0001);
        assertEquals("#000000", poly.getBorderColor());
        assertEquals("#FFFFFF", poly.getFillColor());
        assertEquals(0.0, poly.getRotationAngle(), 0.0001);
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidConstructorThrowsException() throws Exception {
        new RegularPolygon("P3", 2, new Point(0, 0), 10.0);
    }

    @Test(expected = InvalidShapeException.class)
    public void testInvalidConstructorNegativeRadius() throws Exception {
        new RegularPolygon("P4", 5, new Point(0, 0), -1.0);
    }

    @Test
    public void testGetVertices() throws Exception {
        RegularPolygon poly = new RegularPolygon("P5", 6, new Point(0, 0), 1.0);
        
        double radiusBefore = poly.getRadius();
        int nSidesBefore = poly.getNSides();
        Point centerBefore = poly.center();
        double rotationAngleBefore = poly.getRotationAngle();


        Point[] vertices = poly.getVertices();
        assertEquals(6, vertices.length);
        assertEquals(new Point(1, 0), vertices[0]);
        
        assertEquals(new Point(1./2., Math.sqrt(3)/2), vertices[1]);
        
        assertEquals(new Point(-1./2., Math.sqrt(3)/2), vertices[2]);
        assertEquals(new Point(-1, 0.), vertices[3]);
        assertEquals(new Point(-1./2., -Math.sqrt(3)/2), vertices[4]);
        assertEquals(new Point(1./2., -Math.sqrt(3)/2), vertices[5]);

        // Make sure the method does not change the object
        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(centerBefore, poly.center());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore, poly.getRotationAngle(), 0.0001);
    }

    @Test
    public void testScale() throws Exception {
        RegularPolygon poly = new RegularPolygon("P6", 6, new Point(0, 0), 1.0);

        double scaleFactor = 3;

        double areaBefore = poly.area();
        Point centerBefore = poly.center();
        double radiusBefore = poly.getRadius();
        int nSidesBefore = poly.getNSides();
        double rotationAngleBefore = poly.getRotationAngle();

        poly.scale(scaleFactor);
        double areaAfter = poly.area();
        Point centerAfter = poly.center();
        double radiusAfter = poly.getRadius();
        int nSidesAfter = poly.getNSides();
        double rotationAngleAfter = poly.getRotationAngle();

        assertEquals(Math.pow(scaleFactor, 2)* areaBefore, areaAfter,0.0001);
        assertEquals(centerBefore, centerAfter);
        assertEquals(scaleFactor*radiusBefore, radiusAfter, 0.0001);
        assertEquals(nSidesBefore, nSidesAfter, 0.0001);
        assertEquals(rotationAngleBefore, rotationAngleAfter, 0.0001);

        Point[] vertices = poly.getVertices();
        assertEquals(6, vertices.length);
        assertEquals( new Point(scaleFactor * 1., 0), vertices[0]);
        assertEquals(new Point(scaleFactor * 1./2., scaleFactor * Math.sqrt(3)/2), vertices[1]);
        assertEquals(new Point(scaleFactor * (-1./2.), scaleFactor * Math.sqrt(3)/2), vertices[2]);
        assertEquals(new Point(scaleFactor * (-1), 0.), vertices[3]);
        assertEquals(new Point(scaleFactor * (-1./2.), -scaleFactor * Math.sqrt(3)/2), vertices[4]);
        assertEquals(new Point(scaleFactor * (1./2.), -scaleFactor * Math.sqrt(3)/2), vertices[5]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScaleWithNonPositiveFactor() throws Exception {
        RegularPolygon poly = new RegularPolygon("P7", 3, new Point(0, 0), 2.0);
        poly.scale(0.0);
    }


    @Test
    public void testRotate() throws Exception {
        RegularPolygon poly = new RegularPolygon("P7", 3, new Point(0, 0), 1.0);

        int nSidesBefore = poly.getNSides();
        Point centerBefore = poly.center();
        double radiusBefore = poly.getRadius();
        double rotationAngleBefore = poly.getRotationAngle();

        //rotate 90 degrees counterclockwise
        double rotationAngleToApply = Math.PI / 2;
        poly.rotate(rotationAngleToApply); 

        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(centerBefore, poly.center());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore + rotationAngleToApply, poly.getRotationAngle(), 0.0001);

        Point[] vertices = poly.getVertices();
        assertEquals(new Point(0, 1), vertices[0]);
        assertEquals(new Point(-Math.sqrt(3)/2, -1./2.), vertices[1]);
        assertEquals(new Point(Math.sqrt(3)/2, -1./2.), vertices[2]);

        // Apply a second rotation
        rotationAngleBefore = poly.getRotationAngle();
        poly.rotate(rotationAngleToApply); 
        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(centerBefore, poly.center());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore + rotationAngleToApply, poly.getRotationAngle(), 0.0001);

        vertices = poly.getVertices();
        assertEquals(new Point(-1, 0), vertices[0]);
        assertEquals(new Point(1./2., -Math.sqrt(3)/2), vertices[1]);
        assertEquals(new Point(1./2., Math.sqrt(3)/2), vertices[2]);

    }

    
    @Test
    public void testArea() throws Exception {
        RegularPolygon poly = new RegularPolygon("P8", 6, new Point(0, 0), 2.0);
        double expected = (6 * 2.0 * 2.0 * Math.sin(2 * Math.PI / 6)) / 2;

        int nSidesBefore = poly.getNSides();
        Point centerBefore = poly.center();
        double radiusBefore = poly.getRadius();
        double rotationAngleBefore = poly.getRotationAngle();

        assertEquals(expected, poly.area(), 0.0001);

        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(centerBefore, poly.center());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore, poly.getRotationAngle(), 0.0001);
    }

    @Test
    public void testPerimeter() throws Exception {
        RegularPolygon poly = new RegularPolygon("P9", 8, new Point(0, 0), 3.0);

        int nSidesBefore = poly.getNSides();
        Point centerBefore = poly.center();
        double radiusBefore = poly.getRadius();
        double rotationAngleBefore = poly.getRotationAngle();


        double sideLength = 2 * 3.0 * Math.sin(Math.PI / 8);
        double expected = 8 * sideLength;
        assertEquals(expected, poly.perimeter(), 0.0001);

        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(centerBefore, poly.center());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore, poly.getRotationAngle(), 0.0001);
    }

    @Test
    public void testName() throws Exception {
        RegularPolygon poly = new RegularPolygon("P10", 5, new Point(0, 0), 1.0);

        int nSidesBefore = poly.getNSides();
        Point centerBefore = poly.center();
        double radiusBefore = poly.getRadius();
        double rotationAngleBefore = poly.getRotationAngle();


        assertEquals("RegularPolygon", poly.name());

        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(centerBefore, poly.center());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore, poly.getRotationAngle(), 0.0001);
    }

    @Test
    public void testCenter() throws Exception {
        Point center = new Point(2.0, 3.0);
        RegularPolygon poly = new RegularPolygon("P11", 5, center, 1.0);

        int nSidesBefore = poly.getNSides();
        Point centerBefore = poly.center();
        double radiusBefore = poly.getRadius();
        double rotationAngleBefore = poly.getRotationAngle();

        assertEquals(center, poly.center());

        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(centerBefore, poly.center());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore, poly.getRotationAngle(), 0.0001);
    }

    @Test
    public void testMove() throws Exception {
        RegularPolygon poly = new RegularPolygon("P12", 5, new Point(1.0, 2.0), 1.0);
        
        double radiusBefore = poly.getRadius();
        int nSidesBefore = poly.getNSides();
        double rotationAngleBefore = poly.getRotationAngle();

        poly.move(3.0, 4.0);

        assertEquals(new Point(4.0, 6.0), poly.center());
        
        assertEquals(nSidesBefore, poly.getNSides());
        assertEquals(radiusBefore, poly.getRadius(), 0.0001);
        assertEquals(rotationAngleBefore, poly.getRotationAngle(), 0.0001);
    }
    
}