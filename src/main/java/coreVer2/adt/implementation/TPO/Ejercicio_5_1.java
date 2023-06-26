package coreVer2.adt.implementation.TPO;

import coreVer2.adt.definition.IStack;
import coreVer2.adt.implementation.dynamic.node.Node;

public class Stack5_1 implements IStack {

    private Node first;

    @Override
    public void add(int a) {
        this.first = new Node(a, this.first);
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacía");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope de una pila vacía");
            return -1;
        }
        return this.first.getValue();
    }

    public Stack getUniqueSortedStack() { //Complejidad total: O(n^2)
        Stack5_1 originalStack = new Stack5_1();
        Stack5_1 newStack = new Stack5_1();

        // Copiar elementos de la pila original a una pila auxiliar   Complejidad: O(n)
        while (!isEmpty()) {
            originalStack.add(getTop());
            remove();
        }

        // Ordenar la pila original en orden ascendente
        originalStack = sortStack(originalStack);

        // Agregar elementos únicos a la nueva pila en orden ascendente Complejidad: O(n)
        int prevElement = -1;
        while (!originalStack.isEmpty()) {
            int currentElement = originalStack.getTop();
            originalStack.remove();

            if (currentElement != prevElement) {
                newStack.add(currentElement);
                prevElement = currentElement;
            }
        }

        // Invertir la nueva pila para tener orden descendente
        newStack = reverseStack(newStack);

        return newStack;
    }

    // Método para ordenar una pila en orden ascendente utilizando otro Stack auxiliar Complejidad:O(n^2)
    private Stack5_1 sortStack(Stack5_1 stack) {
        Stack5_1 sortedStack = new Stack5_1();

        while (!stack.isEmpty()) {
            int temp = stack.getTop();
            stack.remove();

            while (!sortedStack.isEmpty() && sortedStack.getTop() > temp) {
                stack.add(sortedStack.getTop());
                sortedStack.remove();
            }

            sortedStack.add(temp);
        }

        return sortedStack;
    }

    // Método para invertir el orden de una pila utilizando otro Stack auxiliar Complejidad: O(n)
    private Stack5_1 reverseStack(Stack5_1 stack) {
        Stack5_1 reversedStack = new Stack5_1();

        while (!stack.isEmpty()) {
            reversedStack.add(stack.getTop());
            stack.remove();
        }

        return reversedStack;
    }
}
