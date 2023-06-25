package org.adt.core.adt.implementation.TPO;

import java.util.ArrayList;
import java.util.List;

public class QueueOfStacks implements IQueue {

    private final List<Stack> stacks;
    private final int stackSize;

    public QueueOfStacks(int stackSize) {
        this.stacks = new ArrayList<>();
        this.stackSize = stackSize;
    }

    @Override
    public void add(int a) {
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).isFull()) {
            stacks.add(new Stack());
        }
        stacks.get(stacks.size() - 1).add(a);
    }

    @Override
    public void remove() {
        if (stacks.isEmpty()) {
            System.out.println("Error, no se puede desacolar una cola vacía.");
            return;
        }
        stacks.get(0).remove();
        if (stacks.get(0).isEmpty()) {
            stacks.remove(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return stacks.isEmpty();
    }

    @Override
    public int getFirst() {
        if (stacks.isEmpty()) {
            System.out.println("Error, no se puede obtener el primero de una cola vacía.");
            return -1;
        }
        return stacks.get(0).getTop();
    }

    public static int calcularTraza(QueueOfStacks queueOfStacks) { //complejidad O(n)
        int traza = 0;
        int stackIndex = 0;
        int elementIndex = 0;

        while (stackIndex < queueOfStacks.getStacks().size() && elementIndex < queueOfStacks.getStackSize()) {
            Stack stack = queueOfStacks.getStacks().get(stackIndex);
            if (elementIndex < stack.getCount()) {
                int element = stack.getElement(elementIndex);
                traza += element;
            }
            stackIndex++;
            elementIndex++;
        }

        return traza;
    }

    public static QueueOfStacks obtenerTraspuesta(QueueOfStacks queueOfStacks) {//Complejidad:  O(n^2)
        QueueOfStacks traspuesta = new QueueOfStacks(queueOfStacks.getStackSize());

        for (int i = 0; i < queueOfStacks.getStackSize(); i++) {
            for (int j = 0; j < queueOfStacks.getStacks().size(); j++) {
                Stack stack = queueOfStacks.getStacks().get(j);
                traspuesta.add(stack.getElement(i));
            }
        }

        return traspuesta;
    }

    public static QueueOfStacks sumarMatrices(QueueOfStacks matriz1, QueueOfStacks matriz2) {//complejidad O(n^2)
        QueueOfStacks suma = new QueueOfStacks(matriz1.getStackSize());

        for (int i = 0; i < matriz1.getStackSize(); i++) {
            for (int j = 0; j < matriz1.getStacks().size(); j++) {
                Stack stack1 = matriz1.getStacks().get(j);
                Stack stack2 = matriz2.getStacks().get(j);
                int elemento1 = stack1.getElement(i);
                int elemento2 = stack2.getElement(i);
                suma.add(elemento1 + elemento2);
            }
        }

        return suma;
    }


}

