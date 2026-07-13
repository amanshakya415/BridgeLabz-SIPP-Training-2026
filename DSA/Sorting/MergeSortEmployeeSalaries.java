// 1. Merge Sort – Employee Salaries
// Problem Statement
// A company stores employee salaries in an unsorted array. The HR department wants to
// generate a report where salaries are arranged in ascending order for analysis.
// You are required to implement the Merge Sort algorithm to sort the salaries. You are not allowed
// to use any built-in sorting functions.
// Input Format
// ● First line contains an integer N — number of employees
// ● Second line contains N integers representing salaries
// Output Format
// ● Print the sorted salaries in ascending order
// Constraints
// ● 1 ≤ N ≤ 10^5
// ● 0 ≤ salary ≤ 10^9
// Example
// Input :- 6
// [45000 32000 78000 55000 40000 60000]
// Output
// [32000 40000 45000 55000 60000 78000]
package DSA.Sorting;

public class MergeSortEmployeeSalaries {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case: array is already sorted
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copy data to left and right subarrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Recursively sort the subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted subarrays
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two subarrays while maintaining order
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy any remaining elements from either subarray
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
