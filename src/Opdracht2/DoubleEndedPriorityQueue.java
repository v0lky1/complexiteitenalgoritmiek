package Opdracht2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public interface DoubleEndedPriorityQueue {
    void add(int toBeAdded);

    void minHeapInsert();

    void maxHeapInsert();

    int removeLow();

    int removeMax();

    int size();

    boolean isEmpty();

    int getLow();

    int getHigh();
}