package com.rroIKS;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class LineTest {

    @Test
    public void checkSetLinePoint2() {
        Line l = new Line(1, 4, 4, 2);
        Line k = new Line(1, 4, 4, 2);
        k.setLinePoint2(new Point (5,5));
        boolean result = l.isEqualTo(k);
        assertFalse(result);
    }

    @Test
    public void checkSetLinePoint1() {
        Line l = new Line(1, 4, 4, 2);
        Line k = new Line(1, 4, 4, 2);
        k.setLinePoint1(new Point (5,5));
        boolean result = l.isEqualTo(k);
        assertFalse(result);
    }

    @Test
    public void checkIsEqualToLineKNotEqual() {
        Line l = new Line(1, 4, 4, 2);
        Line k = new Line(1, 4, 4, 3);
        boolean result = l.isEqualTo(k);
        assertFalse(result);
    }

    @Test
    public void checkIsEqualToLineK() {
        Line l = new Line(1, 4, 4, 2);
        Line k = new Line(1, 4, 4, 2);
        boolean result = l.isEqualTo(k);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualToLineKInvertedPoints() {
        Line l = new Line(1, 4, 4, 2);
        Line k = new Line(4, 2, 1, 4);
        boolean result = l.isEqualTo(k);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualToPointP() {
        Line l = new Line(1, 4, 4, 2);
        Point p = new Point(-2, -4);
        boolean result = l.isEqualTo(p);
        assertFalse(result);
    }

    @Test
    public void checkIsEqualToShapeS() {
        Line l = new Line(1, 4, 4, 2);
        Shape s = new Point(-2, -4);
        boolean result = l.isEqualTo(s);
        assertFalse(result);
    }

    @Test
    public void checkConstructor() {
        new Line(new Point(1,1),new Point(2,2));

    }

    @Test
    public void checkToString() {
        Line l = new Line(1, 1, 2, 2);
        String result = l.toString();
        assertEquals("Line through (Point 1.0/1.0) and (Point 2.0/2.0) with a slope of 1.0 and a y-intercept at 0.0.",result);
    }

    @Test
    public void checkToStringZero() {
        Line l = new Line(0, 0, 0, 0);
        String result = l.toString();
        assertEquals("Line through (Point 0.0/0.0) and (Point 0.0/0.0) with a slope of NaN and a y-intercept at NaN.", result);
    }

    @Test
    public void checkGetSlopeM() {
        Line l = new Line(1, 1, 2, 2);
        float result = l.getSlopeM();
        assertEquals(1, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetSlopeMVertical() {
        Line l = new Line(1, 1, 1, 2);
        float result = l.getSlopeM();
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void checkGetSlopeMHorizontal() {
        Line l = new Line(1, 2, 2, 2);
        float result = l.getSlopeM();
        assertEquals(0, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetSlopeMZero() {
        Line l = new Line(0, 0, 0, 0);
        float result = l.getSlopeM();
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void checkGetYInt() {
        Line l = new Line(1, 1, 2, 2);
        float result = l.getYInt();
        assertEquals(0, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetYIntVertical() {
        Line l = new Line(1, 1, 1, 2);
        float result = l.getYInt();
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void checkGetLineIntersectIdenticalLines() {
        Line l = new Line(1, 1, 2, 2);
        Line k = new Line(1, 1, 2, 2);
        Point result = k.getLineIntersect(l);
        assertNull(result);
    }

    @Test
    public void checkGetLineIntersect() {
        Line l = new Line(2, 0, 0, -2);
        Line k = new Line(-4, 0, 0, -8);
        Point prediction = new Point(-2, -4);
        Point result = k.getLineIntersect(l);
        assertTrue(prediction.isEqualTo(result));
    }

    @Test
    public void checkGetLineIntersectZero() {
        Line l = new Line(2, 1, 0, -7);
        Line k = new Line(2, 0, 0, -8);
        //Point prediction = null;
        Point result = k.getLineIntersect(l);
        assertNull(result);
    }

    @Test
    public void checkGetCenter() {
        Line l = new Line(2, 0, 0, -2);
        Point prediction = new Point(1, -1);
        Point result = l.getCenter();
        assertTrue(prediction.isEqualTo(result));
    }

    @Test
    public void checkGetCenterVertical() {
        Line l = new Line(1, 2, 1, -2);
        Point prediction = new Point(1, 0);
        Point result = l.getCenter();
        assertTrue(prediction.isEqualTo(result));
    }

    @Test
    public void checkGetArea() {
        Line l = new Line(1, 4, 4, 2);
        float result = l.getArea();
        assertEquals(0,result,GeometryHelper.DELTA);
    }

    @Test
    public void checkGetCircumference() {
        Line l = new Line(1, 4, 4, 2);
        float result = l.getCircumference();
        assertEquals(0,result,GeometryHelper.DELTA);
    }

    @Test
    public void checkDistanceToLineK() {
        Line l = new Line(2, 3, 2, 5);
        Line k = new Line(3, 3, 5, 5);
        float prediction = 2;
        float result = l.distanceTo(k);
        assertEquals(prediction,result,GeometryHelper.DELTA);
    }

    @Test
    public void checkDistanceToIdenticalLineK() {
        Line l = new Line(2, 3, 2, 5);
        Line k = new Line(2, 3, 2, 5);
        float prediction = 0;
        float result = l.distanceTo(k);
        assertEquals(prediction,result,GeometryHelper.DELTA);
    }
}
