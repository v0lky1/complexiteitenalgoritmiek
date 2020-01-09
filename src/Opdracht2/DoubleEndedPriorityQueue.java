package Opdracht2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DoubleEndedPriorityQueue {

    private List<Node> list = new ArrayList<>();
    private int numberOfElements;

    public DoubleEndedPriorityQueue() {
    }

    public void add(int element) {
        if (size() % 2 == 0) {
            list.add(new Node(element, -1));
        } else {
            Node lastNode = list.get(list.size() -1);
            if (lastNode.getMin() < element) {
                lastNode.setMax(element);
            } else {
                lastNode.setMax(lastNode.getMin());
                lastNode.setMin(element);
            }
        }

        numberOfElements++;

        if (size() <= 2) {
            return;
        }

        Node parent = list.get((list.size() -1) / 2);
        if (parent.getMin() > element) {
            minHeapInsert();
        } else if (parent.getMax() < element) {
            maxHeapInsert();
        }
    }

    public void minHeapInsert() {
        int index = list.size() -1;
        Node node = list.get(index);

        while (index > 0) {
            int parent = index / 2;
            Node parentNode = list.get(parent);

            if (node.getMin() >= parentNode.getMin()) {
                break;
            }

            int temp = node.getMin();
            node.setMin(parentNode.getMin());
            parentNode.setMin(temp);
            index = parent;
            node = parentNode;
        }
    }

    private void maxHeapInsert() {
        int index = list.size() -1;
        Node node = list.get(index);

        while (index > 0) {
            int parent = index / 2;
            Node parentNode = list.get(parent);

            if (node.getMax() == -1) {
                if (node.getMin() < parentNode.getMax()) {
                    break;
                }
                int temp = node.getMin();
                node.setMin(parentNode.getMax());
                parentNode.setMax(temp);

                index = parent;
                node = parentNode;
            } else {
                if (node.getMax() < parentNode.getMax()) {
                    break;
                }
                int temp = node.getMax();
                node.setMax(parentNode.getMax());
                parentNode.setMax(temp);

                index = parent;
                node = parentNode;
            }
        }
    }

    public int size() {
        return numberOfElements;
    }
    public int getLow() {
        return list.get(0).getMin();
    }

    public int getHigh() {
        if (size() == 1) {
            return list.get(0).getMin();
        } else {
            return list.get(0).getMax();
        }
    }





}
