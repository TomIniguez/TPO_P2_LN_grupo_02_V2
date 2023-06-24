package org.uade.algo2.ejercicio6.item1;

import org.uade.algo2.ejercicio6.Node;

public class LimitedStack implements IStack{

    private Node first;
    private int limit;
    private int count = 0;

    public LimitedStack(int limit){
        this.limit = limit;
    }

    @Override
    public void add(int a) {
        if(this.count <= this.limit){
            this.first = new Node(a, this.first);
            this.count++;
        }else{
            System.out.println("Se ha alcanzado el limite de la pila. No se puede agregar mas elementos");
        }

    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
        this.count--;
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
