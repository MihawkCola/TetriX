package de.prog3.tetrix;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import de.prog3.tetrix.interfaces.Gamefield;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public int FPS = 6;

    private TextView text;
    int count = 0;
    private Timer timer = new Timer();
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private ImageView imageView;
    private int breite =800;
    private int hoehe = 800;
    private GameView game;
    private Handler handler = new Handler();
    private ImageView im;



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
//                FPS++;
                game.postDelayed(this, 1000 / FPS);
            }
        };

        game.post(nextFrameRunnable);

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        game.nextFrame();
//                    }
//                });
//            }
//        }, 0, 1000 / FPS);
    }

    private void addCount(){
        count++;
        text.setText("Count: "+ count);
    }

    private void moveBox(int x,int y){
        if(x>1 || x <-1){return;}
        if(y>1 || y <-1){return;}

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.top){
            addCount();
            Toast.makeText(this ,"hi",Toast.LENGTH_SHORT).show();
        }
    }
}
