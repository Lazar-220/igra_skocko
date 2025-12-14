/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.RezultatIgre;

/**
 *
 * @author milos
 */
public class ModelTabeleOdigraneIgre extends AbstractTableModel {

    private List<RezultatIgre>lista;
    private static String[]kolone={"Datum","Zadata kombinacija","Broj pokusaja","Rezultat"};

    public ModelTabeleOdigraneIgre(List<RezultatIgre> lista) {
        this.lista = lista;
    }

    public ModelTabeleOdigraneIgre() {
    }

    
    public List<RezultatIgre> getLista() {
        return lista;
    }

    public void setLista(List<RezultatIgre> lista) {
        this.lista = lista;
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RezultatIgre r=lista.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
        switch(columnIndex){
            case 0:
                return sdf.format(r.getDatumVreme());
            case 1:
                return r.getZadataKombinacija();
            case 2:
                return r.getBrojPokusaja();
            case 3:
                return r.getRezultat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
