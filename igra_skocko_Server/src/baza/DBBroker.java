/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import forme.ServerskaForma;
import model.Igra;
import model.RezultatIgre;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author milos
 */
public class DBBroker {

    public RezultatIgre dodajRezultatUBazu(RezultatIgre r) {
        try {
            String upit="INSERT INTO rezultatiigara (datumVreme,zadataKombinacija,brojPokusaja,rezultat) VALUES(?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit,PreparedStatement.RETURN_GENERATED_KEYS);
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Timestamp datumSql=java.sql.Timestamp.valueOf(sdf.format(r.getDatumVreme()));
            ps.setTimestamp(1, datumSql);
            
            ps.setString(2, r.getZadataKombinacija());
            ps.setInt(3, r.getBrojPokusaja());
            ps.setString(4, r.getRezultat());
            
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                int id=rs.getInt(1);
                r.setId(id);
            }
            
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<RezultatIgre> ucitajIgreIzBaze() {
        List<RezultatIgre>lista=new ArrayList<>();
        try {
            String upit="SELECT * FROM rezultatiigara";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                int id=rs.getInt(1);
                
                java.sql.Timestamp datumSql=rs.getTimestamp(2);
                java.util.Date datum=new java.util.Date(datumSql.getTime());
                
                String zadataKomb=rs.getString(3);
                int brPokusaja=rs.getInt(4);
                String rezultat=rs.getString(5);
                
                RezultatIgre r=new RezultatIgre(id, datum, zadataKomb, brPokusaja, rezultat, null);
                lista.add(r);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void dodajIgruUBazu(List<Igra> pokusaji,RezultatIgre r) {
        try {
            String upit="INSERT INTO igra(kombinacija,brNaMestu,brVanMesta,dobitnaKomb_id) VALUES(?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);

            for(Igra i:pokusaji){
                
                ps.setString(1, i.getKombinacija());
                ps.setInt(2, i.getBrojPogodjenihNaMestu());
                ps.setInt(3, i.getBrojPogodjenihVanMesta());
                ps.setInt(4, r.getId());

                ps.executeUpdate();//ps.addBatch() moze i ovako...
            }
            //ps.executeBatch();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Igra> ucitajPokusajeIzBaze(int idRezultata) {
        List<Igra>lista=new ArrayList<>();
        try {
            String upit="SELECT * FROM igra WHERE dobitnaKomb_id=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, idRezultata);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                
                
                Igra i=new Igra(-5, rs.getString(2), rs.getInt(3), rs.getInt(4));
                lista.add(i);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}