package info.fandroid.reminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import info.fandroid.reminder.preferences.SHHelper;

public class AgileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agile);

        SHHelper.sTitle = getSharedPreferences("Tname",MODE_PRIVATE);
        SHHelper.Title  = SHHelper.sTitle.getString(SHHelper.SAVED_TITLE,"");

        SHHelper.sTitle = getSharedPreferences("Tname",MODE_PRIVATE);
        SHHelper.Title  = SHHelper.sTitle.getString(SHHelper.SAVED_TITLE,"");

        SHHelper.sPart1 = getSharedPreferences("Tpart1",MODE_PRIVATE);
        SHHelper.Part1  = SHHelper.sPart1.getString(SHHelper.SAVED_PART1,"");

        SHHelper.sPart2 = getSharedPreferences("Tpart2",MODE_PRIVATE);
        SHHelper.Part2  = SHHelper.sPart2.getString(SHHelper.SAVED_PART2,"");

        SHHelper.sPart3 = getSharedPreferences("Tpart3",MODE_PRIVATE);
        SHHelper.Part3  = SHHelper.sPart3.getString(SHHelper.SAVED_PART3,"");

        SHHelper.sHabit = getSharedPreferences("Thabit",MODE_PRIVATE);
        SHHelper.Habit  = SHHelper.sHabit.getString(SHHelper.SAVED_HABIT,"");

        SHHelper.sWhy = getSharedPreferences("Twhy",MODE_PRIVATE);
        SHHelper.Why  = SHHelper.sWhy.getString(SHHelper.SAVED_WHY,"");

        SHHelper.sPresent = getSharedPreferences("Tpresent",MODE_PRIVATE);
        SHHelper.Present  = SHHelper.sPresent.getString(SHHelper.SAVED_PRESENT,"");

        TextView Goal_name = (TextView) findViewById(R.id.outputt);
        Goal_name.setText(SHHelper.Title);

        TextView Goal_part1 = (TextView) findViewById(R.id.outputt_part1);
        Goal_part1.setText(SHHelper.Part1);

        TextView Goal_part2 = (TextView) findViewById(R.id.outputt_part2);
        Goal_part2.setText(SHHelper.Part2);

        TextView Goal_part3 = (TextView) findViewById(R.id.outputt_part3);
        Goal_part3.setText(SHHelper.Part3);

        TextView Goal_habit = (TextView) findViewById(R.id.outputt_habit);
        Goal_habit.setText(SHHelper.Habit);

        TextView Goal_why = (TextView) findViewById(R.id.outputt_why);
        Goal_why.setText(SHHelper.Why);

        TextView Goal_present = (TextView) findViewById(R.id.outputt_present);
        Goal_present.setText(SHHelper.Present);

    }
}
