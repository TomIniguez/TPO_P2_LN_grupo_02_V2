package org.uade.algo2.ejercicio02.generics.impl;

public class NodeGeneric<T>  {

    private T value;
    private NodeGeneric next;

    public NodeGeneric(T value, NodeGeneric next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeGeneric getNext() {
        return next;
    }

    public void setNext(NodeGeneric next) {
        this.next = next;
    }
}
