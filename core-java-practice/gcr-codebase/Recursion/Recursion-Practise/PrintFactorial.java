public class PrintFactorial {
    public static void main(String[] args) {
        int number = 5; 
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }

    public static int factorial(int n) {
        // Base case: if n is 0 or 1, return 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive call: n! = n * (n-1)!
        return n * factorial(n - 1);
    }
}
