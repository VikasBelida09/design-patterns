package org.example.test.BookMyShow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Show {
    private Movie movie;
    private List<Seat> seatList;
    private LocalDate showStartDate;
    private String showId;
    private double price;
    private Screen screen;
    private Theatre theatre;

    public Show(int seatingCapacity,LocalDate showStartDate,double price, Screen screen){
        this.showId="SHOW"+ UUID.randomUUID().toString().substring(0,8);
        this.seatList=new ArrayList<>();
        this.showStartDate=showStartDate;
        this.price=price;
        generateSeatingLayout(seatingCapacity);
        this.screen=screen;
        this.theatre=screen.getTheatre();
    }
    public void generateSeatingLayout(int seatingCapacity){
        char level='A';
        for(int i=1;i<=seatingCapacity;i++){
            int number=i;
            if(i%10==0){
                level=(char)(level+1);
                number=1;
            }
            Seat seat=new Seat(level, number);
            this.seatList.add(seat);
        }
    }
    public boolean reserveSeat(String seatDetails){
      Optional<Seat> seat= Optional.of(this.seatList.stream().filter(s -> (s.getLevel() + "-" + s.getNumber()).equals(seatDetails)).findFirst().get());
        return seat.map(Seat::bookSeat).orElse(false);
    }
    public void showSeatLayout(){
        // logic to show seat layout;
        char level='A';
        for(int i=1;i<=this.seatList.size();i++){
            Seat s=this.seatList.get(i-1);
            if(i%10==0){
                System.out.println("");
            }
            String print=s.getStatus()==SeatStatus.AVAILABLE ? "|"+s.getLevel()+"-"+s.getNumber()+"|":"|X|";
            System.out.print(print);
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public LocalDate getShowStartDate() {
        return showStartDate;
    }

    public void setShowStartDate(LocalDate showStartDate) {
        this.showStartDate = showStartDate;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
