package de.prog3.tetrix;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Block {
protected int x;
protected int y;
protected Bitmap block;
protected boolean isAktiev;
protected int size;
    public Block(Bitmap block, int x, int y, boolean isAktiev, int size){
        this.block = block;
        this.x = x;
        this.y = y;
        this.isAktiev = isAktiev;
        this.size = size;
    }
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(block, x, y, null);
    }

    public void setX(int x) {
        this.x = x;
    }
}
