package forme;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Igra;

/**
 *
 * @author milos
 */
public class ModelTabelePokusaji extends AbstractTableModel {

    private List<Igra>lista;
    private static String[]kolone={"RB","kombinacija","Pogodjenih na mestu","Pogodjenih van mesta"};

    public ModelTabelePokusaji(List<Igra> lista) {
        this.lista = lista;
    }

    public List<Igra> getLista() {
        return lista;
    }

    public void setLista(List<Igra> lista) {
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
        Igra i=lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return i.getRb();
            case 1:
                return i.getKombinacija();
            case 2:
                return i.getBrojPogodjenihNaMestu();
            case 3: 
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
