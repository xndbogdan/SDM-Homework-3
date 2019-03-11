package com.SDM.Models;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.SDM.Interfaces.MyRemoteInterface;

public class MyRemote extends UnicastRemoteObject implements MyRemoteInterface {
    private int sum=0;
    public MyRemote() throws RemoteException {
        super();
    }
    public void add(int d) throws RemoteException {
        sum+=d;
    }
    public int getResult() throws RemoteException {
        return sum;
    }
}
