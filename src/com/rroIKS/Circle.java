package com.rroIKS;

public class Circle implements Shape {

    private float radius;
    private Point center;


    Circle(float r, Point p) {
        radius = r;
        center = p;
    }

    Circle(float r, float xCenter, float yCenter) {
       this(r,new Point(xCenter,yCenter));
    }

    public boolean isEqualTo(Shape s) {
        if (!(s instanceof Circle))
            return false;
        else return (this.center.isEqualTo(((Circle) s).center))
                && ((Math.abs(this.getRadius() - ((Circle) s).getRadius()) < GeometryHelper.DELTA));
    }

    public String toString() {
        return "Circle with its center at ("
                + this.center.getXCoordinate() + "/"
                + this.center.getYCoordinate()
                + ") and a radius of " + radius + ".";
    }

    public float getArea() {
        double area = Math.PI * Math.pow(radius, 2);
        return (float) area;
    }

    public float getCircumference() {
        double circumference = 2 * Math.PI * radius;
        return (float) circumference;
    }

    public Point getCenter() {
        return center;
    }

    void setCenter(Point center) {
        this.center = center;
    }

    void setRadius(float radius) {
        this.radius = radius;
    }

    public float distanceTo(Shape otherShape) {
        return this.getCenter().distanceTo(otherShape.getCenter());
    }

    float getRadius() {
        return radius;
    }
}
