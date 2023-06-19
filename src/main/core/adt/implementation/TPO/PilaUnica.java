package org.adt.core.adt.implementation.TPO;

import org.adt.core.adt.implementation.normal.Stack;

public class PilaUnica {
    public static Stack generarPila(Stack pila) {
        Stack pilaUnica = new Stack();
        Stack pilaAux = new Stack();

        // Eliminar elementos repetidos
        while (!pila.isEmpty()) {
            int numero = pila.getTop();
            if (pilaUnica.getTop != numero) {
                pilaUnica.add(numero);
            }
            pila.remove();
        }

        // Ordenar en orden descendente
        while (!pilaUnica.isEmpty()) {
            int numero = pilaUnica.getTop();
            if(pilaAux.getTop() > numero){
                pilaAux.add(numero);
                pilaUnica.remove();
            }//Falta terminar aa
        }

        return stack;
    }
}
