// An astronomer has 10M sorted star-brightness entries. Binary search for a
// target in O(log n). Extend: search in rotated catalog (telescope glitch
// scrambled it), find first and last occurrence of a repeated brightness value,
// and find the minimum element.
package DSA.BinarySearch.ScenarioBased;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] sorted = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int firstIndex = findFirstOccurrence(sorted, target);
        int lastIndex = findLastOccurrence(sorted, target);
        System.out.println("Sorted array: first occurrence of " + target + ": " + firstIndex);
        System.out.println("Sorted array: last occurrence of " + target + ": " + lastIndex);

        // Classic binary search on sorted array
        int bsIndex = binarySearch(sorted, 3);
        System.out.println("Binary search: index of 3 => " + bsIndex);

        // Rotated array examples
        int[] rotated = {4,5,6,7,0,1,2};
        int rotatedTarget = 0;
        int rotatedIndex = searchInRotated(rotated, rotatedTarget);
        System.out.println("Rotated array: index of " + rotatedTarget + " => " + rotatedIndex);

        // Find minimum in rotated array
        int min = findMinInRotated(rotated);
        System.out.println("Minimum in rotated array => " + min);
    }

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Search in the left half
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Search in the right half
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return result;
    }

    // Standard binary search (works on sorted arrays)
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Search target in a rotated sorted array in O(log n)
    public static int searchInRotated(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;

            // If left half is sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right half is sorted
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // Find minimum element in a rotated sorted array in O(log n)
    public static int findMinInRotated(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array must be non-empty");
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }
}