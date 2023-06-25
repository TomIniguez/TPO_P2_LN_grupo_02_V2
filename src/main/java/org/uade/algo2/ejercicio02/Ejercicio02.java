package org.uade.algo2.ejercicio02;


import org.uade.algo2.ejercicio02.generics.ISetGeneric;
import org.uade.algo2.ejercicio02.generics.IStackGeneric;
import org.uade.algo2.ejercicio02.generics.impl.DynamicSetGeneric;
import org.uade.algo2.ejercicio02.generics.impl.StackGeneric;

public class Ejercicio02<T> {

    public static IStackGeneric invertirStackGenerico(StackGeneric stack){
        StackGeneric reversed = new StackGeneric();
        StackGeneric aux = new StackGeneric();
        while(!stack.isEmpty()){
            reversed.add(stack.getTop());
            aux.add(stack.getTop());
            stack.remove();
        }
        while(!aux.isEmpty()){
            stack.add(aux.getTop());
            aux.remove();
        }
        return reversed;
    }

    public static <T> ISetGeneric copy(ISetGeneric set){
        ISetGeneric copy = new DynamicSetGeneric<>();
        ISetGeneric aux = new DynamicSetGeneric<>();
        while(!set.isEmpty()){
            T elem = (T) set.choose();
            copy.add(elem);
            aux.add(elem);
            set.remove(elem);
        }
        while(!aux.isEmpty()){
            T elem = (T) aux.choose();
            set.add(elem);
            aux.remove(elem);
        }
        return copy;
    }







}
