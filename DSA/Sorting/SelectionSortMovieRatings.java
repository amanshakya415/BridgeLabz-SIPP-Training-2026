
import java.util.*;

public class SelectionSortMovieRatings {

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
        int[] ratings = {8, 5, 9, 7, 6, 10};
        selectionSort(ratings);
        System.out.println(Arrays.toString(ratings));
    }
}
