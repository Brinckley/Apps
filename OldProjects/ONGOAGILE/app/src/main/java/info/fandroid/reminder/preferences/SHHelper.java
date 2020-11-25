package info.fandroid.reminder.preferences;

import android.content.SharedPreferences;

public class SHHelper {
    public static SharedPreferences sTitle, sPart1, sPart2, sPart3, sHabit, sWhy, sPresent;

    public static final String SAVED_TITLE = "saved_title";
    public static final String SAVED_PART1 = "saved_part1";
    public static final String SAVED_PART2 = "saved_part2";
    public static final String SAVED_PART3 = "saved_part3";
    public static final String SAVED_HABIT = "saved_habit";
    public static final String SAVED_WHY = "saved_why";
    public static final String SAVED_PRESENT = "saved_present";

    public static String Title, Part1, Part2, Part3, Habit, Why, Present;

    public static SharedPreferences dpMonday, dpTuesday, dpWednesday, dpThursday, dpFriday, dpSaturday, dpcounter, dpweekcounter;

    public static final String SAVED_Monday = "saved_Monday";
    public static final String SAVED_Tuesday = "saved_Tuesday";
    public static final String SAVED_Wednesday = "saved_Wednesday";
    public static final String SAVED_Thursday = "saved_Thursday";
    public static final String SAVED_Friday = "saved_Friday";
    public static final String SAVED_Saturday = "saved_Saturday";

    public static final String SAVED_COUNTER = "saved_counter";
    public static final String SAVED_WEEKCOUNTER = "saved_weekcounter";
}

