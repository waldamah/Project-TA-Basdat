package Model;

import Helper.KoneksiDb;
import java.sql.Connection;
import Entity.barang;
import java.sql.*;
import java.util.ArrayList;
public class BarangModel {
    private String sql;
    public Connection conn = KoneksiDb.getconnection();
    public ArrayList<barang> getbarang(){
        ArrayList<barang> arraylistbarang = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM barang";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                barang Barang = new barang();
                Barang.setId_barang(rs.getInt("id_barang"));
                Barang.setNama_barang(rs.getString("nama_barang"));
                Barang.setJenis_barang(rs.getString("jenis_barang"));
                Barang.setKategori_barang(rs.getString("kategori_barang"));
                Barang.setHarga_barang(rs.getInt("harga_barang"));
                Barang.setStok_barang(rs.getInt("stok_barang"));
                arraylistbarang.add(Barang);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylistbarang;
    }
    
    public ArrayList<barang>getIdbarang(int id){
        ArrayList<barang> arraylistbarang = new ArrayList<>();
        try {
            sql = "SELECT * FROM barang WHERE id_barang=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                barang Barang = new barang();
                Barang.setNama_barang(rs.getString("nama_barang"));
                Barang.setJenis_barang(rs.getString("jenis_barang"));
                Barang.setKategori_barang(rs.getString("kategori_barang"));
                Barang.setHarga_barang(rs.getInt("harga_barang"));
                Barang.setStok_barang(rs.getInt("stok_barang"));
                arraylistbarang.add(Barang);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistbarang;
    }
  public void deleteDataBarang(int id) {
        try {
            sql = "DELETE FROM barang WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL HAPUS DATA!!!");
            e.printStackTrace();
        }
    }
    public void insertData(barang Barang) {
        try {
            sql = "INSERT INTO barang (nama_barang, jenis_barang, kategori_barang,harga_barang, stok_barang) Values(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, Barang.getNama_barang());
            stat.setString(2, Barang.getJenis_barang());
            stat.setString(3, Barang.getKategori_barang());
            stat.setInt(4, Barang.getHarga_barang());
            stat.setInt(5, Barang.getStok_barang());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }

    public void updateNamaBarang(String nama_barang, int id) {
        try {
            sql = "update barang SET nama_barang =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama_barang);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Nama!!!");
            e.printStackTrace();
        }
    }
    
    public void updateJenisBarang(String jenis_barang, int id) {
        try {
            sql = "update barang SET jenis_barang =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,jenis_barang);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Nama!!!");
            e.printStackTrace();
        }
    }
    
    public void updateKategoriBarang(String kategori_barang, int id) {
        try {
            sql = "update barang SET kategori_barang =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,kategori_barang);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Nama!!!");
            e.printStackTrace();
        }
    }
    public void updateHargaBarang(int harga_barang, int id) {
        try {
            sql = "update barang SET harga_barang =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,harga_barang);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public void updateStokBarang(int stok_barang, int id) {
        try {
            sql = "update barang SET stok_barang =? WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, stok_barang);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update NoTelp!!!");
            e.printStackTrace();
        }
    }
    
    public int cekVerif(int id) {
        int cek = 0;
        try {
            sql = "SELECT * FROM barang WHERE id_barang =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("status");
            }else{
                cek = 0;
            }
        } catch (SQLException e) {
            System.out.println("Gagal !!!");
            e.printStackTrace();
        }
        return cek;
    }
}
