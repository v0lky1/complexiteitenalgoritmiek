package Opdracht1.Methods;

public class SortedMinMax {
    public  SortedMinMax(){

    }


    public int[] getResult(int[] toBeHandled) {
        Integer temp;

        for (int i = 0; i < toBeHandled.length; i++) {

            for (int j = 1; j < toBeHandled.length; j++) {


                if (toBeHandled[j - 1] > toBeHandled[j]) {
                    temp = toBeHandled[j - 1];

                    toBeHandled[j - 1] = toBeHandled[j];
                    toBeHandled[j] = temp;
                }
            }
        }

        System.out.println("Min: " + toBeHandled[0] + "\nMax: " + toBeHandled[toBeHandled.length - 1]);
        return toBeHandled;
    }
}