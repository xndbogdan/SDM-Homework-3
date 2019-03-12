package com.SDM;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.SDM.Models.MyRemote;

public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        MyRemote myr=new MyRemote();
        Registry registry=LocateRegistry.createRegistry(2500);
        registry.bind("object", myr);
        System.out.println("Server Online...Gdpr compliance is however, off! :)");
    }
}
