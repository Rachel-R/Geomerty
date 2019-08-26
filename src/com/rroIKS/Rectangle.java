package com.rroIKS;

public class Rectangle implements Shape {

    private Point upperRight;
    private Point lowerRight;
    private Point upperLeft;
    private Point lowerLeft;

    private Point center = new Point(0, 0);
    private float height;
    private float width;

    Rectangle(Point a, Point b, Point c, Point d) {
        /*  Points starting with Point upperRight
            then Point lowerRight with the same x value as upperRight
            then Point upperLeft, with the same y value as upperRight
            "smallest" Point is lowerLeft
        */

        Point[] pointsUnsorted = new Point[]{a, b, c, d};
        Point[] pointsSorted = GeometryHelper.sort(pointsUnsorted);

        upperRight = pointsSorted[3];
        lowerRight = pointsSorted[2];
        upperLeft = pointsSorted[1];
        lowerLeft = pointsSorted[0];

        height = lowerLeft.distanceTo(upperLeft);
        width = lowerLeft.distanceTo(lowerRight);
        center.setXCoordinate(lowerLeft.getXCoordinate()+ (width/2));
        center.setYCoordinate(lowerLeft.getYCoordinate()+ (height/2));

        if (!isRectangleNotParallelogram(upperRight, lowerRight, upperLeft, lowerLeft)){
             throw new ArithmeticException("Error. Not a proper rectangle.");
        }
    }

    Rectangle(Point c, float h, float w) {
        this(new Point ((c.getXCoordinate()-(w/2)),(c.getYCoordinate()+(h/2))),
             new Point ((c.getXCoordinate()+(w/2)),(c.getYCoordinate()+(h/2))),
             new Point ((c.getXCoordinate()+(w/2)),(c.getYCoordinate()-(h/2))),
             new Point ((c.getXCoordinate()-(w/2)),(c.getYCoordinate()-(h/2))));
    }

    Rectangle(float xCenter, float yCenter, float h, float w) {
       this(new Point(xCenter,yCenter),h,w);
    }

    public boolean isEqualTo(Shape s){
        if (!(s instanceof Rectangle))
            return false;
        else
            return this.isEqualTo((Rectangle) s);
    }

    public boolean isEqualTo(Rectangle r){
        if (this.getUpperRight().isEqualTo(r.getUpperRight()) &&
                this.getLowerRight().isEqualTo(r.getLowerRight()) &&
                this.getUpperLeft().isEqualTo(r.getUpperLeft())&&
                this.getLowerLeft().isEqualTo(r.getLowerLeft()))
            return true;

        return false;
    }


    private boolean isRectangleNotParallelogram(Point upperRight, Point lowerRight, Point upperLeft, Point lowerLeft) {
        return (((GeometryHelper.areFloatsEqual(upperRight.getXCoordinate(),lowerRight.getXCoordinate())&&
                 (GeometryHelper.areFloatsEqual(upperRight.getYCoordinate(),upperLeft.getYCoordinate())&&
                 (GeometryHelper.areFloatsEqual(lowerRight.getYCoordinate(),lowerLeft.getYCoordinate())&&
                 (GeometryHelper.areFloatsEqual(upperLeft.getXCoordinate(),lowerLeft.getXCoordinate())))))));
    }

    public String toString(){
        return "Rectangle with height: "+height+", " +
                "width: "+width+" and its center at " +
                "("+this.center.getXCoordinate()+"/"+this.center.getYCoordinate()
                +").";
    }

    public float distanceTo(Shape otherShape) {
        return this.getCenter().distanceTo(otherShape.getCenter());
    }

    public float getArea() {
        return height * width;
    }

    public float getCircumference() {
        return 2 * height + 2 * width;
    }

    public Point getCenter() {
        return center;
    }

    Point getLowerLeft() {
        return lowerLeft;
    }

    Point getUpperLeft() {
        return upperLeft;
    }

    Point getLowerRight() {
        return lowerRight;
    }

    Point getUpperRight() {
        return upperRight;
    }

    float getHeight() {
        return height;
    }

    float getWidth() {
        return width;
    }
}
