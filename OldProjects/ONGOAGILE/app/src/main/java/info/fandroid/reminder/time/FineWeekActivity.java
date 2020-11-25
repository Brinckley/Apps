package info.fandroid.reminder.time;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import info.fandroid.reminder.preferences.SHHelper;
import info.fandroid.reminder.preferences.WeekEndHelper;
import info.fandroid.reminder.time.ConstantActivity;

import info.fandroid.reminder.R;

public class FineWeekActivity extends AppCompatActivity {

    Button btnend, btnst;
    EditText txtprogress, txtwhat, txtfuture;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine_week);

        txtprogress= (EditText) findViewById(R.id.week_progress);
        txtwhat = (EditText) findViewById(R.id.week_learned);
        txtfuture = (EditText) findViewById(R.id.week_future);

        btnend = (Button) findViewById(R.id.week_end);
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sum = "Прогресс в цели: " + txtprogress.getText() + "; " + " Чему я научился: " + txtwhat.getText() + "; " + "Что я могу улучшить в будущем: " + txtfuture.getText() + ";";
                Intent intent = new Intent(FineWeekActivity.this, ConstantActivity.class);
                WeekEndHelper.weCounter = getSharedPreferences("Wcounter",MODE_PRIVATE);
                String kkl = WeekEndHelper.weCounter.getString(WeekEndHelper.SAVED_COUNTER,"");
                int u = Integer.parseInt(kkl);
                switch (u){
                    case 1:
                        WeekEndHelper.weWeek1 = getSharedPreferences("WEweek1",MODE_PRIVATE);
                        SharedPreferences.Editor kj1 = WeekEndHelper.weWeek1.edit();
                        kj1.putString(WeekEndHelper.SAVED_WEEK1,sum);
                        kj1.commit();
                        break;
                    case 2:
                        WeekEndHelper.weWeek2 = getSharedPreferences("WEweek2",MODE_PRIVATE);
                        SharedPreferences.Editor kj2 = WeekEndHelper.weWeek2.edit();
                        kj2.putString(WeekEndHelper.SAVED_WEEK1,sum);
                        kj2.commit();
                        break;
                    case 3:
                        WeekEndHelper.weWeek3 = getSharedPreferences("WEweek3",MODE_PRIVATE);
                        SharedPreferences.Editor kj3 = WeekEndHelper.weWeek3.edit();
                        kj3.putString(WeekEndHelper.SAVED_WEEK1,sum);
                        kj3.commit();
                        break;
                    case 4:
                        WeekEndHelper.weWeek4 = getSharedPreferences("WEweek4",MODE_PRIVATE);
                        SharedPreferences.Editor kj4 = WeekEndHelper.weWeek4.edit();
                        kj4.putString(WeekEndHelper.SAVED_WEEK1,sum);
                        kj4.commit();
                        break;
                    case 5:
                        WeekEndHelper.weWeek5 = getSharedPreferences("WEweek5",MODE_PRIVATE);
                        SharedPreferences.Editor kj5 = WeekEndHelper.weWeek5.edit();
                        kj5.putString(WeekEndHelper.SAVED_WEEK1,sum);
                        kj5.commit();
                        break;
                    case 6:
                        WeekEndHelper.weWeek6 = getSharedPreferences("WEweek6",MODE_PRIVATE);
                        SharedPreferences.Editor kj6 = WeekEndHelper.weWeek6.edit();
                        kj6.putString(WeekEndHelper.SAVED_WEEK6,sum);
                        kj6.commit();
                        break;
                    case 7:
                        WeekEndHelper.weWeek7 = getSharedPreferences("WEweek7",MODE_PRIVATE);
                        SharedPreferences.Editor kj7 = WeekEndHelper.weWeek7.edit();
                        kj7.putString(WeekEndHelper.SAVED_WEEK7,sum);
                        kj7.commit();
                        break;
                    case 8:
                        WeekEndHelper.weWeek8 = getSharedPreferences("WEweek8",MODE_PRIVATE);
                        SharedPreferences.Editor kj8 = WeekEndHelper.weWeek8.edit();
                        kj8.putString(WeekEndHelper.SAVED_WEEK8,sum);
                        kj8.commit();
                        break;
                    case 9:
                        Intent intent1 = new Intent(FineWeekActivity.this,FineWeeksActivity.class);
                        startActivity(intent1);
                        break;
                }
                String k = Integer.toString(1);
                WeekEndHelper.weCounter = getSharedPreferences("Wcounter",MODE_PRIVATE);
                kkl = WeekEndHelper.weCounter.getString(WeekEndHelper.SAVED_COUNTER,"");
                int r = Integer.parseInt(kkl);
                r=r+1;
                kkl = Integer.toString(r);
                SharedPreferences.Editor edcounter1 = WeekEndHelper.weCounter.edit();
                edcounter1.putString(WeekEndHelper.SAVED_COUNTER,kkl);
                edcounter1.commit();
                SHHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
                SharedPreferences.Editor edcounter = SHHelper.dpcounter.edit();
                edcounter.putString(SHHelper.SAVED_COUNTER,k);
                edcounter.commit();
                startActivity(intent);
            }
        });
        btnst = (Button) findViewById(R.id.week_stat);
        btnst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FineWeekActivity.this,OutputStatisticaActivity.class);
                startActivity(intent1);
            }
        });

    }
}
