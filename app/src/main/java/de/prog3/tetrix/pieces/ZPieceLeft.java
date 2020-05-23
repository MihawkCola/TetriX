package de.prog3.tetrix.pieces;

import android.graphics.Color;

import de.prog3.tetrix.interfaces.Block;

public class ZPieceLeft extends Piece3x3 {
    public ZPieceLeft(Block[][] grid) {
        super(grid);

        this.color = Color.parseColor("#00ff00");

        this.blocks[1][0] = true;
        this.blocks[2][0] = true;
        this.blocks[0][1] = true;
        this.blocks[1][1] = true;
    }
}
