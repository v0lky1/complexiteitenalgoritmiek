package Opdracht2;

public interface DoubleEndedPriorityQueue {
    void add(int toBeAdded);


    int removeLow();

    int removeMax();

    int size();

    boolean isEmpty();

    int getLow();

    int getHigh();
}