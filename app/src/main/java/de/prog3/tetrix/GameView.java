package de.prog3.tetrix;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;

import de.prog3.tetrix.interfaces.Gamefield;
import de.prog3.tetrix.interfaces.IPiece;
import de.prog3.tetrix.pieces.LPieceLeft;

public class GameView extends View {
    private Bitmap form, backgroundImage, scoreStar;
    private  ABlock playerBlock;

    private int formX;
    private int canvasWidth, canvasHeight;
    private int formWidth = 40;
    private int formHeight = 40;
    private Paint scorePaint = new Paint();
    private int startY,drawY;
    private int xGrid[] = new int[10];
    private int yGrid[] = new int[18];
    private Block[][] feld= new Block[10][18];
    private int screenWidthPixels;
    private int screenHeightPixels;
    private de.prog3.tetrix.interfaces.Gamefield gamefield;


    de.prog3.tetrix.interfaces.Block grid[][] = new de.prog3.tetrix.interfaces.Block[10][21];
    IPiece activePiece;





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
        this.invalidate();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}


