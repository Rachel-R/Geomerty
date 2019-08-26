package com.rroIKS;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeometryHelperTest {

    @Test
    public void checkAreFloatsEqual() {
        float f1 = (float) 0.7 + 0.0000099f;
        float f2 = (float) 0.7;
        assertTrue(GeometryHelper.areFloatsEqual(f1, f2));
    }

    @Test
    public void checkAreFloatsEqualNotEqual() {
        float f1 = (float) 1;
        float f2 = (float) 1 + 0.00001f;
        assertFalse(GeometryHelper.areFloatsEqual(f1, f2));
    }

    @Test
    public void checkIsFloat1LessThanFloat2() {
        float f1 = (float) 1;
        float f2 = (float) 1.7;
        assertTrue(GeometryHelper.isFloat1LessThanFloat2(f1, f2));
    }

    @Test
    public void checkIsFloat1LessThanFloat2NotLess() {
        float f1 = (float) 1;
        float f2 = (float) 0.7;
        assertFalse(GeometryHelper.isFloat1LessThanFloat2(f1, f2));
    }

    @Test
    public void checkSort() {
        Point[] points = new Point[]{
                new Point(6, -1),
                new Point(3, 6),
                new Point(7, 6),
                new Point(7, -1),
                new Point(7, 8)};

        GeometryHelper.sort(points);
    }
}
