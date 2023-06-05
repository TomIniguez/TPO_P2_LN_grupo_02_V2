package org.adt.core.adt.implementation.TPO;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.dynamic.node.Node;

public class DynamicStackLimited implements IStack {

    private Node first;
    private int sizeMax;
    private int tam;
    public DynamicStackLimited(int size){
        this.sizeMax = size;
        this.tam = 0;
    }

    public boolean maxSize(){
        return (tam == sizeMax);
    }
    @Override
    public void add(int a) {
        if(maxSize()){
            System.out.println("La Pila esta llena");
        }else {
            this.first = new Node(a, this.first);
            tam++;
        }
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
        tam--;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            return -1;
        }
        return this.first.getValue();
    }
}
