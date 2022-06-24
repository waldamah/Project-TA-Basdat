package Entity;


public class detail_transaksi {
     private int jumlah_harga;
     private int id_barang;
     private int id_pembeli;
     private int id_transaksi;



public detail_transaksi() {};

public detail_transaksi(int id_barang, int id_pembeli, int id_transaksi, int jumlah_harga){
        this.jumlah_harga = jumlah_harga;
        this.id_barang = id_barang;
        this.id_pembeli = id_pembeli;
        this.id_transaksi = id_transaksi;
}

    public int getJumlah_harga() {
        return jumlah_harga;
    }
    
    public void setJumlah_harga(int jumlah_harga){
        this.jumlah_harga = jumlah_harga;
    }
    
    public int getId_barang(){
        return id_barang;
    }
    
    public void setId_barang(int id_barang){
        this.id_barang = id_barang;
    }
    
    public int getId_pembeli(){
        return id_pembeli;
    }
    
    public void setId_pembeli(int id_pembeli){
        this.id_pembeli = id_pembeli;
    }
    
    public int getId_transaksi(){
        return id_transaksi;
    }
    
    public void setId_transaksi(int id_transaksi){
        this.id_transaksi = id_transaksi;
    }
}
