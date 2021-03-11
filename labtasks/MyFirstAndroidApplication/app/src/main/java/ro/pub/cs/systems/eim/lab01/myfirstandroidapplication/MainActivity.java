package ro.pub.cs.systems.eim.lab01.myfirstandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final private static long TRANSPARENCY_EFFECT_DURATION = 5000;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText userNameEditText = (EditText) findViewById(R.id.user_name_edit_text);
            // get the container for the views
            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
            String greetingText = "Welcome to the EIM laboratory, xxx!";

            // create a new view and set the text to a greeting
            final TextView textView = new TextView(MainActivity.this);
            textView.setAlpha(1);
            textView.setText(greetingText.replace("xxx", userNameEditText.getText()));
            linearLayout.addView(textView, 0);

            // animation effect
            AlphaAnimation fadeEffect = new AlphaAnimation(1.0f, 0.0f);
            fadeEffect.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    linearLayout.removeView(textView);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            fadeEffect.setDuration(TRANSPARENCY_EFFECT_DURATION);
            fadeEffect.setFillAfter(true);
            textView.setAnimation(fadeEffect);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(buttonClickListener);
    }
}
