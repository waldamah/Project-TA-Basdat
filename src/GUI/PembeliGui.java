package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PembeliGui extends ComponentGui {
    JTable tabelpembeli = new JTable();
    JScrollPane sppembeli = new JScrollPane(tabelpembeli);
    JTextField textpilih = new JTextField();
    JButton btnmenupembeli = new JButton("INFO");
    int kode;
    public PembeliGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("MENU PEMBELI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        sppembeli.setBounds(20, 50, 500, 350);
        tabelpembeli.setModel(AllObjectController.pembeli.daftarPembeli());
        add(sppembeli);
        
        
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnmenupembeli.setBounds(540, 145, 110, 25);
        btnmenupembeli.setFocusPainted(false);
        btnmenupembeli.setBorder(null);
        btnmenupembeli.setBackground(Color.black);
        btnmenupembeli.setForeground(Color.white);
        add(btnmenupembeli);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabelpembeli.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabelpembeli.getSelectedRow();
                textpilih.setText(AllObjectController.pembeli.daftarPembeli().getValueAt(i, 0).toString());
            }
        });
         
        btndelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.barang.DeleteDatabarang(cek);
                tabelpembeli.setModel(AllObjectController.pembeli.daftarPembeli());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA PEMBELI");
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
                LoginPembeliGui loginAdminGui = new LoginPembeliGui();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnmenupembeli.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PembeliMenuInfoGui pembeliMenuGui = new PembeliMenuInfoGui(cek);
                pembeliMenuGui.setVisible(true);
                dispose();
            }
        });
    } 
}
