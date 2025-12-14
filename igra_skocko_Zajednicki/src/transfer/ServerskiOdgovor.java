/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author milos
 */
public class ServerskiOdgovor implements Serializable{
    private Object serverskiOdgovor;

    

    
    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object serverskiOdgovor) {
        this.serverskiOdgovor = serverskiOdgovor;
    }

    public Object getServerskiOdgovor() {
        return serverskiOdgovor;
    }

    public void setServerskiOdgovor(Object serverskiOdgovor) {
        this.serverskiOdgovor = serverskiOdgovor;
    }
    
}
