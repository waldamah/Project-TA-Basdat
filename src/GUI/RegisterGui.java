package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class RegisterGui extends ComponentGui{
    public RegisterGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Akun Pembeli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
//        labelregister.setText("REGISTER PEMBELI");
//        labelregister.setBounds(160, 50, 150, 25);
//        add(labelregister);
//        
//        
        labelidpembeli.setBounds(35, 50, 80, 25);
        add(labelidpembeli);
        fieldidpembeli.setBounds(140, 50, 290, 25);
        add(fieldidpembeli);
        
        labelnama.setBounds(35, 100, 40, 25);
        add(labelnama);
        fieldnama.setBounds(140, 100, 290, 25);
        add(fieldnama);
        
        labelpassword.setBounds(35, 150, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(140, 150, 290, 25);
        add(fieldpassword);
        
        labelnotelp.setBounds(35, 200, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(140, 200, 290, 25);
        add(fieldnotelp);
        
        btnback.setBounds(15, 15, 80, 15);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnregister.setBounds(160, 380, 140, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);
        
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
                LoginPembeliGui loginGui = new LoginPembeliGui();
                loginGui.setVisible(true);
                dispose();
            }
        });
        
        btnregister.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e){
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama_user = fieldnama.getText();
                String password = fieldpassword.getText();
                int idpembeli = Integer.parseInt(fieldidpembeli.getText());
                int notelp = Integer.parseInt(fieldnotelp.getText());
                if(nama_user.length() != 0 && password.length() != 0){
                    AllObjectController.pembeli.insertData(idpembeli,nama_user, password, notelp);
                    JOptionPane.showMessageDialog(null, nama_user + " Adalah Pelanggan Baru");
                    dispose();
                    new LoginPembeliGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
