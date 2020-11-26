package com.Brinkley.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    //keys for intent
    private static final String EXTRA_ANSWER_IS_TRUE =
            "com.Brinkley.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.Brinkley.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false); //extracting boolean extra from intent

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswerIsTrue) {//changing text according to the right answer
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);//preparing answer to the MainActivity

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//checking version on the device
                    //adding animation
                    int cx = mShowAnswerButton.getWidth() / 2;
                    int cy = mShowAnswerButton.getHeight() / 2;
                    float radius = mShowAnswerButton.getWidth();
                    Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswerButton, cx, cy, radius, 0);//button is disappearing in a circle
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mShowAnswerButton.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                    //end of the animation
                } else {
                    mShowAnswerButton.setVisibility(View.VISIBLE);//simply making the button invisible
                }
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();//create new intent to send answer with it
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);//writing answer in it
        setResult(RESULT_OK, data);//packing result to send intent out to the caller
        //if button wasn't clicked than the result of the Activity would be RESULT_CANCELED
    }

    public static boolean wasAnswerShown(Intent result) { //returning the answer to the question that was asked in the name of the method
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);//making easy to decode
    }

    //static method to create intend and send info at once (and do it only in CheatActivity)
    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

}