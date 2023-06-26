package coreVer2.adt.algorithms;

import coreVer2.adt.definition.IStack;
import coreVer2.adt.implementation.normal.Stack;

public class StackAlgorithms {

    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }

    public static IStack copy(IStack stack) {
        IStack copy = (IStack) new Stack();
        IStack aux = (IStack) new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            copy.add(aux.getTop());
            aux.remove();
        }
        return copy;
    }

    public static void revert(IStack stack) {
        IStack aux = (IStack) new Stack();
        IStack aux2 = (IStack) new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            aux2.add(aux.getTop());
            aux.remove();
        }
        while (!aux2.isEmpty()) {
            stack.add(aux2.getTop());
            aux2.remove();
        }
    }

}
