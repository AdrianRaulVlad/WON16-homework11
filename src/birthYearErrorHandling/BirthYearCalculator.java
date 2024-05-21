package birthYearErrorHandling;

import java.time.Year;

public class BirthYearCalculator {
    private int age;

    public BirthYearCalculator (int age) throws InvalidAgeException {
        if (age <= 0 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is invalid!");
        }
        this.age = age;
    }

    public int calculateBirthYear() {
        int currentYear = Year.now().getValue();
        return currentYear - age;
    }
}
