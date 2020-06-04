package de.prog3.tetrix.Class;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.concurrent.ThreadLocalRandom;

import de.prog3.tetrix.Class.Block;
import de.prog3.tetrix.R;
import de.prog3.tetrix.interfaces.IPiece;
import de.prog3.tetrix.pieces.LPieceLeft;
import de.prog3.tetrix.pieces.LPieceRight;
import de.prog3.tetrix.pieces.LongPiece;
import de.prog3.tetrix.pieces.OPiece;
import de.prog3.tetrix.pieces.TPiece;
import de.prog3.tetrix.pieces.ZPieceLeft;
import de.prog3.tetrix.pieces.ZPieceRight;

public class Gamefield {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;

    // Tetris Grid 10x21
    Block grid[][] = new Block[WIDTH][HEIGHT];
    IPiece activePiece;

    Bitmap gamefieldBackground;

    public boolean isFinished = false;

    public int x;
    public int y;
    int blockSize;
    int i = 0;

    public Gamefield(Context context) {
        gamefieldBackground = BitmapFactory.decodeResource(context.getResources(), R.drawable.gamefield);


        for (int i = 0; i < grid.length; i++){
            for (int k = 0; k < grid[i].length; k++){
                Bitmap form;
                form = BitmapFactory.decodeResource(context.getResources(), R.drawable.square_white);

                grid[i][k] = new Block(form);
            }
        }
        createRandomNextPiece();


        activePiece.addToGrid();
    }

    public void createRandomNextPiece(){
        int k = ThreadLocalRandom.current().nextInt(0, 5);
        int position = (WIDTH / 2) - 1;
        switch(k) {
            case 0:
                activePiece = new LPieceLeft(grid,position);
                break;
            case 1:
                activePiece = new ZPieceLeft(grid,position);
                break;
            case 2:
                activePiece = new ZPieceRight(grid,position);
                break;
            case 3:
                activePiece = new LPieceRight(grid,position);
                break;
            case 4:
                activePiece = new TPiece(grid,position);
                break;
            case 5:
                activePiece = new OPiece(grid);
                break;
            case 6:
                activePiece = new LongPiece(grid);
                break;
        }
    }


    public void moveLeft(){
      activePiece.movePieceLeft();
    }
    public void moveRight(){
        activePiece.movePieceRight();
    }

    public void nextFrame() {
        if (isFinished) return;

        boolean hasMovedDown = activePiece.movePieceDown();
        if(!hasMovedDown) {
            createRandomNextPiece();
            boolean addedSuccessfully = activePiece.addToGrid();
            if (!addedSuccessfully) {
                //TODO: SPIEL ABBRUCH
                isFinished = true;
            }
        }
    }

    public void draw(Canvas canvas) {
        int borderoffset = 4;
        int x = borderoffset;
        int y = borderoffset;
        int blockSize;

        int width = canvas.getWidth() - borderoffset*2;
        int height = canvas.getHeight() - borderoffset*2;
        if ((width / WIDTH)*HEIGHT > height) {
            blockSize = height / HEIGHT;
            // Spielfeld ist breiter als hoch
        } else {
            blockSize = width / WIDTH;
            // Spielfeld ist höher als breit
        }
        x = (width- blockSize*WIDTH )/2; // centrieren

        // draw gamefield background
        if (gamefieldBackground.getWidth() != blockSize*WIDTH + borderoffset*2) {
            gamefieldBackground = Bitmap.createScaledBitmap(
                    gamefieldBackground,
                    blockSize*WIDTH + borderoffset*2,
                    blockSize*HEIGHT + borderoffset*2,
                    false
            );
        }
        canvas.drawBitmap(gamefieldBackground, x-borderoffset, y-borderoffset, null);

        // draw blocks
        for (int i = 0; i < grid.length; i++){
            for (int k = 0; k < grid[i].length; k++){
                grid[i][k].draw(canvas,x+(i*blockSize),y+(k*blockSize), blockSize);
            }
        }
    }
}
