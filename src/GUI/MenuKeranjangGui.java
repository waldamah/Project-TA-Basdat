package GUI;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class MenuKeranjangGui extends ComponentGui{
    JTable tabelidbarang = new JTable();
    JTable tabelbarang = new JTable();
    JTable tabeljenis = new JTable();
    JTable tabelkategori = new JTable();
    JTable tabelharga   = new JTable();
    JTable tabelstok  = new JTable();
    JScrollPane spidbarang = new JScrollPane(tabelidbarang);
    JScrollPane spbarang = new JScrollPane(tabelbarang);
    JScrollPane spjenis = new JScrollPane(tabeljenis);
    JScrollPane spkategori = new JScrollPane(tabelkategori);
    JScrollPane spharga = new JScrollPane(tabelharga);
    JScrollPane spstok = new JScrollPane(tabelstok);

    JTextField textpilih = new JTextField();
    JButton btnmasukpembeli = new JButton("PEMBELI");
    JButton btntambahbarang = new JButton("TAMBAH BARANG");
    JButton btnmasuktransaksi = new JButton("TRANSAKSI");
    JButton btnubahbarang = new JButton("UBAH BARANG");
    int kode;
    public MenuKeranjangGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("DAFTAR BELANJAAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
         
        spbarang.setBounds(20, 100, 870, 520);
        tabelbarang.setModel(AllObjectController.barang.daftarBarang());
        spidbarang.setBounds(20,70,870,520);
        tabelidbarang.setModel(AllObjectController.barang.daftarBarang());
        spjenis.setBounds(20,70,870,520);
        tabeljenis.setModel(AllObjectController.barang.daftarBarang());
        spkategori.setBounds(20,70,870,520);
        tabelkategori.setModel(AllObjectController.barang.daftarBarang());
        spharga.setBounds(20,70,870,520);
        tabelharga.setModel(AllObjectController.barang.daftarBarang());   
        spstok.setBounds(20,70,870,520);
        tabelstok.setModel(AllObjectController.barang.daftarBarang());
        add(spbarang);

        btntambahbarang.setBounds(920, 230, 110, 25);
        btntambahbarang.setFocusPainted(false);
        btntambahbarang.setBorder(null);
        btntambahbarang.setBackground(Color.black);
        btntambahbarang.setForeground(Color.white);
        add(btntambahbarang);
        
        btnubahbarang.setBounds(920, 270, 110, 25);
        btnubahbarang.setFocusPainted(false);
        btnubahbarang.setBorder(null);
        btnubahbarang.setBackground(Color.black);
        btnubahbarang.setForeground(Color.white);
        add(btnubahbarang);
        
        btndelete.setBounds(920, 310, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnmasuktransaksi.setBounds(920, 370, 110, 25);
        btnmasuktransaksi.setFocusPainted(false);
        btnmasuktransaksi.setBorder(null);
        btnmasuktransaksi.setBackground(Color.black);
        btnmasuktransaksi.setForeground(Color.white);
        add(btnmasuktransaksi);
        
        btnback.setBounds(15, 15, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabelbarang.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabelbarang.getSelectedRow();
                textpilih.setText(AllObjectController.barang.daftarBarang().getValueAt(i, 0).toString());
            }
        });
        
        
        btndelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.barang.DeleteDatabarang(kode);
                tabelbarang.setModel(AllObjectController.barang.daftarBarang());
                JOptionPane.showMessageDialog(null, "Hapus Barang");
            }
        });
        btndelete.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btndelete.setForeground(Color.black);
                btndelete.setBackground(Color.RED);
            }

            public void mouseExited(MouseEvent e){
                btndelete.setForeground(Color.white);
                btndelete.setBackground(Color.black);
            }
        });
        
        
        btnback.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MenuKeranjangGui loginAdminGui = new MenuKeranjangGui(kode);
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btntambahbarang.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BarangGui barang = new BarangGui();
                barang.setVisible(true);
                dispose();
            }
        });
        
        btnmasuktransaksi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
             //   kode = Integer.parseInt(textpilih.getText());
                MenuTransaksiGui transaksiGui = new MenuTransaksiGui(cek);
                transaksiGui.setVisible(true);
                dispose();
            }
        });
        btntambahbarang.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btntambahbarang.setForeground(Color.black);
                btntambahbarang.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btntambahbarang.setForeground(Color.white);
                btntambahbarang.setBackground(Color.black);
            }
        });
        
        btnubahbarang.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                BarangUDGui udBarang = new BarangUDGui(kode);
                udBarang.setVisible(true);
                dispose();
            }
        });
        btnubahbarang.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnubahbarang.setForeground(Color.black);
                btnubahbarang.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btnubahbarang.setForeground(Color.white);
                btnubahbarang.setBackground(Color.black);
            }
        });
    } 
}
