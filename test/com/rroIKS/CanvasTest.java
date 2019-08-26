package com.rroIKS;
import org.junit.Test;
import static org.junit.Assert.*;


public class CanvasTest {

    private void populateCanvas(Canvas c) {
        int i;
        for (i = 0; i < c.size(); i++) {
            c.collection[i] = new Point(2, i);
        }
    }

    @Test
    public void checkContainsAPoint(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        Point p = new Point (2,2);
        boolean result = canvas.contains(p);
        assertTrue(result);
    }

    @Test
    public void checkContainsAPointFalse(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        Point p = new Point (5,2);
        boolean result = canvas.contains(p);
        assertFalse(result);
    }

    @Test
    public void checkContainsALine(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        canvas.collection[4]= new Line(1,2,4,6);
        Line l = new Line (1,2,4,6);
        boolean result = canvas.contains(l);
        assertTrue(result);
    }

    @Test
    public void checkContainsACircle(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        canvas.collection[4]= new Circle(4,1,1);
        Circle c = new Circle(4,1,1);
        boolean result = canvas.contains(c);
        assertTrue(result);
    }

    @Test
    public void checkContainsATriangle(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        canvas.collection[4]= new Triangle(-4,-2,-1,3,3,1);
        Triangle t = new Triangle (-4,-2,-1,3,3,1);
        boolean result = canvas.contains(t);
        assertTrue(result);
    }

    @Test
    public void checkContainsARectangle(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        canvas.collection[4]= new Rectangle(new Point (-2,6),
                new Point (5,6),
                new Point (5, 0),
                new Point(-2,0));
        Rectangle rDuplicate = new Rectangle(new Point (-2,6),
                new Point (5,6),
                new Point (5, 0),
                new Point(-2,0));
        boolean result = canvas.contains(rDuplicate);
        assertTrue(result);
    }

    @Test
    public void checkContainsASquare(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        canvas.collection[4]= new Square(
                new Point(2,-2),
                new Point (5,-2),
                new Point(2,-5),
                new Point (5,-5));
        Square sDuplicate = new Square(
                new Point(2,-2),
                new Point (5,-2),
                new Point(2,-5),
                new Point (5,-5));
        boolean result = canvas.contains(sDuplicate);
        assertTrue(result);
    }

    @Test
    public void checkAdd(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        canvas.collection[4]= null;
        Square sDuplicate = new Square(
                new Point(2,-2),
                new Point (5,-2),
                new Point(2,-5),
                new Point (5,-5));
        canvas.add(sDuplicate);
        assertEquals(sDuplicate,canvas.collection[5]);
        assertEquals(7, canvas.collection.length);
    }

    @Test
    public void checkAddNullInTheBack(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        Square sDuplicate = new Square(
                new Point(2,-2),
                new Point (5,-2),
                new Point(2,-5),
                new Point (5,-5));
        canvas.add(sDuplicate);
        assertEquals(sDuplicate,canvas.collection[5]);
    }

    @Test
    public void checkRemoveATriangle(){
        Canvas canvas =new Canvas();
        populateCanvas(canvas);
        canvas.collection[2]= new Triangle(-4,-2,-1,3,3,1);
        Triangle t = new Triangle (-4,-2,-1,3,3,1);
        boolean result = canvas.removeFirstInstanceOf(t);
        assertTrue(result);
    }

    @Test
    public void checkRemoveFindFirstInstanceOfObject() {
        Canvas canvas = new Canvas();
        populateCanvas(canvas);
        boolean result = canvas.remove(new Point(2, 3));
        assertTrue(result);
    }

    @Test
    public void checkRemoveFirstInstanceOf() {
        Canvas canvas = new Canvas();
        populateCanvas(canvas);
        canvas.collection[4] = new Point (2,3);
        boolean result = canvas.removeFirstInstanceOf(new Point(2, 3));
        assertTrue(result);
    }

    @Test
    public void checkRemove(){
        Canvas canvas = new Canvas();
        populateCanvas(canvas);
        canvas.collection[4] = new Point (2,3);
        canvas.collection[1] = new Point (2,3);
        boolean result = canvas.remove(new Point(2, 3));
        assertTrue(result);
    }

    @Test
    public void checkRemoveFirstNullElements(){
        Canvas canvas = new Canvas();
        populateCanvas(canvas);
        canvas.collection[4] = null;
        canvas.collection[1] = null;
        boolean result = canvas.removeFirstNullElement();
        assertTrue(result);
    }

    @Test
    public void checkRemoveAllNullElements(){
        Canvas canvas = new Canvas();
        populateCanvas(canvas);
        canvas.collection[4] = null;
        canvas.collection[1] = null;
        boolean result = canvas.removeAllNullElements();
        assertTrue(result);
    }
}
