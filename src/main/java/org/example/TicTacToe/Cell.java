package org.example.TicTacToe;

public class Cell {
    int row;
    int col;
    Piece piece;

    Cell(int i, int j){
        this.row=i;
        this.col=j;
        this.piece=Piece.EMPTY;
    }
}
