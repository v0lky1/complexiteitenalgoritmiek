package Opdracht1;

import Opdracht1.Methods.MinMaxer;
import Opdracht1.Methods.RecMinMax;
import Opdracht1.Methods.SeqMinMax;
import Opdracht1.Methods.SortedMinMax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    PrintWriter writer = new PrintWriter("measurements.txt", StandardCharsets.UTF_8);


    public Main() throws IOException {
    }

    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() {

        boolean quit = false;

        while (!quit) {
            int[] configs = setup();
            ArrayList<Integer> randomList = createList(configs[0]);
            ArrayList<MinMaxer> minMaxerList = new ArrayList<>();

            SortedMinMax sortedMinMax = new SortedMinMax();
            SeqMinMax seqMinMax = new SeqMinMax();
            RecMinMax recMinMax = new RecMinMax();
            minMaxerList.add(recMinMax);
            minMaxerList.add(seqMinMax);
            minMaxerList.add(sortedMinMax);

            if (configs[2] == 1) {
                //Sorted Min Max
                System.out.println(output(sortedMinMax, configs, randomList));
            } else if (configs[2] == 2) {
                //Seq Min Max
                System.out.println(output(seqMinMax, configs, randomList));

            } else if (configs[2] == 3) {
                //Rec Min Max
                System.out.println(output(recMinMax, configs, randomList));

            } else if (configs[2] == 0) {
                quit = true;
            } else if (configs[2] == 4) {
                //set amount of runs for option 4
                configs[1] = 10;
                int[] numbers = {5_000, 10_000, 50_000, 100_000, 500_000, 1_000_000, 5_000_000, 10_000_000, 50_000_000, 100_000_000};
                for (MinMaxer minMaxer : minMaxerList) {
                    System.out.println("\n\n*******" + minMaxer.toString().toUpperCase() + "*******\n\n");

                    for (int number : numbers) {
                        System.out.println("******* ELEMENTS: " + number + " *******\n");
                        configs[0] = number;
                        randomList = createList(configs[0]);
                        System.out.println(output(minMaxer, configs, randomList));
                    }
                }

            }
            writer.close();
        }
    }

    /**
     * setting initial configurations for the assignment,
     * configs contains 3 numbers, [0] being the length of the array
     * and [1] being the amount of runs
     * [2] has been added for the select menu
     *
     * @return configurations.
     */
    public int[] setup() {
        int[] configs = new int[3];
        System.out.println("Select the algorithm you want to test: ");
        System.out.println("1) SortedMinMax \n" +
                "2) SeqMinMax\n" +
                "3) RecMinMax\n" +
                "4) Run the entire assignment\n" +
                "0) Quit");

        System.out.print("\nYour entry: ");
        configs[2] = scanner.nextInt();

        //if user selected quit.
        if (configs[2] == 0 || configs[2] == 4) {
            return configs;
        }

        System.out.print("Select the length of the array: ");
        configs[0] = scanner.nextInt();
        System.out.print("Amount of runs: ");
        configs[1] = scanner.nextInt();
        System.out.println("-----------------------------------------");
        System.out.println("ARRAYSIZE: " + configs[0]);
        System.out.println("RUNS: " + configs[1]);
        writer.println("Array size: " + configs[0]);
        writer.println("Amount of runs: " + configs[1] + "\n");
        System.out.println("------------------START------------------");

        return configs;
    }

    private ArrayList<Integer> createList(int arrayLength) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            int toBeAdded = (int) (Math.random() * Integer.MAX_VALUE);
            list.add(toBeAdded);
        }
        return list;
    }

    private String output(MinMaxer minMaxer, int[] configs, ArrayList<Integer> toBeHandled) {
        ArrayList<Long> avgDurations = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < configs[1]; i++) {

            Instant begin = Instant.now();
            List<Integer> minMax = minMaxer.getResult(toBeHandled);
            Instant end = Instant.now();

            Duration duration = Duration.between(begin, end);
            avgDurations.add(duration.toMillis());


            result.append("Run number: ").append(i + 1).append("\t \t Time: ").append(duration.toMillis()).append("ms \n");
            result.append("Min: ").append(minMax.get(0)).append("\n").append("Max: ").append(minMax.get(1)).append("\n");
            if (configs[1] != i + 1) {
                result.append("***\n");
            }
        }

        //sorting the timeframes and deleting the lowest and highest values for more accurate
        //average running time
        Collections.sort(avgDurations);
        if (avgDurations.size() > 2) {
            avgDurations.remove(avgDurations.size() - 1);
            avgDurations.remove(0);
        }


        //calculate the average time
        long averageTime = 0;
        for (Long number : avgDurations) {
            averageTime += number;
        }
        averageTime = averageTime / avgDurations.size();

        result.append("^^^^^^^^^^^^^^^^^^END^^^^^^^^^^^^^^^^^^\n");
        result.append(minMaxer.toString()).append("\t\t Time: ").append(averageTime).append("ms\n");
        result.append("---------------------------------------");


        writer.println(result.toString());
        return result.toString();
    }
}
