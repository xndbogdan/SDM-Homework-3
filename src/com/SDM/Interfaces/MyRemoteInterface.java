package com.SDM.Interfaces;
import com.SDM.Models.Seat;
import com.SDM.Models.Ticket;
import com.SDM.Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MyRemoteInterface extends Remote {
    public ArrayList<Seat> getEmptySeats(User u) throws RemoteException;
    public boolean occupySeat(Seat s, User u) throws RemoteException;
    public ArrayList<Ticket> getTickets(User u) throws RemoteException;
}
