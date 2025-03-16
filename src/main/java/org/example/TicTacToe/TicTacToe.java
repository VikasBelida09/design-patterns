package org.example.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    Board board;
    Player player1, player2;
    Player currentPlayer;

    TicTacToe(int size, Player player1, Player player2){
        board=new Board(size);
        this.player2=player2;
        this.player1=player1;
        this.currentPlayer=player1;
    }
    void startGame(){
        Scanner scanner=new Scanner(System.in);
        int moves=0;
        int maxMoves= board.size * board.size;
        while(moves < maxMoves){
            board.printBoard();
            System.out.println(currentPlayer.getName()+" ( "+currentPlayer.getPiece()+ " ) , enter row and column:");
            int x1= scanner.nextInt();
            int y1=scanner.nextInt();
            if(!board.checkMove(x1,y1)){
                System.out.println("Invalid Move x and y! please try again");
                continue;
            }
            board.makeMove(x1,y1,currentPlayer);
            moves++;
            if(board.checkWinner(currentPlayer)){
                System.out.println("Player "+currentPlayer.getName()+" is the winner!");
                return;
            }
            currentPlayer = currentPlayer==player1? player2:player1;
        }
        board.printBoard();
        System.out.println("Its a Draw!");
    }
    void resetGame(){
      startGame();
    }

    public static void main(String[] args) {
        Player player1=new Player("Player1",Piece.X);
        Player player2=new Player("Player2",Piece.O);
        TicTacToe game=new TicTacToe(3, player1, player2);
        game.startGame();
    }

}
