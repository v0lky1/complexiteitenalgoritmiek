package Opdracht1.Methods;

public class SeqMinMax {

    public SeqMinMax(){

    }

    public int[] getResult(int[] toBeHandled) {

        int[] numbers = new int[2];

        numbers[0] = Integer.MAX_VALUE;
        numbers[1] = Integer.MIN_VALUE;

        for (int i = 0; i < toBeHandled.length; i++) {
            if (toBeHandled[i] < numbers[0]) {
                numbers[0] = toBeHandled[i];
            }
            if (toBeHandled[i] > numbers[1]) {
                numbers[1] = toBeHandled[i];

            }
        }

        System.out.println("Min: " + numbers[0] + "\nMax: " + numbers[1]);
        return numbers;
    }
}
