package info.fandroid.reminder.information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.fandroid.reminder.MainActivity;
import info.fandroid.reminder.R;
import info.fandroid.reminder.preferences.SHHelper;

public class GoalActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNext, btnExit;

    EditText Title, Part1, Part2, Part3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        Title = (EditText) findViewById(R.id.title_goal);
        Part1  = (EditText) findViewById(R.id.title_goal_part1);
        Part2  = (EditText) findViewById(R.id.title_goal_part2);
        Part3  = (EditText) findViewById(R.id.title_goal_part3);

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                saveText();
                Intent intent = new Intent(GoalActivity.this,HabitsActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_exit:
                Intent intent2 = new Intent(GoalActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    private void saveText() {
        SHHelper.sTitle = getSharedPreferences("Tname",MODE_PRIVATE);
        SharedPreferences.Editor ed = SHHelper.sTitle.edit();
        ed.putString(SHHelper.SAVED_TITLE, Title.getText().toString());
        ed.commit();

        SHHelper.sPart1 = getSharedPreferences("Tpart1",MODE_PRIVATE);
        SharedPreferences.Editor ed1 = SHHelper.sPart1.edit();
        ed1.putString(SHHelper.SAVED_PART1, Part1.getText().toString());
        ed1.commit();

        SHHelper.sPart2 = getSharedPreferences("Tpart2",MODE_PRIVATE);
        SharedPreferences.Editor ed2 = SHHelper.sPart2.edit();
        ed2.putString(SHHelper.SAVED_PART2, Part2.getText().toString());
        ed2.commit();

        SHHelper.sPart3 = getSharedPreferences("Tpart3",MODE_PRIVATE);
        SharedPreferences.Editor ed3 = SHHelper.sPart3.edit();
        ed3.putString(SHHelper.SAVED_PART3, Part3.getText().toString());
        ed3.commit();

        Toast.makeText(GoalActivity.this, "Текст сохранён", Toast.LENGTH_SHORT).show();

        SHHelper.sTitle = getSharedPreferences("Tname",MODE_PRIVATE);
        SHHelper.Title  = SHHelper.sTitle.getString(SHHelper.SAVED_TITLE,"");

        SHHelper.sPart1 = getSharedPreferences("Tpart1",MODE_PRIVATE);
        SHHelper.Part1  = SHHelper.sPart1.getString(SHHelper.SAVED_PART1,"");

        SHHelper.sPart2 = getSharedPreferences("Tpart2",MODE_PRIVATE);
        SHHelper.Part2  = SHHelper.sPart2.getString(SHHelper.SAVED_PART2,"");

        SHHelper.sPart3 = getSharedPreferences("Tpart3",MODE_PRIVATE);
        SHHelper.Part3  = SHHelper.sPart3.getString(SHHelper.SAVED_PART3,"");

    }
}

