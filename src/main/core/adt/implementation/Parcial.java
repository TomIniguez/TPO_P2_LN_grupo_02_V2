package org.adt.core.adt.implementation;


import org.adt.core.adt.implementation.normal.Dictionary;
import org.adt.core.adt.implementation.normal.PriorityQueue;
import org.adt.core.adt.implementation.normal.Set;

public class Parcial {
    public static void main(String[] args) {

    }

    public static PriorityQueue joinPQueues(PriorityQueue a, PriorityQueue b){//Costo O**2, porque son dos loops
        PriorityQueue junta = new PriorityQueue();
        int valor = 0;
        int prio = 0;

        while(!a.isEmpty()){
            valor = a.getFirst();
            prio = a.getPriority();
            junta.add(valor, prio);
            a.remove();
        }

        while(!b.isEmpty()){
            valor = b.getFirst();
            junta.add(valor, (prio*2 + b.getPriority()));
            b.remove();
        }

        return junta;
    }

    public static boolean DiferentesValores(Dictionary a, Dictionary b){//Costo Lineal
        //Verifica si el conjunto de llaves de ambos diccionarios son iguales o no
        Set llavesA = new Set();
        Set llavesB = new Set();

        int llave = 0;

        while(!a.isEmpty() || !b.isEmpty()){
            llave = a.getKeys().choose();
            llavesA.add(llave);
            a.remove(llave, a.getValue(llave));
            llave = b.getKeys().choose();
            llavesB.add(llave);
            b.remove(llave, b.getValue(llave));
        }

        return(!llavesA.equals(llavesB));
    }
}
