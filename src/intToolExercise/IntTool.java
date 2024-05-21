package intToolExercise;

public class IntTool {
    private int number;

    // Constructor to initialize the state
    public IntTool(int number) {
        this.number = number;
    }

    // Main method to test the class functionality
    public static void main(String[] args) {
        IntTool tool = new IntTool(12345);

        System.out.println("Digit Sum: " + tool.digitSum()); // Should print 15
        System.out.println("Last Digit: " + tool.lastDigit()); // Should print 5
        try {
            System.out.println("Digit at position 2: " + tool.digitAt(2)); // Should print 3
            System.out.println("Digit at position 5: " + tool.digitAt(5)); // Should throw exception
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }

        // Testing with a negative number
        IntTool negativeTool = new IntTool(-12345);
        System.out.println("Digit Sum (negative): " + negativeTool.digitSum()); // Should print 15
        System.out.println("Last Digit (negative): " + negativeTool.lastDigit()); // Should print 5
        try {
            System.out.println("Digit at position 2 (negative): " + negativeTool.digitAt(2)); // Should print 3
            System.out.println("Digit at position 5 (negative): " + negativeTool.digitAt(5)); // Should throw exception
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }

    // Method to return the sum of its digits
    public int digitSum() {
        int sum = 0;
        int tempNumber = number < 0 ? -number : number; // Handle negative numbers
        while (tempNumber > 0) {
            sum += tempNumber % 10;
            tempNumber /= 10;
        }
        return sum;
    }

    // Method to return the last digit
    public int lastDigit() {
        return number < 0 ? -(number % 10) : number % 10; // Handle negative numbers
    }

    // Method to return the digit at a specified position
    // The position is 0-based from the right (0 = last digit)
    public int digitAt(int position) {
        int tempNumber = number < 0 ? -number : number; // Handle negative numbers
        int length = String.valueOf(tempNumber).length();

        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        for (int i = 0; i < position; i++) {
            tempNumber /= 10;
        }
        return tempNumber % 10;
    }
}
