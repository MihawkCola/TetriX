package de.prog3.tetrix.pieces;

import android.graphics.Color;

import de.prog3.tetrix.Abstract.Piece3x3;
import de.prog3.tetrix.Class.Block;

public class ZPieceRight extends Piece3x3 {
    public ZPieceRight(Block[][] grid, int x) {
        super(grid,x);

        this.color = Color.parseColor("#0000ff");

        this.blocks[0][0] = true;
        this.blocks[1][0] = true;
        this.blocks[1][1] = true;
        this.blocks[2][1] = true;
    }
}
