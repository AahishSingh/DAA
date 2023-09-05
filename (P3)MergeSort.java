import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    static final int MAX = 200000;
    static int[] a = new int[MAX];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Max array size: ");
        int n = input.nextInt();
        Random random = new Random();

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            // a[i] = input.nextInt(); // for keyboard entry
            a[i] = random.nextInt(100000);
            System.out.print(a[i] + " ");
        }

        long startTime = System.nanoTime();
        mergeSortAlgorithm(0, n - 1);
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;

        System.out.println("\nTime Complexity (ms) for n = " + n + " is : " + (double) elapsedTime / 1000000);
        System.out.println("Sorted Array (Merge Sort):");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        input.close();
    }

    public static void mergeSortAlgorithm(int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSortAlgorithm(low, mid);
            mergeSortAlgorithm(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {
        int[] b = new int[MAX];
        int i, h, j, k;
        h = i = low;
        j = mid + 1;
        
        while ((h <= mid) && (j <= high)) {
            if (a[h] < a[j])
                b[i++] = a[h++];
            else
                b[i++] = a[j++];
        }
        
        if (h > mid) {
            for (k = j; k <= high; k++) {
                b[i++] = a[k];
            }
        } else {
            for (k = h; k <= mid; k++) {
                b[i++] = a[k];
            }
        }
        
        for (k = low; k <= high; k++) {
            a[k] = b[k];
        }
    }
}
