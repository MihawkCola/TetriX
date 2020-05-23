package de.prog3.tetrix.pieces;

import android.graphics.Color;

import de.prog3.tetrix.interfaces.Block;
import de.prog3.tetrix.interfaces.IPiece;

public class LPieceLeft extends Piece3x3{

    public LPieceLeft(Block[][] grid) {
        super(grid);
        this.color = Color.parseColor("#ffff00");

        this.blocks[0][0] = true;
        this.blocks[0][1] = true;
        this.blocks[1][1] = true;
        this.blocks[2][1] = true;
    }
}
