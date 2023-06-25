package org.uade.algo2.ejercicio02.generics;

public interface IQueueGeneric<T> {

    public void add(T a);
    public void remove();
    public boolean isEmpty();
    public T getFirst();

}
