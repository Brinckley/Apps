package com.Brinkley.geoquiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; //Source of the message, also need to find messages in Logcat
    private static final String KEY_INDEX = "index";

    private static final int REQUEST_CODE_CHEAT = 0;
    private boolean mIsCheater; //flag if the user has cheated

    private int mClickCounter;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;
    private boolean mCheckedButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//called in the beginning of work
        super.onCreate(savedInstanceState);
        mClickCounter = 0;
        Log.d(TAG, "onCreate(Bundle) called"); //Registrate the message
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {//if counter was changed before the orientation change
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);//take saved data
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ////prep for starting new activity
                    //Intent intent = new Intent(MainActivity.this, CheatActivity.class); //second param is the class that works with the new activity
                    //startActivity(intent); //just starting CheatActivity
                    ////press Back button to close CheatActivity
                    boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue(); //taking answer
                    Intent intent = CheatActivity.newIntent(MainActivity.this, answerIsTrue);//starting intent and putting extra at once
                    startActivityForResult(intent, REQUEST_CODE_CHEAT);//starting CheatActivity to get the result if the user has cheated
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurrentIndex == 0) {
                    mCurrentIndex = mQuestionBank.length - 1;
                } else {
                    mCurrentIndex--;
                }
                updateQuestion();
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                if(mIsCheater){
                    mClickCounter++;
                }
                if(mClickCounter == 4) {
                    mCheatButton.setVisibility(View.INVISIBLE);
                }
                mIsCheater = false;
                updateQuestion();
            }
        });

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {//program is waiting for a click (some event)
            @Override//anonymous inner class
            public void onClick(View view) {//method from the interface
                if(!mCheckedButton) {
                    checkAnswer(true);
                } else {
                    Toast.makeText(MainActivity.this, R.string.twice_click_answer, Toast.LENGTH_SHORT).show();
                }
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mCheckedButton) {
                    checkAnswer(false);
                } else {
                    Toast.makeText(MainActivity.this, R.string.twice_click_answer, Toast.LENGTH_SHORT).show();
                }
            }
        });
        updateQuestion();//method is called for extra case
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null) {
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }

    private void updateQuestion() { //changing text in textView if the counter number was increased
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        mCheckedButton = false;
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if(mIsCheater) { //if the user has cheated
            messageResId = R.string.judgment_toast;
        }else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }
        mCheckedButton = true;
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    //other methods of life cycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {//save counter
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);//saving counter to use it after the activity was opened again
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}