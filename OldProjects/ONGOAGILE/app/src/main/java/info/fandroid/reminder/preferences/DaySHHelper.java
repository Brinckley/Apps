package info.fandroid.reminder.preferences;

import android.content.SharedPreferences;

public class DaySHHelper {
    public static SharedPreferences sdTitle1, sdTitle2, sdTitle3, sdAchievement, sdThanks, sdHabit;

    public static final String SAVED_TITLE1 = "saved_title1";
    public static final String SAVED_TITLE2 = "saved_title2";
    public static final String SAVED_TITLE3 = "saved_title3";
    public static final String SAVED_ACHIEVEMENT = "saved_achievement";
    public static final String SAVED_THANKS = "saved_thanks";
    public static final String SAVED_HABIT = "saved_habit";

    public static String Title1, Title2, Title3, Achievement, Thanks;
    public static int Habit;
}
