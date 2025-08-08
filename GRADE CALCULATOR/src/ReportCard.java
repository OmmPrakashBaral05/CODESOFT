import java.util.Scanner;

public class ReportCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how many subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store marks
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Validate marks
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                System.out.print("Re-enter marks for Subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }

            totalMarks += marks[i];
        }

        // Calculate percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Calculate grade
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display Results
        System.out.println("\n----- Result -----");
        System.out.println("Total Marks Obtained: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
