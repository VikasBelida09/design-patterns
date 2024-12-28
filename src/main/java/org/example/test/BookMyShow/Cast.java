package org.example.test.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Cast {
    private List<Actor> actorList;
    public Cast(){
        actorList=new ArrayList<>();
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
