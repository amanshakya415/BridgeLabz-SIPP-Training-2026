public class UsernameValidator {
    public static void main(String[] args) {
        String username1 = "abcdxyz";
        String username2 = "abcD123";

        System.out.println("Username '" + username1 + "' is valid: " + isValidUsername(username1, 0));
        System.out.println("Username '" + username2 + "' is valid: " + isValidUsername(username2, 0));
    }

    public static boolean isValidUsername(String username, int index) {
        // Base case: if we've reached the end of the string, return true
        if (index == username.length()) {
            return true;
        }
        // Check if the current character is a lowercase letter
        if (username.charAt(index) < 'a' || username.charAt(index) > 'z') {
            return false;
        }
        // Recursive call with the next index
        return isValidUsername(username, index + 1);
    }
}
