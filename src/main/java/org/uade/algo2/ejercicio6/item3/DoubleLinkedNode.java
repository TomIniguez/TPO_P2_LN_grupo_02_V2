package org.uade.algo2.ejercicio6.item3;

import org.uade.algo2.ejercicio6.Node;

import java.util.Objects;

public class DoubleLinkedNode {

    private int value;
    private DoubleLinkedNode next;
    private DoubleLinkedNode previous;

    public DoubleLinkedNode(int value, DoubleLinkedNode next, DoubleLinkedNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode next) {
        this.next = next;
    }

    public DoubleLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedNode previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
    }

}
