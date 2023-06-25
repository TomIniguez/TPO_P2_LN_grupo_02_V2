package org.uade.algo2.ejercicio02.generics.impl;

public class PriorityNode<T> {

    private T value;
    private int priority;
    private PriorityNode next;

    public PriorityNode(T value, int priority, PriorityNode next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriorityNode getNext() {
        return next;
    }

    public void setNext(PriorityNode next) {
        this.next = next;
    }
}
