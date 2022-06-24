package GUI;

import GUI.AllObjectController;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class TransaksiGui extends ComponentGui {
    int kode;
    
    public TransaksiGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("MENAMBAH TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("TAMBAH TRANSAKSI");
        labelregister.setBounds(200, 50, 150, 25);
        add(labelregister);
        
        labelnama_barang.setBounds(35, 100, 80, 25);
        add(labelnama_barang);
        fieldnama_barang.setBounds(140, 100, 290, 25);
        add(fieldnama_barang);
        
        labeljenis_Barang.setBounds(35, 150, 80, 25);
        add(labeljenis_Barang);
        fieldjenis_Barang.setBounds(140, 150, 290, 25);
        add(fieldjenis_Barang);
        
        labelKategori_barang.setBounds(35, 200, 80, 25);
        add(labelKategori_barang);
        fieldKategori_barang.setBounds(140, 200, 290, 25);
        add(fieldKategori_barang);
        
        labelharga_barang.setBounds(35, 250, 180, 25);
        add(labelharga_barang);
        fieldharga_barang.setBounds(140, 250, 290, 25);
        add(fieldharga_barang);
        
        labelstok_barang.setBounds(35, 300, 80, 25);
        add(labelstok_barang);
        fieldstok_barang.setBounds(140, 300, 290, 25);
        add(fieldstok_barang);
        
        btnback.setBounds(15, 15, 80, 15);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnbarang.setBounds(160, 380, 140, 25);
        btnbarang.setBorder(null);
        btnbarang.setBackground(Color.black);
        btnbarang.setForeground(Color.white);
        btnbarang.setFocusPainted(false);
        add(btnbarang);
        
        btnback.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.YELLOW);
            }
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MenuKeranjangGui barang = new MenuKeranjangGui(2);
                barang.setVisible(true);
                dispose();
            }
        });
        
        btnbarang.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnbarang.setForeground(Color.black);
                btnbarang.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e){
                btnbarang.setForeground(Color.white);
                btnbarang.setBackground(Color.black);
            }
        });
        
        btnbarang.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama_barang = fieldnama_barang.getText();
                String jenis_barang = fieldjenis_Barang.getText();
                String kategori_barang = fieldKategori_barang.getText();
                int harga_barang = Integer.parseInt(fieldharga_barang.getText());
                int stok_barang = Integer.parseInt(fieldstok_barang.getText());
                if(nama_barang.length() != 0 && jenis_barang.length() != 0 && kategori_barang.length() != 0 ){
                    AllObjectController.barang.insertData(nama_barang, jenis_barang, kategori_barang, harga_barang, stok_barang);
                    //AllObjectController.barang.updateData1(WIDTH, nama_barang, WIDTH);
                    //AllObjectController.barang.updateData2(WIDTH, WIDTH, WIDTH);
                    JOptionPane.showMessageDialog(null, nama_barang + "nama barang baru");
                    dispose();
                    new MenuKeranjangGui(kode).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }}
