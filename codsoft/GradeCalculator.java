import java.util.Scanner;

class GradeCal {
    public String calculateGrade(int averageMarks) {
        switch (averageMarks / 10) {
            case 10:
                return "A+";
            case 9:
                return "A";
            case 8:
                return "B+";
            case 7:
                return "B";
            case 6:
                return "C";
            case 5:
                return "D";
            default:
                return "F";
        }
    }
}

public class GradeCalculator{
    public static void main(String[] args) {
        GradeCal gradeCalculator = new GradeCal();
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of subjects
        System.out.println("Enter the number of subjects");
        int totalSubjects = scanner.nextInt();
        int totalMarks = 0;

        // Taking and adding all the marks
        for (int i = 0; i < totalSubjects; i++) {
            System.out.println("Enter the marks obtained in subject " + (i + 1));
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        // Calculating the average percentage
        int averageMarks = totalMarks / totalSubjects;

        // Calculating the grade
        String grade = gradeCalculator.calculateGrade(averageMarks);

        // Displaying all the data
        System.out.println("-----------------------");
        System.out.println("        RESULTS        ");
        System.out.println("-----------------------");
        System.out.println("Total marks obtained: " + totalMarks);
        System.out.println("Percentage obtained: " + averageMarks + "%");
        System.out.println("Grade obtained: " + grade);
        System.out.println("-----------------------");

        scanner.close();
    }
}