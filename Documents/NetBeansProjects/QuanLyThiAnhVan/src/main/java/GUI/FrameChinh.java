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

public class FrameChinh extends JFrame {

    JButton thisinh,khoathi;
    
    public FrameChinh() {                
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Trang chủ");
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
        label1.setText("Trang chủ");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(22, 8, 360, 50);



// khung chứa nhập dl- nút
        //khung trái chứa nhập dl(5-250)
       
           
        
        //khoathi.setBounds(95, 10, 120, 20);
        
        
        
        //ngaythi.setBounds(95, 65, 120, 20);
        

        
        //phongthi.setBounds(95, 110, 120, 20);
        

        //khung phải nut(250-490)
        JButton thisinh = new JButton("Quản Lý Thí Sinh");
        thisinh.setBounds(50, 50, 200, 30);
/*        JButton sapxep = new JButton("Sắp Xếp");
        sapxep.setPreferredSize(new Dimension(180, 40)); */
        JButton khoathi = new JButton("Quản Lý Khóa Thi");
        khoathi.setBounds(50, 120, 200, 30);


//CHỨC NĂNG
        thisinh.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuanLyThiSinh a = new QuanLyThiSinh();
                a.run();
            }
        });

        khoathi.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
               QuanLyKhoaThi b = new QuanLyKhoaThi();
               b.run();
            }
        });

       
       
//ADD frame
        //panel 1 add
        panel1.add(label1);
        

        //panel 3 add
        

        panel3l.add(thisinh);       
        panel3l.add(khoathi);
        


        //frame add
        add(panel1);
        add(panel3l);                
    }

    public void run() {
        //pack();
        setVisible(true);
    }
   
    
  
   
    
    public static void main(String[] args)
    {
        FrameChinh a = new FrameChinh();
        a.setVisible(true);
    }
}
