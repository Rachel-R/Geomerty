package com.rroIKS;

public interface Shape {
    float getArea();
    float getCircumference();
    Point getCenter();
    float distanceTo(Shape otherShape);

    boolean isEqualTo(Shape s);

}
