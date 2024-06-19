/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;
import DAO.DAONovel;
import ImplementDAO.ImplementNovel;
import Model.ModelNovel;
import Model.TabelModel;
import View.ViewNovel;
import java.util.List;
/**
 *
 * @author user
 */
public class ControllerNovel {
    
    ViewNovel frame_novel;
    ImplementNovel implemet_novel;
    List<ModelNovel> list_novel;
    
    public ControllerNovel(ViewNovel frame_novel){
        this.frame_novel = frame_novel;
        implemet_novel = new DAONovel();
        list_novel = implemet_novel.getALL();
    }
    
    //Tombol Reset
    public void reset(){
        frame_novel.getTxt_id().setText("");
        frame_novel.getTxt_nama().setText("");
        frame_novel.getTxt_penulis().setText("");
        frame_novel.getTxt_genre().setText("");
        frame_novel.getTxt_status().setSelectedItem("---Pilih---");
        frame_novel.getTxt_cari().setText("");
    }
    
    //Tampil Data Ke Tabel
    public void isiTable(){
        list_novel = implemet_novel.getALL();
        TabelModel tmb = new TabelModel(list_novel);
        frame_novel.getjTable1().setModel(tmb);
    }
    
    //Menampilkan Data Ke Form Ketika Data DI Klik
    public void isiField(int row){
        frame_novel.getTxt_id().setText(list_novel.get(row).getId().toString());
        frame_novel.getTxt_nama().setText(list_novel.get(row).getNama());
        frame_novel.getTxt_penulis().setText(list_novel.get(row).getPenulis());
        frame_novel.getTxt_genre().setText(list_novel.get(row).getGenre());
        frame_novel.getTxt_status().setSelectedItem(list_novel.get(row).getStatus());
    }
    
    //Insert Data Dari Form Ke Database
    public void insert(){
        if(!frame_novel.getTxt_nama().getText().trim().isEmpty()& !frame_novel.getTxt_penulis().getText().trim().isEmpty()& !frame_novel.getTxt_genre().getText().trim().isEmpty()){
            ModelNovel b = new ModelNovel();
            b.setNama(frame_novel.getTxt_nama().getText());
            b.setPenulis(frame_novel.getTxt_penulis().getText());
            b.setGenre(frame_novel.getTxt_genre().getText());
            b.setStatus(frame_novel.getTxt_status().getSelectedItem().toString());
            
            implemet_novel.insert(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame_novel, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame_novel.getTxt_id().getText().trim().isEmpty()){
            ModelNovel b = new ModelNovel();
            b.setNama(frame_novel.getTxt_nama().getText());
            b.setPenulis(frame_novel.getTxt_penulis().getText());
            b.setGenre(frame_novel.getTxt_genre().getText());
            b.setStatus(frame_novel.getTxt_status().getSelectedItem().toString());
            b.setId(Integer.parseInt(frame_novel.getTxt_id().getText()));
            
            implemet_novel.update(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_novel, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete(){
        if(!frame_novel.getTxt_id().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame_novel.getTxt_id().getText());
            implemet_novel.delete(id);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_novel, "Silahkan Pilih Data Yang Akan Di Hapus");
        }
    }
    
    //Cari Data
    public void isiTableCariNama(){
        list_novel = implemet_novel.getCariNama(frame_novel.getTxt_cari().getText());
        TabelModel tmb = new TabelModel(list_novel);
        frame_novel.getjTable1().setModel(tmb);
    }
    
    public void carinama(){
        if(!frame_novel.getTxt_cari().getText().trim().isEmpty()){
            implemet_novel.getCariNama(frame_novel.getTxt_cari().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_novel, "Silahkan Pilih Data !!!");
        }
    }
}
