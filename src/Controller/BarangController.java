package Controller;

import Entity.barang;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class BarangController {
    public void insertData(String nama_barang, String jenis_barang, String kategori_barang, int harga_barang, int stok_barang){
        barang Barang = new barang();
        Barang.setNama_barang(nama_barang);
        Barang.setHarga_barang(harga_barang);
        Barang.setJenis_barang(jenis_barang);
        Barang.setKategori_barang(kategori_barang);
        Barang.setStok_barang(stok_barang);
        AllObjectModel.barangModel.insertData(Barang);
    }
    
    public void updateData1(int urut, String data, int id){
        switch(urut){
            case 1 : AllObjectModel.barangModel.updateNamaBarang(data, id);
                break;
            case 2 : AllObjectModel.barangModel.updateJenisBarang(data, id);
                break;
            case 3 : AllObjectModel.barangModel.updateKategoriBarang(data, id);
                break;
            case 4 : AllObjectModel.barangModel.updateHargaBarang(urut, id);
                break;
            case 5 : AllObjectModel.barangModel.updateStokBarang(urut, id);
        }
    }

    public void DeleteDatabarang(int id){
        AllObjectModel.barangModel.deleteDataBarang(id);
    }
    public ArrayList<barang> getbarang(){
        return AllObjectModel.barangModel.getbarang();
    }
    
    public ArrayList<barang> getId_barang(int id_barang){
        return AllObjectModel.barangModel.getIdbarang(id_barang);
    }
    
    public int verif(int id){
        int cek = AllObjectModel.barangModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarBarang(){
    DefaultTableModel dataDaftarBarang = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA BARANG","JENIS BARANG","KATEGORI BARANG","HARGA BARANG","STOK BARANG"};
    dataDaftarBarang.setColumnIdentifiers(kolom);
    int size=getbarang().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[6];
        data[0]=AllObjectModel.barangModel.getbarang().get(i).getId_barang();
        data[1]=AllObjectModel.barangModel.getbarang().get(i).getNama_barang();
        data[2]=AllObjectModel.barangModel.getbarang().get(i).getJenis_barang();
        data[3]=AllObjectModel.barangModel.getbarang().get(i).getKategori_barang();
        data[4]=AllObjectModel.barangModel.getbarang().get(i).getHarga_barang();
        data[5]=AllObjectModel.barangModel.getbarang().get(i).getStok_barang();
        dataDaftarBarang.addRow(data);
    }
    return dataDaftarBarang;
  }
}
