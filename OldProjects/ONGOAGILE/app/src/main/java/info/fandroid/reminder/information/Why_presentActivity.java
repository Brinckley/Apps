package info.fandroid.reminder.information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import info.fandroid.reminder.MainActivity;
import info.fandroid.reminder.R;
import info.fandroid.reminder.diary.DayActivity;
import info.fandroid.reminder.preferences.DayPlanHelper;
import info.fandroid.reminder.preferences.SHHelper;
import info.fandroid.reminder.preferences.WeekEndHelper;
import info.fandroid.reminder.time.TimeHelper;


public class Why_presentActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnNext, btnSave, btnBack, btnExit;

    EditText txtWhy, txtPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why_present);

        txtWhy = (EditText) findViewById(R.id.title_why);

        txtPresent = (EditText) findViewById(R.id.title_present);

        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                Intent intent1 = new Intent(Why_presentActivity.this, HabitsActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_exit:
                Intent intent2 = new Intent(Why_presentActivity.this,MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.start_sprint:
                saveText();
                int i=0;
                String k = Integer.toString(i);
                SHHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
                SharedPreferences.Editor edcounter = SHHelper.dpcounter.edit();
                edcounter.putString(SHHelper.SAVED_COUNTER,k);
                edcounter.commit();

               SHHelper.dpweekcounter = getSharedPreferences("WEcounter", MODE_PRIVATE);
                SharedPreferences.Editor b = SHHelper.dpweekcounter.edit();
                b.putString(SHHelper.SAVED_WEEKCOUNTER,k);
                b.commit();
                Intent intent3 = new Intent(Why_presentActivity.this,MainActivity.class);
                startActivity(intent3);


                break;
            default:

                break;
        }
    }

    private void saveText() {
        SHHelper.sWhy = getSharedPreferences("Twhy",MODE_PRIVATE);
        SharedPreferences.Editor ed1 = SHHelper.sWhy.edit();
        ed1.putString(SHHelper.SAVED_WHY, txtWhy.getText().toString());
        ed1.commit();
        SHHelper.sPresent = getSharedPreferences("Tpresent",MODE_PRIVATE);
        SharedPreferences.Editor ed2 = SHHelper.sPresent.edit();
        ed2.putString(SHHelper.SAVED_PRESENT, txtPresent.getText().toString());
        ed2.commit();
        Toast.makeText(Why_presentActivity.this, "Текст сохранён", Toast.LENGTH_SHORT).show();

        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        String string = simpleDateFormat.format(calendar.getTime());

        txtWhy.setText(string);
    }
}
