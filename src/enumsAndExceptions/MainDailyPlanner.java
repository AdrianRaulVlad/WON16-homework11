package enumsAndExceptions;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainDailyPlanner {
    public static void main(String[] args) {
        DailyPlanner planner = new DailyPlanner();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an option");
            System.out.println("1. Add an activity");
            System.out.println("2. Remove an activity");
            System.out.println("3. List all activities");
            System.out.println("4. End planning");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addActivity(scanner, planner);
                        break;
                    case 2:
                        removeActivity(scanner, planner);
                        break;
                    case 3:
                        listAllActivities(planner);
                        break;
                    case 4:
                        endPlanning(planner);
                        return; // Exit after ending planning
                    case 5:
                        System.out.println("Exiting application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NoActivityException | NoActivitiesForDayException exception) {
                System.err.println("Error: " + exception.getMessage());
            }
        }
    }

    private static void addActivity(Scanner scanner, DailyPlanner planner) {
        try {
            System.out.print("Day: ");
            String dayInput = scanner.nextLine().toUpperCase();
            Day day = Day.valueOf(dayInput);

            System.out.println("Activity: ");
            String activity = scanner.nextLine();

            planner.addActivity(day, activity);
            System.out.println("Activity added.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid day entered. Please enter a valid day.");
        }
    }

    private static void removeActivity(Scanner scanner, DailyPlanner planner) {
        try {
            System.out.print("Day: ");
            String dayInput = scanner.nextLine().toUpperCase();
            Day day = Day.valueOf(dayInput);

            System.out.print("Activity: ");
            String activity = scanner.nextLine();

            planner.removeActivity(day, activity);
            System.out.println("Activity removed.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid day entered. Please enter a valid day.");
        }
    }

    private static void listAllActivities(DailyPlanner planner) {
        for (Day day : Day.values()) {
            List<String> activities = planner.getActivities(day);
            System.out.println(day + ": " + activities);
        }
    }

    private static void endPlanning(DailyPlanner planner) throws NoActivitiesForDayException {
        Map<Day, List<String>> planningResult = planner.endPlanning();
        System.out.println("Planing complete:");
        for (Map.Entry<Day, List<String>> entry : planningResult.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
