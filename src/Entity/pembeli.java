package Entity;

public class pembeli {
    private String nama_pembeli;
    private int notelp;
    private int id_pembeli;
    private String password_pembeli;

    public pembeli() {};
    

    public pembeli(int id_pembeli, String nama_pembeli, String password_pembeli, int notelp){
        this.password_pembeli = password_pembeli;
        this.id_pembeli = id_pembeli;
        this.notelp = notelp;
        this.nama_pembeli = nama_pembeli;
    }
    public String getPassword_pembeli(){
        return password_pembeli;
    }
    public void setPassword_pembeli(String password_pembeli){
        this.password_pembeli = password_pembeli;
    }
    public String getNama_pembeli() {
        return nama_pembeli;
    }
 
    public void setNama_pembeli(String nama_pembeli){
        this.nama_pembeli = nama_pembeli;
    }

    public int getNoTelp(){
        return notelp;
    }

    public void setNoTelp(int notelp){
        this.notelp = notelp;
    }
    public int getId_pembeli(){
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli){
        this.id_pembeli = id_pembeli;
    }
}
