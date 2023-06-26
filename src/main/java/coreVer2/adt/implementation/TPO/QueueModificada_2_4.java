package coreVer2.adt.implementation.TPO;

import coreVer2.adt.definition.IQueue;

import java.util.Arrays;
public class Queue implements IQueue {

    private final int[] array;
    private int count;

    public Queue(int... elements) {
        this.array = Arrays.copyOf(elements, elements.length + 10000);
        this.count = elements.length;
    }

    @Override
    public void add(int a) {
        int[] newArray = Arrays.copyOf(array, count + 1);
        newArray[count] = a;
        array = newArray;
        count++;
    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return -1;
        }
        return this.array[0];
    }
}