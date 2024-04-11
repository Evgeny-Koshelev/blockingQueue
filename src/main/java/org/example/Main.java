package org.example;



public class Main {
    public static void main(String[] args) {

        BlockingQueue queue = new BlockingQueue();

        for(int i =0; i< 20; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(queue.dequeue());
                    System.out.println(queue.size());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread thread2 = new Thread(() -> {
                try {
                    queue.enqueue("STR");
                    System.out.println("Was enqueue STR");
                    System.out.println(queue.size());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
            thread2.start();
        }

    }
}