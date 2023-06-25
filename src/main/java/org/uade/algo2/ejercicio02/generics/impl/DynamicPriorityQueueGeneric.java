package org.uade.algo2.ejercicio02.generics.impl;


import org.uade.algo2.ejercicio02.generics.IPriorityQueueGeneric;

public class DynamicPriorityQueueGeneric<T> implements IPriorityQueueGeneric<T> {

    private PriorityNode first;

    @Override
    public void add(T a, int priority) {
        if(this.first == null) {
            this.first = new PriorityNode(a, priority,null);
            return;
        }
        PriorityNode candidate = this.first;
        while(candidate.getNext() != null && candidate.getPriority() > priority) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new PriorityNode(a, priority,candidate.getNext()));
    }

    @Override
    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public T getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return null;
        }
        return (T) this.first.getValue();
    }

    @Override
    public int getPriority() {
        if(this.first == null) {
            System.out.println("No se puede obtener la prioridad del primero una cola vacia");
            return -1;
        }
        return this.first.getPriority();
    }

}
