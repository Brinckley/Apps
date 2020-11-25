package info.fandroid.reminder.time;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import info.fandroid.reminder.MainActivity;
import info.fandroid.reminder.R;

public class FineWeeksActivity extends AppCompatActivity {

    EditText sprintgoal, sprintach, sprintlearned, sprintthank, sprintfuture;
    Button btnexit, btnstat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine_weeks);

        sprintgoal = (EditText) findViewById(R.id.sprint_goal);
        sprintach = (EditText) findViewById(R.id.sprint_main);
        sprintlearned = (EditText) findViewById(R.id.sprint_learned);
        sprintthank = (EditText) findViewById(R.id.sprint_thank);
        sprintfuture = (EditText) findViewById(R.id.sprint_future);

        btnexit = (Button) findViewById(R.id.sprint_finish);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FineWeeksActivity.this,SpintStatActivity.class);
                startActivity(intent1);
            }
        });

        btnstat = (Button) findViewById(R.id.sprint_stat);
        btnstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sum = "О цели спринта: "+sprintgoal.getText()+"; Главное достижение за спринт: "+sprintach.getText()+"; Чему я научился: "+sprintlearned.getText()+"; Кому я благодарен: "+sprintthank.getText()+"; Что я могу улучшить в будущем: "+sprintfuture.getText() + ";";
                SaverSprint.sSprint = getSharedPreferences("Результат спринта",MODE_WORLD_READABLE);
                SharedPreferences.Editor editor = SaverSprint.sSprint.edit();
                editor.putString(SaverSprint.SAVED_SPRINT,sum);
                editor.commit();
                Intent intent = new Intent(FineWeeksActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
