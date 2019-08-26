package com.rroIKS;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeometryTests {

  /*  //POINT
    @Test
    public void geometryPointToString() {
        Point p = new Point(2, 2);
        String result = p.toString();
        assertTrue("Point 2.0/2.0".equals(result));
    }

    @Test
    public void geometryPointDistanceTo() {
        Point p = new Point(1, 1);
        Point q = new Point(2, 1);
        float result = p.distanceTo(q);
        assertEquals(1, result, 0.000001);
    }

    @Test
    public void geometryPointIsEqualTo() {
        Point p = new Point(1, 1);
        Point q = new Point(1, 1);
        boolean result = p.isEqualTo(q);
        assertTrue(result);
    }

    @Test
    public void geometryPointIsNotEqualTo() {
        Point p = new Point(1, 1);
        Point q = new Point(2, 1);
        boolean result = p.isEqualTo(q);
        assertFalse(result);
    }

    //LINE
    @Test
    public void geometryLineToString() {
        Line l = new Line(1, 1, 2, 2);
        String result = l.toString();
        assertEquals(result, "Line through (Point 1.0/1.0) and (Point 2.0/2.0) with a slope of 1.0 and a y-intercept at 0.0.");
    }

    @Test
    public void geometryLineToStringZero() {
        Line l = new Line(0, 0, 0, 0);
        String result = l.toString();
        assertEquals(result, "Line through (Point 0.0/0.0) and (Point 0.0/0.0) with a slope of NaN and a y-intercept at NaN.");
    }

    @Test
    public void geometryLineGetSlopeM() {
        Line l = new Line(1, 1, 2, 2);
        float result = l.getSlopeM();
        assertTrue(result == 1);
    }

    @Test
    public void geometryLineGetSlopeMVertical() {
        Line l = new Line(1, 1, 1, 2);
        float result = l.getSlopeM();
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void geometryLineGetSlopeMHorizontal() {
        Line l = new Line(1, 2, 2, 2);
        float result = l.getSlopeM();
        assertTrue(result == 0);
    }

    @Test
    public void geometryLineGetSlopeMZero() {
        Line l = new Line(0, 0, 0, 0);
        float result = l.getSlopeM();
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void geometryLineGetYInt() {
        Line l = new Line(1, 1, 2, 2);
        float result = l.getYInt();
        assertTrue(result == 0);
    }

    @Test
    public void geometryLineGetYIntVertical() {
        Line l = new Line(1, 1, 1, 2);
        float result = l.getYInt();
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void geometryLineGetLineIntersect() {
        Line l = new Line(2, 0, 0, -2);
        Line k = new Line(-4, 0, 0, -8);
        Point prediction = new Point(-2, -4);
        Point result = k.getLineIntersect(l);
        assertTrue(result.isEqualTo(prediction));
    }

    @Test
    public void geometryLineGetLineIntersectZero() {
        Line l = new Line(2, 1, 0, -7);
        Line k = new Line(2, 0, 0, -8);
        //Point prediction = null;
        Point result = k.getLineIntersect(l);
        assertNull(result);
    }

    @Test
    public void geometryLineGetCenter() {
        Line l = new Line(2, 0, 0, -2);
        Point prediction = new Point(1, -1);
        Point result = l.getCenter();
        assertTrue(result.isEqualTo(prediction));
    }

    @Test
    public void geometryLineGetCenterVertical() {
        Line l = new Line(1, 2, 1, -2);
        Point prediction = new Point(1, 0);
        Point result = l.getCenter();
        assertTrue(result.isEqualTo(prediction));
    }

    //Circle
    @Test
    public void geometryCircleToString() {
        Circle c = new Circle(2, 1, 1);
        String result = c.toString();
        assertEquals(result, "Circle with its center at (1.0/1.0) and a radius of 2.0.");
    }

    @Test
    public void geometryCircleGetArea() {
        Circle c = new Circle(2, 1, 1);
        float prediction = (float) (Math.PI * 4);
        float result = c.getArea();
        assertTrue(result == prediction);
    }

    @Test
    public void geometryCircleGetAreaRadiusZero() {
        Circle c = new Circle(0, 1, 1);
        float prediction = 0;
        float result = c.getArea();
        assertTrue(result == prediction);
    }

    @Test
    public void geometryCircleGetCircumference() {
        Circle c = new Circle(2, 1, 1);
        float prediction = (float) (2 * Math.PI * 2);
        float result = c.getCircumference();
        assertTrue(result == prediction);
    }

    @Test
    public void geometryCircleGetCircumferenceRadiusZero() {
        Circle c = new Circle(0, 1, 1);
        float prediction = 0;
        float result = c.getCircumference();
        assertTrue(result == prediction);
    }

    //Triangle
    @Test
    public void geometryTriangleToString() {
        Triangle t = new Triangle(1, 3, -2, 6, -3, 3);
        String result = t.toString();
        assertEquals(result, "Triangle with vertices at (1.0/3.0), (-2.0/6.0) and (-3.0/3.0).");
    }

    @Test
    public void geometryTriangleGetArea() {
        Triangle t = new Triangle(1, 3, -2, 6, -3, 3);
        //float prediction = ((1 * (6 - 3)) + (-2 * (3 - 3)) + (-3 * (3 - 6))) / 2;
        float result = t.getArea();
        assertTrue(result == 6);
    }

    @Test
    public void geometryTriangleGetAreaZeroArea() {
        Triangle t = new Triangle(1, 1, 1, 1, 1, 1);
        //float prediction = ((1 * (1 - 1)) + (-1 * (1 - 1)) + (-1 * (1 - 1))) / 2;
        float result = t.getArea();
        assertTrue(result == 0);
    }

    @Test
    public void geometryTriangleGetCircumference() {
        Triangle t = new Triangle(1, 3, -2, 6, -3, 3);
        float prediction = t.pointA.distanceTo(t.pointB) + t.pointB.distanceTo(t.pointC) + t.pointC.distanceTo(t.pointA);
        float result = t.getCircumference();
        assertTrue(result == prediction);
    }

    @Test
    public void geometryTriangleGetCenter() {
        Triangle t = new Triangle(3, 3, -3, 6, -6, 3);
        Point prediction = new Point(-2, 4);
        Point result = t.getCenter();
        assertTrue(result.isEqualTo(prediction));
    }

    //Rectangle
    @Test
    public void geometryRectangleToString() {
        Rectangle r = new Rectangle(1, 1, 2, 3);
        String result = r.toString();
        assertEquals(result, "Rectangle with height: 2.0, width: 3.0 and its center at (1.0/1.0).");

    }

    @Test
    public void geometryRectangleGetArea() {
        Rectangle r = new Rectangle(1, 1, 2, 3);
        float result = r.getArea();
        assertTrue(result == 6);

    }

    @Test
    public void geometryRectangleGetCircumference() {
        Rectangle r = new Rectangle(1, 1, 2, 3);
        float result = r.getCircumference();
        assertTrue(result == 10);
    }

    //Square
    @Test
    public void geometrySquareToString() {
        Square s = new Square(1, 1, 2);
        String result = s.toString();
        assertEquals(result, "Square with a side length of : 2.0 and its center at (1.0/1.0).");
    }

   */
}
