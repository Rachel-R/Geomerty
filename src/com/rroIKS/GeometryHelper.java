package com.rroIKS;

public class GeometryHelper {

    static final double DELTA = 1E-5;

    static boolean areFloatsEqual(float f1, float f2) {
        return Math.abs(f1 - f2) < DELTA;
    }

    static boolean isFloat1LessThanFloat2(float f1, float f2) {
        return f1 + DELTA <= f2;
    }

    static Point[] sort(Point[] points) {
        Point temp;
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < points.length - i; j++) {
                if (points[j+1].isLowerOrEqualTo(points[j])) {
                    temp = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = temp;
                }
            }
        }
        return points;
    }
}
