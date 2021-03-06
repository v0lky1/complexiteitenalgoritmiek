package Opdracht2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Opdracht2.Main().run();
    }

    private void run() {
        IntervalHeap queue = new IntervalHeap();
        Scanner listener = new Scanner(System.in);
        buildMethodsMenu();

        int[] testSample = new int[]{1, 1, 1, 2, 2, 2, 4, 4, 4};

        for (int i : testSample) {
            queue.add(i);
        }

        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < queue.list.size(); i++) {
                Node node = queue.list.get(i);
                sb.append("NODE: ").append(i).append(node);
            }

            System.out.println(sb.toString());
            System.out.println("Enter your choice: (1=add, 2=removehigh, 3=removelow, 4=currmax, 5=currmin, 6=currsize, 7=isEmpty?, 0=quit)");

            int myChoice = 0;

            try {
                myChoice = listener.nextInt();
            } catch (InputMismatchException ime) {
                System.err.println("That's not a valid choice!");
            }

            try {
                if (myChoice == 0) {
                    break;
                } else if (myChoice == 1) {
                    System.out.println("Number to add: ");
                    queue.add(listener.nextInt());
                } else if (myChoice == 2) {
                    System.out.println("Removing highest number: " + queue.removeMax());
                } else if (myChoice == 3) {
                    System.out.println("Removing lowest number: " + queue.removeLow());
                } else if (myChoice == 4) {
                    System.out.println("Current max value is: " + queue.getHigh());
                } else if (myChoice == 5) {
                    System.out.println("Current min value is: " + queue.getLow());
                } else if (myChoice == 6) {
                    System.out.println("Current queue size is: " + queue.size());
                } else if (myChoice == 7) {
                    System.out.println("List is empty?: " + queue.isEmpty());
                }
            } catch (NoSuchElementException nse) {
                System.err.println("Can't perform action! LIST SIZE: " + queue.size());
            }
        }
    }

    private void buildMethodsMenu() {
        System.out.println("***** METHODS ***** \n" +
                "What do you want to do?\n" +
                "1) Add a number \n" +
                "2) Remove the highest number \n" +
                "3) Remove the lowest number \n" +
                "4) Get the max value \n" +
                "5) Get the min value \n" +
                "6) Get the number of values \n" +
                "7) Check if list is empty \n" +
                "0) Exit");
    }
}
