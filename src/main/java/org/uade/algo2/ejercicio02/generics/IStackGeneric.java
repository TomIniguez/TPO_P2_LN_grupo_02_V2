package org.uade.algo2.ejercicio02.generics;

public interface IStackGeneric<T> {

    /**
    * Precondition: solo se puede agregar un elemento si la pila esta inicializada.
    * Postcondition: el elemento se coloca como tope
    * @param a un numero entero
    * */
    public void add(T a);
    public void remove(); //elimina el elemento que esta por encima, el ultimo agregado

    /**
     * Pre: la pila debe esta inicializada
     * Post: se va a indicar si la pila esta vacia o no
     * @return true si la pila esta vacia y false si la pila tiene elementos
     */
    public boolean isEmpty();
    public T getTop(); // devuelve el ultimo elemento agregado


}
