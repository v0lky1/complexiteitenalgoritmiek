package Opdracht1;

import Opdracht1.Methods.MinMaxer;
import Opdracht1.Methods.RecMinMax;
import Opdracht1.Methods.SeqMinMax;
import Opdracht1.Methods.SortedMinMax;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int[] configs = setup();
        ArrayList<Integer> randomList = createList(configs[0]);

        SortedMinMax sortedMinMax = new SortedMinMax();
        SeqMinMax seqMinMax = new SeqMinMax();
        RecMinMax recMinMax = new RecMinMax();


        if (configs[2] == 1) {
            //Sorted Min Max
            System.out.println(output(sortedMinMax, configs, randomList));
        } else if (configs[2] == 2) {
            //Seq Min Max
            System.out.println(output(seqMinMax, configs, randomList));

        } else if (configs[2] == 3) {
            //Rec Min Max
            System.out.println(output(recMinMax, configs, randomList));

        }
    }

    /**
     * setting initial configurations for the assignment,
     * configs contains 3 numbers, [0] being the length of the array
     * and [1] being the amount of runs
     * [2] has been added for the select menu
     *
     * @return
     */
    public int[] setup() {
        Scanner scanner = new Scanner(System.in);
        int[] configs = new int[3];
        System.out.println("Select the algorithm you want to test: ");
        System.out.println("1) SortedMinMax \n" +
                "2) SeqMinMax\n" +
                "3) RecMinMax");
        System.out.print("\nYour entry: ");
        configs[2] = scanner.nextInt();
        System.out.print("Select the length of the array: ");
        configs[0] = scanner.nextInt();
        System.out.print("Amount of runs: ");
        configs[1] = scanner.nextInt();

        System.out.println("-----------------------------------------");
        System.out.println("ARRAYSIZE: " + configs[0]);
        System.out.println("RUNS: " + configs[1]);
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
        long avgDuration = 0;
        String result = "";

        for (int i = 0; i < configs[1]; i++) {


            Instant begin = Instant.now();
            List<Integer> minMax = minMaxer.getResult(toBeHandled);
            Instant end = Instant.now();


            Duration duration = Duration.between(begin, end);
            avgDuration += duration.toMillis();


            result += "Run number: " + (i + 1) + "\t \t \t Time: " + duration.toMillis() + "ms \n";
            result += "Min: " + minMax.get(0) + "\n" + "Max: " + minMax.get(1) + "\n*** \n";


        }
        result += "^^^^^^^^^^^^^^^^^^END^^^^^^^^^^^^^^^^^^\n";
        result += minMaxer.toString() + "\t\t\t Avg Time: " + avgDuration / configs[1] + "ms\n";
        result += "---------------------------------------";


        return result;
    }
}
