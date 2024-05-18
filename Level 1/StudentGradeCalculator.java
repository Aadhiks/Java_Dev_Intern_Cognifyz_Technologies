import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter the number of grades: ");
        int numGrades = scanner.nextInt();



        if (numGrades <= 0) {
            System.out.println("Please enter a valid number of grades.");
            return;
        }

        int sum=0;
        for (int i = 1; i <= numGrades; i++) {
            System.out.print("Enter grade " + i + ": ");
            int grade = scanner.nextInt();
            sum += grade;
        }


        double average = (double) sum / numGrades;

        System.out.println("The average grade is: " + average);


        scanner.close();
    }
}