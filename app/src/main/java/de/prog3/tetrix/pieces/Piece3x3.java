package de.prog3.tetrix.pieces;

import android.graphics.Color;

import de.prog3.tetrix.interfaces.Block;
import de.prog3.tetrix.interfaces.IPiece;

public abstract class Piece3x3 implements IPiece {
    private int x;
    private int y;

    protected int color;

    /** The blocks inside te 3x3 Area that are blocked by this piece */
    protected boolean blocks[][];

    /** reference t the parent grid */
    private Block[][] grid;

    public  Piece3x3(Block[][] grid) {
        this.blocks = new boolean[3][3];
        this.grid = grid;
        x = 0;
        y = 0;

        this.color = Color.parseColor("#ff0000");

    }


    public boolean canMoveLeft() {
        return false;
    }
    public boolean canMoveRight() {
        return false;
    }


    public boolean canMoveDown() {
        for (int i = 0; i <3;i++){
            for (int k = 0; k <3;k++){
                if(blocks[i][k]) {
                    // Unterkante des Spielfelds erreicht?
                    if (y+k+1 >= grid[0].length) {
                        return false;
                    }

                    boolean isSelfBelow = false;
                    if (k+1 < 3) {
                        isSelfBelow = this.blocks[i][k+1];
                    }
                    Block blockBelow = grid[x+i][y+k+1];
                    if(!isSelfBelow && blockBelow.isActive()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void movePieceLeft() {
    }
    public void movePieceRight() {
    }

    /**
     * Add this piece to the grid
     */
    public void addToGrid() {
        updateGrid(this);
    }
    /**
     * Remove this piece from the grid
     */
    private void removeFromGrid() {
        updateGrid(null);
    }
    private void updateGrid(IPiece piece){
        for (int i = 0; i <3;i++) {
            for (int k = 0; k < 3; k++) {
                if (blocks[i][k]) {
                    grid[x + i][y + k].setPiece(piece);
                }
            }
        }
    }


    public boolean movePieceDown() {
        if (canMoveDown()) {
            removeFromGrid();
            y++;
            addToGrid();
            return true;
        }
        return false;
    }


    public boolean canRotateLeft() {
        return false;
    }


    public boolean canRotateRight() {
        return false;
    }


    public void rotateLeft() {
    }


    public void rotateRight() {
    }

    public int getColor() {
        return this.color;
    }
}
