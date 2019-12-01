package Opdracht1.Methods;

import java.util.ArrayList;
import java.util.List;

public class SortedMinMax implements MinMaxer {
    public SortedMinMax() {
    }

    public List<Integer> getResult(List<Integer> list) {

        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            for (int j = 1; j < list.size(); j++) {

                if (list.get(j - 1) > list.get(j)) {
                    Integer temp = list.get(j - 1);

                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        returnList.add(list.get(0));
        returnList.add(list.get(list.size() - 1));

        return returnList;
    }

    @Override
    public String toString() {
        return "SortedMinMax";
    }
}