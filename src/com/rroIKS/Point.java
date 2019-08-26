package com.rroIKS;

public class Point implements Shape {

    private float xCoordinate;
    private float yCoordinate;

    Point(float xC, float yC) {
        xCoordinate = xC;
        yCoordinate = yC;
    }

    public String toString() {
        return "Point " + xCoordinate + "/" + yCoordinate;
    }

    public void setEqual(Point p) {
        this.setXCoordinate(p.getXCoordinate());
        this.setYCoordinate(p.getYCoordinate());
    }

    public float getXCoordinate() {
        return xCoordinate;
    }

    public float getYCoordinate() {
        return yCoordinate;
    }

    public void setXCoordinate(float x) {
        xCoordinate = x;
    }

    public void setYCoordinate(float y) {
        yCoordinate = y;
    }

    public float getArea() {
        return 0;
    }

    public float getCircumference() {
        return 0;
    }

    public Point getCenter() {
        return this;
    }

    public float distanceTo(Shape otherShape) {
        Point localPoint2 = otherShape.getCenter();

        double x1 = this.xCoordinate;
        double x2 = localPoint2.xCoordinate;
        double y1 = this.yCoordinate;
        double y2 = localPoint2.yCoordinate;

        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return (float) distance;
    }

    public boolean isEqualTo(Shape s) {
        if (!(s instanceof Point))
            return false;
        else
            return this.isEqualTo((Point) s);
    }

    public boolean isEqualTo(Point p) {
        if (p == null)
            return false;
        if (sameXValue(p) && sameYValue(p))
            return true;
         else
            return false;
    }

    boolean sameYValue(Point p) {
        return GeometryHelper.areFloatsEqual(this.getYCoordinate(), p.getYCoordinate());
    }

    boolean sameXValue(Point p) {
        return GeometryHelper.areFloatsEqual(this.getXCoordinate(), p.getXCoordinate());
    }

    public boolean isLowerOrEqualTo(Point p) {
        if (this.isXValueLessThanXValueOf(p)) {
            return true;
        } else if (this.sameXValue(p)) {
            if (isYValueLessThanYValueOf(p)) {
                return true;
            } else if (this.sameYValue(p)) {
                return true;
            }
        }
        return false;
    }

    boolean isYValueLessThanYValueOf(Point p) {
        return GeometryHelper.isFloat1LessThanFloat2(this.getYCoordinate(), p.getYCoordinate());
    }

    boolean isXValueLessThanXValueOf(Point p) {
        return GeometryHelper.isFloat1LessThanFloat2(this.getXCoordinate(), p.getXCoordinate());
    }
}