package coreVer2.adt.implementation.normal;

import coreVer2.adt.definition.IPriorityStack;
public class PriorityStack implements IPriorityStack {

    private static final int LENGTH = 10000;

    private final int[] array;
    private final int[] priorities;
    private int count;

    public PriorityStack() {
        this.array = new int[LENGTH];
        this.priorities = new int[LENGTH];
        this.count = 0;
    }

    @Override
    public void add(int a, int priority) { //Complejidad Computacional O(n)
        int index = binarySearch(priority);

        for (int i = this.count; i > index; i--) {
            this.array[i] = this.array[i - 1];
            this.priorities[i] = this.priorities[i - 1];
        }

        this.array[index] = a;
        this.priorities[index] = priority;

        this.count++;
    }

    @Override
    public void remove() {//Complejidad Computacional O(1)
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacia");
            return;
        }
        this.count--;
    }

    private int binarySearch(int priority) {//Complejidad Computacional O(log n)
        int low = 0;
        int high = this.count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (this.priorities[mid] == priority) {
                return mid;
            } else if (this.priorities[mid] < priority) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    @Override
    public boolean isEmpty() {//Complejidad Computacional O(1)
        return this.count == 0;
    }

    @Override
    public int getTop() {//Complejidad Computacional O(1)
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una pila vacia");
            return -1;
        }
        return this.array[this.count - 1];
    }

    @Override
    public int getPriority() {//Complejidad Computacional O(1)
        if (count == 0) {
            System.out.println("Error, no se puede obtener la prioridad del primero de una pila vacia");
            return -1;
        }
        return this.priorities[this.count - 1];
    }
}
