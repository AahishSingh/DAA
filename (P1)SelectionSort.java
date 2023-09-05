import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static int[] generateRandomNumbers(int n) {
        int[] nums = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = rand.nextInt(10000); // Generates numbers between 0 and 9999
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nValues = { 5000, 10000, 15000, 20000, 25000 };
        long[] timeTaken = new long[nValues.length];

        for (int i = 0; i < nValues.length; i++) {
            int n = nValues[i];
            int[] arr = generateRandomNumbers(n);
            long startTime = System.nanoTime();
            selectionSort(arr);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
            timeTaken[i] = duration;
            System.out.println("Time taken to sort " + n + " elements: " + duration + " milliseconds");
        }
    }
}
