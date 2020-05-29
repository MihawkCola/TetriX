package de.prog3.tetrix;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

import de.prog3.tetrix.Class.Block;
import de.prog3.tetrix.Class.Gamefield;
import de.prog3.tetrix.interfaces.IPiece;

public class GameView extends View {
    private Gamefield gamefield;


    public GameView(Context context) {
        super(context);

        DisplayMetrics dpm = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dpm);

        gamefield = new Gamefield(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gamefield.draw(canvas);

       // playerBlock.onDraw(canvas);

    }

    /**
     * Calculates the next frame and renders it
     */
    public void nextFrame() {
        // calculate next frame
        gamefield.nextFrame();

        // invalidate the view to draw it again
        //this.invalidate();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}


