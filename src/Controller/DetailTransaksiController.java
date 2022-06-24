package Controller;
import Model.DetailTransaksiModel;
import Entity.detail_transaksi;
import Entity.transaksi_barang;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class DetailTransaksiController {

    
   
    public ArrayList<detail_transaksi> getTransaksi(){
        return AllObjectModel.DetailTransaksiModel.getdetail_transaksi();
    }
    
    public DefaultTableModel daftarTransaksi(){
    DefaultTableModel dataDaftarTransaksi = new DefaultTableModel();
    Object[] kolom = {"SELECT * FROM detail"};
    dataDaftarTransaksi.setColumnIdentifiers(kolom);
    int size=getTransaksi().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[9];
        data[0]=AllObjectModel.DetailTransaksiModel.getdetail_transaksi().get(i).getId_barang();
        data[3]=AllObjectModel.DetailTransaksiModel.getdetail_transaksi().get(i).getId_pembeli();
        data[4]=AllObjectModel.DetailTransaksiModel.getdetail_transaksi().get(i).getId_transaksi();
        data[5]=AllObjectModel.DetailTransaksiModel.getdetail_transaksi().get(i).getJumlah_harga();

        dataDaftarTransaksi.addRow(data);
    }
    return dataDaftarTransaksi;
  }
}
