package info.fandroid.reminder.information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import info.fandroid.reminder.MainActivity;
import info.fandroid.reminder.R;
import info.fandroid.reminder.preferences.SHHelper;

public class HabitsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNext, btnSave, btnBack, btnExit;
    MultiAutoCompleteTextView txtHabit;
    String[] habits = {"Планировать расходы","Делать мини-уборку","Гулять по 15-30 мин","Делать 10-минутную зарядку утром", "Питаться 5-6 раз в день",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habits);

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(this);

        txtHabit = (MultiAutoCompleteTextView) findViewById(R.id.habits_scroll);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(HabitsActivity.this,R.layout.support_simple_spinner_dropdown_item,habits);

        txtHabit.setAdapter(adapter);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                saveText();
                Intent intent = new Intent(HabitsActivity.this,Why_presentActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_back:
                Intent intent1 = new Intent(HabitsActivity.this, GoalActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_exit:
                Intent intent2 = new Intent(HabitsActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            default:

                break;
        }
    }

    private void saveText() {
        SHHelper.sHabit = getSharedPreferences("Thabit",MODE_PRIVATE);
        SharedPreferences.Editor ed = SHHelper.sHabit.edit();
        ed.putString(SHHelper.SAVED_HABIT, txtHabit.getText().toString());
        ed.commit();

        Toast.makeText(HabitsActivity.this, "Текст сохранён", Toast.LENGTH_SHORT).show();
    }
}
