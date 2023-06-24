package org.uade.algo2.ejercicio6.item4;

public class Pair {

    private int value;
    private int cant;
    public Pair(int value, int cant){
        this.value = value;
        this.cant = cant;
    }
    public int getValue(){
        return this.value;
    }
    public int getCant(){
        return this.cant;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
