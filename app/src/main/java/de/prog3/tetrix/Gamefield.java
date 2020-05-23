package de.prog3.tetrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class Gamefield extends View {
    private int xGrid[] = new int[10];
    private int yGrid[] = new int[18];
    private Block[][] feld= new Block[10][18];
    private int x;
    private int y;
    private int width;
    private int height;
    private int screenWidthPixels;
    private int screenHeightPixels;
    private Bitmap gamefield;
    private ABlock playerBlock;

    public Gamefield(Context context, int x, int y, int screenWidthPixels, int screenHeightPixels) {
        super(context);
        this.x = x;
        this.y = y;
        this.screenWidthPixels = screenWidthPixels;
        this.screenHeightPixels = screenHeightPixels;

        gamefield = BitmapFactory.decodeResource(getResources(), R.drawable.gamefield);
        gamefield = Bitmap.createScaledBitmap(gamefield,screenWidthPixels/2, screenHeightPixels/2,false);

        int k= (screenWidthPixels/2)/2;
        for (int i = 1; i <xGrid.length+1; i++){
            xGrid[i-1]=((gamefield.getWidth()/10)*i)+x-40;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(gamefield, (screenWidthPixels/2)/2,(screenHeightPixels/2)/3 , null);
        playerBlock.onDraw(canvas);
    }


}
