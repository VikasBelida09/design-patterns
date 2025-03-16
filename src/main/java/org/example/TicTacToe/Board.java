package org.example.TicTacToe;

public class Board {
    Cell[][] gameBoard;
    int size;
    Board(int N){
        size=N;
        gameBoard=new Cell[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                gameBoard[i][j]=new Cell(i,j);
            }
        }
    }
    void makeMove(int x, int y, Player currentPlayer){
        gameBoard[x][y].piece=currentPlayer.getPiece();
    }
    boolean checkMove(int x, int y){
         return x>=0 && y>=0 && x<size && y<size && gameBoard[x][y].piece==Piece.EMPTY;
    }
    boolean checkWinner(Player currentPlayer){
        for(int i=0;i<size;i++){
            if(checkRow(i, currentPlayer.getPiece()) || checkColumn(i, currentPlayer.getPiece()))return true;
        }
        return checkDiagonal(currentPlayer.getPiece()) || checkAntiDiagonal(currentPlayer.getPiece());
    }
    boolean checkDiagonal(Piece piece){
        for(int i=0;i<size;i++){
            if(gameBoard[i][i].piece!=piece)return false;
        }
        return true;
    }
    boolean checkAntiDiagonal(Piece piece){
        for(int i=0;i<size;i++){
            if(gameBoard[i][size-i-1].piece!=piece)return false;
        }
        return true;
    }
    boolean checkRow(int i, Piece piece){
        for(int col=0;col<size;col++){
            if(gameBoard[i][col].piece!=piece)return false;
        }
        return true;
    }
    boolean checkColumn(int i, Piece piece){
        for(int row=0;row<size;row++){
            if(gameBoard[row][i].piece!=piece)return false;
        }
        return true;
    }
    void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print("| "+gameBoard[i][j].piece.toString()+" |");
            }
            System.out.println(" ");
        }
    }
}
