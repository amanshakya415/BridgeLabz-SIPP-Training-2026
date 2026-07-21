
import java.util.*;

public class InsertionSortArray {

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

    public static void main(String[] args) {
        int[] nums = {12, 11, 13, 5, 6};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
