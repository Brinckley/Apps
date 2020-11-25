package info.fandroid.reminder;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import info.fandroid.reminder.preferences.DaySHHelper;
import info.fandroid.reminder.preferences.SHHelper;
import info.fandroid.reminder.time.TimeHelper;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{


    EditText mTitle1, mTitle2, mTitle3, mAchievement, mThanks;

    CheckBox mhabit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        String string = simpleDateFormat.format(cal.getTime());
       // TimeHelper.stTimeYesterdayday = getSharedPreferences("Tyesterday",MODE_PRIVATE);
        //String syes = TimeHelper.stTimeYesterdayday.getString(TimeHelper.SAVED_TIMEYESTERDAY,"");

            outputText();

    }

    @Override
    public void onClick(View v) {

    }
    private void outputText() {
        DaySHHelper.sdTitle1 = getSharedPreferences("Tdaytitle1", MODE_PRIVATE);
        DaySHHelper.Title1 = DaySHHelper.sdTitle1.getString(DaySHHelper.SAVED_TITLE1, "");
        DaySHHelper.sdTitle2 = getSharedPreferences("Tdaytitle2", MODE_PRIVATE);
        DaySHHelper.Title2 = DaySHHelper.sdTitle2.getString(DaySHHelper.SAVED_TITLE2, "");
        DaySHHelper.sdTitle3 = getSharedPreferences("Tdaytitle3", MODE_PRIVATE);
        DaySHHelper.Title3 = DaySHHelper.sdTitle3.getString(DaySHHelper.SAVED_TITLE3, "");
        DaySHHelper.sdAchievement = getSharedPreferences("Tdayachievement", MODE_PRIVATE);
        DaySHHelper.Achievement = DaySHHelper.sdAchievement.getString(DaySHHelper.SAVED_ACHIEVEMENT, "");
        DaySHHelper.sdThanks = getSharedPreferences("Tdaythanks", MODE_PRIVATE);
        DaySHHelper.Thanks = DaySHHelper.sdThanks.getString(DaySHHelper.SAVED_THANKS, "");


        mTitle1 = (EditText) findViewById(R.id.day_goal1);
        mTitle1.setText(DaySHHelper.Title1);
        mTitle2 = (EditText) findViewById(R.id.day_goal2);
        mTitle2.setText(DaySHHelper.Title2);
        mTitle3 = (EditText) findViewById(R.id.day_goal3);
        mTitle3.setText(DaySHHelper.Title3);

        mAchievement = (EditText) findViewById(R.id.day_achievement);
        mAchievement.setText(DaySHHelper.Achievement);
        mThanks = (EditText) findViewById(R.id.day_thanks);
        mThanks.setText(DaySHHelper.Thanks);
        mhabit = (CheckBox) findViewById(R.id.today_habit);

    }
    public void saveText(){
        DaySHHelper.sdTitle1 = getSharedPreferences("Tdaytitle1",MODE_PRIVATE);
        SharedPreferences.Editor ed1 = DaySHHelper.sdTitle1.edit();
        ed1.putString(DaySHHelper.SAVED_TITLE1, mTitle1.getText().toString());
        ed1.commit();
        DaySHHelper.sdTitle1 = getSharedPreferences("Tdaytitle1",MODE_PRIVATE);
        DaySHHelper.Title1  = DaySHHelper.sdTitle1.getString(SHHelper.SAVED_TITLE,"");

        DaySHHelper.sdTitle2 = getSharedPreferences("Tdaytitle2",MODE_PRIVATE);
        SharedPreferences.Editor ed2 = DaySHHelper.sdTitle2.edit();
        ed2.putString(DaySHHelper.SAVED_TITLE2, mTitle2.getText().toString());
        ed2.commit();
        DaySHHelper.sdTitle2 = getSharedPreferences("Tdaytitle2",MODE_PRIVATE);
        DaySHHelper.Title2  = DaySHHelper.sdTitle2.getString(DaySHHelper.SAVED_TITLE2,"");

        DaySHHelper.sdTitle3 = getSharedPreferences("Tdaytitle3",MODE_PRIVATE);
        SharedPreferences.Editor ed3 = DaySHHelper.sdTitle3.edit();
        ed3.putString(DaySHHelper.SAVED_TITLE3, mTitle3.getText().toString());
        ed3.commit();
        DaySHHelper.sdTitle3 = getSharedPreferences("Tdaytitle3",MODE_PRIVATE);
        DaySHHelper.Title3  = DaySHHelper.sdTitle3.getString(DaySHHelper.SAVED_TITLE3,"");

        DaySHHelper.sdAchievement = getSharedPreferences("Tdayachievement",MODE_PRIVATE);
        SharedPreferences.Editor ed4 = DaySHHelper.sdAchievement.edit();
        ed4.putString(DaySHHelper.SAVED_ACHIEVEMENT, mAchievement.getText().toString());
        ed4.commit();
        DaySHHelper.sdAchievement = getSharedPreferences("Tdayachievement",MODE_PRIVATE);
        DaySHHelper.Achievement  = DaySHHelper.sdAchievement.getString(DaySHHelper.SAVED_ACHIEVEMENT,"");

        DaySHHelper.sdThanks = getSharedPreferences("Tdaythanks",MODE_PRIVATE);
        SharedPreferences.Editor ed5 = DaySHHelper.sdThanks.edit();
        ed5.putString(DaySHHelper.SAVED_THANKS, mThanks.getText().toString());
        ed5.commit();
        DaySHHelper.sdThanks = getSharedPreferences("Tdaythanks",MODE_PRIVATE);
        DaySHHelper.Thanks  = DaySHHelper.sdThanks.getString(DaySHHelper.SAVED_THANKS,"");

        //      DaySHHelper.sdHabit = getSharedPreferences("Tdayhabit",MODE_PRIVATE);
//        SharedPreferences.Editor ed6 = DaySHHelper.sdHabit.edit();
//        ed6.putInt(DaySHHelper.SAVED_THANKS, mhabit.getText().toString());
//        ed6.commit();
    }
}
