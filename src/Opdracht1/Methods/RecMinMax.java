package Opdracht1.Methods;

import java.util.Arrays;

public class RecMinMax {

    public RecMinMax(){

    }

    public int[] getResult(int[] toBeHandled) {

        int[] numbers = new int[2];

        if (toBeHandled.length == 1){
            numbers[0] = toBeHandled[0];
            numbers[1] = toBeHandled[0];
        } else if (toBeHandled.length == 2) {
            numbers[0] = toBeHandled[0];
            numbers[1] = toBeHandled[1];
        } else {
            int firstHalf[] = Arrays.copyOfRange(toBeHandled, 0, toBeHandled.length/2);
            int secondHalf[] = Arrays.copyOfRange(toBeHandled, (toBeHandled.length/2), toBeHandled.length);

            if (findMin(firstHalf, 0) < findMin(secondHalf, 0)) {
                numbers[0] = findMin(firstHalf, 0);
            } else {
                numbers[0] = findMin(secondHalf, 0);
            }

            if (findMax(firstHalf, 0) > findMax(secondHalf, 0)) {
                numbers[1] = findMax(firstHalf, 0);
            } else {
                numbers[1] = findMax(secondHalf, 0);
            }
        }
        System.out.println("Min: " + numbers[0] + "\nMax: " + numbers[1]);
        return numbers;
    }

    public int findMin(int half[], int start){
        if (start == half.length) {
            return half[0];
        }
        return Math.min(half[start],findMin(half, start+1));
    }

    public int findMax(int half[], int start) {
        if (start == half.length) {
            return half[0];
        }
        return Math.max(half[start],findMax(half, start+1));
    }

}
