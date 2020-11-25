package info.fandroid.reminder.time;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import info.fandroid.reminder.R;
import info.fandroid.reminder.preferences.SHHelper;

public class OutputStatisticaActivity extends AppCompatActivity {

    TextView dayone, daytwo, daythree, dayfour, dayfive, daysix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_statistica);

        dayone = (TextView) findViewById(R.id.text_monday);
        daytwo = (TextView) findViewById(R.id.text_tuesday);
        daythree = (TextView) findViewById(R.id.text_wednesday);
        dayfour = (TextView) findViewById(R.id.text_thursday);
        dayfive = (TextView) findViewById(R.id.text_friday);
        daysix = (TextView) findViewById(R.id.text_saturday);

        SHHelper.dpMonday = getSharedPreferences("Dmonday",MODE_PRIVATE);
        dayone.setText(SHHelper.dpMonday.getString(SHHelper.SAVED_Monday,""));
        SHHelper.dpTuesday = getSharedPreferences("Dtuesday",MODE_PRIVATE);
        daytwo.setText(SHHelper.dpTuesday.getString(SHHelper.SAVED_Tuesday,""));
        SHHelper.dpWednesday = getSharedPreferences("Dwednesday",MODE_PRIVATE);
        daythree.setText(SHHelper.dpWednesday.getString(SHHelper.SAVED_Wednesday,""));
        SHHelper.dpThursday = getSharedPreferences("Dthursday",MODE_PRIVATE);
        dayfour.setText(SHHelper.dpThursday.getString(SHHelper.SAVED_Thursday,""));
        SHHelper.dpFriday = getSharedPreferences("Dfriday",MODE_PRIVATE);
        dayfive.setText(SHHelper.dpFriday.getString(SHHelper.SAVED_Friday,""));
        SHHelper.dpSaturday = getSharedPreferences("Dsutarday",MODE_PRIVATE);
        daysix.setText(SHHelper.dpSaturday.getString(SHHelper.SAVED_Saturday,""));
    }
}
