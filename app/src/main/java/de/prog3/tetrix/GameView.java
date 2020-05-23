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

public class GameView extends View {
    private Bitmap form, backgroundImage, gamefield, scoreStar;
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
    private Gamefield g;








    public GameView(Context context) {
        super(context);

        DisplayMetrics dpm = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dpm);
        form = BitmapFactory.decodeResource(getResources(), R.drawable.square);
        form = Bitmap.createScaledBitmap(form, formWidth, formHeight, false);


        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background_main);

        gamefield = BitmapFactory.decodeResource(getResources(), R.drawable.gamefield);
        gamefield = Bitmap.createScaledBitmap(gamefield,dpm.widthPixels/2, dpm.heightPixels/2,false);


        int x= (dpm.widthPixels/2)/2;
        for (int i = 1; i <xGrid.length+1; i++){
            xGrid[i-1]=((gamefield.getWidth()/10)*i)+x-40;
        }


        formX = (getScreenWidth() / 2) - (form.getWidth() / 2);
        startY = (dpm.heightPixels/2)/3;
        drawY = (dpm.heightPixels/2)/3;
        formX = xGrid[0];
        playerBlock = new ABlock(form,formX,startY,true,40,1);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        backgroundImage = Bitmap.createScaledBitmap(backgroundImage, canvasWidth, canvasHeight, false);
        Rect frameToDrawBG = new Rect(0, 0, backgroundImage.getWidth(), backgroundImage.getHeight());
        RectF whereToDrawBG = new RectF(0, 0, canvasWidth, canvasHeight);
        canvas.drawBitmap(backgroundImage, frameToDrawBG, whereToDrawBG, null);

        canvas.drawBitmap(gamefield, (canvasWidth/2)/2,(canvasHeight/2)/3 , null);

        playerBlock.onDraw(canvas);

    }


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}


