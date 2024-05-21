package birthYearErrorHandling;

import java.util.Scanner;

public class BirthYearApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int age = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Please input your age: ");
                age = Integer.parseInt(scanner.nextLine());
                BirthYearCalculator yearCalculator = new BirthYearCalculator(age);
                int birthYear = yearCalculator.calculateBirthYear();
                System.out.println("The birth year is " + birthYear);
                validInput = true;

            } catch (InvalidAgeException ageException) {
                System.out.println(ageException.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
