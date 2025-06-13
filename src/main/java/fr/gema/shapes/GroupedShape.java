package fr.gema.shapes;

import java.util.List;

/**
 * Represents a shape composed of multiple other shapes.
 * Shapes can be added dynamically to this group.
 */
public class GroupedShape extends GenericShape {

    private List<Shape> shapes;

    /**
     * Constructs a GroupedShape with the specified label.
     * @param label the label for the grouped shape
     */
    public GroupedShape(String label) {
        // TODO
    }

    /**
     * Adds a shape to the group.
     * @param shape the shape to add
     */
    public void addShape(Shape shape) {
        // TODO
    }

    /**
     * Returns the list of shapes in this group.
     * @return the list of shapes
     */
    public List<Shape> getShapes() {
        // TODO
        return null;
    }

    @Override
    public void scale(double factor) {
        // TODO
    }

    @Override
    public void rotate(double angle) {
        // TODO
    }

    @Override
    public double area() {
        // TODO
        return 0;
    }

    @Override
    public double perimeter() {
        // TODO
        return 0;
    }

    @Override
    public String name() {
        // TODO
        return null;
    }

    @Override
    public Point center() {
        // TODO
        return null;
    }

    @Override
    public void move(double dx, double dy) {
        // TODO
    }

}