package GUI;

import BUS.KhoathiBUS;
import BUS.PhongthiBUS;
import DTO.KhoathiDTO;
import DTO.PhongthiDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLyKhoaThi_ThemKhoa extends JFrame {

    DefaultTableModel model;
    JTextField  ngaythi,phongthi,khoathi;
    JComboBox trinhdo; 
    KhoathiBUS bus;
    ArrayList del = new ArrayList();
    
    public QuanLyKhoaThi_ThemKhoa() {        
        bus = new KhoathiBUS();
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Thêm Khóa Thi");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

//vùng làm việc:3- đầu-nút-danh sách
        JPanel panel1 = new JPanel();       
        JPanel panel3l = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel3l.setBackground(Color.lightGray);
        panel1.setPreferredSize(new Dimension(300, 50));
        panel3l.setPreferredSize(new Dimension(300,250));
        //setLayout
        panel1.setLayout(null);
        panel3l.setLayout(null);
        panel3l.setBorder(matte);

//Label head
        //label danh sách Sach
        JLabel label1 = new JLabel();
        label1.setText("Thêm Khóa thi");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(22, 8, 360, 50);



// khung chứa nhập dl- nút
        //khung trái chứa nhập dl(5-250)
        JLabel sbd = new JLabel();
        sbd.setText("Khóa thi:");
        sbd.setForeground(Color.BLACK);
        sbd.setFont(new Font("Arial", Font.BOLD, 17));
        sbd.setBounds(10, 10, 100, 30);
        
        JLabel ho = new JLabel();
        ho.setText("Ngày thi:");
        ho.setForeground(Color.BLACK);
        ho.setFont(new Font("Arial", Font.BOLD, 17));
        ho.setBounds(10, 60, 100, 30);
                

        khoathi = new JTextField();
        String khoa = bus.get_makhoathi();
        khoathi.setText(khoa);        
        khoathi.setBounds(95, 10, 120, 20);
        khoathi.setBackground(Color.white);
        khoathi.setEditable(false);
        
        ngaythi = new JTextField();
        ngaythi.setText(null);
        ngaythi.setBounds(95, 65, 120, 20);
        ngaythi.setBackground(Color.white);

        phongthi = new JTextField();
        phongthi.setText(null);
        phongthi.setBounds(95, 110, 120, 20);
        phongthi.setBackground(Color.white);
        phongthi.setEditable(false);

        //khung phải nut(250-490)
        JButton them = new JButton("Thêm");
        them.setBounds(30, 160, 100, 30);
/*        JButton sapxep = new JButton("Sắp Xếp");
        sapxep.setPreferredSize(new Dimension(180, 40)); */
        JButton thoat = new JButton("Quay Lại");
        thoat.setBounds(150, 160, 100, 30);


//CHỨC NĂNG
        them.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
               them();
            }
        });

        thoat.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
               quaylai();
            }
        });

       
       
//ADD frame
        //panel 1 add
        panel1.add(label1);
        

        //panel 3 add
        

        panel3l.add(them);       
        panel3l.add(thoat);
        panel3l.add(sbd);
        panel3l.add(ho);
        panel3l.add(khoathi);  
        //panel3l.add(trinhdo);
        panel3l.add(ngaythi);
        //panel3l.add(phongthi);


        //frame add
        add(panel1);
        add(panel3l);                
    }

    public void run() {
        //pack();
        setVisible(true);
    }
   
    public void them(){        
        KhoathiDTO temp = new KhoathiDTO(khoathi.getText(), ngaythi.getText());
        bus.insert(temp);
        this.dispose();
    }
    
  
    
    public void quaylai(){
        this.dispose();
    }
    
    public static void main(String[] args)
    {
        QuanLyKhoaThi_ThemKhoa a = new QuanLyKhoaThi_ThemKhoa();
        a.setVisible(true);
    }
}
