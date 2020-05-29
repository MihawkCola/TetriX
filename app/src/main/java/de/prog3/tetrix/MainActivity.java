package de.prog3.tetrix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity {
    public int speed = 6;
    private GameView game;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new GameView(this);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.gameview);
        layout1.addView(game);

        final Runnable nextFrameRunnable = new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        game.nextFrame();
                    }
                });
                game.postDelayed(this, 1000 / speed);
            }
        };

        final Runnable FPS = new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        game.invalidate();
                    }
                });
                game.postDelayed(this, 1000 / 60);
            }
        };

        game.post(nextFrameRunnable);
        game.post(FPS);

    }
}
