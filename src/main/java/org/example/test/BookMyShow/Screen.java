package org.example.test.BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Screen {
    private String screenId;
    private List<Show> shows;
    private int screenNumber;
    private int seatingCapacity;
    private Theatre theatre;
    public Screen(int screenNumber,int seatingCapacity, Theatre theatre){
        this.screenNumber=screenNumber;
        this.seatingCapacity=seatingCapacity;
        this.shows=new ArrayList<>();
        this.screenId="SC"+ UUID.randomUUID().toString().substring(0,8);
        this.theatre=theatre;
    }
    public void addShow(Show s){
        this.shows.add(s);
    }
    public void removeShow(Show s){
        this.shows.remove(s);
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
