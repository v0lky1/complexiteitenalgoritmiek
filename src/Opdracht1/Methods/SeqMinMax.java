package Opdracht1.Methods;

public class SeqMinMax {

    public SeqMinMax(){

    }

    public int[] seqMinMax(int[] toBeHandled) {
        int smallestNumber = Integer.MAX_VALUE;
        int biggestNumber = Integer.MIN_VALUE;

        int[] numbers = new int[2];
        //TODO what do we do with the return

        for (int i = 0; i < toBeHandled.length; i++) {
            if (toBeHandled[i] < smallestNumber) {
                numbers[0] = toBeHandled[i];
            }
            if (toBeHandled[i] > biggestNumber) {
                numbers[1] = toBeHandled[i];

            }
        }
        return numbers;
    }
}
