package Opdracht1.Methods;

import java.util.ArrayList;
import java.util.List;

public class SeqMinMax implements MinMaxer {
    public SeqMinMax() {
    }

    public List<Integer> getResult(List<Integer> toBeHandled) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        ArrayList<Integer> minMax = new ArrayList<>();

        for (int i = 0; i < toBeHandled.size(); i++) {
            if (toBeHandled.get(i) < min) {
                min = toBeHandled.get(i);
            }
            if (toBeHandled.get(i) > max) {
                max = toBeHandled.get(i);
            }
        }

        minMax.add(min);
        minMax.add(max);

        return minMax;
    }

    @Override
    public String toString() {
        return "SeqMinMax";
    }
}
