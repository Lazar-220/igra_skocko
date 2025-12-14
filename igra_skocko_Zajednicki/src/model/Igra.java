/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author milos
 */
public class Igra implements Serializable {
    //private int id;
    private int rb;
    private String kombinacija;
    private int brojPogodjenihNaMestu;
    private int brojPogodjenihVanMesta;

    public Igra() {
    }

    public Igra(int rb, String kombinacija, int brojPogodjenihNaMestu, int brojPogodjenihVanMesta) {
        this.rb = rb;
        this.kombinacija = kombinacija;
        this.brojPogodjenihNaMestu = brojPogodjenihNaMestu;
        this.brojPogodjenihVanMesta = brojPogodjenihVanMesta;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getKombinacija() {
        return kombinacija;
    }

    public void setKombinacija(String kombinacija) {
        this.kombinacija = kombinacija;
    }

    public int getBrojPogodjenihNaMestu() {
        return brojPogodjenihNaMestu;
    }

    public void setBrojPogodjenihNaMestu(int brojPogodjenihNaMestu) {
        this.brojPogodjenihNaMestu = brojPogodjenihNaMestu;
    }

    public int getBrojPogodjenihVanMesta() {
        return brojPogodjenihVanMesta;
    }

    public void setBrojPogodjenihVanMesta(int brojPogodjenihVanMesta) {
        this.brojPogodjenihVanMesta = brojPogodjenihVanMesta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Igra other = (Igra) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (this.brojPogodjenihNaMestu != other.brojPogodjenihNaMestu) {
            return false;
        }
        if (this.brojPogodjenihVanMesta != other.brojPogodjenihVanMesta) {
            return false;
        }
        return Objects.equals(this.kombinacija, other.kombinacija);
    }

    @Override
    public String toString() {
        return "Igra{" + "rb=" + rb + ", kombinacija=" + kombinacija + ", brojPogodjenihNaMestu=" + brojPogodjenihNaMestu + ", brojPogodjenihVanMesta=" + brojPogodjenihVanMesta + '}';
    }
    
    
}
