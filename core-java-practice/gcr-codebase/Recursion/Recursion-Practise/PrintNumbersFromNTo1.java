public class PrintNumbersFromNTo1 {
    public static void main(String[] args) {
        int N = 5; 
        printNumbers(N);
    }

    public static void printNumbers(int N) {
        if (N < 1) {
            return;
        }
        System.out.print(N + " ");
        // Recursive call with N decremented by 1
        printNumbers(N - 1);
    }
}