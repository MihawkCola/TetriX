package de.prog3.tetrix.interfaces;

public interface IPiece {
    public int getColor();

    public boolean canMoveLeft();
    public boolean canMoveRight();
    public boolean canMoveDown();
    public void movePieceLeft();
    public void movePieceRight();
    public boolean movePieceDown();

    public boolean canRotateLeft();
    public boolean canRotateRight();
    public void rotateLeft();
    public void rotateRight();

    public boolean addToGrid();
}
