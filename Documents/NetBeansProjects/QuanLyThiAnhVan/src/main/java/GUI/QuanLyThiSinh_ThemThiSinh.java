package GUI;

import BUS.ThisinhBUS;
import DTO.ThisinhDTO;
import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class QuanLyThiSinh_ThemThiSinh extends JFrame {

    DefaultTableModel model;
    JTextField  hot, tent, gioitinh,ngaysinhtxt,noisinhtxt,
            cmndtxt,ngaycaptxt,noicaptxt,sdttxt,emailtxt,phongthitxt,khoathitxt;
    JRadioButton nam, nu;
    JComboBox trinhdo,khoathi;    
    ButtonGroup groupgioitinh;    
    ThisinhBUS bus;
    ArrayList del = new ArrayList();

    public QuanLyThiSinh_ThemThiSinh() {

        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Thêm Thí Sinh");
        setSize(500, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

//vùng làm việc:3- đầu-nút-danh sách
        JPanel panel1 = new JPanel();       
        JPanel panel3l = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel3l.setBackground(Color.lightGray);
        panel1.setPreferredSize(new Dimension(500, 50));
        panel3l.setPreferredSize(new Dimension(500,450));
        //setLayout
        panel1.setLayout(null);
        panel3l.setLayout(null);
        panel3l.setBorder(matte);

//Label head
        //label danh sách Sach
        JLabel label1 = new JLabel();
        label1.setText("Thêm Thí Sinh");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(130, 10, 360, 50);



// khung chứa nhập dl- nút
        //khung trái chứa nhập dl(5-250)
        JLabel sbd = new JLabel();
        sbd.setText("Trình độ:");
        sbd.setForeground(Color.BLACK);
        sbd.setFont(new Font("Arial", Font.BOLD, 17));
        sbd.setBounds(10, 10, 100, 30);
        
        JLabel ho = new JLabel();
        ho.setText("Họ:");
        ho.setForeground(Color.BLACK);
        ho.setFont(new Font("Arial", Font.BOLD, 17));
        ho.setBounds(10, 60, 100, 30);
        
        JLabel ten = new JLabel();
        ten.setText("Tên:");
        ten.setForeground(Color.BLACK);
        ten.setFont(new Font("Arial", Font.BOLD, 17));
        ten.setBounds(10, 110, 100, 30);
        
        JLabel ngaysinh = new JLabel();
        ngaysinh.setText("Ngày sinh:");
        ngaysinh.setForeground(Color.BLACK);
        ngaysinh.setFont(new Font("Arial", Font.BOLD, 17));
        ngaysinh.setBounds(10, 160, 100, 30);
        
        JLabel noisinh = new JLabel();
        noisinh.setText("Nơi sinh:");
        noisinh.setForeground(Color.BLACK);
        noisinh.setFont(new Font("Arail", Font.BOLD, 17));
        noisinh.setBounds(10, 210, 100, 30);
        
        JLabel cmnd = new JLabel();
        cmnd.setText("CMND:");
        cmnd.setForeground(Color.BLACK);
        cmnd.setFont(new Font("Arail", Font.BOLD, 17));
        cmnd.setBounds(250, 10, 100, 30);
        
        JLabel ngaycap = new JLabel();
        ngaycap.setText("Ngày cấp:");
        ngaycap.setForeground(Color.BLACK);
        ngaycap.setFont(new Font("Arail", Font.BOLD, 17));
        ngaycap.setBounds(250, 60, 100, 30);
        
        JLabel noicap = new JLabel();
        noicap.setText("Nơi cấp:");
        noicap.setForeground(Color.BLACK);
        noicap.setFont(new Font("Arail", Font.BOLD, 17));
        noicap.setBounds(250, 110, 100, 30);
        
        JLabel sdt = new JLabel();
        sdt.setText("SDT:");
        sdt.setForeground(Color.BLACK);
        sdt.setFont(new Font("Arail", Font.BOLD, 17));
        sdt.setBounds(250, 160, 100, 30);
        
        JLabel email = new JLabel();
        email.setText("Email:");
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Arail", Font.BOLD, 17));
        email.setBounds(250, 210, 100, 30);
        
        JLabel phongthi = new JLabel();
        phongthi.setText("Phòng Thi:");
        phongthi.setForeground(Color.BLACK);
        phongthi.setFont(new Font("Arail", Font.BOLD, 17));
        phongthi.setBounds(250, 260, 100, 30);
        
        JLabel khoathi = new JLabel();
        khoathi.setText("Khóa Thi:");
        khoathi.setForeground(Color.BLACK);
        khoathi.setFont(new Font("Arail", Font.BOLD, 17));
        khoathi.setBounds(250, 310, 100, 30);
        
        JLabel gioitinh = new JLabel();
        gioitinh.setText("Giới tính:");
        gioitinh.setForeground(Color.BLACK);
        gioitinh.setFont(new Font("Arial", Font.BOLD, 17));
        gioitinh.setBounds(10, 250, 100, 30);

        //textfield
        String[] a = {"    A2", "     B1"};
        trinhdo = new JComboBox(a);        
        trinhdo.setBounds(90, 15, 120, 20);
        trinhdo.setBackground(Color.white);
        trinhdo.setEditable(false);
                

        hot = new JTextField();
        hot.setText(null);
        hot.setBounds(90, 65, 120, 20);
        hot.setBackground(Color.white);

        tent = new JTextField();
        tent.setText(null);
        tent.setBounds(90, 115, 120, 20);
        tent.setBackground(Color.white);

        this.gioitinh = new JTextField();
        this.gioitinh.setText(null);
        this.gioitinh.setBounds(90, 165, 120, 20);
        this.gioitinh.setBackground(Color.white);        
        
        groupgioitinh = new ButtonGroup();
        nam = new JRadioButton("Nam", false);
        nu = new JRadioButton("Nữ", false);
        groupgioitinh.add(nam);
        groupgioitinh.add(nu);
        nam.setBounds(90, 255, 60, 20);
        nu.setBounds(150, 255, 60, 20);
        
        this.ngaysinhtxt = new JTextField();
        this.ngaysinhtxt.setText(null);
        this.ngaysinhtxt.setBackground(Color.white);
        //this.ngaysinhtxt.setFont(new Font("Arial", Font.BOLD, 17));
        this.ngaysinhtxt.setBounds(90, 160, 120, 20);
        
        this.noisinhtxt = new JTextField();
        this.noisinhtxt.setText(null);
        this.noisinhtxt.setBackground(Color.white);
        //this.noisinhtxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.noisinhtxt.setBounds(90, 210, 120, 20);
        
        this.cmndtxt = new JTextField();
        this.cmndtxt.setText(null);
        this.cmndtxt.setBackground(Color.white);
        //this.cmndtxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.cmndtxt.setBounds(340, 20, 120, 20);
        
        this.ngaycaptxt = new JTextField();
        this.ngaycaptxt.setText(null);
        this.ngaycaptxt.setBackground(Color.white);
        //this.ngaycaptxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.ngaycaptxt.setBounds(340, 70, 120, 20);
        
        this.noicaptxt = new JTextField();
        this.noicaptxt.setText(null);
        this.noicaptxt.setBackground(Color.white);
        //this.noicaptxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.noicaptxt.setBounds(340, 120, 120, 20);
        
        this.sdttxt = new JTextField();
        this.sdttxt.setText(null);
        this.sdttxt.setBackground(Color.white);
        //this.sdttxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.sdttxt.setBounds(340, 170, 120, 20);
        
        this.emailtxt = new JTextField();
        this.emailtxt.setText(null);
        this.emailtxt.setBackground(Color.white);
        //this.email.setFont(new Font("Arail", Font.BOLD, 17));
        this.emailtxt.setBounds(340, 220, 120, 20);
        
        this.phongthitxt = new JTextField();
        this.phongthitxt.setText(null);
        this.phongthitxt.setBackground(Color.white);
        //this.phongthitxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.phongthitxt.setBounds(340, 270, 120, 20);
        this.phongthitxt.setEditable(false);
        
        String[] b = this.getkhoathi();
        this.khoathi = new JComboBox(b);        
        this.khoathi.setBackground(Color.white);
        //this.khoathitxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.khoathi.setBounds(340, 320, 120, 20);

        //khung phải nut(250-490)
        JButton them = new JButton("Thêm");
        them.setBounds(90, 360, 100, 30);
/*        JButton sapxep = new JButton("Sắp Xếp");
        sapxep.setPreferredSize(new Dimension(180, 40)); */
        JButton thoat = new JButton("Quay Lại");
        thoat.setBounds(300, 360, 100, 30);


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
        panel3l.add(ten);        
        panel3l.add(cmnd);
        panel3l.add(email);
        panel3l.add(ngaycap);
        panel3l.add(noicap);
        panel3l.add(phongthi);
        panel3l.add(khoathi);
        panel3l.add(ngaysinh);
        panel3l.add(noisinh);
        panel3l.add(sdt);        
        panel3l.add(gioitinh);
        
        panel3l.add(trinhdo);
        panel3l.add(hot);
        panel3l.add(tent);
        panel3l.add(this.ngaysinhtxt);
        panel3l.add(this.noisinhtxt);
        panel3l.add(this.cmndtxt);
        panel3l.add(this.ngaycaptxt);
        panel3l.add(this.noicaptxt);
        panel3l.add(this.sdttxt);
        panel3l.add(this.emailtxt);
        panel3l.add(this.phongthitxt);
        panel3l.add(this.khoathi);                    
        panel3l.add(nam);
        panel3l.add(nu);

        //frame add
        add(panel1);
        add(panel3l);
        


    }

    public void run() {
        //pack();
        setVisible(true);
    }
   
    public void them(){        
        if (this.kiemtra() == false)
            return;
        String trinhdo = (String) this.trinhdo.getSelectedItem();
        trinhdo = trinhdo.trim();
        ThisinhDTO thisinh = new ThisinhDTO();
        thisinh.setHo(this.hot.getText());
        thisinh.setTen(this.tent.getText());
        thisinh.setCMND(this.cmndtxt.getText());
        thisinh.setEmail(this.emailtxt.getText());
        if (this.nam.isSelected())
            thisinh.setGioitinh("1");
        else
            thisinh.setGioitinh("0");
        thisinh.setKhoathi((String)this.khoathi.getSelectedItem());
        System.out.println("KHOATHI:"+(String)this.khoathi.getSelectedItem());
        System.out.println("trinhdo:"+trinhdo);
        thisinh.setNgaycap(this.ngaycaptxt.getText());
        thisinh.setNgaysinh(this.ngaysinhtxt.getText());
        thisinh.setNoicap(this.noicaptxt.getText());
        thisinh.setNoisinh(this.noisinhtxt.getText());
        thisinh.setSDT(this.sdttxt.getText());
        thisinh.setPhongthi(bus.get_phongthi((String)this.khoathi.getSelectedItem(),
                trinhdo));
        bus.insert_without_SBD(thisinh, (String)this.trinhdo.getSelectedItem(), (String)this.khoathi.getSelectedItem());
        this.dispose();
    }
    
    public boolean kiemtra(){
        if( this.hot.getSelectionEnd()==0 ||
           this.tent.getSelectionEnd()==0 || this.ngaysinhtxt.getSelectionEnd()==0||
           this.noisinhtxt.getSelectionEnd()==0||this.cmndtxt.getSelectionEnd()==0||
           this.ngaycaptxt.getSelectionEnd()==0||this.noicaptxt.getSelectionEnd()==0||
           this.sdttxt.getSelectionEnd()==0 || this.emailtxt.getSelectionEnd()==0
           )
       {
           JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin","Cảnh báo",JOptionPane.CANCEL_OPTION);
           return false;
       }
        return true;
    }
    
    public String[] getkhoathi(){
        bus = new ThisinhBUS();
        return bus.getkhoathi();
    }
    
    public void quaylai(){
        this.dispose();
    }
    
    public static void main(String[] args)
    {
        QuanLyThiSinh_ThemThiSinh a = new QuanLyThiSinh_ThemThiSinh();
        a.setVisible(true);
    }
}
