package com.rroIKS;
import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void checkGetArea() {
        Point p = new Point(2, 2);
        float result = p.getArea();
        assertEquals(0, result,GeometryHelper.DELTA);
    }

    @Test
    public void checkGetCircumference() {
        Point p = new Point(2, 2);
        float result = p.getCircumference();
        assertEquals(0, result,GeometryHelper.DELTA);
    }

    @Test
    public void checkToString() {
        Point p = new Point(2, 2);
        String result = p.toString();
        assertEquals("Point 2.0/2.0", result);
    }

    @Test
    public void checkDistanceTo() {
        Point p = new Point(1, 1);
        Point q = new Point(2, 1);
        float result = p.distanceTo(q);
        assertEquals(1, result, GeometryHelper.DELTA);
    }

    @Test
    public void checkSetEqual() {
        Point p = new Point(2, 4);
        Point q = new Point(1, 1);
        p.setEqual(q);
        boolean result =p.isEqualTo(q);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualTo() {
        Point p = new Point(1, 1);
        Point q = new Point(1, 1);
        boolean result = p.isEqualTo(q);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualToNull() {
        Point p = new Point(1, 1);
        Point q = null;
        boolean result = p.isEqualTo(q);
        assertFalse(result);
    }

    @Test
    public void checkIsEqualToShapeQ() {
        Point p = new Point(1, 1);
        Shape q = new Point(1, 1);
        boolean result = p.isEqualTo(q);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualToLine() {
        Point p = new Point(1, 1);
        Line l = new Line(4,4,2,3);
        boolean result = p.isEqualTo(l);
        assertFalse(result);
    }

    @Test
    public void checkIsNotEqualTo() {
        Point p = new Point(1, 1);
        Point q = new Point(2, 1);
        boolean result = p.isEqualTo(q);
        assertFalse(result);
    }

    @Test
    public void checkIsEqualToDecimalToFraction() {
        Point p = new Point((float) 0.5, (float) 0.5);
        Point q = new Point(1, 1);
        q.setXCoordinate(q.getXCoordinate() / 2);
        q.setYCoordinate(q.getYCoordinate() / 2);
        boolean result = p.isEqualTo(q);
        assertTrue(result);
    }

    @Test
    public void checkIsEqualToFail1() {
        Point p = new Point((float) (0.7), (float) (0.7));
        Point q = new Point((float) (0.8), (float) (0.6));
        q.setXCoordinate(q.getXCoordinate() - (float) 0.1);
        q.setYCoordinate(q.getYCoordinate() + (float) 0.1);
        boolean result = p.isEqualTo(q);
        assertTrue(result);
    }

    @Test
    public void checkSameYValue() {
        Point p = new Point((float) (0.7), (float) (0.7));
        Point q = new Point((float) (0.8), (float) (0.7 + 0.0000099));
        assertTrue(p.sameYValue(q));
    }

    @Test
    public void checkSameYValueNotTheSame() {
        Point p = new Point((float) (0.7), (float) (0.7));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertFalse(p.sameYValue(q));
    }

    @Test
    public void checkSameXValue() {
        Point p = new Point((float) (0.7 + 0.0000099), (float) (0.7));
        Point q = new Point((float) (0.7), (float) (0.9));
        assertTrue(p.sameXValue(q));
    }

    @Test
    public void checkSameXValueNotTheSame() {
        Point p = new Point((float) (0.7), (float) (0.7));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertFalse(p.sameXValue(q));
    }

    @Test
    public void checkIsXValueLessThanXValueOf() {
        Point p = new Point((float) (0.7), (float) (0.5));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertTrue(p.isXValueLessThanXValueOf(q));
    }

    @Test
    public void checkIsXValueLessThanXValueOfNotLess() {
        Point p = new Point((float) (1), (float) (0.5));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertFalse(p.isXValueLessThanXValueOf(q));
    }

    @Test
    public void checkIsYValueLessThanYValueOf() {
        Point p = new Point((float) (0.7), (float) (0.5));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertTrue(p.isYValueLessThanYValueOf(q));
    }

    @Test
    public void checkIsYValueLessThanYValueOfNotLess() {
        Point p = new Point((float) (0.7), (float) (1));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertFalse(p.isYValueLessThanYValueOf(q));
    }

    @Test
    public void checkIsLowerOrEqualToPointPHasLowerXValue() {
        Point p = new Point((float) (0.7), (float) (0.5));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertTrue(p.isLowerOrEqualTo(q));
    }

    @Test
    public void checkIsLowerOrEqualToPointPHasGreaterXValue() {
        Point p = new Point((float) (1), (float) (0.5));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertFalse(p.isLowerOrEqualTo(q));
    }

    @Test
    public void checkIsLowerOrEqualToPointPHasEqualXValueLowerYValue() {
        Point p = new Point((float) (0.8), (float) (0.5));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertTrue(p.isLowerOrEqualTo(q));
    }

    @Test
    public void checkIsLowerOrEqualToPointPHasEqualXValueEqualYValue() {
        Point p = new Point((float) (0.8), (float) (0.6));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertTrue(p.isLowerOrEqualTo(q));
    }

    @Test
    public void checkIsLowerOrEqualToPointPHasEqualXValueGreaterYValue() {
        Point p = new Point((float) (0.8), (float) (0.7));
        Point q = new Point((float) (0.8), (float) (0.6));
        assertFalse(p.isLowerOrEqualTo(q));
    }
}
