package Opdracht2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Opdracht2.Main().run();
    }

    private void run() {
        IntervalHeap queue = new IntervalHeap();
        Scanner listener = new Scanner(System.in);
        buildMethodsMenu();
        while (true) {
            System.out.println("Enter your choice: (1=add, 2=removehigh, 3=removelow, 4=currmax, 5=currmin, 6=currsize, 7=isEmpty?)");

            int myChoice = listener.nextInt();

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
            } else if(myChoice == 5){
                System.out.println("Current min value is: " + queue.getLow());
            } else if(myChoice == 6){
                System.out.println("Current queue size is: " + queue.size());
            } else if (myChoice ==7){
                System.out.println("List is empty?: " + queue.isEmpty());
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
