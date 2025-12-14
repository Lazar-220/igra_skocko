/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author milos
 */
public class RezultatIgre implements Serializable {
    private int id;
    private Date datumVreme;
    private String zadataKombinacija;
    private int  brojPokusaja;
    private String rezultat;
    private List<Igra>pokusaji;

    public RezultatIgre() {
    }

    public RezultatIgre(int id, Date datumVreme, String zadataKombinacija, int brojPokusaja, String rezultat, List<Igra> pokusaji) {
        this.id = id;
        this.datumVreme = datumVreme;
        this.zadataKombinacija = zadataKombinacija;
        this.brojPokusaja = brojPokusaja;
        this.rezultat = rezultat;
        this.pokusaji = pokusaji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getZadataKombinacija() {
        return zadataKombinacija;
    }

    public void setZadataKombinacija(String zadataKombinacija) {
        this.zadataKombinacija = zadataKombinacija;
    }

    public int getBrojPokusaja() {
        return brojPokusaja;
    }

    public void setBrojPokusaja(int brojPokusaja) {
        this.brojPokusaja = brojPokusaja;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public List<Igra> getPokusaji() {
        return pokusaji;
    }

    public void setPokusaji(List<Igra> pokusaji) {
        this.pokusaji = pokusaji;
    }
    
    
}
