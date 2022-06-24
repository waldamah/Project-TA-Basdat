package GUI;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 

public class MenuTransaksiGui extends ComponentGui{
    JTable tabeltransaksi = new JTable();
    JScrollPane sptransaksi = new JScrollPane(tabeltransaksi);
    JTextField textpilih = new JTextField();
    JButton btntambahtransaksi = new JButton("TAMBAH TRANSAKSI");
    JButton btnubahtransaksi = new JButton("UBAH TRANSAKSI");
    int kode;
    public MenuTransaksiGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("MENU TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("INFORMASI TRANSAKSI");
        labelregister.setBounds(480, 50, 150, 25);
        add(labelregister);
        
        sptransaksi.setBounds(20, 100, 870, 520);
        tabeltransaksi.setModel(AllObjectController.transaksi.daftarTransaksi());
        add(sptransaksi);
        
        btntambahtransaksi.setBounds(920, 230, 110, 25);
        btntambahtransaksi.setFocusPainted(false);
        btntambahtransaksi.setBorder(null);
        btntambahtransaksi.setBackground(Color.black);
        btntambahtransaksi.setForeground(Color.white);
        add(btntambahtransaksi);
        
        btnubahtransaksi.setBounds(920, 270, 110, 25);
        btnubahtransaksi.setFocusPainted(false);
        btnubahtransaksi.setBorder(null);
        btnubahtransaksi.setBackground(Color.black);
        btnubahtransaksi.setForeground(Color.white);
        add(btnubahtransaksi);
        
        btndelete.setBounds(920, 310, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnback.setBounds(15, 15, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabeltransaksi.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabeltransaksi.getSelectedRow();
                textpilih.setText(AllObjectController.transaksi.daftarTransaksi().getValueAt(i, 0).toString());
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.barang.DeleteDatabarang(kode);
                tabeltransaksi.setModel(AllObjectController.transaksi.daftarTransaksi());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS BARANG");
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
                MenuTransaksiGui menuTransaksiGui = new MenuTransaksiGui(kode);
                menuTransaksiGui.setVisible(true);
                dispose();
            }
        });
        
        btntambahtransaksi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               
                dispose();
            }
        });
        btntambahtransaksi.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btntambahtransaksi.setForeground(Color.black);
                btntambahtransaksi.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btntambahtransaksi.setForeground(Color.white);
                btntambahtransaksi.setBackground(Color.black);
            }
        });
        
        btnubahtransaksi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                
                dispose();
            }
        });
        btnubahtransaksi.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnubahtransaksi.setForeground(Color.black);
                btnubahtransaksi.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btnubahtransaksi.setForeground(Color.white);
                btnubahtransaksi.setBackground(Color.black);
            }
        });
    } 
}
