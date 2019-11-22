package Opdracht1;

import Opdracht1.Methods.SortedMinMax;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        SortedMinMax sortedMinMax = new SortedMinMax();

        int[] configs = setup();


        for (int i = 0; i < configs[1]; i++) {
            int[] randomList = createList(configs[0]);
            System.out.println("Run number: " + (i + 1));
            Instant begin = Instant.now();
            sortedMinMax.getResult(randomList);
            Instant end = Instant.now();

            Duration duration = Duration.between(begin, end);
            System.out.println("Time: " + duration.toMillis() + "ms \n");
        }

    }

    /**
     * setting initial configurations for the sorting,
     * configs contains 2 numbers, [0] being the length of the array
     * and [1] being the amount of runs
     *
     * @return
     */
    public int[] setup() {
        Scanner scanner = new Scanner(System.in);
        int[] configs = new int[2];
        System.out.print("Select the length of the array: ");
        configs[0] = scanner.nextInt();
        System.out.print("Amount of runs: ");
        configs[1] = scanner.nextInt();
        System.out.println();

        return configs;
    }

    public int[] createList(int arrayLength) {
        int[] list = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int toBeAdded = (int) (Math.random() * Integer.MAX_VALUE);
            list[i] = toBeAdded;
        }
        return list;
    }
}
