package de.prog3.tetrix;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;

import de.prog3.tetrix.Class.Gamefield;

public class GameView extends View {
    private Gamefield gamefield;


    public GameView(Context context) {
        super(context);


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
    public void onButtonLeftClicked(){
        gamefield.moveLeft();
    }
    public void onButtonRightClicked(){
        gamefield.moveRight();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}


