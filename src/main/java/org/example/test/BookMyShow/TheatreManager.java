package org.example.test.BookMyShow;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TheatreManager {
    private final List<Theatre> theatreList;
    public TheatreManager(){
        this.theatreList=new CopyOnWriteArrayList<>();
    }
    public void addTheatre(Theatre t){
        this.theatreList.add(t);
    }
    public void removeTheatre(Theatre t){
        this.theatreList.remove(t);
    }
    public List<Show> getShowsByMovieName(String movie){
        return this.theatreList.parallelStream().flatMap(theatre->theatre.searchByMovieName(movie).stream()).collect(Collectors.toList());
    }
    public List<Show> getShowsByStartDate(LocalDate date){
        return this.theatreList.parallelStream().flatMap(theatre->theatre.searchByShowStartTime(date).stream()).collect(Collectors.toList());
    }
    public List<Theatre> getTheatreList(String theatreName){
        return getTheatresByFilter(t->t.getTheatreName().contains(theatreName));
    }
    public List<Theatre> getTheatreListByLocation(String pinCode){
        return getTheatresByFilter(theatre -> theatre.getAddress().getPinCode().equals(pinCode));
    }
    public List<Theatre> getTheatresByFilter(Predicate<Theatre> filter){
        return this.theatreList.stream().filter(filter).toList();
    }
}
