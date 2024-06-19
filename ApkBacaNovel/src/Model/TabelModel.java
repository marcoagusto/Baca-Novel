/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TabelModel extends AbstractTableModel {

     List<ModelNovel> list_novel;
    
    public TabelModel(List<ModelNovel> list_member){
        this.list_novel = list_member;
    }
    
    @Override
    public int getRowCount() {
        return list_novel.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "id";
            case 1:
                return "nama";
            case 2:
                return "penulis";
            case 3:
                return "genre";
            case 4:
                return "status";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return list_novel.get(row).getId();
            case 1:
                return list_novel.get(row).getNama();
            case 2:
                return list_novel.get(row).getPenulis();
            case 3:
                return list_novel.get(row).getGenre();
            case 4:
                return list_novel.get(row).getStatus();
            default:
                return null;
        }
    }
}
