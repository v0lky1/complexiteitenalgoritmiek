package Opdracht2;

public class Main {

    public static void main(String[] args) {
        new Opdracht2.Main().run();
    }

    private void run() {
        IntervalHeap queue = new IntervalHeap();

        System.out.println("Size: " + queue.size());
        queue.add(5);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " + queue.getHigh());
        queue.add(3);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " + queue.getHigh());
        queue.add(8);
        queue.add(11);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " + queue.getHigh());
        queue.add(18);
        queue.add(13);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.getLow());
        System.out.println("Max: " + queue.getHigh());
        System.out.println("Min: " + queue.removeLow());
        System.out.println("Min: " + queue.getLow());
        System.out.println("High: " + queue.removeMax());
        System.out.println("Size: " + queue.size());
        System.out.println("High: " + queue.removeMax());
        System.out.println("Size: " + queue.size());
        System.out.println("High: " + queue.removeMax());
        System.out.println("Size: " + queue.size());
        System.out.println("High: " + queue.removeMax());
        System.out.println("Size: " + queue.size());
        System.out.println("Removing max: " + queue.removeMax());
        System.out.println("Size: " + queue.size());
        System.out.println("List empty: " + queue.isEmpty());
    }
}
