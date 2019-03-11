package com.SDM;

import com.SDM.Models.MyRemote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import com.SDM.Interfaces.MyRemoteInterface;

public class Main2 {
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry registry = LocateRegistry.getRegistry(7500);
        for(String s : registry.list()){
            System.out.println(s);
        }
        MyRemoteInterface remote = (MyRemoteInterface) registry.lookup("object");
        for(int i=0;i<10;i++) {
            remote.add(15);
            System.out.print(remote.getResult());
            Thread.sleep(1500);
        }
    }
}
