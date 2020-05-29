package de.prog3.tetrix.pieces;

import android.graphics.Color;

import de.prog3.tetrix.Abstract.Piece3x3;
import de.prog3.tetrix.Class.Block;

public class TPiece extends Piece3x3 {

    public TPiece(Block[][] grid, int x) {
        super(grid,x);
        this.color = Color.parseColor("#ff00ff");

        this.blocks[1][0] = true;
        this.blocks[0][1] = true;
        this.blocks[1][1] = true;
        this.blocks[2][1] = true;
    }
}
