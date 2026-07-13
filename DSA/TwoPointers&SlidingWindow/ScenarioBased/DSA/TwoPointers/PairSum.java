public class PairSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 7;
        boolean result = hasPairWithSum(arr, target);
        System.out.println("Pair with sum " + target + ": " + result);
    }

    public static boolean hasPairWithSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
