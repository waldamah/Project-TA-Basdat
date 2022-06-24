package Entity;

public class barang {

    private int id_barang;
    private int harga_barang;
    private String nama_barang;
    private int stok_barang;
    private String jenis_barang;
    private String kategori_barang;

    public barang() {};
    
    public barang(int id_barang, String nama_barang, String jenis_barang, String kategori_barang, int stok_barang, int harga_barang){
        this.nama_barang = nama_barang;
        this.id_barang = id_barang;
        this.jenis_barang = jenis_barang;
        this.kategori_barang = kategori_barang;
        this.harga_barang = harga_barang;
        this.stok_barang = stok_barang;
    }
    public String getKategori_barang() {
        return kategori_barang;
    }
    public void setKategori_barang(String kategori_barang){
        this.kategori_barang = kategori_barang;
    }
    
    public String getJenis_barang(){
        return jenis_barang;
    }
    public void setJenis_barang(String jenis_barang){
        this.jenis_barang = jenis_barang;
    }

    public int getId_barang() {
        return id_barang;
    }
     public void setId_barang(int id_barang){
        this.id_barang = id_barang;
    }
     public int getHarga_barang(){
        return harga_barang;
    } 
    public void setHarga_barang(int harga_barang){
        this.harga_barang = harga_barang;
    }
    public String getNama_barang(){
        return nama_barang;
    }
    public void setNama_barang(String nama_barang){
        this.nama_barang = nama_barang;
    }
    public int getStok_barang(){
        return stok_barang;
    }

    public void setStok_barang(int stok_barang){
        this.stok_barang = stok_barang;
    }
}
