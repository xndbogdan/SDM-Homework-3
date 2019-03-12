package com.SDM.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable {
    private User owner;
    private Seat Seat;

    public Ticket() {
        owner = null;
        Seat = null;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public com.SDM.Models.Seat getSeat() {
        return Seat;
    }

    public void setSeat(com.SDM.Models.Seat seat) {
        Seat = seat;
    }

}
