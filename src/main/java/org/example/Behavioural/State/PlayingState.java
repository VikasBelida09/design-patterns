package org.example.Behavioural.State;

public class PlayingState implements MusicState{
    private MusicPlayer player;
    public PlayingState(MusicPlayer player){
        this.player=player;
    }
    @Override
    public void pressPlayButton() {
        System.out.println("pausing music player");
        this.player.setState(new PausedState(player));
    }
}
