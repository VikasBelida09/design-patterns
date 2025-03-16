package org.example.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE=100;
    private final List<Snake> snakeList;
    private final List<Ladder>ladderList;
    Board(){
        this.snakeList=new ArrayList<>();
        this.ladderList=new ArrayList<>();
        initSnakesAndLadders();
    }
    public int getBoardSize(){
        return BOARD_SIZE;
    }
    private void initSnakesAndLadders(){
        snakeList.add(new Snake(16, 8));
        snakeList.add(new Snake(48,10));
        snakeList.add(new Snake(60, 35));
        snakeList.add(new Snake(94, 6));
        snakeList.add(new Snake(72, 28));

        ladderList.add(new Ladder(11, 40));
        ladderList.add(new Ladder(15,55));
        ladderList.add(new Ladder(12, 32));
        ladderList.add(new Ladder(50, 96));
        ladderList.add(new Ladder(45, 91));
    }
    public int getPlayerPositionAfterSnakeOrLadderCheck(int currPosition){
        for(Snake snake: snakeList){
            if(snake.getStart()==currPosition) return snake.getEnd();
        }
        for(Ladder ladder:ladderList){
            if(ladder.getStart()==currPosition)return ladder.getEnd();
        }
        return currPosition;
    }

}
