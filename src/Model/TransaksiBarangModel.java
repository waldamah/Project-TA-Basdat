package Model;

import Helper.KoneksiDb;
import java.sql.Connection;
import Entity.transaksi_barang;
import java.sql.*;
import java.util.ArrayList;
public class TransaksiBarangModel {
    private String sql;
    public Connection conn = KoneksiDb.getconnection();
    public ArrayList<transaksi_barang> gettransaksi(){
        ArrayList<transaksi_barang> arraylisttransaksi = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM transaksi";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                transaksi_barang Transaksi = new transaksi_barang();
                Transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                Transaksi.setId_pembeli(rs.getInt("id_pembeli"));
                Transaksi.setNama_pembeli(rs.getString("nama_barang"));
                Transaksi.setTotal_harga(rs.getInt("harga_barang"));
                Transaksi.setBayar(rs.getInt("Uang_bayar"));
                Transaksi.setSisa(rs.getInt("Sisa_uang"));
                arraylisttransaksi.add(Transaksi);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylisttransaksi;
    }
    
    public ArrayList<transaksi_barang>getTransaksi(int id){
        ArrayList<transaksi_barang> arraylisttransaksi = new ArrayList<>();
        try {
            sql = "SELECT * FROM transaksi WHERE id_transaksi=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
              transaksi_barang Transaksi = new transaksi_barang();
                Transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                Transaksi.setId_pembeli(rs.getInt("id_pembeli"));
                Transaksi.setNama_pembeli(rs.getString("nama_barang"));
                Transaksi.setTotal_harga(rs.getInt("harga_barang"));
                Transaksi.setBayar(rs.getInt("Uang_bayar"));
                Transaksi.setSisa(rs.getInt("Sisa_uang"));
                arraylisttransaksi.add(Transaksi);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylisttransaksi ;
    }

    public void insertData(transaksi_barang Transaksi) {
        try {
            sql = "INSERT INTO transaksi_barang (nama_pembeli, total_harga, bayar, sisa) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, Transaksi.getNama_pembeli());
            stat.setInt(2, Transaksi.getTotal_harga());
            stat.setInt(3, Transaksi.getBayar());
            stat.setInt(4, Transaksi.getSisa());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }

    public void updateNamaPembeli(String nama_pembeli, int id) {
        try {
            sql = "update transaksi SET nama_pembeli =? WHERE id_transaksi =?";
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
    
    public void updateTotalHarga(int total_harga, int id) {
        try {
            sql = "update transaksi SET total_harga =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,total_harga);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public void updateBayar(int bayar, int id) {
        try {
            sql = "update transaksi SET bayar =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,bayar);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public void updateSisa(int sisa, int id) {
        try {
            sql = "update transaksi SET sisa =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,sisa);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public int cekVerif(int id) {
        int cek = 0;
        try {
            sql = "SELECT * FROM transaksi WHERE id_transaksi =?";
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
