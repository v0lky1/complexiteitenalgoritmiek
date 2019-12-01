package Opdracht1.Methods;

import java.util.ArrayList;

import java.util.List;

public class RecMinMax implements MinMaxer {

    public RecMinMax() {

    }

    public List<Integer> getResult(List<Integer> toBeHandled) {
        ArrayList<Integer> result = new ArrayList<>();

        //setting defaults
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if (toBeHandled.size() <= 2) {
            if (toBeHandled.size() == 1) {
                min = toBeHandled.get(0);
                max = toBeHandled.get(0);
            } else {
                min = Math.min(toBeHandled.get(0), toBeHandled.get(1));
                max = Math.max(toBeHandled.get(0), toBeHandled.get(1));
            }
        }
        //We hebben meer dan 2 getallen
        List<Integer> firstHalf = toBeHandled.subList(0, toBeHandled.size() / 2);
        List<Integer> secondHalf = toBeHandled.subList(toBeHandled.size() / 2, toBeHandled.size());

        return result;
    }

    public List<Integer> getMax(List<Integer> numbers) {

        if (numbers.size() == 1) {
            return numbers;

        } else if (numbers.get(0) > numbers.get(1)) {
            numbers.remove(numbers.get(1));

        } else {
            numbers.remove(numbers.get(0));
        }

        return getMax(numbers);
    }

    @Override
    public String toString() {
        return "RecMinMax";
    }
}
