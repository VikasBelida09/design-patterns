package org.example.Behavioural.State;

public class PausedState implements MusicState{
    private final MusicPlayer player;
    public PausedState(MusicPlayer player){
        this.player=player;
    }
    @Override
    public void pressPlayButton() {
        System.out.println("playing music player");
        this.player.setState(new PlayingState(player));
    }
}
