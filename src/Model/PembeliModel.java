package Model;

import Entity.pembeli;
import java.sql.*;
import java.util.ArrayList;
public class PembeliModel extends ModelAbstract{
    private String sql;
    public ArrayList<pembeli> getpembeli(){
        ArrayList<pembeli> arraylistpembeli = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM pembeli";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                pembeli Pembeli = new pembeli();
                Pembeli.setId_pembeli(rs.getInt("id_pembeli"));
                Pembeli.setNama_pembeli(rs.getString("nama_pemilik"));
                Pembeli.setPassword_pembeli(rs.getString("password"));
                Pembeli.setNoTelp(rs.getInt("noTelp"));
                arraylistpembeli.add(Pembeli);
            }
        }catch (SQLException e){
                    System.out.println(e);
                    }
            return arraylistpembeli;
    }
    
    public ArrayList<pembeli>getIdpembeli(int id){
        ArrayList<pembeli> arraylistpembeli = new ArrayList<>();
        try {
            sql = "SELECT * FROM pembeli WHERE id_pembeli =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                pembeli Pembeli = new pembeli();
                Pembeli.setId_pembeli(rs.getInt("id_pembeli"));
                Pembeli.setNama_pembeli(rs.getString("nama_pemilik"));
                Pembeli.setPassword_pembeli(rs.getString("password"));
                Pembeli.setNoTelp(rs.getInt("noTelp"));
                arraylistpembeli.add(Pembeli);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistpembeli;
    }
    public void insertData(pembeli Pembeli) {
        try {
            sql = "INSERT INTO pembeli Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, Pembeli.getId_pembeli());
            stat.setString(2, Pembeli.getNama_pembeli());
            stat.setString(3, Pembeli.getPassword_pembeli());
            stat.setInt(4, Pembeli.getNoTelp());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
                System.out.println("GAGAL INPUT DATA!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNamaPembeli(String nama_pembeli, int id) {
        try {
            sql = "update pembeli SET nama_pembeli =? WHERE id_pembeli =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama_pembeli);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Nama!!!");
            e.printStackTrace();
        }
    }
    
    public void updatePassword(String password, int id) {
        try {
            sql = "update pembeli SET password =? WHERE id_pembeli =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,password);
            stat.setInt(2, id);
            stat.executeUpdate();
        }catch (SQLException e) {
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNoTelp(String noTelp, int id) {
        try {
            sql = "update pembeli SET no_telp =? WHERE id_pembeli =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update NoTelp!!!");
            e.printStackTrace();
        }
    }
     
    public int cekLogin(String nama_pembeli, String password) {
        int cek = 0;
        try {
            sql = "SELECT * FROM pembeli WHERE nama_pembeli =? and password=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama_pembeli);
            stat.setString(2,password);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                cek = rs.getInt("id_pembeli");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }
       
    public void verifBarang(int id) {
        try {
            sql = "update barang SET status = 1 WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void unverifBarang(int id) {
        try {
            sql = "update barang SET status = 0 WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
}