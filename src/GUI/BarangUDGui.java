package GUI;

import Entity.barang;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files; 
import java.nio.file.StandardCopyOption; 
import java.util.logging.Level; 
import java.util.logging.Logger;
public class BarangUDGui extends ComponentGui{
    int id; 
    String nama_barang, jenis_barang, kategori_barang; 
    int harga_barang, stok_barang;
    public BarangUDGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek) {
        for (barang barang : AllObjectController.barang.getId_barang(cek)) {
            this.id = barang.getId_barang();
            this.nama_barang = barang.getNama_barang();
            this.jenis_barang = barang.getJenis_barang();
            this.kategori_barang = barang.getKategori_barang();
            this.harga_barang = barang.getHarga_barang();
            this.stok_barang = barang.getStok_barang();
        }
        setTitle("DATA BARANG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); setVisible(true);
        
        labelregister.setText("UBAH BARANG");
        labelregister.setBounds(200, 50, 150, 25);
        add(labelregister);
        labelnama_barang.setBounds (35, 100, 80, 25);
        add(labelnama_barang);
        fieldnama_barang.setBounds (140, 100, 290, 25);
        fieldnama_barang.setText(nama_barang);
        fieldnama_barang.setEditable(true);
        add(fieldnama_barang);
        
        labeljenis_Barang.setBounds (35, 150, 80, 25);
        add(labeljenis_Barang);
        fieldjenis_Barang.setBounds (140, 150, 290, 25);
        fieldjenis_Barang.setText(jenis_barang);
        fieldjenis_Barang.setEditable(true);
        add(fieldjenis_Barang);
        
        labelKategori_barang.setBounds (35, 200, 80, 25);
        add(labelKategori_barang);
        fieldKategori_barang.setBounds (140, 200, 290, 25);
        fieldKategori_barang.setText(kategori_barang);
        fieldKategori_barang.setEditable(true);
        add(fieldKategori_barang);

        labelharga_barang.setBounds(35, 250, 180, 25);
        add(labelharga_barang);
        fieldharga_barang.setBounds (140, 250, 290, 25);
        fieldharga_barang.setText(Integer.toString(harga_barang));
        fieldharga_barang.setEditable(true);
        add(fieldharga_barang);

        labelstok_barang.setBounds (35, 300, 80, 25);
        add(labelstok_barang);
        fieldstok_barang.setBounds(140, 300, 290, 25);
        fieldstok_barang.setText(Integer.toString(stok_barang));
        fieldstok_barang.setEditable(true);
        add(fieldstok_barang);

        bingkaigambar.setBounds(50,225,150,200);
        add(bingkaigambar);

        btnubahnama_barang.setBounds(35, 120, 80, 25);
        btnubahjenis_Barang.setBounds(35, 170, 80, 25);
        btnubahKategori_barang.setBounds(35, 220, 80, 25);
        btnubahharga_barang.setBounds(35, 270, 180, 25);
        btnubahstok_barang.setBounds(35, 320, 80, 25);

        add(btnubahnama_barang);
        add(btnubahjenis_Barang);
        add(btnubahKategori_barang);
        add(btnubahharga_barang);
        add(btnubahstok_barang);
        
        btnback.setBounds(15,15,80,15);
        btnback.setBackground (Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        
        
        btnback.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MenuKeranjangGui MPembeli = new MenuKeranjangGui(cek);
                MPembeli.setVisible(true);
                dispose();
            }
        });
        btnubahnama_barang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputnamaBarang = JOptionPane.showInputDialog("Masukkan Nama Barang Baru");
                    if(inputnamaBarang.length() >0){
                        AllObjectController.barang. updateData1(1, inputnamaBarang,cek);
                        fieldnama_barang.setText(inputnamaBarang);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
            });
        
         btnubahjenis_Barang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputJenisBarang = JOptionPane.showInputDialog("Masukkan Jenis Barang Baru");
                    if(inputJenisBarang.length() >0){
                        AllObjectController.barang. updateData1(2, inputJenisBarang,cek);
                        fieldjenis_Barang.setText(inputJenisBarang);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
            });
         
         btnubahKategori_barang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputKategoriBarang = JOptionPane.showInputDialog("Masukkan Kategori Barang Baru");
                    if(inputKategoriBarang.length() >0){
                        AllObjectController.barang. updateData1(3, inputKategoriBarang,cek);
                        fieldKategori_barang.setText(inputKategoriBarang);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
            });
        
        btnubahharga_barang.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                try {
                    String inputHargaBarang = JOptionPane.showInputDialog("Masukkan Harga Barang Baru");
                    if (inputHargaBarang.length() > 0){
                        AllObjectController.barang.updateData1(4, inputHargaBarang, cek);
                        fieldharga_barang.setText(inputHargaBarang); 
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnubahstok_barang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String inputstokBarang = JOptionPane.showInputDialog("Masukkan Stok Barang Baru");
                    if(inputstokBarang.length() > 0){
                        AllObjectController.barang.updateData1(5,inputstokBarang, cek);
                        fieldstok_barang.setText(inputstokBarang);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
     }
}
