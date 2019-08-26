package com.rroIKS;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void checkConstructor() {
        Point p = new Point(1,1);
        Circle c = new Circle(2, p);
        assertTrue(c.getRadius() == 2 && c.getCenter().isEqualTo(p));
    }

    @Test
    public void checkToString() {
        Circle c = new Circle(2, 1, 1);
        String result = c.toString();
        assertEquals("Circle with its center at (1.0/1.0) and a radius of 2.0.",result);
    }

    @Test
    public void checkGetArea() {
        Circle c = new Circle(2, 1, 1);
        float prediction = (float) (Math.PI * 4);
        float result = c.getArea();
        assertEquals(prediction, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetAreaRadiusZero() {
        Circle c = new Circle(0, 1, 1);
        float prediction = 0;
        float result = c.getArea();
        assertEquals(prediction, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetCircumference() {
        Circle c = new Circle(2, 1, 1);
        float prediction = (float) (2 * Math.PI * 2);
        float result = c.getCircumference();
        assertEquals(prediction, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetCircumferenceRadiusZero() {
        Circle c = new Circle(0, 1, 1);
        float prediction = 0;
        float result = c.getCircumference();
        assertEquals(prediction, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkIsEqualToCircle() {
        Circle c = new Circle(4, 1, 1);
        Circle e = new Circle(4, 1, 1);
        assertTrue(c.isEqualTo(e));
    }

    @Test
    public void checkIsEqualToCircleNotEqual() {
        Circle c = new Circle(4, 1, 1);
        Circle e = new Circle(1, 3, 2);
        assertFalse(c.isEqualTo(e));
    }

    @Test
    public void checkIsEqualToShape() {
        Circle c = new Circle(4, 1, 1);
        Shape e = new Circle(1, 3, 2);
        assertFalse(c.isEqualTo(e));
    }

    @Test
    public void checkIsEqualToPoint() {
        Circle c = new Circle(4, 1, 1);
        Point e = new Point(1, 3);
        assertFalse(c.isEqualTo(e));
    }

    @Test
    public void checkSetCenter() {
        Circle c = new Circle(4, 1, 1);
        Point oldPoint = c.getCenter();
        c.setCenter(new Point(0, 0));
        assertFalse(oldPoint.isEqualTo(c.getCenter()));
    }

    @Test
    public void checkSetRadius() {
        Circle c = new Circle(4, 1, 1);
        float oldRadius = c.getRadius();
        c.setRadius(2);
        assertNotEquals(oldRadius, c.getRadius(), GeometryHelper.DELTA);
    }

    @Test
    public void checkDistanceTo() {
        Circle c = new Circle(4, 1, 1);
        Point p = new Point(4, 1);
        float prediction = 3;
        float result = c.distanceTo(p);
        assertEquals(prediction, result, GeometryHelper.DELTA);
    }
}
