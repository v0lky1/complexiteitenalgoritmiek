package Opdracht2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IntervalHeap implements DoubleEndedPriorityQueue {

    private List<Node> list = new ArrayList<>();
    private int elementsAmount;

    public void add(int integerToBeAdded) {
        // If the last node already has two elements create a new node.
        if (size() % 2 == 0) {
            list.add(new Node(integerToBeAdded, -1));
            // else, add this integerToBeAdded to the last node
        } else {
            Node lastNode = list.get(list.size() - 1);
            if (lastNode.getMin() < integerToBeAdded) {
                lastNode.setMax(integerToBeAdded);
            } else {
                lastNode.setMax(lastNode.getMin());
                lastNode.setMin(integerToBeAdded);
            }
        }
        elementsAmount++;

        // If there is only one node, no need to min/maxheapinsert
        if (size() <= 2) {
            return;
        }

        Node parentNode = list.get((list.size() - 1) / 2);
        if (parentNode.getMin() > integerToBeAdded) {
            minHeapInsert();
        } else if (parentNode.getMax() < integerToBeAdded) {
            maxHeapInsert();
        }
    }

    public void minHeapInsert() {
        int index = list.size() - 1;
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

    public void maxHeapInsert() {
        int index = list.size() - 1;
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

    public int removeMax() {
        int max = getHigh();

        if (size() == 1) {
            list.remove(0);
            elementsAmount--;
            return max;
        }

        Node lastNode = list.get(list.size() - 1);

        /*Getting the attribute from the last node
        and giving it to the first node
        after this we should bubble it down to the correct spot in the tree.*/

        if (size() % 2 == 1) {
            list.get(0).setMax(lastNode.getMin());
            list.remove(list.size() - 1);
        } else {
            list.get(0).setMax(lastNode.getMax());
            lastNode.setMax(-1);
        }
        elementsAmount--;


        int index = 0;
        Node currentNode = list.get(index);

        while (true) {
            //if true node has no child and we're done bubbling
            if (index * 2 >= list.size()) {
                break;
            }

            int childIndex;

            //If true, currentNode has two children
            if (index * 2 + 1 < list.size()) {
                //if true second child has no max attribute and is last node
                //if false child has max attribute.
                if (size() % 2 == 1 && index * 2 + 1 == list.size() - 1) {
                    //if true, max of child 1 is smaller than the min of second child.

                    if (list.get(index * 2).getMax() < list.get(index * 2 + 1).getMin()) {
                        childIndex = index * 2 + 1;
                    } else {
                        childIndex = index * 2;
                    }

                } else if (list.get(index * 2).getMax() < list.get(index * 2 + 1).getMax()) {
                    childIndex = index * 2 + 1;
                } else {
                    childIndex = index * 2;
                }
            } else {
                childIndex = index * 2;
            }

            //We start bubbling <;-)

            Node highestChildNode = list.get(childIndex);
            //if true highestchild has no max
            if (highestChildNode.getMax() == -1) {

                 /* if true, the max of currentNode is less than the min of it's highest child attribute
                 so switch them with each other to establish a good interval heap.
                 if the child doesn't exceed the max of our currentNode the bubbling has been completed.*/

                if (currentNode.getMax() < highestChildNode.getMin()) {
                    int temp = currentNode.getMax();
                    currentNode.setMax(highestChildNode.getMin());
                    highestChildNode.setMin(temp);

                } else {
                    break;
                }
                 /* if true, the max of currentNode is less than the max of it's highest child attribute
                 if the child doesn't exceed the max of our currentNode the bubbling has been completed.*/
            } else if (currentNode.getMax() < highestChildNode.getMax()) {
                int temp = currentNode.getMax();
                currentNode.setMax(highestChildNode.getMax());
                highestChildNode.setMax(temp);
                if (highestChildNode.getMin() > highestChildNode.getMax()) {
                    int temp1 = highestChildNode.getMax();
                    highestChildNode.setMax(highestChildNode.getMin());
                    highestChildNode.setMin(temp1);
                }
            } else {
                break;
            }
            index = childIndex;
            currentNode = highestChildNode;
        }
        return max;
    }

    public int size() {
        return elementsAmount;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getLow() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return list.get(0).getMin();
    }

    public int getHigh() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty**");
        }
        if (size() == 1) {
            return list.get(0).getMin();
        } else {
            return list.get(0).getMax();
        }
    }
}