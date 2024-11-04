package org.example.Behavioural.State;

public class MusicPlayer {
    private MusicState state;
    public MusicPlayer(){
        state=new StoppedState(this);
    }
    public void pressPlayButton(){
        state.pressPlayButton();
    }
    public void setState(MusicState state){
        this.state=state;
    }
}
