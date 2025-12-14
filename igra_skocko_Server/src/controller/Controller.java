/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import forme.ServerskaForma;
import java.util.ArrayList;
import java.util.List;
import model.Igra;
import model.RezultatIgre;

/**
 *
 * @author milos
 */
public class Controller {
    
    private List<Igra>pokusaji=new ArrayList<>();
    private List<RezultatIgre>igre=new ArrayList<>();
    private ServerskaForma sf;
    private static Controller instance;
    private DBBroker dbb;

    public static Controller getInstance() {
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }


    
    

    private Controller() {
        dbb=new DBBroker();
    }

    public Igra vratiBrojPogodjenih(Igra pokusaj) {
        String dobitnaKomb=sf.vratiDobitnuKomb();
        String[]cifrePrave=dobitnaKomb.split("-");
        String[]cifre=pokusaj.getKombinacija().split("-");
        int brNaMestu=0;
        int brVanMesta=0;
        boolean signal1=false;
        int cuvar1=0;
        boolean signal2=false;
        int cuvar2=0;
        String[]cifrePraveKopija=new String[4];
        String[]cifreKopija=new String[4];
        int index=0;
        String pomocnik="10";
        for(int i=0;i<cifrePrave.length;i++){
            if(cifrePrave[i].equals(cifre[i])){
                brNaMestu++;
            }else{
                cifrePraveKopija[index]=cifrePrave[i];
                cifreKopija[index]=cifre[i];
                index++;
            }
        }
        for(int i=0;i<index;i++){
            System.out.println(cifrePraveKopija[i]+" ");
            for(int j=0;j<index;j++){
                System.out.println(cifreKopija[j]+" ");
                if(cifrePraveKopija[i].equals(cifreKopija[j])){
                    
                    if(brojCifaraTrenutnogPravaKomb(cifrePraveKopija[i],cifrePraveKopija)>brojCifaraTrenutnogKombPokusaj(cifreKopija[j],cifreKopija)){
                        if(signal1==true&&!cifrePraveKopija[i].equals(pomocnik)){
                            signal2=true;
                            cuvar2=brojCifaraTrenutnogKombPokusaj(cifreKopija[j], cifreKopija);
                        }else{
                            pomocnik=cifrePraveKopija[i];
                            signal1=true;
                            cuvar1=brojCifaraTrenutnogKombPokusaj(cifreKopija[j], cifreKopija);
                        }
                    }else if(brojCifaraTrenutnogPravaKomb(cifrePraveKopija[i],cifrePraveKopija)<brojCifaraTrenutnogKombPokusaj(cifreKopija[j],cifreKopija)){
                        if(signal1==true&&!cifrePraveKopija[i].equals(pomocnik)){
                            signal2=true;
                            cuvar2=brojCifaraTrenutnogKombPokusaj(cifrePraveKopija[i], cifrePraveKopija);
                        }else{
                            pomocnik=cifrePraveKopija[i];
                            signal1=true;
                            cuvar1=brojCifaraTrenutnogKombPokusaj(cifrePraveKopija[i], cifrePraveKopija);
                        }
                    }
                    else{
                        brVanMesta++;
                        break;
                    }
                    
                }
            }
        }
        if(signal2==true){
            brVanMesta=brVanMesta+cuvar2;
        }
        if(signal1==true){
            brVanMesta=brVanMesta+cuvar1;
        }
        pokusaj.setBrojPogodjenihVanMesta(brVanMesta);
        pokusaj.setBrojPogodjenihNaMestu(brNaMestu);
        
        pokusaji.add(pokusaj);
        return pokusaj;
          
    }

    private int brojCifaraTrenutnogKombPokusaj(String KombPokusaj, String[] cifre) {
        int brojac=0;
        for(int i=0;i<cifre.length;i++){
            if(KombPokusaj.equals(cifre[i])){
                brojac++;
            }
        }
        return brojac;
    }

    private int brojCifaraTrenutnogPravaKomb(String PravaKomb, String[] cifrePrave) {
        int brojac=0;
        for(int i=0;i<cifrePrave.length;i++){
            if(PravaKomb.equals(cifrePrave[i])){
                brojac++;
            }
        }
        return brojac;
    }

    public ServerskaForma getSf() {
        return sf;
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }

    public List<Igra> vratiPokusaje(){
        return pokusaji;
    }
    
    public void dodajRezultatIgre(RezultatIgre r){
        igre.add(r);
    }
    public List<RezultatIgre> vratiIgre(){
        return igre;
    }

    public void restartujListu() {
        pokusaji=new ArrayList<>();
    }

    public RezultatIgre dodajRezultatUBazu(RezultatIgre r) {
        return dbb.dodajRezultatUBazu(r);
    }

    public List<RezultatIgre> ucitajIgreIzBaze() {
        return dbb.ucitajIgreIzBaze();
    }

    public void dodajIgruUBazu(List<Igra> pokusaji,RezultatIgre r) {
        dbb.dodajIgruUBazu(pokusaji,r);
    }

    public List<Igra> ucitajPokusajeIzBaze(int idRezultata) {
        return dbb.ucitajPokusajeIzBaze(idRezultata);
    }

    

    
}
