package com.rroIKS;

public class Triangle implements Shape {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    Triangle(Point p1, Point p2, Point p3) {
        /* Sorts Points in descending order, A being the largest
           The larger Point has a greater x-value. When the x-values are equal the greater y-value decides
         */
        Point[] pointsUnsorted = new Point[]{p1, p2, p3};
        Point[] pointsSorted = GeometryHelper.sort(pointsUnsorted);

        pointA = pointsSorted[2];
        pointB = pointsSorted[1];
        pointC = pointsSorted[0];
    }

    Triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    Point getPointA() {
        return pointA;
    }

    Point getPointB() {
        return pointB;
    }

    Point getPointC() {
        return pointC;
    }

    public boolean isEqualTo(Shape s) {
        if (!(s instanceof Triangle))
            return false;

        return this.isEqualTo((Triangle) s);
    }

    boolean isEqualTo(Triangle t) {
        if (this.getPointA().isEqualTo(t.getPointA()) &&
            this.getPointB().isEqualTo(t.getPointB()) &&
            this.getPointC().isEqualTo(t.getPointC()))
            return true;

        return false;
    }

    public String toString() {
        return "Triangle with vertices at (" + this.pointA.getXCoordinate() + "/"
                + this.pointA.getYCoordinate()+ "), (" + this.pointB.getXCoordinate() + "/"
                + this.pointB.getYCoordinate() + ") and " +"("
                + this.pointC.getXCoordinate() + "/" + this.pointC.getYCoordinate() + ").";
    }

    void setPointCoordinates(float x1, float y1, float x2, float y2, float x3, float y3) {
        pointA.setXCoordinate(x1);
        pointA.setYCoordinate(y1);
        pointB.setXCoordinate(x2);
        pointB.setYCoordinate(y2);
        pointC.setXCoordinate(x3);
        pointC.setYCoordinate(y3);
    }

    public float getArea() {
        //double area = (x1(y2 -y3) + x2(y3 -y1) + x3(y1 - y2))/2;
        double area = ((pointA.getXCoordinate() * (pointB.getYCoordinate() - pointC.getYCoordinate())) +
                (pointB.getXCoordinate() * (pointC.getYCoordinate() - pointA.getYCoordinate())) +
                (pointC.getXCoordinate() * (pointA.getYCoordinate() - pointB.getYCoordinate()))) / 2;

        return (float) area;
    }

    public float getCircumference() {
        //circumference = line ab + line bc + line ca
        double circumference = pointA.distanceTo(pointB) + pointB.distanceTo(pointC) + pointC.distanceTo(pointA);

        return (float) circumference;
    }

    public Point getCenter() {
        //centerTriangle = (x1+x2+x3)/3, (y1+y2+y3)/3
        Point centerTriangle = new Point(0, 0);

        centerTriangle.setXCoordinate((pointA.getXCoordinate() + pointB.getXCoordinate() + pointC.getXCoordinate()) / 3);
        centerTriangle.setYCoordinate((pointA.getYCoordinate() + pointB.getYCoordinate() + pointC.getYCoordinate()) / 3);

        return centerTriangle;
    }

    public float distanceTo(Shape otherShape) {
        return this.getCenter().distanceTo(otherShape.getCenter());
    }
}
