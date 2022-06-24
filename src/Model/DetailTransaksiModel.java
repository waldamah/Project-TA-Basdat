package Model;

import Helper.KoneksiDb;
import java.sql.Connection;
import Entity.detail_transaksi;
import java.sql.*;
import java.util.ArrayList;
public class DetailTransaksiModel {
    private String sql;
    public Connection conn = KoneksiDb.getconnection();
    public ArrayList<detail_transaksi> getdetail_transaksi(){
        ArrayList<detail_transaksi> arraylistdetail_transaksi = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM detail_transaksi";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                detail_transaksi DetailTransaksi = new detail_transaksi();
                DetailTransaksi.setJumlah_harga(rs.getInt("jumlah_harga"));
                arraylistdetail_transaksi.add(DetailTransaksi);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylistdetail_transaksi;
    }
    
    public ArrayList<detail_transaksi>getdetail_transaksi(int id){
        ArrayList<detail_transaksi> arraylistdetail_transaksi = new ArrayList<>();
        try {
            sql = "SELECT * FROM detail_transaksi WHERE jumlah_harga=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
              detail_transaksi DetailTransaksi = new detail_transaksi();
                DetailTransaksi.setJumlah_harga(rs.getInt("jumlah_harga"));
                arraylistdetail_transaksi.add(DetailTransaksi);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistdetail_transaksi;
    }
}
    