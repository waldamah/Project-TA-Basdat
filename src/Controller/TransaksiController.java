package Controller;

import Entity.transaksi_barang;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class TransaksiController {
    public void insertData(int id_transaksi, int total_harga, String nama_pembeli, int sisa, int bayar, int id_pembeli){
        transaksi_barang Transaksi = new transaksi_barang();
        Transaksi.setId_transaksi(id_transaksi);
        Transaksi.setTotal_harga(total_harga);
        Transaksi.setId_pembeli(id_pembeli);
        Transaksi.setNama_pembeli(nama_pembeli);
        Transaksi.setBayar(bayar);
        Transaksi.setSisa(sisa);
        AllObjectModel.TransaksiBarangModel.insertData(Transaksi);
    }
    
    public void updateTotalHarga(int data, int id){
        AllObjectModel.TransaksiBarangModel.updateTotalHarga(data, id);
    }
    
    
    public void updateNamaPembeli(String data, int id){
        AllObjectModel.TransaksiBarangModel.updateNamaPembeli(data, id);
    }
    
    public void updateBayarUang(int data, int id){
        AllObjectModel.TransaksiBarangModel.updateBayar(data, id);
    }
    
     public void updateSisaUang(int data, int id){
        AllObjectModel.TransaksiBarangModel.updateSisa(data, id);
    }
    
    public ArrayList<transaksi_barang> getTransaksi(){
        return AllObjectModel.TransaksiBarangModel.gettransaksi();
    }
    
    public ArrayList<transaksi_barang> getIdTransaksi(int cek){
        return AllObjectModel.TransaksiBarangModel.getTransaksi(cek);
    }
    
    public int verif(int id){
        int cek = AllObjectModel.TransaksiBarangModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarTransaksi(){
    DefaultTableModel dataDaftarTransaksi = new DefaultTableModel();
    Object[] kolom = {"ID TRANSAKSI","ID PEMBELI","NAMA PEMBELI","TOTAL HARGA","BAYAR", "SISA"};
    dataDaftarTransaksi.setColumnIdentifiers(kolom);
    int size=getTransaksi().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[9];
        data[0]=AllObjectModel.TransaksiBarangModel.gettransaksi().get(i).getId_transaksi();   
        data[1]=AllObjectModel.TransaksiBarangModel.gettransaksi().get(i).getId_pembeli();
        data[2]=AllObjectModel.TransaksiBarangModel.gettransaksi().get(i).getNama_pembeli();
        data[3]=AllObjectModel.TransaksiBarangModel.gettransaksi().get(i).getTotal_harga();
        data[4]=AllObjectModel.TransaksiBarangModel.gettransaksi().get(i).getBayar();
        data[5]=AllObjectModel.TransaksiBarangModel.gettransaksi().get(i).getSisa();
        dataDaftarTransaksi.addRow(data);
    }
    return dataDaftarTransaksi;
  }
}
