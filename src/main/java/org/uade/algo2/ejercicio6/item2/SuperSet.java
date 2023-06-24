package org.uade.algo2.ejercicio6.item2;

import org.uade.algo2.ejercicio6.Node;

import java.util.Objects;
import java.util.Random;

public class SuperSet implements ISuperSet {

    private Node first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            return;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                return;
            }
        }
        candidate.setNext(new Node(a, null));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Node backup = this.first;
        Node candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }

    @Override
    public boolean isSubset(ISuperSet set) {
        ISuperSet aux = new SuperSet();
        boolean subset = true;
        while(!set.isEmpty()) {
            int element = set.choose();
            if(!in(this, element)) {
                subset = false;
                break;
            }
            aux.add(element);
            set.remove(element);
            this.remove(element);
        }
        if(this.isEmpty()) {
            subset = false;
        }
        while(!aux.isEmpty()) {
            int element = aux.choose();
            set.add(element);
            this.add(element);
            aux.remove(element);
        }
        return subset;
    }

    /*
    * Precondicion: el set que se pasa por parametro debe ser un subset de this
    * */
    @Override
    public ISuperSet complement(ISuperSet set) {
        ISuperSet aux = new SuperSet();
        ISuperSet complement = new SuperSet();
        while(!this.isEmpty()){
            int elem = this.choose();
            if(!in(set, elem)){
                complement.add(elem);
            }
            aux.add(elem);
            this.remove(elem);
        }
        while(!aux.isEmpty()){
            int elem = aux.choose();
            this.add(elem);
            aux.remove(elem);
        }
        return complement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperSet set = (SuperSet) o;
        return count == set.count && Objects.equals(first, set.first);
    }

    private static boolean in(ISuperSet a, int element) {
        ISuperSet aux = new SuperSet();
        boolean exists = false;
        while(!a.isEmpty()) {
            int value = a.choose();
            if(element == value) {
                exists = true;
                break;
            }
            aux.add(value);
            a.remove(value);
        }

        while(!aux.isEmpty()) {
            int value = aux.choose();
            a.add(value);
            aux.remove(value);
        }
        return exists;
    }
}