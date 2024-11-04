package org.example.Behavioural.State;

public class StoppedState implements MusicState{
    private MusicPlayer player;
    public StoppedState(MusicPlayer player){
        this.player=player;
    }
    @Override
    public void pressPlayButton() {
        System.out.println("starting music player");
        this.player.setState(new PlayingState(player));
    }
}
