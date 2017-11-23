package projects.nyinyihtunlwin.takenote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import projects.nyinyihtunlwin.takenote.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = NoteListActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        }, 3000);

    }
}
