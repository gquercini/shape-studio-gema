package fr.gema.shapes;


import fr.gema.shapes.exceptions.InvalidShapeException;
import org.junit.Test;
import static org.junit.Assert.*;

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
        double rotationAngleBefore = poly.getRotationAngle();
        Point[] vertices = poly.getVertices();
        assertEquals(6, vertices.length);
        assertEquals(vertices[0], new Point(1, 0));
        
        assertEquals(vertices[1], new Point(1./2., Math.sqrt(3)/2));
        
        assertEquals(vertices[2], new Point(-1./2., Math.sqrt(3)/2));
        assertEquals(vertices[3], new Point(-1, 0.));
        assertEquals(vertices[4], new Point(-1./2., -Math.sqrt(3)/2));
        assertEquals(vertices[5], new Point(1./2., -Math.sqrt(3)/2));

        // Make sure the method does not change the object
        assertEquals(poly.getNSides(), 6);
        assertEquals(poly.center(), new Point(0, 0));
        assertEquals(poly.getRadius(), 1.0, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore, 0.0001);
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

        assertEquals(areaAfter, Math.pow(scaleFactor, 2)* areaBefore, 0.0001);
        assertEquals(centerAfter, centerBefore);
        assertEquals(radiusAfter, scaleFactor*radiusBefore, 0.0001);
        assertEquals(nSidesAfter, nSidesBefore, 0.0001);
        assertEquals(rotationAngleAfter, rotationAngleBefore, 0.0001);

        Point[] vertices = poly.getVertices();
        assertEquals(6, vertices.length);
        assertEquals(vertices[0], new Point(scaleFactor * 1., 0));
        assertEquals(vertices[1], new Point(scaleFactor * 1./2., scaleFactor * Math.sqrt(3)/2));
        assertEquals(vertices[2], new Point(scaleFactor * (-1./2.), scaleFactor * Math.sqrt(3)/2));
        assertEquals(vertices[3], new Point(scaleFactor * (-1), 0.));
        assertEquals(vertices[4], new Point(scaleFactor * (-1./2.), -scaleFactor * Math.sqrt(3)/2));
        assertEquals(vertices[5], new Point(scaleFactor * (1./2.), -scaleFactor * Math.sqrt(3)/2));
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

        assertEquals(poly.getNSides(), nSidesBefore);
        assertEquals(poly.center(), centerBefore);
        assertEquals(poly.getRadius(), radiusBefore, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore + rotationAngleToApply, 0.0001);

        Point[] vertices = poly.getVertices();
        assertEquals(vertices[0], new Point(0, 1));
        assertEquals(vertices[1], new Point(-Math.sqrt(3)/2, -1./2.));
        assertEquals(vertices[2], new Point(Math.sqrt(3)/2, -1./2.));

        // Apply a second rotation
        rotationAngleBefore = poly.getRotationAngle();
        poly.rotate(rotationAngleToApply); 
        assertEquals(poly.getNSides(), nSidesBefore);
        assertEquals(poly.center(), centerBefore);
        assertEquals(poly.getRadius(), radiusBefore, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore + rotationAngleToApply, 0.0001);

        vertices = poly.getVertices();
        assertEquals(vertices[0], new Point(-1, 0));
        assertEquals(vertices[1], new Point(1./2., -Math.sqrt(3)/2));
        assertEquals(vertices[2], new Point(1./2., Math.sqrt(3)/2));

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

        
        assertEquals(poly.getNSides(), nSidesBefore);
        assertEquals(poly.center(), centerBefore);
        assertEquals(poly.getRadius(), radiusBefore, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore, 0.0001);
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

        assertEquals(poly.getNSides(), nSidesBefore);
        assertEquals(poly.center(), centerBefore);
        assertEquals(poly.getRadius(), radiusBefore, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore, 0.0001);
    }

    @Test
    public void testName() throws Exception {
        RegularPolygon poly = new RegularPolygon("P10", 5, new Point(0, 0), 1.0);

        int nSidesBefore = poly.getNSides();
        Point centerBefore = poly.center();
        double radiusBefore = poly.getRadius();
        double rotationAngleBefore = poly.getRotationAngle();


        assertEquals("RegularPolygon", poly.name());

        assertEquals(poly.getNSides(), nSidesBefore);
        assertEquals(poly.center(), centerBefore);
        assertEquals(poly.getRadius(), radiusBefore, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore, 0.0001);
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

        assertEquals(poly.getNSides(), nSidesBefore);
        assertEquals(poly.center(), centerBefore);
        assertEquals(poly.getRadius(), radiusBefore, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore, 0.0001);
    }

    @Test
    public void testMove() throws Exception {
        RegularPolygon poly = new RegularPolygon("P12", 5, new Point(1.0, 2.0), 1.0);
        
        double radiusBefore = poly.getRadius();
        int nSidesBefore = poly.getNSides();
        double rotationAngleBefore = poly.getRotationAngle();

        poly.move(3.0, 4.0);

        assertEquals(new Point(4.0, 6.0), poly.center());
        
        assertEquals(poly.getNSides(), nSidesBefore);
        assertEquals(poly.getRadius(), radiusBefore, 0.0001);
        assertEquals(poly.getRotationAngle(), rotationAngleBefore, 0.0001);
    }
    
}