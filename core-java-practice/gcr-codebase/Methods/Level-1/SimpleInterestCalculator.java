import java.util.*;
public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter Principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = sc.nextDouble();

        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return principal * rate * time / 100;
    }
}
