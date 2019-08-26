package com.rroIKS;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void checkToString() {
        Triangle t = new Triangle(1, 3, -2, 6, -3, 3);
        String result = t.toString();
        assertEquals(result, "Triangle with vertices at (1.0/3.0), (-2.0/6.0) and (-3.0/3.0).");
    }

    @Test
    public void checkGetArea() {
        Triangle t = new Triangle(1, 3, -2, 6, -3, 3);
        //float prediction = ((1 * (6 - 3)) + (-2 * (3 - 3)) + (-3 * (3 - 6))) / 2;
        float result = t.getArea();
        assertTrue(result == 6);
    }

    @Test
    public void checkGetAreaZeroArea() {
        Triangle t = new Triangle(1, 1, 1, 1, 1, 1);
        //float prediction = ((1 * (1 - 1)) + (-1 * (1 - 1)) + (-1 * (1 - 1))) / 2;
        float result = t.getArea();
        assertTrue(result == 0);
    }

    @Test
    public void checkGetCircumference() {
        Triangle t = new Triangle(1, 3, -2, 6, -3, 3);
        float prediction = t.getPointA().distanceTo(t.getPointB())
                         + t.getPointB().distanceTo(t.getPointC())
                         + t.getPointC().distanceTo(t.getPointA());
        float result = t.getCircumference();
        assertTrue(result == prediction);
    }

    @Test
    public void checkGetCenter() {
        Triangle t = new Triangle(3, 3, -3, 6, -6, 3);
        Point prediction = new Point(-2, 4);
        Point result = t.getCenter();
        assertTrue(prediction.isEqualTo(result));
    }

    @Test
    public void checkConstructorSortingProperty() {
        Triangle t1 = new Triangle(1, 7, 2, 6, 2, 8);
        System.out.println("PointA: " +t1.getPointA()+" PointB: "+t1.getPointB()+" PointC: "+t1.getPointC());
        Triangle t1Jumble = new Triangle(2, 8, 2, 6, 1, 7);
        System.out.println("PointA: " +t1Jumble.getPointA()+" PointB: "+t1Jumble.getPointB()+" PointC: "+t1Jumble.getPointC());
        Triangle t2 = new Triangle(2, -1, 2, -5, 6, -3);
        System.out.println("PointA: " +t2.getPointA()+" PointB: "+t2.getPointB()+" PointC: "+t2.getPointC());
        Triangle t2Jumble = new Triangle(6,-3, 2, -5, 2,-1);
        System.out.println("PointA: " +t2Jumble.getPointA()+" PointB: "+t2Jumble.getPointB()+" PointC: "+t2Jumble.getPointC());
        Triangle t3 = new Triangle(1, 4, 3, 4, 4, 6);
        System.out.println("PointA: " +t3.getPointA()+" PointB: "+t3.getPointB()+" PointC: "+t3.getPointC());
        Triangle t3Jumble = new Triangle(3, 4, 1, 4, 4, 6);
        System.out.println("PointA: " +t3Jumble.getPointA()+" PointB: "+t3Jumble.getPointB()+" PointC: "+t3Jumble.getPointC());
        Triangle t4 = new Triangle(-3, 3, -5, 3, -2, 6);
        System.out.println("PointA: " +t4.getPointA()+" PointB: "+t4.getPointB()+" PointC: "+t4.getPointC());
        Triangle t4Jumble = new Triangle(-2, 6, -3, 3, -5, 3);
        System.out.println("PointA: " +t4Jumble.getPointA()+" PointB: "+t4Jumble.getPointB()+" PointC: "+t4Jumble.getPointC());
        Triangle t5 = new Triangle(-1, 0, -3, 0, -1, 2);
        System.out.println("PointA: " +t5.getPointA()+" PointB: "+t5.getPointB()+" PointC: "+t5.getPointC());
        Triangle t5Jumble = new Triangle(-1, 2, -3, 0, -1, 0);
        System.out.println("PointA: " +t5Jumble.getPointA()+" PointB: "+t5Jumble.getPointB()+" PointC: "+t5Jumble.getPointC());
        Triangle t6 = new Triangle(0, -2, -3, -1, -3, -4);
        System.out.println("PointA: " +t6.getPointA()+" PointB: "+t6.getPointB()+" PointC: "+t6.getPointC());
        Triangle t6Jumble= new Triangle(0, -2, -3, -4, -3, -1);
        System.out.println("PointA: " +t6Jumble.getPointA()+" PointB: "+t6Jumble.getPointB()+" PointC: "+t6Jumble.getPointC());

    }

    @Test
    public void checkIsEqualToTriangle() {
        Triangle t = new Triangle(1, 7, 2, 6, 2, 8);
        Triangle tDuplicate = new Triangle(1, 7, 2, 6, 2, 8);
        assertTrue(t.isEqualTo(tDuplicate));
    }

    @Test
    public void checkIsEqualToTriangleNotEqual() {
        Triangle t = new Triangle(1, 7, 2, 6, 2, 8);
        Triangle tDuplicate = new Triangle(1, 3, 2, 6, 2, 8);
        assertFalse(t.isEqualTo(tDuplicate));
    }

    @Test
    public void checkIsEqualToTriangleOrderP2P1P3() {
        Triangle t = new Triangle(6, 7, 8, 6, 4, 8);
        Triangle tDuplicate = new Triangle(6, 7, 8, 6, 4, 8);
        assertTrue(t.isEqualTo(tDuplicate));
    }

    @Test
    public void checkIsEqualToTriangleOrderP2P3P1() {
        Triangle t = new Triangle(6, 7, 8, 6, 7, 8);
        Triangle tDuplicate = new Triangle(6, 7, 8, 6, 7, 8);
        assertTrue(t.isEqualTo(tDuplicate));
    }

    @Test
    public void checkIsEqualToJumbledTriangle() {
        Triangle t = new Triangle(1, 7, 2, 6, 2, 8);
        Triangle tJumble = new Triangle(2, 8, 2, 6, 1, 7);
        assertTrue(t.isEqualTo(tJumble));
    }

    @Test
    public void checkIsEqualToShape() {

        Triangle t = new Triangle(2, -1, 2, -5, 6, -3);
        Shape tJumble = new Triangle(6,-3, 2, -5, 2,-1);
        assertTrue(t.isEqualTo(tJumble));

    }

    @Test
    public void checkIsEqualToPoint() {
        Triangle t = new Triangle(1, 4, 3, 4, 4, 6);
        Point p = new Point(3, 4);
        assertFalse(t.isEqualTo(p));

    }

    @Test
    public void checkDistanceTo() {
        Triangle t = new Triangle(10, 15, 6, 8, 14, 10);
        Point p = new Point(6, 11);
        float prediction = 4;
        float result = t.distanceTo(p);
        assertEquals(prediction,result,GeometryHelper.DELTA);
    }

    @Test
    public void checkSetPointCoordinates() {
        Triangle t = new Triangle(new Point(1,1),new Point(0,0), new Point(3,0));
        System.out.println(t);
        t.setPointCoordinates(10, 15, 6, 8, 14, 10);
        System.out.println(t);
    }

}


