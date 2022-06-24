package Entity;

public class transaksi_barang {
    private int id_transaksi;
    private int total_harga;
    private String nama_pembeli;
    private int id_pembeli;
    private int bayar;
    private int sisa;

    public transaksi_barang() {};
    
    public transaksi_barang(int id_transaksi, int total_harga, String nama_pembeli, int id_pembeli, int bayar, int sisa){
        this.nama_pembeli = nama_pembeli;
        this.id_transaksi = id_transaksi;
        this.id_pembeli = id_pembeli;
        this.total_harga = total_harga;
        this.bayar = bayar;
        this.total_harga = total_harga;
    }
    
    public int getBayar() {
        return bayar;
    }
     public void setBayar(int bayar){
        this.bayar = bayar;
    }
    
     public int getSisa() {
        return sisa;
    }
     public void setSisa(int sisa){
        this.sisa = sisa;
    } 

    public int getId_transaksi() {
        return id_transaksi;
    }
     public void setId_transaksi(int id_transaksi){
        this.id_transaksi = id_transaksi;
    }
   
    public int getId_pembeli(){
        return id_pembeli;
    }
    public void setId_pembeli (int id_pembeli){
        this.id_pembeli = id_pembeli;
    }
    public String getNama_pembeli(){
        return nama_pembeli;
    }
    public void setNama_pembeli(String nama_pembeli){
        this.nama_pembeli = nama_pembeli;
    }
    public int getTotal_harga(){
        return total_harga;
    }

    public void setTotal_harga(int total_harga){
        this.total_harga = total_harga;
    }
    
}
    
   