import java.util.*;
public class MaxNoOfHandshakes {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        int maxHandshakes = calculateMaxHandshakes(numberOfStudents);

        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is: " + maxHandshakes);
    }

    public static int calculateMaxHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }
}
