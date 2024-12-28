package org.example.test.BookMyShow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class Theatre {
    private final List<Screen> screens;
    private String theatreId;
    private String theatreName;
    private Address address;
    public Theatre(String theatreName, Address address){
        this.theatreName=theatreName;
        this.address=address;
        this.theatreId="TH"+ UUID.randomUUID().toString().substring(0,8);
        screens=new ArrayList<>();
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // methods
    public void addScreen(Screen screen){
        this.screens.add(screen);
    }
    public void removeScreen(Screen screen){
        this.screens.remove(screen);
    }
    public List<Show> searchByMovieName(String movieName) {
        return getShowByFilter(show -> show.getMovie().getMovieName().equalsIgnoreCase(movieName));
    }

    public List<Show> searchByShowStartTime(LocalDate date) {
        return getShowByFilter(show -> show.getShowStartDate().isEqual(date));
    }
    public List<Show> getShowByFilter(Predicate<Show> filter){
        return screens.parallelStream()
                .flatMap(screen -> screen.getShows().stream())
                .filter(filter)
                .toList();
    }

}
