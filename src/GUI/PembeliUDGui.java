package GUI;

import Entity.pembeli;
import GUI.AllObjectController;
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

public class PembeliUDGui extends ComponentGui{
    int id; 
    String nama, password;
    int notelp;
    public PembeliUDGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek) {
        for (pembeli Pembeli : AllObjectController.pembeli.getById(cek)) {
            this.id = Pembeli.getId_pembeli();
            this.nama = Pembeli.getNama_pembeli();
            this.password = Pembeli.getPassword_pembeli();
            this.notelp = Pembeli.getNoTelp();
        }
        setTitle("BIODATA PEMBELI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); setVisible(true);
        
        labelregister.setText("BIODATA PEMBELI");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        btnback.setBounds(15,15,80,15);
        btnback.setBackground (Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        labelnama.setBounds (35,100,80,25);
        add(labelnama);
        fieldnama.setBounds (140,100,200,25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);

        labelpassword.setBounds(35,150,80,25);
        add(labelpassword);
        fieldpassword.setBounds (140,150,200,25);
        fieldpassword.setText(password);
        fieldpassword.setEditable(false);
        add(fieldpassword);

        labelnotelp.setBounds (35,200,80,25);
        add(labelnotelp);
        fieldnotelp.setBounds(140, 200, 200,25);
        fieldnotelp.setText(String.valueOf(notelp));
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
        
        bingkaigambar.setBounds(50,225,150,200);
        add(bingkaigambar);

        btnubahnama.setBounds(350,100, 80, 25);
        btnubahpassword.setBounds(350,150,80,25);
        btnubahnotelp.setBounds(350,200,80,25);
        add(btnubahnama);
        add(btnubahpassword);
        add(btnubahnotelp);
        
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
                PembeliMenuInfoGui p = new PembeliMenuInfoGui(cek);
                p.setVisible(true);
                dispose();
            }
        });
        btnubahnama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputnama = JOptionPane.showInputDialog("Masukkan Nama Baru");
                    if(inputnama.length() >0){
                        AllObjectController.pembeli. updateData(1, inputnama,cek);
                        fieldnama.setText(inputnama);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
            });
        
        btnubahpassword.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                try {
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if (inputpass.length() > 0){
                        AllObjectController.pembeli.updateData(2, inputpass, cek);
                        fieldpassword.setText(inputpass); 
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnubahnotelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane. showInputDialog("Masukkan Nomor Telepon Baru");
                    if(inputNoTelp.length()>0){
                        AllObjectController.pembeli.updateData(3,inputNoTelp, cek);
                        fieldnotelp.setText(inputNoTelp);
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
