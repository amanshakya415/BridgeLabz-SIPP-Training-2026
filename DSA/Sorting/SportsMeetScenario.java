
import java.util.*;

public class SportsMeetScenario {

    static int bubbleSort(int[] arr) {
        int swaps = 0;
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean passSwap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swaps++;
                    passSwap = true;
                }
            }
            if (!passSwap) {
                break;
            }
            sorted = false;
        }
        System.out.println("Already Sorted? " + (swaps == 0));
        return swaps;
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void traceBubble(int[] a) {
        System.out.println("Trace:");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] scores = {50, 95, 77, 88, 60, 99, 84};
        int[] b = scores.clone();
        int swaps = bubbleSort(b);
        System.out.println("Bubble Sorted=" + Arrays.toString(b));
        System.out.println("Swaps=" + swaps);
        int[] ins = scores.clone();
        insertionSort(ins);
        System.out.println("Insertion Sorted=" + Arrays.toString(ins));
        System.out.println("Top3=" + ins[ins.length - 1] + ", " + ins[ins.length - 2] + ", " + ins[ins.length - 3]);
        traceBubble(new int[]{64, 25, 12, 22, 11});
    }
}
