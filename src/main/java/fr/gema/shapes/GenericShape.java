package fr.gema.shapes;

import fr.gema.shapes.exceptions.InvalidBorderWidthException;
import fr.gema.shapes.exceptions.InvalidColorException;

/**
 * An abstract base class for geometric shapes, providing common properties such as label,
 * border width, border color, and fill color, as well as basic validation and movement methods.
 */
public abstract class GenericShape implements Shape {

    /** The label of the shape. */
    private String label;
    /** The width of the border. */
    private float borderWidth;
    /** The color of the border in hexadecimal format (e.g., #FFFFFF). */
    private String borderColor;
    /** The fill color in hexadecimal format (e.g., #FFFFFF). */
    private String fillColor;
    
    public GenericShape() {}

    /**
     * Constructs a GenericShape with the specified label and default border and fill colors.
     *
     * @param label the label for the shape
     */
    public GenericShape(String label) {
        this.label = label;
        this.borderWidth = 1.0f;
        this.borderColor = "#000000";
        this.fillColor = "#FFFFFF";
    }

    /**
     * Constructs a GenericShape with the specified label, border width, border color, and fill color.
     *
     * @param label the label for the shape
     * @param borderWidth the width of the border
     * @param borderColor the color of the border in hexadecimal format
     * @param fillColor the fill color in hexadecimal format
     * @throws InvalidColorException if the color format is invalid
     * @throws InvalidBorderWidthException if the border width is negative
     */
    public GenericShape(String label,
            float borderWidth,
            String borderColor,
            String fillColor) throws InvalidColorException, InvalidBorderWidthException {
        this(label);
        this.setBorderWidth(borderWidth);
        this.setBorderColor(borderColor);
        this.setFillColor(fillColor);
    }

    /**
     * Returns the label of the shape.
     * @return the label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets the label of the shape.
     * @param label the new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Returns the border width.
     * @return the border width
     */
    public float getBorderWidth() {
        return borderWidth;
    }

    /**
     * Sets the border width.
     * @param borderWidth the new border width
     * @throws InvalidBorderWidthException if the border width is negative
     */
    public final void setBorderWidth(float borderWidth) throws InvalidBorderWidthException {
        if (borderWidth < 0)
            throw new InvalidBorderWidthException("Border width cannot be negative " + borderWidth);
        this.borderWidth = borderWidth;
    }

    /**
     * Returns the border color.
     * @return the border color in hexadecimal format
     */
    public String getBorderColor() {
        return borderColor;
    }

    /**
     * Sets the border color.
     * @param borderColor the new border color in hexadecimal format
     * @throws InvalidColorException if the color format is invalid
     */
    public final void setBorderColor(String borderColor) throws InvalidColorException {
        if (!isValidColor(borderColor))
            throw new InvalidColorException("Invalid color " + borderColor);

        this.borderColor = borderColor;
    }

    /**
     * Returns the fill color.
     * @return the fill color in hexadecimal format
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     * Sets the fill color.
     * @param fillColor the new fill color in hexadecimal format
     * @throws InvalidColorException if the color format is invalid
     */
    public final void setFillColor(String fillColor) throws InvalidColorException {
        if (!isValidColor(fillColor))
            throw new InvalidColorException("Invalid color " + fillColor);

        this.fillColor = fillColor;
    }

    /**
     * Moves the center of the shape to the origin (0,0).
     */
    @Override
    public void move() {
        Point origin = new Point();

        double deltaX = origin.getX() - this.center().getX();
        double deltaY = origin.getY() - this.center().getY();

        this.move(deltaX, deltaY);
    }

    /**
     * Validates if the given color string is a valid hexadecimal color (e.g., #FFFFFF).
     * @param color the color string to validate
     * @return true if the color is valid, false otherwise
     */
    private static boolean isValidColor(String color) {

        color = color.toUpperCase();

        if (color.charAt(0) != '#')
            return false;

        for (int i = 1; i < color.length(); i += 1) {
            char c = color.charAt(i);
            if (!((c >= 'A' && c <= 'F') || (c >= '0' && c <= '9')))
                return false;
        }

        return true;

    }

}
