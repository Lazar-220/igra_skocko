/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitiK;

import forme.KlijentskaForma;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author milos
 */
public class NitK extends Thread {
    private KlijentskaForma kf;
    private boolean kraj=false;
    private JLabel labela;

    public NitK(KlijentskaForma kf,JLabel labela) {
        this.kf = kf;
        this.labela=labela;
    }

    @Override
    public void run() {
        while(!kraj){
            try {
                Random r=new Random();
                int min=0;
                int max=5;
                int broj=r.nextInt(max-min+1)+min;
                labela.setText(broj+"");
                //kf.popunilabelu(labela);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitK.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void zaustavi(){
        kraj=true;
        //interrupt();
    }
}
