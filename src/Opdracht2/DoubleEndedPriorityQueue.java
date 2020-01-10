package Opdracht2;

import java.util.ArrayList;
import java.util.List;

public class DoubleEndedPriorityQueue {

    private List<Node> list = new ArrayList<>();
    private int elementsAmount;

    public DoubleEndedPriorityQueue() {
    }

    public void add(int element) {
        // If the last node already has two elements create a new node.
        if (size() % 2 == 0) {
            list.add(new Node(element, -1));
            // else, add this element to the last node
        } else {
            Node lastNode = list.get(list.size() -1);
            if (lastNode.getMin() < element) {
                lastNode.setMax(element);
            } else {
                lastNode.setMax(lastNode.getMin());
                lastNode.setMin(element);
            }
        }
        elementsAmount++;

        // If there is only one node, no need to min/maxheapinsert
        if (size() <= 2) {
            return;
        }

        Node daddyNode = list.get((list.size() -1) / 2);
        if (daddyNode.getMin() > element) {
            minHeapInsert();
        } else if (daddyNode.getMax() < element) {
            maxHeapInsert();
        }
    }

    public void minHeapInsert() {
        int index = list.size() -1;
        Node node = list.get(index);

        while (index > 0) {
            Node parentNode = list.get(index / 2);

            // If minimum element of parent node is smaller then there is no need to bubble up
            if (node.getMin() >= parentNode.getMin()) {
                break;
            }

            // If min element is lower than it's parent's min element
            int temp = node.getMin();
            node.setMin(parentNode.getMin());
            parentNode.setMin(temp);
            // Change index to index of parent node
            index = index / 2;
            // Setting node to parentnode
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

    public int removeLow() {
        int min = getLow();

        if (size() == 1) {
            list.remove(0);
            elementsAmount--;
            return min;
        }

        Node lastNode = list.get(list.size() - 1);
        list.get(0).setMin(lastNode.getMin());

        if (size() % 2 == 1) {
            list.remove(list.size() - 1);
        } else {
            lastNode.setMin(lastNode.getMax());
            lastNode.setMax(-1);
        }

        elementsAmount--;

        int index = 0;
        Node node = list.get(index);

        while (true) {

            if (index * 2 >= list.size()) {
                break;
            }

            int childIndex;

            if (index * 2 + 1 < list.size()) {
                if (list.get(index * 2).getMin() < list.get(2 * index + 1).getMin()) {
                    childIndex = index * 2;
                } else {
                    childIndex = index * 2 + 1;
                }
            } else {
                childIndex = index * 2;
            }

            Node childNode = list.get(childIndex);
            if (node.getMin() < childNode.getMin()) {
                break;
            }

            int temp = childNode.getMin();
            childNode.setMin(node.getMin());
            node.setMin(temp);

            if (childNode.getMax() != -1 && childNode.getMin() > childNode.getMax()) {
                temp = childNode.getMin();
                childNode.setMin(childNode.getMax());
                childNode.setMax(temp);
            }

            index = childIndex;
            node = childNode;
        }

        return min;
    }

    public int size() {
        return elementsAmount;
    }

    public boolean isEmpty() {
        return list.isEmpty();
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
