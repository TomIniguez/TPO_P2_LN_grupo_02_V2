package org.uade.algo2.ejercicio02.generics.impl;

import org.uade.algo2.ejercicio02.generics.ISetGeneric;

import java.util.Random;

public class DynamicSetGeneric<T> implements ISetGeneric<T> {

    private NodeGeneric first;
    private int count;

    @Override
    public void add(T a) { // N * C
        if(this.first == null) { // C
            this.first = new NodeGeneric(a, null); // C
            count++;
            return;
        }

        if(this.first.getValue() == a) { // C
            return;
        }

        NodeGeneric candidate = this.first; // C
        while(candidate.getNext() != null) { // N * C
            candidate = candidate.getNext(); // C
            if(candidate.getValue() == a) { // C
                return;
            }
        }
        candidate.setNext(new NodeGeneric(a, null)); // C
        this.count++; // C
    }

    @Override
    public void remove(T a) {
        if(this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if(this.first != null && this.first.getNext() == null) {
            this.first = null;
            this.count--;
            return;
        }

        NodeGeneric backup;
        NodeGeneric candidate = this.first;
        while(candidate.getNext() != null) {
            backup = candidate;
            candidate = candidate.getNext();
            if(candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T choose() {
        if(this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        NodeGeneric candidate = this.first;
        for(int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return (T) candidate.getValue();
    }

}
