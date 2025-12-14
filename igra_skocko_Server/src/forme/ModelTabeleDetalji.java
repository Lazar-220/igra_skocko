/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import baza.Konekcija;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Igra;

/**
 *
 * @author milos
 */
public class ModelTabeleDetalji extends AbstractTableModel {
    
    private List<Igra>lista=new ArrayList<>();
    private static String[] kolone={"kombinacija","broj na mestu","broj van mesta"};

    public ModelTabeleDetalji(List<Igra> lista) {
        this.lista = lista;
    }

    public ModelTabeleDetalji() {
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
        Igra i=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getKombinacija();
            case 1:
                return i.getBrojPogodjenihNaMestu();
            case 2:
                return i.getBrojPogodjenihVanMesta();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
