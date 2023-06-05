package org.adt.core.adt.implementation.dynamic.node;

import org.adt.core.adt.definition.IPriorityStack;
public class MultipleDictionaryNodeStack {

    private int key;
    private IPriorityStack value;
    private MultipleDictionaryNodeStack next;

    public MultipleDictionaryNodeStack(int key, IPriorityStack value, MultipleDictionaryNodeStack next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public IPriorityStack getValue() {
        return value;
    }

    public void setValue(IPriorityStack value) {
        this.value = value;
    }

    public MultipleDictionaryNodeStack getNext() {
        return next;
    }

    public void setNext(MultipleDictionaryNodeStack next) {
        this.next = next;
    }
}
