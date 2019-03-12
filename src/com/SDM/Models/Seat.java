package com.SDM.Models;

import java.io.Serializable;

public class Seat implements Serializable {
    private boolean occupied;
    private int seatNumber;
    private int row;

    public Seat(){
        this.occupied=false;
    }
    public int getSeatNumber() {
        return this.seatNumber;
    }
    public boolean isOccupied(){
        return this.occupied;
    }
    public void occupy(){
        this.occupied=true;
    }
    public void vacate(){
        this.occupied=false;
    }
    public void setSeatNumber(int seatNumber){
        this.seatNumber=seatNumber;
    }
    public int getRow(){
        return row;
    }
    public void setRow(int row){
        this.row=row;
    }
}
