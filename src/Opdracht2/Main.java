package Opdracht2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
            new Opdracht2.Main().run();
    }

    private void run() {
        DoubleEndedPriorityQueue queue = new DoubleEndedPriorityQueue();

        System.out.println("Size: " + queue.size());
        queue.add(5);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " +queue.getHigh());
        queue.add(3);
        System.out.println("Size: " +queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " +queue.getHigh());
        queue.add(8);
        queue.add(11);
        System.out.println("Size: " +queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " +queue.getHigh());
        queue.add(18);
        queue.add(13);
        System.out.println("Size: " +queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " +queue.getHigh());
        System.out.println("Min: " + queue.removeLow());
        System.out.println("Min: " + queue.getLow());
    }
}
