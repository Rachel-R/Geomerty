package com.rroIKS;

public class Square extends Rectangle {

    Square(Point a, Point b, Point c, Point d){
        super(a, b, c, d);
        if(!GeometryHelper.areFloatsEqual((getLowerLeft().distanceTo(getLowerRight())),
                (getLowerLeft().distanceTo(getUpperLeft())))){
            throw new ArithmeticException("Error. Not a square.");
        }
    }

    Square (float xCenter, float yCenter,float side) {
        super(xCenter,yCenter,side,side);
    }

    public String toString(){
        return "Square with a side length of : "+getHeight()+" and its center at " +
                "("+this.getCenter().getXCoordinate()+"/"+this.getCenter().getYCoordinate()
                +").";
    }
}
