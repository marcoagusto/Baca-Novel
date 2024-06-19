/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author user
 */
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Koneksi.KoneksiNovel;
import Model.ModelNovel;
import ImplementDAO.ImplementNovel;


public class DAONovel implements ImplementNovel{
    
    Connection connection;
    final String insert = "INSERT INTO tbnovel (nama,penulis,genre,status) VALUES (?,?,?,?);";
    final String update = "UPDATE tbnovel set nama=?, penulis=?, genre=?, status=? where id=? ;";
    final String delete = "DELETE FROM tbnovel where id=? ;";
    final String select = "SELECT * FROM tbnovel;";
    final String carinama = "SELECT * FROM tbnovel where nama like ?";
    
    public DAONovel(){
        connection = KoneksiNovel.connection();
    }
    
    @Override
    public void insert(ModelNovel b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getPenulis());
            statement.setString(3, b.getGenre());
            statement.setString(4, b.getStatus());
            statement.executeUpdate();
//            ResultSet rs = statement.getGeneratedKeys();
//            while(rs.next()){
//                b.setId(rs.getInt(1));
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(ModelNovel b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getPenulis());
            statement.setString(3, b.getGenre());
            statement.setString(4, b.getStatus());
            statement.setInt(5, b.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void delete(int id){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<ModelNovel> getALL(){
        List<ModelNovel> lb = null;
        try{
            lb = new ArrayList<ModelNovel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                ModelNovel b = new ModelNovel();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setPenulis(rs.getString("penulis"));
                b.setGenre(rs.getString("genre"));
                b.setStatus(rs.getString("status"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAONovel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lb;
    }
    
    @Override
    public List<ModelNovel> getCariNama(String nama){
        List<ModelNovel> lb = null;
        try{
            lb = new ArrayList<ModelNovel>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                ModelNovel b = new ModelNovel();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setPenulis(rs.getString("penulis"));
                b.setGenre(rs.getString("genre"));
                b.setStatus(rs.getString("status"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAONovel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lb;
    }
}