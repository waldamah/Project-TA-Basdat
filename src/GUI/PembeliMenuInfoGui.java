package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PembeliMenuInfoGui extends ComponentGui{
    JTable tabelpembeli = new JTable();
    JScrollPane sppembeli = new JScrollPane(tabelpembeli);
    JTextField textpilih = new JTextField();
    int kode;
    public PembeliMenuInfoGui(int cek){
        initComponent(cek);
    }
    void initComponent(final int cek){
        setTitle("MENU INFORMASI PEMBELI ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        sppembeli.setBounds(20, 50, 500, 350);
        tabelpembeli.setModel(AllObjectController.pembeli.daftarPembeli());
        add(sppembeli);
        
        btnubahdata.setBounds(540, 50, 110, 25);
        btnubahdata.setFocusPainted(false);
        btnubahdata.setBorder(null);
        btnubahdata.setBackground(Color.black);
        btnubahdata.setForeground(Color.white);
        add(btnubahdata);
        
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
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
        
        btnubahdata.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PembeliUDGui pembeliMenuUDGui = new PembeliUDGui(cek);
                pembeliMenuUDGui.setVisible(true);
                dispose();
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
                PembeliGui pembeliGui = new PembeliGui(cek);
                pembeliGui.setVisible(true);
                dispose();
            }
        });
    } 
}
