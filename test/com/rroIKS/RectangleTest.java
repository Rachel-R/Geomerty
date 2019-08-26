package com.rroIKS;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class RectangleTest {

    @Test
    public void checkToString() {
        Rectangle r = new Rectangle(1, 1, 2, 3);
        String result = r.toString();
        assertEquals("Rectangle with height: 2.0, width: 3.0 and its center at (1.0/1.0).",result);
    }

    @Test
    public void checkGetArea() {
        Rectangle r = new Rectangle(1, 1, 2, 3);
        float result = r.getArea();
        assertEquals(6, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkGetCircumference() {
        Rectangle r = new Rectangle(1, 1, 2, 3);
        float result = r.getCircumference();
        assertEquals(10, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkConstructors(){
        Rectangle rCenterHeightWidth = new Rectangle(new Point((float)1.5,3),6,7);
        System.out.println(rCenterHeightWidth);
        Rectangle rCoordinatesHeightWidth = new Rectangle((float)1.5,3,6,7);
        System.out.println(rCoordinatesHeightWidth);
        Rectangle rFourPoints = new Rectangle(new Point (-2,6),
                                              new Point (5,6),
                                              new Point (5, 0),
                                              new Point(-2,0));
        System.out.println(rFourPoints);
    }

    @Test(expected = ArithmeticException.class)
    public void checkConstructorsInvalidRectangle(){
        new Rectangle(new Point (-2,6),
                      new Point (5,6),
                      new Point (5, 1),
                      new Point(-2,0));

    }

    @Test
    public void checkConstructorSorting() {
        //Permutations of abcd
        Point p1 = new Point (2,1);
        Point p2 = new Point(2,5);
        Point p3 = new Point(10,1);
        Point p4 = new Point(10,5);

        Rectangle abcd = new Rectangle(p1,p2,p3,p4);
        Rectangle abdc = new Rectangle(p1,p2,p4,p3);
        Rectangle acbd = new Rectangle(p1,p3,p2,p4);
        Rectangle acdb = new Rectangle(p1,p3,p4,p2);
        Rectangle adbc = new Rectangle(p1,p4,p2,p3);
        Rectangle adcb = new Rectangle(p1,p4,p3,p2);

        Rectangle bacd = new Rectangle(p2,p1,p3,p4);
        Rectangle badc = new Rectangle(p2,p1,p4,p3);
        Rectangle bcad = new Rectangle(p2,p3,p1,p4);
        Rectangle bcda = new Rectangle(p2,p3,p4,p1);
        Rectangle bdac = new Rectangle(p2,p4,p1,p3);
        Rectangle bdca = new Rectangle(p2,p4,p3,p1);

        Rectangle cabd = new Rectangle(p3,p1,p2,p4);
        Rectangle cadb = new Rectangle(p3,p1,p4,p2);
        Rectangle cbad = new Rectangle(p3,p2,p1,p4);
        Rectangle cbda = new Rectangle(p3,p2,p4,p1);
        Rectangle cdab = new Rectangle(p3,p4,p1,p2);
        Rectangle cdba = new Rectangle(p3,p4,p2,p1);

        Rectangle dabc = new Rectangle(p4,p1,p2,p3);
        Rectangle dacb = new Rectangle(p4,p1,p3,p2);
        Rectangle dbac = new Rectangle(p4,p2,p1,p3);
        Rectangle dbca = new Rectangle(p4,p2,p3,p1);
        Rectangle dcab = new Rectangle(p4,p3,p1,p2);
        Rectangle dcba = new Rectangle(p4,p3,p2,p1);

        System.out.println(abcd + "\n" +abdc + "\n" +acbd + "\n" +acdb + "\n" +adbc + "\n" +adcb + "\n" +bacd + "\n" +
                badc + "\n" +bcad + "\n" +bcda + "\n" +bdac + "\n" +bdca + "\n" +cabd + "\n" +cadb + "\n" +cbad + "\n" +
                cbda + "\n" +cdab + "\n" +cdba + "\n" +dabc + "\n" +dacb + "\n" +dbac + "\n" +dbca + "\n" +dcab + "\n" +
                dcba);
    }

    @Test
    public void checkIsEqualToRectangleR(){
        Rectangle r = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        Rectangle rDuplicate = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        boolean result = r.isEqualTo(rDuplicate);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualToNotEqual(){
        Rectangle r = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        Rectangle rDifferent = new Rectangle(
                new Point(3,-2),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-2));
        boolean result = r.isEqualTo(rDifferent);
        assertFalse(result);
    }

    @Test
    public void checkIsEqualToShapeRectangle(){
        Rectangle r = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        Shape s = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        boolean result = r.isEqualTo(s);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualToShapePoint(){
        Rectangle r = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        Shape s = new Point(0,3);
        boolean result = r.isEqualTo(s);
        assertFalse(result);
    }

    @Test
    public void checkDistanceTo(){
        Rectangle r = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        Point p = new Point((float)4.5,(float)2.5);
        float prediction = 1;
        float result = r.distanceTo(p);
        assertEquals(prediction,result,GeometryHelper.DELTA);
    }

    @Test
    public void checkGettersForCoverage(){
        Rectangle r = new Rectangle(
                new Point(3,-1),
                new Point(3,6),
                new Point(4,6),
                new Point(4,-1));
        r.getCenter();
        r.getHeight();
        r.getWidth();
    }
}
