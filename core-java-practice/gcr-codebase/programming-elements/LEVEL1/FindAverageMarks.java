public class FindAverageMarks {
    public static void main(String[] args) {
        int math_marks = 94;
        int physics_marks = 95;
        int chemistry_marks = 96;

        int total_marks = math_marks + physics_marks + chemistry_marks;
        float average_marks = total_marks / 3;

        System.out.println("Sam's average mark in PCM is: " + average_marks);
    }
}