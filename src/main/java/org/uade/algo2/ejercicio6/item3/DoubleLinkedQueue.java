package org.uade.algo2.ejercicio6.item3;

public class DoubleLinkedQueue implements IQueue{

    private DoubleLinkedNode first;
    private int count;

    @Override
    public void add(int a) {
        DoubleLinkedNode node = new DoubleLinkedNode(a, null, null);
        if (this.first == null) {
            this.first = node;
            this.count++;
            return;
        }
        DoubleLinkedNode candidate = this.first;
        int cont = 0;
        while (cont < this.count - 1) {
            candidate = candidate.getNext();
            cont++;
        }
        node.setPrevious(candidate);
        node.setNext(this.first);
        candidate.setNext(node);
        this.first.setPrevious(node);
        this.count++;
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        DoubleLinkedNode candidate = this.first;
        int cont = 0;
        while (cont < this.count - 1) {
            candidate = candidate.getNext();
            cont++;
        }
        System.out.println(candidate.getValue());
        candidate.setNext(this.first.getNext());
        this.first.getNext().setPrevious(candidate);
        this.first = this.first.getNext();
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        if (this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return this.first.getValue();
    }

}
