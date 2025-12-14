/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milos
 */
public class PokreniServer extends Thread {
    private ServerSocket serverSocket;
    private boolean kraj=false;

    @Override
    public void run() {
        try {
            serverSocket=new ServerSocket(9000);
            while(!kraj){
                System.out.println("Soket je otvoren");
                Socket s=serverSocket.accept();
                ObradaKlijentskihZahteva nit=new ObradaKlijentskihZahteva(s);
                System.out.println("Klijent se povezao");
                nit.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void zaustavi(){
        System.out.println("Soket je zatvoren");
        kraj=true;
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
