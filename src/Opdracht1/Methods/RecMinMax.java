package Opdracht1.Methods;

import java.util.ArrayList;

import java.util.List;

public class RecMinMax implements MinMaxer {

    public RecMinMax() {

    }

    public List<Integer> getResult(List<Integer> toBeHandled) {
        List<Integer> result = new ArrayList<>();

        //setting defaults
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        //We hebben meer dan 2 getallen
        List<Integer> firstHalf = toBeHandled.subList(0, toBeHandled.size() / 2);
        List<Integer> secondHalf = toBeHandled.subList(toBeHandled.size() / 2, toBeHandled.size());

        int minFirstHalf = findMin(firstHalf);
        int minSecondHalf = findMin(secondHalf);
        int maxFirstHalf = findMax(firstHalf);
        int maxSecondHalf = findMax(secondHalf);

        result.add(Math.min(minFirstHalf, minSecondHalf));

        result.add(Math.max(maxFirstHalf, maxSecondHalf));

        return result;
    }

    public int findMax(List<Integer> list) {
        List<Integer> keep = new ArrayList<>();

        int first = list.get(0);
        int firstNumber = first;
        for (int number : list) {
            if (number > firstNumber) {
                firstNumber = number;
                keep.add(number);
            }
        }

        if (keep.size() == 0)
            return first;

        if (keep.size() == 1)
            return keep.get(0);

        return findMax(keep);
    }

    public int findMin(List<Integer> list) {
        List<Integer> keep = new ArrayList<>();

        int first = list.get(0);
        int firstNumber = first;
        for (int number : list) {
            if (number < firstNumber) {
                firstNumber = number;
                keep.add(number);
            }
        }

        if (keep.size() == 0)
            return first;

        if (keep.size() == 1)
            return keep.get(0);

        return findMin(keep);
    }

    @Override
    public String toString() {
        return "RecMinMax";
    }
}
