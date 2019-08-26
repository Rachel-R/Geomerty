package com.rroIKS;

public class Line implements Shape {

    private Point linePoint1;
    private Point linePoint2;

    Line(Point p1, Point p2) {
        linePoint1 = p1;
        linePoint2 = p2;
    }

    Line(float x1, float y1, float x2, float y2) {

        this(new Point(x1, y1), new Point(x2, y2));
    }

    public boolean isEqualTo(Shape s) {
        if (!(s instanceof Line))
            return false;

        return (this.isEqualTo((Line)s));
    }

    public boolean isEqualTo(Line l) {

        if (hasSameYIntercept(l) && hasSameSlope(l))
            return true;

        return false;
    }

    private boolean hasSameSlope(Line s) {
        return GeometryHelper.areFloatsEqual(this.getSlopeM(), s.getSlopeM());
    }

    private boolean hasSameYIntercept(Line s) {
        return GeometryHelper.areFloatsEqual(this.getYInt(), s.getYInt());
    }

    public String toString() {
        return "Line through ("
                + linePoint1 + ") and ("
                + linePoint2 + ") with a slope of "
                + this.getSlopeM() + " and a y-intercept at "
                + this.getYInt() + ".";
    }

    void setLinePoint1(Point linePoint1) {
        this.linePoint1 = linePoint1;
    }

    void setLinePoint2(Point linePoint2) {
        this.linePoint2 = linePoint2;
    }

    float getSlopeM() {
        return (linePoint2.getYCoordinate() - linePoint1.getYCoordinate())
             / (linePoint2.getXCoordinate() - linePoint1.getXCoordinate());
    }

    float getYInt() {
        return linePoint1.getYCoordinate() - (getSlopeM() * linePoint1.getXCoordinate());
    }

    Point getLineIntersect(Line line2) {
        if (this.getSlopeM() == line2.getSlopeM())
            return null;

        float x = (line2.getYInt() - this.getYInt()) / (this.getSlopeM() - line2.getSlopeM());
        float y = (this.getSlopeM() * x + this.getYInt());

        return new Point(x, y);
    }

    public float getArea() {
        return 0;
    }

    public float getCircumference() {
        return 0;
    }

    public Point getCenter() {
        float xCoordinateMid = ((linePoint1.getXCoordinate() + linePoint2.getXCoordinate()) / 2);
        float yCoordinateMid = ((linePoint1.getYCoordinate() + linePoint2.getYCoordinate()) / 2);

        Point lineMidPoint = new Point(xCoordinateMid, yCoordinateMid);
        return lineMidPoint;
    }

    public float distanceTo(Shape otherShape) {
        return this.getCenter().distanceTo(otherShape.getCenter());
    }
}
