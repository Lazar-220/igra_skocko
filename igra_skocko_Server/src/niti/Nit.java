/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.ServerskaForma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milos
 */
public class Nit extends Thread {
    private ServerskaForma sf;
    private boolean kraj=false;

    public Nit(ServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        while(!kraj){
            try {
                sf.popuniLabele();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void zaustavi(){
        kraj=true;
        //interrupt();
    }
}
