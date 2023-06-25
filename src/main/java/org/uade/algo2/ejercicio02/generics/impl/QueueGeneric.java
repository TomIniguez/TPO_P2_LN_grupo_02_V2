package org.uade.algo2.ejercicio02.generics.impl;


import org.uade.algo2.ejercicio02.generics.IQueueGeneric;

public class QueueGeneric<T> implements IQueueGeneric<T> {

    private NodeGeneric first;

    public QueueGeneric(){
        this.first = null;
    }

    @Override
    public void add(T a) {
        NodeGeneric node = new NodeGeneric(a, null);
        if (this.first == null){
            this.first = node;
            return;
        }
        NodeGeneric candidate = this.first;//c
        while(candidate.getNext() != null){ // N :no es constante, se ejecuta tantas veces como elementos haya
            candidate = candidate.getNext(); //c
        }
        candidate.setNext(node); //c
    }

    @Override
    public void remove() {
        if (this.first.getNext() == null){
            this.first = null;
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public T getFirst() {
        return (T) this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
