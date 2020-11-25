package info.fandroid.reminder.time;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import info.fandroid.reminder.R;
import info.fandroid.reminder.preferences.DayPlanHelper;
import info.fandroid.reminder.preferences.SHHelper;
import info.fandroid.reminder.preferences.WeekEndHelper;
import info.fandroid.reminder.preferences.Weekcounter;
import info.fandroid.reminder.time.FineWeekActivity;
import static info.fandroid.reminder.preferences.DayPlanHelper.dpcounter;

public class ConstantActivity extends AppCompatActivity {

    int i,z;

    Button btnNextDay;

    EditText aimpart1, aimpart2, aimpart3, ach, thank;

    TextView daynumber;

    CheckBox habit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constant);

        SHHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
        String s = SHHelper.dpcounter.getString(SHHelper.SAVED_COUNTER,"");
        i = Integer.parseInt(s);
        if(i==7){
            Intent intent = new Intent(ConstantActivity.this,FineWeekActivity.class);
            startActivity(intent);
        }


        aimpart1 = (EditText) findViewById(R.id.today_task1);
        aimpart2 = (EditText) findViewById(R.id.today_task2);
        aimpart3 = (EditText) findViewById(R.id.today_task3);

        daynumber = (TextView) findViewById(R.id.day_number);
        ach = (EditText) findViewById(R.id.today_ach);
        thank = (EditText) findViewById(R.id.today_thank);
        habit = (CheckBox) findViewById(R.id.habit_check);
        if(habit.isChecked()){
            TimeHelper.sthabit = getSharedPreferences("ALLhabit",MODE_PRIVATE);
            String l = TimeHelper.sthabit.getString(TimeHelper.SAVED_HABIT,"");
            int j = Integer.parseInt(l);
            j+=1;
            l=Integer.toString(j);
            SharedPreferences.Editor editor22 = TimeHelper.sthabit.edit();
            editor22.putString(TimeHelper.SAVED_HABIT,l);
            editor22.commit();
        }
        btnNextDay = (Button) findViewById(R.id.next_day);
        btnNextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SHHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
                String s = SHHelper.dpcounter.getString(SHHelper.SAVED_COUNTER,"");
                i = Integer.parseInt(s);
                i=i+1;
                if(i>7){
                    i=i%7;
                 }

                String sum = "Три ваших задачи: " +" 1. "+ aimpart1.getText() + "; 2. " + aimpart2.getText() + "; 3. " + aimpart3.getText() + "; " + "Ваше достижение дня " + ach.getText() + ";";
                switch (i){
                    case 1:
                        SHHelper.dpMonday = getSharedPreferences("Dmonday",MODE_PRIVATE);
                        SharedPreferences.Editor edcounter1 = SHHelper.dpMonday.edit();
                        edcounter1.putString(SHHelper.SAVED_Monday,sum);
                        edcounter1.commit();
                        break;
                    case 2:
                        SHHelper.dpTuesday = getSharedPreferences("Dtuesday",MODE_PRIVATE);
                        SharedPreferences.Editor edcounter2 = SHHelper.dpTuesday.edit();
                        edcounter2.putString(SHHelper.SAVED_Tuesday,sum);
                        edcounter2.commit();
                        break;
                    case 3:
                        SHHelper.dpWednesday = getSharedPreferences("Dwednesday",MODE_PRIVATE);
                        SharedPreferences.Editor edcounter3 = SHHelper.dpWednesday.edit();
                        edcounter3.putString(SHHelper.SAVED_Wednesday,sum);
                        edcounter3.commit();
                        break;
                    case 4:
                        SHHelper.dpThursday = getSharedPreferences("Dthursday",MODE_PRIVATE);
                        SharedPreferences.Editor edcounter4 = SHHelper.dpThursday.edit();
                        edcounter4.putString(SHHelper.SAVED_Thursday,sum);
                        edcounter4.commit();
                        break;
                    case 5:
                        SHHelper.dpFriday = getSharedPreferences("Dfriday",MODE_PRIVATE);
                        SharedPreferences.Editor edcounter5 = SHHelper.dpFriday.edit();
                        edcounter5.putString(SHHelper.SAVED_Friday,sum);
                        edcounter5.commit();
                        break;
                    case 6:
                        SHHelper.dpSaturday = getSharedPreferences("Dsutarday",MODE_PRIVATE);
                        SharedPreferences.Editor edcounter6 = SHHelper.dpSaturday.edit();
                        edcounter6.putString(SHHelper.SAVED_Saturday,sum);
                        edcounter6.commit();
                        break;
                    case 7:


                        Intent intent = new Intent(ConstantActivity.this,FineWeekActivity.class);
                        startActivity(intent);
                        break;
                }
                aimpart1.setText("");
                aimpart2.setText("");
                aimpart3.setText("");
                ach.setText("");
                thank.setText("");
                habit.setEnabled(false);
                String k = Integer.toString(i);
                SHHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
                SharedPreferences.Editor edcounter = SHHelper.dpcounter.edit();
                edcounter.putString(SHHelper.SAVED_COUNTER,k);
                edcounter.commit();
                WeekEndHelper.weCounter = getSharedPreferences("Wcounter",MODE_PRIVATE);
                String kkl = WeekEndHelper.weCounter.getString(WeekEndHelper.SAVED_COUNTER,"");
                String z1 = SHHelper.dpcounter.getString(SHHelper.SAVED_COUNTER,"");
                daynumber.setText("Номер дня: "+kkl);
                //  saveandclear();

            }
        });
        outtext();
    }


    private void savetext() {
        TimeHelper.staim1 = getSharedPreferences("Daim1",MODE_PRIVATE);
        SharedPreferences.Editor ed1 = TimeHelper.staim1.edit();
        ed1.putString(TimeHelper.SAVED_AIM1,aimpart1.getText().toString());
        ed1.commit();
        TimeHelper.staim2 = getSharedPreferences("Daim2",MODE_PRIVATE);
        SharedPreferences.Editor ed2 = TimeHelper.staim2.edit();
        ed2.putString(TimeHelper.SAVED_AIM2,aimpart2.getText().toString());
        ed2.commit();
        TimeHelper.staim3 = getSharedPreferences("Daim3",MODE_PRIVATE);
        SharedPreferences.Editor ed3 = TimeHelper.staim3.edit();
        ed3.putString(TimeHelper.SAVED_AIM3,aimpart3.getText().toString());
        ed3.commit();
        TimeHelper.stthank = getSharedPreferences("Dach",MODE_PRIVATE);
        SharedPreferences.Editor ed4 = TimeHelper.stachievement.edit();
        ed4.putString(TimeHelper.SAVED_ACHIEVEMENT,ach.getText().toString());
        ed4.commit();
        TimeHelper.stthank = getSharedPreferences("Dthank",MODE_PRIVATE);
        SharedPreferences.Editor ed5 = TimeHelper.stthank.edit();
        ed5.putString(TimeHelper.SAVED_THANK,thank.getText().toString());
        ed5.commit();
    }
    private void outtext() {
        TimeHelper.staim1 = getSharedPreferences("Daim1",MODE_PRIVATE);
        aimpart1.setText(TimeHelper.staim1.getString(TimeHelper.SAVED_AIM1,""));
        TimeHelper.staim2 = getSharedPreferences("Daim2",MODE_PRIVATE);
        aimpart2.setText(TimeHelper.staim2.getString(TimeHelper.SAVED_AIM2,""));
        TimeHelper.staim3 = getSharedPreferences("Daim3",MODE_PRIVATE);
        aimpart3.setText(TimeHelper.staim3.getString(TimeHelper.SAVED_AIM3,""));
        TimeHelper.stachievement = getSharedPreferences("Dach",MODE_PRIVATE);
        ach.setText(TimeHelper.stachievement.getString(TimeHelper.SAVED_ACHIEVEMENT,""));
        TimeHelper.stthank = getSharedPreferences("Dthank",MODE_PRIVATE);
        thank.setText(TimeHelper.stthank.getString(TimeHelper.SAVED_THANK,""));

    }

    @Override
    protected void onDestroy() {
        savetext();
        super.onDestroy();
    }
}
