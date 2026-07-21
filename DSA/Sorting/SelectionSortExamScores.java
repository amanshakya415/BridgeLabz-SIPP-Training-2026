
import java.util.*;

public class SelectionSortExamScores {

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }

    public static void main(String[] args) {
        int[] scores = {87, 56, 92, 61, 73};
        selectionSort(scores);
        System.out.println(Arrays.toString(scores));
    }
}
