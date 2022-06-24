package Controller;

import Entity.pembeli;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class PembeliController{
    public void insertData(int id_pembeli,String nama_pembeli, String password_pembeli, int notelp){
        pembeli Pembeli = new pembeli();
        Pembeli.setId_pembeli(id_pembeli);
        Pembeli.setNama_pembeli(nama_pembeli);
        Pembeli.setPassword_pembeli(password_pembeli);
        Pembeli.setNoTelp(notelp);
        AllObjectModel.PembeliModel.insertData(Pembeli);
    }
    
    public ArrayList<pembeli> getpembeli(){
        return AllObjectModel.PembeliModel.getpembeli();
    }
    
    public ArrayList<pembeli> getById(int cek){
        return AllObjectModel.PembeliModel.getIdpembeli(cek);
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1 : AllObjectModel.PembeliModel.updateNamaPembeli(data, id);
                break;
            case 2 : AllObjectModel.PembeliModel.updatePassword(data, id);
                break;
            case 3 : AllObjectModel.PembeliModel.updateNoTelp(data, id);
                break;
        }
    }
  
    
    
    public int login(String nama, String password) {
        int log = AllObjectModel.PembeliModel.cekLogin(nama, password);
        return log;
    }
    
    public DefaultTableModel daftarPembeli(){
    DefaultTableModel dataDaftarPembeli = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA","NOTELP","PASSWORD"};
    dataDaftarPembeli.setColumnIdentifiers(kolom);
    int size=getpembeli().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.PembeliModel.getpembeli().get(i).getId_pembeli();    
        data[2]=AllObjectModel.PembeliModel.getpembeli().get(i).getNama_pembeli();
        data[3]=AllObjectModel.PembeliModel.getpembeli().get(i).getNoTelp();
        data[4]=AllObjectModel.PembeliModel.getpembeli().get(i).getPassword_pembeli();
        dataDaftarPembeli.addRow(data);
    }
    return dataDaftarPembeli;
  }
}
