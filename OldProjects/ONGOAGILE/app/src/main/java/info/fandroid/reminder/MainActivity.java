package info.fandroid.reminder;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import info.fandroid.reminder.adapter.TabAdapter;
import info.fandroid.reminder.alarm.AlarmHelper;
import info.fandroid.reminder.database.DBHelper;
import info.fandroid.reminder.dialog.AddingTaskDialogFragment;
import info.fandroid.reminder.dialog.EditTaskDialogFragment;
import info.fandroid.reminder.diary.DayActivity;
import info.fandroid.reminder.fragment.CurrentTaskFragment;
import info.fandroid.reminder.fragment.DoneTaskFragment;
import info.fandroid.reminder.fragment.TaskFragment;
import info.fandroid.reminder.information.GoalActivity;
import info.fandroid.reminder.model.ModelTask;
import info.fandroid.reminder.preferences.PreferenceHelper;
import info.fandroid.reminder.preferences.SHHelper;
import info.fandroid.reminder.preferences.WeekEndHelper;
import info.fandroid.reminder.preferences.Weekcounter;
import info.fandroid.reminder.time.ConstantActivity;
import info.fandroid.reminder.time.TimeHelper;

public class MainActivity extends AppCompatActivity
        implements AddingTaskDialogFragment.AddingTaskListener,
        CurrentTaskFragment.OnTaskDoneListener, DoneTaskFragment.OnTaskRestoreListener,
        EditTaskDialogFragment.EditingTaskListener {

    FragmentManager fragmentManager;

    PreferenceHelper preferenceHelper;
    TabAdapter tabAdapter;

    TaskFragment currentTaskFragment;
    TaskFragment doneTaskFragment;

    SearchView searchView;

    public DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceHelper.getInstance().init(getApplicationContext());
        preferenceHelper = PreferenceHelper.getInstance();

        AlarmHelper.getInstance().init(getApplicationContext());

        dbHelper = new DBHelper(getApplicationContext());

        fragmentManager = getFragmentManager();


        setUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.activityResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyApplication.activityPaused();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Input_goal) {
            Intent intent=new Intent(MainActivity.this, GoalActivity.class);
            int i=1;
            String k = Integer.toString(i);
            SHHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
            SharedPreferences.Editor edcounter = SHHelper.dpcounter.edit();
            edcounter.putString(SHHelper.SAVED_COUNTER,k);
            edcounter.commit();

            WeekEndHelper.weCounter = getSharedPreferences("Wcounter",MODE_PRIVATE);
            SharedPreferences.Editor edcounter1 = WeekEndHelper.weCounter.edit();
            edcounter1.putString(WeekEndHelper.SAVED_COUNTER,k);
            edcounter1.commit();

            TimeHelper.sthabit = getSharedPreferences("Dhabit", MODE_PRIVATE);
            SharedPreferences.Editor edcounter2 = TimeHelper.sthabit.edit();
            edcounter2.putString(TimeHelper.SAVED_HABIT,k);
            edcounter2.commit();

            Weekcounter.wnumber = getSharedPreferences("number",MODE_PRIVATE);
            SharedPreferences.Editor gog = Weekcounter.wnumber.edit();
            gog.putString(Weekcounter.SAVED_WEEKCOUNTER,k);
            gog.commit();

            startActivity(intent);

        } else {
            if (id == R.id.today_habit) {
                Intent i = new Intent(MainActivity.this,AgileActivity.class);
                startActivity(i);
            }else {if(id==R.id.today_pla){

                int i=1;
                String k = Integer.toString(i);
                SHHelper.dpcounter = getSharedPreferences("Dcounter",MODE_PRIVATE);
                SharedPreferences.Editor edcounter = SHHelper.dpcounter.edit();
                edcounter.putString(SHHelper.SAVED_COUNTER,k);
                edcounter.commit();

                WeekEndHelper.weCounter = getSharedPreferences("Wcounter",MODE_PRIVATE);
                SharedPreferences.Editor edcounter1 = WeekEndHelper.weCounter.edit();
                edcounter1.putString(WeekEndHelper.SAVED_COUNTER,k);
                edcounter1.commit();

                TimeHelper.sthabit = getSharedPreferences("Dhabit", MODE_PRIVATE);
                SharedPreferences.Editor edcounter2 = TimeHelper.sthabit.edit();
                edcounter2.putString(TimeHelper.SAVED_HABIT,k);
                edcounter2.commit();

                Weekcounter.wnumber = getSharedPreferences("number",MODE_PRIVATE);
                SharedPreferences.Editor gog = Weekcounter.wnumber.edit();
                gog.putString(Weekcounter.SAVED_WEEKCOUNTER,k);
                gog.commit();
                Intent intent = new Intent(MainActivity.this, ConstantActivity.class);
                startActivity(intent);
            }}
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUI() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.current_task));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.done_task));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        tabAdapter = new TabAdapter(fragmentManager, 2);

        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });

        currentTaskFragment = (CurrentTaskFragment) tabAdapter.getItem(TabAdapter.CURRENT_TASK_FRAGMENT_POSITION);
        doneTaskFragment = (DoneTaskFragment) tabAdapter.getItem(TabAdapter.DONE_TASK_FRAGMENT_POSITION);

        searchView = (SearchView) findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                currentTaskFragment.findTasks(newText);
                doneTaskFragment.findTasks(newText);
                return false;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment addingTaskDialogFragment = new AddingTaskDialogFragment();
                addingTaskDialogFragment.show(fragmentManager, "AddingTaskDialogFragment");
            }
        });
    }

    @Override
    public void onTaskAdded(ModelTask newTask) {
        currentTaskFragment.addTask(newTask, true);
    }

    @Override
    public void onTaskAddingCancel() {
        Toast.makeText(this, "Task adding cancel", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onTaskDone(ModelTask task) {
        doneTaskFragment.addTask(task, false);
    }

    @Override
    public void onTaskRestore(ModelTask task) {
        currentTaskFragment.addTask(task, false);
    }

    @Override
    public void onTaskEdited(ModelTask updatedTask) {
        currentTaskFragment.updateTask(updatedTask);
        dbHelper.update().task(updatedTask);
    }
}
