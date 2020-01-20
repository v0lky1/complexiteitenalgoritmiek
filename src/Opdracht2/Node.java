package Opdracht2;

public class Node {
    private static int counter = 0;
    private int min;
    private int max;

    public Node(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return " [min: "+min + " | max: " +max + "] \n";
    }
}
