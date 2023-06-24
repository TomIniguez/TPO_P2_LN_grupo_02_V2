package org.uade.algo2.ejercicio6.item4;

import org.uade.algo2.ejercicio6.Node;

import java.util.Objects;

public class NodeRepeatedSet {

    private Pair value;
    private NodeRepeatedSet next;

    public NodeRepeatedSet(Pair value, NodeRepeatedSet next) {
        this.value = value;
        this.next = next;
    }

    public Pair getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value.setValue(value);
    }

    public NodeRepeatedSet getNext() {
        return this.next;
    }

    public void setNext(NodeRepeatedSet next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeRepeatedSet node = (NodeRepeatedSet) o;
        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
    }

}
