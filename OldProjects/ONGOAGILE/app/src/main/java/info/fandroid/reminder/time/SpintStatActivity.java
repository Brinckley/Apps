package info.fandroid.reminder.time;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import info.fandroid.reminder.R;
import info.fandroid.reminder.preferences.SHHelper;
import info.fandroid.reminder.preferences.WeekEndHelper;

public class SpintStatActivity extends AppCompatActivity {

    TextView spweek1, spweek2, spweek3, spweek4, spweek5, spweek6, spweek7, spweek8, spweek9, sphabit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spint_stat);

        spweek1 = (TextView) findViewById(R.id.sprint_week1);
        spweek2 = (TextView) findViewById(R.id.sprint_week2);
        spweek3 = (TextView) findViewById(R.id.sprint_week3);
        spweek4 = (TextView) findViewById(R.id.sprint_week4);
        spweek5 = (TextView) findViewById(R.id.sprint_week5);
        spweek6 = (TextView) findViewById(R.id.sprint_week6);
        spweek7 = (TextView) findViewById(R.id.sprint_week7);
        spweek8 = (TextView) findViewById(R.id.sprint_week8);
        spweek9 = (TextView) findViewById(R.id.sprint_week9);
        sphabit = (TextView) findViewById(R.id.sprint_habit);
        WeekEndHelper.weWeek1 = getSharedPreferences("WEweek1",MODE_PRIVATE);
       spweek1.setText(SHHelper.dpcounter.getString(WeekEndHelper.SAVED_WEEK1,""));
        WeekEndHelper.weWeek2 = getSharedPreferences("WEweek2",MODE_PRIVATE);
        spweek2.setText(WeekEndHelper.weWeek2.getString(WeekEndHelper.SAVED_WEEK2,""));
        WeekEndHelper.weWeek3 = getSharedPreferences("WEweek3",MODE_PRIVATE);
        spweek3.setText(WeekEndHelper.weWeek3.getString(WeekEndHelper.SAVED_WEEK3,""));
        WeekEndHelper.weWeek4 = getSharedPreferences("WEweek4",MODE_PRIVATE);
        spweek4.setText(WeekEndHelper.weWeek4.getString(WeekEndHelper.SAVED_WEEK4,""));
        WeekEndHelper.weWeek5 = getSharedPreferences("WEweek5",MODE_PRIVATE);
        spweek5.setText(WeekEndHelper.weWeek5.getString(WeekEndHelper.SAVED_WEEK5,""));
        WeekEndHelper.weWeek6 = getSharedPreferences("WEweek6",MODE_PRIVATE);
        spweek6.setText(WeekEndHelper.weWeek6.getString(WeekEndHelper.SAVED_WEEK6,""));
        WeekEndHelper.weWeek7 = getSharedPreferences("WEweek7",MODE_PRIVATE);
        spweek7.setText(WeekEndHelper.weWeek7.getString(WeekEndHelper.SAVED_WEEK7,""));
        WeekEndHelper.weWeek8 = getSharedPreferences("WEweek8",MODE_PRIVATE);
        spweek8.setText(WeekEndHelper.weWeek8.getString(WeekEndHelper.SAVED_WEEK8,""));
        WeekEndHelper.weWeek9 = getSharedPreferences("WEweek9",MODE_PRIVATE);
        spweek9.setText(WeekEndHelper.weWeek9.getString(WeekEndHelper.SAVED_WEEK9,""));
        TimeHelper.sthabit = getSharedPreferences("ALLhabit",MODE_PRIVATE);
        String l = TimeHelper.sthabit.getString(TimeHelper.SAVED_HABIT,"");
        int j = Integer.parseInt(l);
        j=100*j/54;
        String k = Integer.toString(j);
        sphabit.setText(k);
    }
}
