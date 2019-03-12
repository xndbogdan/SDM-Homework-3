package com.SDM.Models;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.SDM.Interfaces.MyRemoteInterface;
import com.SDM.Models.Seat;

public class MyRemote extends UnicastRemoteObject implements MyRemoteInterface {
    private ArrayList<Seat> seats;
    private ArrayList<Ticket> tickets;
    private ArrayList<User> users;

    public MyRemote() throws RemoteException {
        super();
        int seatNumber=1;
        seats=new ArrayList<Seat>(); //10x10 seats for this example
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                Seat s = new Seat();
                s.setRow(i);
                s.setSeatNumber(seatNumber);
                s.vacate();
                seats.add(s);
                seatNumber++;
            }
        }
        tickets=new ArrayList<>();
        users = new ArrayList<>();
    }
    public ArrayList<Seat> getEmptySeats(User u){
        System.out.println("User "+u.getName()+" is checking empty seats");
        ArrayList<Seat> emptySeats = new ArrayList<>();
        for(Seat s:seats){
            if(!s.isOccupied()){
                emptySeats.add(s);
            }
        }

        return emptySeats;
    }
    public boolean occupySeat(Seat s, User u) {
        for(Seat seat:seats){
            if(seat.getSeatNumber()==s.getSeatNumber()){
                System.out.println("User "+u.getName()+" bought a ticket!");
                if(!seat.isOccupied()){
                    seat.occupy();
                    Ticket t = new Ticket();
                    t.setSeat(s);
                    boolean newUser = true;
                    for(User usr:users) {
                        if(usr==u) {
                            newUser=false;
                            t.setOwner(usr);
                        }
                    }
                    if(newUser){
                        users.add(u);
                        t.setOwner(u);
                    }
                    tickets.add(t);
                    System.out.println("Cha-ching!");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public ArrayList<Ticket> getTickets(User u){
        System.out.println("User "+u.getName()+" is viewing tickets");
        ArrayList<Ticket> myTickets = new ArrayList<>();
        for(Ticket t:tickets) {
            if(t.getOwner().getName().equals(u.getName())){
                myTickets.add(t);
            }
        }
        return myTickets;
    }
}
