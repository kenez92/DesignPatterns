package com.kenez92;

public final class ShapeFactory {
    public static final String CIRCLE = "CIRCLE";
    public static final String SQUARE = "SQUARE";
    public static final String RECTANGLE = "RECTANGLE";

    public final Shape makeShape(final String shape) {
        switch (shape) {
            case CIRCLE:
                return new Circle("Circle", 4.50);
            case SQUARE:
                return new Square("Square", 7.0);
            case RECTANGLE:
                return new Rectangle("Rectangle", 15.0, 2.50);
            default:
                throw new IllegalArgumentException();
        }
    }
}
