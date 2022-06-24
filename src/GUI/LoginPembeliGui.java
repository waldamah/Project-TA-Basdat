package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.io.File; 
import java.io.IOException; 
import java.util.logging. Level;
import java.util.logging. Logger;


public class LoginPembeliGui extends ComponentGui {
    JRadioButton btnloginpembeli = new JRadioButton("Login Pembeli");
    JButton btnlogin = new JButton("Login");
    JButton btnregispembeli = new JButton("Registrasi");
    String gambar;
    public LoginPembeliGui(){
        initComponent();
    }
    
    void initComponent() {
        setTitle("Login Pembeli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); 
        setVisible(true);

        labelnama.setBounds (85,250,70,25); 
        add(labelnama); 
        fieldnama.setBounds(180,250,185,25);
        add(fieldnama);

        labelpassword.setBounds (85, 290,80, 25);
        add(labelpassword); 
        fieldpassword.setBounds (180, 290, 185,25); 
        add(fieldpassword);
        
        btnloginpembeli.setBounds (180,350,100,25);
        btnloginpembeli.setBackground (Color.red);
        btnloginpembeli. setForeground (Color.white);
        btnloginpembeli.setBorder(null); 
        add(btnloginpembeli);
        
        btnregispembeli.setBounds(140, 400, 180, 25);
        btnregispembeli.setBorder(null);
        btnregispembeli.setBackground(Color.WHITE);
        add(btnregispembeli);
        
        btnlogin.setBounds(140, 350, 180, 25);
        btnlogin.setBorder(null);
        btnlogin.setBackground(Color.WHITE);
        add(btnlogin);

        btnloginpembeli.setBounds(20,10,150,20);
        btnloginpembeli.setBorder(null);
        btnloginpembeli.setBackground (Color.white);
        add (btnloginpembeli);
        bingkaigambar.setBounds (150,70,150, 150);
        add(bingkaigambar);
        gambar = "D:\\ITATS\\praktikum Pemrograman Berorientasi Objek\\admin.png";
        try {
            bufferedimage = ImageIO.read(new File(gambar));
        }catch (IOException ex) {
            Logger.getLogger(LoginPembeliGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        gambarresize = bufferedimage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnregispembeli.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            btnregispembeli.setForeground(Color.BLUE);
        }
        public void mouseExited(MouseEvent e) {
            btnregispembeli.setForeground(Color.black);
        }
        });
        btnregispembeli.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new RegisterPembeliGui().setVisible(true);
        }
        });
        
        btnloginpembeli.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            btnloginpembeli.setForeground(Color.RED);
        }
        public void mouseExited(MouseEvent e) {
            btnloginpembeli.setForeground(Color.black);
        }
        });
        btnloginpembeli.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            dispose();
            LoginPembeliGui LoginAdminGui = new LoginPembeliGui();
            LoginAdminGui.setVisible(true);
        }
        });
        
       
        btnlogin.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground (Color.black);
                btnlogin.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white); 
                btnlogin.setBackground(Color.black);
            }
        });
        btnlogin.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String nama = fieldnama.getText();
                String password = fieldpassword.getText();
                int cek = AllObjectController.pembeli.login(nama, password);
                if (cek>0){
                    dispose();
                    MenuKeranjangGui menuKGui = new MenuKeranjangGui(cek); 
                    menuKGui.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}
