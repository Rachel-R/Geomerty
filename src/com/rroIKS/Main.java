package com.rroIKS;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int in = 0;

        Point pointIn;
        Line lineIn;
        Circle circleIn;
        Triangle triangleIn;
        Rectangle rectangleIn;
        Square squareIn;

        //List<Shape> canvas = new ArrayList<>();
        List<Shape> canvas = new Canvas();

        do {
            System.out.println("Please create a new Object of type Shape.");
            System.out.println("1. Create a point.");
            System.out.println("2. Create a line.");
            System.out.println("3. Create a circle.");
            System.out.println("4. Create a triangle.");
            System.out.println("5. Create a rectangle.");
            System.out.println("6. Create a square.");
            System.out.println("7. Print Canvas");
            System.out.println("8. Clear Canvas");
            System.out.println("9. Quit");
            System.out.println("\n");
            System.out.print("Please choose from 1 to 9: \n");

            try {
                in = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("An error occurred.");
                continue;
            }

            if (in == 1) {
                System.out.println("Please enter an x-coordinate: ");
                float x =(Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter a y-coordinate: ");
                float y =(Float.parseFloat(scanner.nextLine()));
                pointIn = new Point (x,y);
                canvas.add(pointIn);

            } else if (in == 2) {
                System.out.println("Your line will be defined using two points.");
                System.out.println("Please enter the x-coordinate of the first point: ");
                float x1 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the first point: ");
                float y1 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the x-coordinate of the second point: ");
                float x2 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the second point: ");
                float y2 =(Float.parseFloat(scanner.nextLine()));
                lineIn = new Line (x1,y1,x2,y2);
                canvas.add(lineIn);

            } else if (in == 3) {
                System.out.println("Your circle will be defined using the center point and the radius.");
                System.out.println("Please enter the x-coordinate of the center point: ");
                float xCoordinate = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the center point: ");
                float yCoordinate = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the radius: ");
                float radius = (Float.parseFloat(scanner.nextLine()));
                circleIn = new Circle(xCoordinate,yCoordinate,radius);
                canvas.add(circleIn);

            } else if (in == 4) {
                System.out.println("Your triangle will be defined using three vertices.");
                System.out.println("Please enter the x-coordinate of the first vertex: ");
                float x1 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the first vertex: ");
                float y1 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the x-coordinate of the second vertex: ");
                float x2 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the second vertex: ");
                float y2 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the x-coordinate of the third vertex: ");
                float x3 = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the third vertex: ");
                float y3 = (Float.parseFloat(scanner.nextLine()));
                triangleIn = new Triangle(x1,y1,x2,y2,x3,y3);
                canvas.add(triangleIn);

            } else if (in == 5) {
                System.out.println("Your rectangle will be defined using the center point, the height and the width.");
                System.out.println("Please enter the x-coordinate of the center point: ");
                float x = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the center point: ");
                float y = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the height: ");
                float h = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the width: ");
                float w = (Float.parseFloat(scanner.nextLine()));
                rectangleIn = new Rectangle(x,y,h,w);
                canvas.add(rectangleIn);

            } else if (in == 6) {
                System.out.println("Your square will be defined using the center point and the side length.");
                System.out.println("Please enter the x-coordinate of the center point: ");
                float x = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the y-coordinate of the center point: ");
                float y = (Float.parseFloat(scanner.nextLine()));
                System.out.println("Please enter the side length: ");
                float s = (Float.parseFloat(scanner.nextLine()));
                squareIn = new Square(x,y,s);
                canvas.add(squareIn);

            } else if (in == 7) {
                System.out.println("Canvas printout: \n" + canvas.toString());

            } else if (in == 8) {
                canvas.clear();
                System.out.println("\n");

            } else {
                if (in < 1 | in > 9) {
                    System.out.print("Invalid input. \n");
                    System.out.print("\n");
                }
            }
        }
        while (in != 9);
    }
}

