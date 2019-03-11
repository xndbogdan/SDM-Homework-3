package com.SDM.Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteInterface extends Remote {
    public int getResult () throws RemoteException;
    public void add(int d) throws RemoteException;
}
