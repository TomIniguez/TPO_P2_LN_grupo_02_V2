package org.adt.core.adt.implementation.TPO;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOfQueue<T> {
    private Queue<Queue<T>> queueOfQueue;

    public QueueOfQueue() {
        queueOfQueue = new LinkedList<>();
    }

    public void enqueue(Queue<T> queue) {
        queueOfQueue.add(queue);
    }

    public Queue<T> concatenate() {
        Queue<T> concatenatedQueue = new LinkedList<>();
        for (Queue<T> queue : queueOfQueue) {
            concatenatedQueue.addAll(queue);
        }
        return concatenatedQueue;
    }

    public Queue<T> flat() {
        Queue<T> flatQueue = new LinkedList<>();
        for (Queue<T> queue : queueOfQueue) {
            flatQueue.addAll(queue);
        }
        return flatQueue;
    }

    public void reverseWithDepth() {
        Queue<Queue<T>> reversedQueueOfQueue = new LinkedList<>();
        while (!queueOfQueue.isEmpty()) {
            Queue<T> queue = queueOfQueue.poll();
            Queue<T> reversedQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                reversedQueue.add(queue.poll());
            }
            reversedQueueOfQueue.add(reversedQueue);
        }
        queueOfQueue = reversedQueueOfQueue;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        QueueOfQueue<Integer> queueOfQueue = new QueueOfQueue<>();

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queueOfQueue.enqueue(queue1);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);
        queueOfQueue.enqueue(queue2);

        Queue<Integer> queue3 = new LinkedList<>();
        queue3.add(7);
        queue3.add(8);
        queue3.add(9);
        queueOfQueue.enqueue(queue3);

        Queue<Integer> concatenatedQueue = queueOfQueue.concatenate();
        System.out.println("Concatenated Queue: " + concatenatedQueue);

        Queue<Integer> flatQueue = queueOfQueue.flat();
        System.out.println("Flat Queue: " + flatQueue);

        queueOfQueue.reverseWithDepth();
        System.out.println("Reversed Queue of Queue: " + queueOfQueue.queueOfQueue);
    }
}