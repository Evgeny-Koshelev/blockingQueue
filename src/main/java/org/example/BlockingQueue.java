package org.example;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List queue = new LinkedList();
    private final int limit = 10;

    public synchronized void enqueue(Object object) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(object);

    }

    public Object dequeue() throws InterruptedException {
        while (queue.size() == 0){
            wait();
        }
        if (this.queue.size() == this.limit){
            notifyAll();
        }

        return queue.remove(0);

    }

    public Integer size() {
        return queue.size();
    }
}
