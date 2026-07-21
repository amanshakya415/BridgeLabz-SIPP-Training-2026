
import java.util.*;

public class BubbleSortSwapCount {

    static int bubbleSort(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        System.out.println("Swaps=" + bubbleSort(nums));
        System.out.println(Arrays.toString(nums));
    }
}
