package de.prog3.tetrix.pieces;

import android.graphics.Color;

import de.prog3.tetrix.interfaces.Block;

public class LongPiece extends Piece4x4{

    public LongPiece(Block[][] grid) {
        super(grid);
        this.color = Color.parseColor("#aaaa40");

        this.blocks[0][1] = true;
        this.blocks[1][1] = true;
        this.blocks[2][1] = true;
        this.blocks[3][1] = true;
    }
}
