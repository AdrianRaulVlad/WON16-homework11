package enumsAndExceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private List<DaySchedule> schedules;

    public DailyPlanner() {
        this.schedules = new ArrayList<>();
        for (Day day : Day.values()) {
            schedules.add(new DaySchedule(day));
        }
    }

    public void addActivity (Day day, String activity) {
        if (activity == null) {
            throw new NoActivityException("Activity cannot be null");
        }
        DaySchedule schedule = getScheduleForDay(day);
        schedule.addActivity(activity);
    }

    public void removeActivity (Day day, String activity) {
        DaySchedule schedule = getScheduleForDay(day);
        if (!schedule.getActivities().remove(activity)) {
            throw new NoActivityException("Activity does not exist: " + activity);
        }
    }

    public List<String> getActivities(Day day) {
        return getScheduleForDay(day).getActivities();
    }

    public Map<Day, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<Day, List<String>> planningResult = new HashMap<>();
        for (DaySchedule schedule : schedules) {
            if (schedule.getActivities().isEmpty()) {
                throw new NoActivitiesForDayException("No activities for day: " + schedule.getDay());
            }
            planningResult.put(schedule.getDay(), schedule.getActivities());
        }
        return planningResult;
    }

    private DaySchedule getScheduleForDay(Day day) {
        for (DaySchedule schedule : schedules) {
            if (schedule.getDay() == day) {
                return schedule;
            }
        }
        return null;
    }
}
