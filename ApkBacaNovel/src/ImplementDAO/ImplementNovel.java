/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementDAO;

import java.util.List;
import Model.ModelNovel;
/**
 *
 * @author user
 */
public interface ImplementNovel {
    public void insert(ModelNovel b);
    
    public void update(ModelNovel b);
    
    public void delete(int id);
    
    public List<ModelNovel> getALL();
    
    public List<ModelNovel> getCariNama(String nama);
}
