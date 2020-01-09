package Opdracht2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
            new Opdracht2.Main().run();
    }

    private void run() {
        DoubleEndedPriorityQueue queue = new DoubleEndedPriorityQueue();

        System.out.println(queue.size());
        queue.add(5);
        System.out.println(queue.size());
        System.out.println(queue.getLow());
        System.out.println(queue.getHigh());
        queue.add(3);
        System.out.println(queue.size());
        System.out.println(queue.getLow());
        System.out.println(queue.getHigh());
        queue.add(8);
        queue.add(11);
        System.out.println(queue.size());
        System.out.println(queue.getLow());
        System.out.println(queue.getHigh());

    }
}
