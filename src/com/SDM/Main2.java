package com.SDM;

import com.SDM.Models.MyRemote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import com.SDM.Interfaces.MyRemoteInterface;
import com.SDM.Models.Seat;
import com.SDM.Models.Ticket;
import com.SDM.Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        User u = new User(); // this is you!
        u.setName("Tester");

        Registry registry = LocateRegistry.getRegistry(2500);

        MyRemoteInterface remote = (MyRemoteInterface) registry.lookup("object");

        System.out.println("Connected to the server with the user "+u.getName());

        ArrayList<Seat> Seats;

        System.out.println();
        String choice="";

        while(!choice.equals("x")){
            Seats = remote.getEmptySeats(u);
            System.out.println("Empty seats: ");

            for(Seat s:Seats){
                System.out.print(s.getSeatNumber()+" ");
            } System.out.println();

            System.out.println("1.Select a seat");
            System.out.println("2.View your tickets");
            System.out.println("x.Exit");
            choice = reader.nextLine();
            if(choice.equals("1")){
                System.out.println("Select seat by number: ");
                String seatNum = reader.nextLine();
                Seat selectedSeat=null;
                for(Seat s:Seats){
                    if(Integer.toString(s.getSeatNumber()).equals(seatNum)){
                        selectedSeat=s;
                    }
                }
                if(selectedSeat==null){
                    System.out.println("Seat number is invalid! Press enter to continue.");
                    reader.nextLine();
                } else {
                    System.out.println("1.Buy ticket for this seat");
                    System.out.println("2.Get seat row");
                    System.out.println("x.Exit");
                    choice=reader.nextLine();
                    if(choice.equals("1")){
                        if(remote.occupySeat(selectedSeat,u)){
                            System.out.println("Ticket bought! Press enter to continue");
                        } else {
                            System.out.println("Seat is already occupied! Press enter to continue");
                        }
                        reader.nextLine();
                    }
                    else if(choice.equals("2")){
                        System.out.println("Selected seat row is: "+selectedSeat.getRow());
                    }
                }

            } else if(choice.equals("2")){
                ArrayList<Ticket> myTickets = remote.getTickets(u);
                if(myTickets.isEmpty()){
                    System.out.println("You don't have any tickets!");
                }
                else System.out.println("Tickets:");
                int counter=1;
                for(Ticket t:myTickets){
                    System.out.println("Ticket "+counter+" - Seat "+t.getSeat().getSeatNumber()+" with row "+t.getSeat().getRow());
                    counter++;
                }
            }
        }

    }
}
