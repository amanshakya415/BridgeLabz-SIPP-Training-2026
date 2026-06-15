import java.util.Scanner;
public class createSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the original string: ");
        String originalString = sc.nextLine();

        System.out.print("Enter the start index for substring: ");
        int startIndex = sc.nextInt();

        System.out.print("Enter the end index for substring: ");
        int endIndex = sc.nextInt();

        String substringUsingCharAt = createSubstringUsingCharAt(originalString, startIndex, endIndex);
        String substringUsingBuiltIn = originalString.substring(startIndex, endIndex);

        boolean comparisonResult = compareStrings(substringUsingCharAt, substringUsingBuiltIn);

        System.out.println("Substring using charAt(): " + substringUsingCharAt);
        System.out.println("Substring using built-in method: " + substringUsingBuiltIn);
        System.out.println("Are both substrings equal? " + comparisonResult);
    }

    // Create substring using charAt from start (inclusive) to end (exclusive)
    public static String createSubstringUsingCharAt(String s, int start, int end) {
        if (s == null) return null;
        if (start < 0) start = 0;
        if (end > s.length()) end = s.length();
        if (start >= end) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Compare two strings using charAt
    public static boolean compareStrings(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}
