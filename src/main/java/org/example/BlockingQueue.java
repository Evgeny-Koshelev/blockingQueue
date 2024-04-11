package org.example;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List queue = new LinkedList();

    public synchronized void enqueue(Object object) throws InterruptedException {
        int limit = 10;
        while (queue.size() == limit) {
            System.out.println("BLOCK en");
            wait();
        }
        notifyAll();
        queue.add(object);


    }

    public synchronized  Object dequeue() throws InterruptedException {
        while (queue.isEmpty()){
            System.out.println("BLOCK de");
            wait();
        }

        notifyAll();
        return queue.remove(0);

    }

    public Integer size() {
        return queue.size();
    }
}
