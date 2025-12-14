/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Igra;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author milos
 */
public class ObradaKlijentskihZahteva extends Thread {
    private Socket s;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while(true){
            KlijentskiZahtev kz=primiZahtev();
            ServerskiOdgovor so=new ServerskiOdgovor();
            switch(kz.getOperacija()){
                case operacije.Operacije.vratiBrojPogodjenih:
                    Igra pokusaj=controller.Controller.getInstance().vratiBrojPogodjenih((Igra)kz.getParam());
                    so.setServerskiOdgovor((Igra)pokusaj);
                    break;
                default:
                    System.out.println("Greska, nema operacije");
                    
            }
           posaljiOdgovor(so);
        }
        
    }

    public KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
