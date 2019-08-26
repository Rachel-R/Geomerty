package com.rroIKS;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquareTest {

    @Test
    public void checkConstructors() {
        Square sCenterPointSide = new Square((float)3.5, (float) -3.5, 3);
        Square sFourPoints = new Square(
                new Point(2,-2),
                new Point (5,-2),
                new Point(2,-5),
                new Point (5,-5));
        boolean result = sCenterPointSide.isEqualTo(sFourPoints);
        assertTrue(result);
    }

    @Test(expected = ArithmeticException.class)
    public void checkConstructorsPassRectangleInsteadOfSquare() {
        new Square(
                new Point (-2,6),
                new Point (5,6),
                new Point (5, 0),
                new Point(-2,0));
    }

    @Test
    public void checkToString() {
        Square s = new Square(1, 1, 2);
        String result = s.toString();
        assertEquals( "Square with a side length of : 2.0 and its center at (1.0/1.0).",result);
    }

    @Test
    public void checkGetArea() {
        Square s = new Square(1, 1, 2);
        float result = s.getArea();
        assertEquals(4, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetCircumference() {
        Square s = new Square(1, 1, 2);
        float result = s.getCircumference();
        assertEquals(8, result, GeometryHelper.DELTA);
    }
}
