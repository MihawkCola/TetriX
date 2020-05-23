package de.prog3.tetrix;

import android.graphics.Bitmap;
import android.graphics.Canvas;

// Ablock steht für aktiver block
public class ABlock{
    protected int x;
    protected int y;
    protected Bitmap block;
    protected boolean isAktiev;
    protected int size;
    protected Block blocke[]; // ToDo soll später mehrere Blocke Darstellen
    protected int moveSpeed;
    public ABlock(Bitmap block, int x, int y, boolean isAktiev, int size,int moveSpeed) {
        this.block = block;
        this.x = x;
        this.y = y;
        this.isAktiev = isAktiev;
        this.size = size;
        this.moveSpeed = moveSpeed;
        this.moveSpeed = moveSpeed;
    }

    public void moveDown(){
        y = y + moveSpeed;
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(block, x, y, null);
        moveDown();
    }

}
