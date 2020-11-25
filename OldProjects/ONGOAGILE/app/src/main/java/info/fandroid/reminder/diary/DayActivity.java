package info.fandroid.reminder.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TreeMap;

import info.fandroid.reminder.R;
import info.fandroid.reminder.information.EndOfWeekActivity;
import info.fandroid.reminder.preferences.DayPlanHelper;
import info.fandroid.reminder.preferences.SHHelper;
import info.fandroid.reminder.preferences.WeekEndHelper;

public class DayActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNextDay;

    TextView aimpart1, aimpart2, aimpart3, ach, thank;

    CheckBox habit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String string = simpleDateFormat.format(calendar.getTime());

        TextView todayDate = (TextView) findViewById(R.id.today_date);
        todayDate.setText(string);

        btnNextDay = (Button) findViewById(R.id.next_day);

        aimpart1 = (TextView) findViewById(R.id.today_task1);
        aimpart2 = (TextView) findViewById(R.id.today_task2);
        aimpart3 = (TextView) findViewById(R.id.today_task3);
        ach = (TextView) findViewById(R.id.today_ach);
        thank = (TextView) findViewById(R.id.today_thank);
        habit = (CheckBox) findViewById(R.id.habit_check);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.next_day:
                saveandclear();
                break;

            default:
                break;
        }
    }

    private void saveandclear() {

        String sum = "Три ваших задачи: " +" 1. "+ aimpart1.getText() + "; 2. " + aimpart2.getText() + "; 3. " + aimpart3.getText() + "; " + "Ваше достижение дня " + ach.getText() + ";";
        DayPlanHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
        int i = DayPlanHelper.dpcounter.getInt(DayPlanHelper.SAVED_COUNTER,0);
        WeekEndHelper.weCounter = getSharedPreferences("Wcounter",MODE_PRIVATE);
        int i1 = WeekEndHelper.weCounter.getInt(WeekEndHelper.SAVED_COUNTER,0);
        if(i>6){
            i=i-6;
            DayPlanHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
            SharedPreferences.Editor dpcounter1 = DayPlanHelper.dpcounter.edit();
            dpcounter1.putInt(DayPlanHelper.SAVED_COUNTER, i);
            dpcounter1.commit();

            i1+=1;
            if(i1==10)
            {
                Intent intent = new Intent(DayActivity.this, EndOfWeekActivity.class);
                startActivity(intent);
            }
            else {
                DayPlanHelper.dpcounter = getSharedPreferences("Wcounter", MODE_PRIVATE);
                SharedPreferences.Editor wecounter1 = WeekEndHelper.weCounter.edit();
                wecounter1.putInt(DayPlanHelper.SAVED_COUNTER, i1);
                wecounter1.commit();
            }
        }
        switch (i){
            case 1:
                DayPlanHelper.dpMonday = getSharedPreferences("Dmonday",MODE_PRIVATE);
                SharedPreferences.Editor dpday1 = DayPlanHelper.dpMonday.edit();
                dpday1.putString(DayPlanHelper.SAVED_Monday, sum);
                dpday1.commit();
                break;
            case 2:
                DayPlanHelper.dpTuesday = getSharedPreferences("Dtuesday",MODE_PRIVATE);
                SharedPreferences.Editor dpday2 = DayPlanHelper.dpTuesday.edit();
                dpday2.putString(DayPlanHelper.SAVED_Tuesday, sum);
                dpday2.commit();
                break;
            case 3:
                DayPlanHelper.dpWednesday = getSharedPreferences("Dmonday",MODE_PRIVATE);
                SharedPreferences.Editor dpday3 = DayPlanHelper.dpWednesday.edit();
                dpday3.putString(DayPlanHelper.SAVED_Wednesday, sum);
                dpday3.commit();
                break;
            case 4:
                DayPlanHelper.dpThursday = getSharedPreferences("Dthursday",MODE_PRIVATE);
                SharedPreferences.Editor dpday4 = DayPlanHelper.dpThursday.edit();
                dpday4.putString(DayPlanHelper.SAVED_Thursday, sum);
                dpday4.commit();
                break;
            case 5:
                DayPlanHelper.dpFriday = getSharedPreferences("Dfriday",MODE_PRIVATE);
                SharedPreferences.Editor dpday5 = DayPlanHelper.dpFriday.edit();
                dpday5.putString(DayPlanHelper.SAVED_Friday, sum);
                dpday5.commit();
                break;
            case 6:
                DayPlanHelper.dpSaturday = getSharedPreferences("Dsaturday",MODE_PRIVATE);
                SharedPreferences.Editor dpday6 = DayPlanHelper.dpSaturday.edit();
                dpday6.putString(DayPlanHelper.SAVED_Saturday, sum);
                dpday6.commit();
                break;
        }
        aimpart1.setText("");
        aimpart2.setText("");
        aimpart3.setText("");
        ach.setText("");
        thank.setText("");

    }
}
