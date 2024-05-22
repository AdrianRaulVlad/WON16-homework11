package enumsAndExceptions;

import java.util.List;
import java.util.Map;

public class MainDailyPlanner {
    public static void main(String[] args) {
        DailyPlanner planner = new DailyPlanner();

        try {
            planner.addActivity(Day.MONDAY, "Go to the gym");
            planner.addActivity(Day.MONDAY, "Read a book");

            planner.addActivity(Day.TUESDAY, "Attend meeting");

            planner.removeActivity(Day.MONDAY, "Read a book");

            List<String> mondayActivities = planner.getActivities(Day.MONDAY);
            System.out.println("Monday activities: " + mondayActivities);

            Map<Day, List<String>> planningResult = planner.endPlanning();
            System.out.println("Planning result: " + planningResult);
        } catch (NoActivityException | NoActivitiesForDayException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
