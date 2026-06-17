public class ConsecutiveReadingSensor {
    public static void main(String[] args) {
        int[] readings1 = {12, 15, 18, 22, 30};
        int[] readings2 = {12, 15, 14, 22};

        System.out.println("Readings 1 are strictly increasing: " + areReadingsIncreasing(readings1, 0));
        System.out.println("Readings 2 are strictly increasing: " + areReadingsIncreasing(readings2, 0));
    }

    public static boolean areReadingsIncreasing(int[] readings, int index) {
        if (index == readings.length - 1) {
            return true;
        }
        if (readings[index] >= readings[index + 1]) {
            return false;
        }
        return areReadingsIncreasing(readings, index + 1);
    }
}
