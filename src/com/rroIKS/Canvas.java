package com.rroIKS;

import java.util.*;
import java.util.function.UnaryOperator;

public class Canvas implements List<Shape> {

    private static final int INITIALIZE = 5;
    private static final int INCREMENT = 2;
    private int size = INITIALIZE;
    Shape[] collection;

    public Canvas() {
        collection = new Shape[INITIALIZE];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < collection.length; i++) {
            if(!(collection[i]==null))
            sb.append(collection[i]);
        }
        return sb.toString();
    }

    @Override
    public boolean add(Shape shape) {
        int index = 0;
        if (collection.length == size) {
            increaseSize();
        }
        for (int i = 0; i < collection.length; i++) {
            if(collection[i]==null) {
                index=i;
                break;
            }
        }
        add(index, shape);
        return true;
    }


    @Override
    public void clear() {
        for (int i = 0; i < collection.length; i++) {
           collection[i]=null;
            }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Shape s = (Shape) o;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i].isEqualTo(s)) {
                return true;
            }
        }
        return false;
    }

    private void increaseSize(){
        size += INCREMENT;
        collection = Arrays.copyOf(collection,size);
    }

    boolean removeAllNullElements() {
        boolean allInstancesRemoved;
        do {
            allInstancesRemoved = !removeFirstNullElement();
        }
        while (allInstancesRemoved == false);
        return allInstancesRemoved;
    }

    boolean removeFirstNullElement() {
        int counterSecondList = 0;
        Shape[] secondList = new Shape[collection.length - 1];
        boolean removedNullOnceAlready = false;
        for (int i = 0; i < collection.length; i++)
            if (counterSecondList < secondList.length) {
                if (!(collection[i] == null)) {
                    secondList[counterSecondList] = collection[i];
                    counterSecondList++;
                }
                removedNullOnceAlready = true;
            }
        collection = secondList;
        return removedNullOnceAlready;
    }

    boolean removeFirstInstanceOf(Shape s) {
        int counterSecondList = 0;
        Shape[] secondList = new Shape[collection.length - 1];
        boolean removedObjectOnceAlready = false;
        for (int i = 0; i < collection.length; i++)
            if (counterSecondList < secondList.length) {
                if ((!collection[i].isEqualTo(s)) && !(collection[i] == null)) {
                    secondList[counterSecondList] = collection[i];
                    counterSecondList++;
                }
                else if ((s.isEqualTo(collection[i]))) {
                    if (!removedObjectOnceAlready) {
                        removedObjectOnceAlready = true;
                    }
                    else {
                        secondList[counterSecondList] = collection[i];
                        counterSecondList++;
                    }
                }
            }
        collection = secondList;
        return removedObjectOnceAlready;
    }

    @Override
    public boolean remove(Object o) {
        Shape s = (Shape) o;
        boolean allInstancesRemoved;
        do {
            allInstancesRemoved = !removeFirstInstanceOf(s);
        }
        while (allInstancesRemoved == false);

        return allInstancesRemoved;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Shape> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Shape> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<Shape> operator) {

    }

    @Override
    public void sort(Comparator<? super Shape> c) {

    }

    @Override
    public Shape get(int index) {
        return null;
    }

    @Override
    public Shape set(int index, Shape element) {
        return null;
    }

    @Override
    public void add(int index, Shape element) {
        collection[index] = element;
    }

    @Override
    public Shape remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Shape> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Shape> listIterator(int index) {
        return null;
    }

    @Override
    public List<Shape> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<Shape> spliterator() {
        return null;
    }

    @Override
    public Iterator<Shape> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }






}
