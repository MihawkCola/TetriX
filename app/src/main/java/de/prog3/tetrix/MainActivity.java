package de.prog3.tetrix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity {
    public int speed = 6;
    private GameView gameview;
    private Handler handler = new Handler();

    private Button buttonL, buttonR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonL = findViewById(R.id.Butten_Left);
        buttonR = findViewById(R.id.Button_right);

        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameview.onButtonRightClicked();
            }
        });
        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameview.onButtonLeftClicked();
            }
        });

        gameview = new GameView(this);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.gameview);
        layout1.addView(gameview);

        final Runnable nextFrameRunnable = new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameview.nextFrame();
                    }
                });
                gameview.postDelayed(this, 1000 / speed);
            }
        };

        final Runnable FPS = new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameview.invalidate();
                    }
                });
                gameview.postDelayed(this, 1000 / 60);
            }
        };

        gameview.post(nextFrameRunnable);
        gameview.post(FPS);

    }
}
