package org.example.SnakeAndLadder;

import java.util.List;

public class SnakeAndLadder {
    private final Board board;
    private final List<Player> players;
    private int currentIndex;
    SnakeAndLadder(List<String>players){
        this.players=players.stream().map(Player::new).toList();
        board=new Board();
        currentIndex=0;
    }
    void startGame(){
        while(!isGameOver()){
            int roll=Dice.roll();
            Player player=players.get(currentIndex);
            int newPos= board.getPlayerPositionAfterSnakeOrLadderCheck(player.position + roll);
            if(newPos <= board.getBoardSize()){
                player.position=newPos;
                System.out.println("Player "+player.name+" rolled a dice " +roll+" and has moved to "+newPos);
            }
            if(newPos==board.getBoardSize()){
                System.out.println(player.name + " wins!");
                break;
            }
            currentIndex = (currentIndex+1)%players.size();
        }
    }
    boolean isGameOver(){
        for(Player player:players){
            if(player.position==board.getBoardSize())return true;
        }
        return false;
    }
}
