package org.uade.algo2.ejercicio02.generics.impl;


import org.uade.algo2.ejercicio02.generics.IStackGeneric;

public class StackGeneric <T> implements IStackGeneric<T> {

    private NodeGeneric first;

    public StackGeneric() {
        this.first = null;
    }

    public void add(T a){ //Complejidad: N
        NodeGeneric node = new NodeGeneric(a, null);//c
        if(this.first == null){//c
            this.first = node;//c
            return;
        }
        NodeGeneric candidate = this.first;//c
        while(candidate.getNext() != null){ // N :no es constante, se ejecuta tantas veces como elementos haya
            candidate = candidate.getNext(); //c
        }
        candidate.setNext(node); //c
    }

    public void remove(){
        if(this.first.getNext() == null){
            this.first = null;
            return;
        }
        NodeGeneric anteultimo = this.first; //es el back up, voy a necesiatr que este apunte a null
        NodeGeneric candidate = this.first.getNext();
        while(candidate.getNext() != null){
            anteultimo = candidate;
            candidate = candidate.getNext();
        }
        anteultimo.setNext(null);
    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public T getTop(){
        if(this.first.getNext() == null){
            return (T) this.first.getValue();
        }
        NodeGeneric candidate = this.first;
        while(candidate.getNext() != null){
            candidate = candidate.getNext();
        }
        return (T) candidate.getValue();
    }

}
