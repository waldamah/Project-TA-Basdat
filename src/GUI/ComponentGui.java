package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class ComponentGui extends JFrame{
    protected JButton btnregister = new JButton("REGISTRASI");
    protected JButton btnnotreg = new JButton("BELUM REGISTRASI ?");
    protected JButton btnlogin = new JButton("LOG IN");
    protected JButton btnback = new JButton("LOG OUT");
    protected JButton btndelete = new JButton("DELETE");
    protected JButton btnubahdata = new JButton("UBAH DATA");

    
    protected JButton btnpesan = new JButton("PESAN BARANG");
    protected JButton btnbarang = new JButton("TAMBAH BARANG");
    protected JButton btnjenisbarang = new JButton("TAMBAH JENIS BARANG");
    protected JButton btnkategoribarang = new JButton("TAMBAH KATEGORI BARANG");
    protected JLabel labelid_barang = new JLabel("ID BARANG");
    protected JLabel labelnama_barang = new JLabel("NAMA BARANG");
    protected JLabel labeljenis_Barang = new JLabel("JENIS BARANG");
    protected JLabel labelKategori_barang = new JLabel("KATEGORI BARANG");
    protected JLabel labelharga_barang = new JLabel("HARGA BARANG");
    protected JLabel labelstok_barang = new JLabel("STOK BARANG");
    protected JTextField fieldid_barang = new JTextField();
    protected JTextField fieldnama_barang  = new JTextField();
    protected JTextField fieldjenis_Barang = new JTextField();
    protected JTextField fieldKategori_barang = new JTextField();
    protected JTextField fieldharga_barang = new JTextField();
    protected JTextField fieldstok_barang  = new JTextField();
    protected JButton btnubahnama_barang = new JButton("ubah");
    protected JButton btnubahjenis_Barang = new JButton("ubah");
    protected JButton btnubahKategori_barang = new JButton("ubah");
    protected JButton btnubahharga_barang = new JButton("ubah");
    protected JButton btnubahstok_barang = new JButton("ubah");
    
    protected JButton btntransaksi = new JButton("LIHAT TRANSAKSI");
    protected JLabel labelid_Transaksi = new JLabel("ID TRANSAKSI");    
    protected JLabel labelNama_pembeli = new JLabel("NAMA PEMBELI");
    protected JLabel labelTotal_harga = new JLabel("TOTAL HARGA");
    protected JLabel labelbayar = new JLabel("BAYAR");
    protected JLabel labelsisa = new JLabel("SISA");    
    protected JTextField fieldid_Transaksi = new JTextField();
    protected JTextField fieldNama_pembeli  = new JTextField();
    protected JTextField fieldTotal_harga = new JTextField();
    protected JTextField fieldbayar  = new JTextField();
    protected JTextField fieldsisa  = new JTextField();    
    protected JButton btnubahNama_pembeli = new JButton("rubah");
    protected JButton btnubahTotal_harga = new JButton("rubah");
    protected JButton btnubahbayar = new JButton("rubah");
    protected JButton btnubahsisa = new JButton("rubah");
    

    
    protected JLabel labelregister = new JLabel("REGISTER");
    protected JLabel labellogin = new JLabel("LOGIN");
    protected JLabel labelidpembeli = new JLabel("ID PEMBELI");
    protected JLabel labelnama = new JLabel("NAMA PEMBELI");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");
    protected JTextField fieldidpembeli = new JTextField();
    

    protected JLabel bingkaigambar = new JLabel();
    protected JTextField fieldnama  = new JTextField();
    protected JPasswordField fieldpassword  = new JPasswordField();
    protected JTextField fieldnotelp  = new JTextField();

    protected JButton btnubahnama = new JButton("ubah");
    protected JButton btnubahpassword = new JButton("ubah");
    protected JButton btnubahnotelp = new JButton("ubah");

    BufferedImage bufferedimage = null;
    java.awt.Image gambarresize;
    void kosong(){
        fieldnama.setText(null);
        fieldpassword.setText(null);
        fieldnotelp.setText(null);

        fieldid_barang.setText(null);
        fieldnama_barang.setText(null);
        fieldjenis_Barang.setText(null);
        fieldKategori_barang.setText(null);    
        fieldharga_barang.setText(null);
        fieldstok_barang.setText(null);
                
        
        
        fieldid_Transaksi.setText(null);
        fieldNama_pembeli.setText(null);
        fieldTotal_harga.setText(null);    
        fieldbayar.setText(null);
        fieldsisa.setText(null);
    }
}
