package Opdracht1;

import Opdracht1.Methods.RecMinMax;
import Opdracht1.Methods.SeqMinMax;
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
        SeqMinMax seqMinMax = new SeqMinMax();
        RecMinMax recMinMax = new RecMinMax();

        int[] configs = setup();

        int[] randomList = createList(configs[0]);
        long avgDuration = 0;
        for (int i = 0; i < configs[1]; i++) {
            System.out.println("Run number: " + (i + 1));
            Instant begin = Instant.now();
            sortedMinMax.getResult(randomList);
            Instant end = Instant.now();
            Duration duration = Duration.between(begin, end);
            avgDuration += duration.toMillis();
            System.out.println("Time: " + duration.toMillis() + "ms \n");
        }
        System.out.println("sortedMinMax average time: " + avgDuration / configs[1] + "ms\n");

        avgDuration = 0;
        for (int i = 0; i < configs[1]; i++) {
            System.out.println("Run number: " + (i + 1));
            Instant begin = Instant.now();
            seqMinMax.getResult(randomList);
            Instant end = Instant.now();
            Duration duration = Duration.between(begin, end);
            avgDuration += duration.toMillis();
            System.out.println("Time: " + duration.toMillis() + "ms \n");
        }
        System.out.println("seqMinMax average time: " + avgDuration / configs[1] + "ms\n");

        avgDuration = 0;
        for (int i = 0; i < configs[1]; i++) {
            System.out.println("Run number: " + (i + 1));
            Instant begin = Instant.now();
            recMinMax.getResult(randomList);
            Instant end = Instant.now();
            Duration duration = Duration.between(begin, end);
            avgDuration += duration.toMillis();
            System.out.println("Time: " + duration.toMillis() + "ms \n");
        }
        System.out.println("recMinMax average time: " + avgDuration / configs[1] + "ms\n");

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
