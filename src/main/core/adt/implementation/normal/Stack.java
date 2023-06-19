package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IStack;

public class Stack implements IStack {

    private final int[] array;
    private int count;

    public Stack() {
        this.array = new int[10000];
        this.count = 0;
    }

    private Stack(Builder builder) {//Con builder
        this.array = builder.array;
        this.count = builder.count;
    }

    @Override
    public void add(int a) {
        this.array[this.count] = a;
        this.count++;
    }

    //Con builder
    public void addBuilder(int a) {
        int[] newArray = Arrays.copyOf(array, count + 1);
        newArray[count] = a;

        Stack.Builder builder = new Stack.Builder();
        builder.array(newArray);
        builder.count(count + 1);

        Stack newStack = builder.build();
        array = newStack.array;
        count = newStack.count;
    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacia");
            return;
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return -1;
        }
        return this.array[this.count - 1];
    }

    public static class Builder {
        private int[] array;
        private int count;

        public Builder() {
            this.array = new int[10000];
            this.count = 0;
        }

        public Builder array(int[] array) {
            this.array = array;
            return this;
        }

        public Builder count(int count) {
            this.count = count;
            return this;
        }

        public Stack build() {
            return new Stack(this);
        }
    }

}
