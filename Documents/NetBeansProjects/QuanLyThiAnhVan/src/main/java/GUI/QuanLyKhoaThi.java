package GUI;

import BUS.KhoathiBUS;
import DTO.KhoathiDTO;
import DTO.PhongthiDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLyKhoaThi extends JFrame{
    DefaultTableModel model;
    JTable tblDSSV;
    JScrollPane jScrollPane1;
    JTextField khoathi, ngaythi,timkiem3;      
    JButton timkiem4;
    Vector header;
    KhoathiBUS bus;
    int press=-1;
   
   public QuanLyKhoaThi() {

        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Danh Sach Sinh Vien");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

//vùng làm việc:3- đầu-nút-danh sách
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel3l = new JPanel();
        JPanel panel3r = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.gray);
        panel3.setBackground(Color.lightGray);
       

        panel1.setPreferredSize(new Dimension(500, 100));
        panel2.setPreferredSize(new Dimension(500, 200));
        panel3.setPreferredSize(new Dimension(480, 140));

        //setLayout
        panel1.setLayout(null);
        panel2.setLayout(new FlowLayout());

        
        panel3.setBorder(title);
        panel3.setLayout(null);            

//Label head
        //label danh sách sv
        JLabel label1 = new JLabel();
        label1.setText("Danh Sách Khóa Thi");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(100, 10, 360, 50);

//table
        model = new DefaultTableModel();
        header = new Vector();
        header.add("Khóa");
        header.add("Ngày thi");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        tblDSSV = new JTable();
        tblDSSV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //tblDSSV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblDSSV.setModel(model);
        tblDSSV.getTableHeader().setBackground(Color.LIGHT_GRAY);
        tblDSSV.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tblDSSV.setForeground(Color.black);
        //tblDSSV.setFillsViewportHeight(true);
        tblDSSV.setFillsViewportHeight(true);
        jScrollPane1 = new JScrollPane(tblDSSV);        
        jScrollPane1.setViewportView(tblDSSV);
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new Dimension(480, 190));

//chuc nang tim kiem
        //jlabel tim kiem
        JLabel timkiem = new JLabel();
        timkiem.setText("Tìm Kiếm khóa thi");
        timkiem.setForeground(Color.black);
        timkiem.setFont(new Font("Arial", Font.BOLD, 20));
        timkiem.setBounds(10, 75, 200, 25);

        //TEXTFIELD timkiem
        timkiem3 = new JTextField();
        timkiem3.setBounds(200, 75, 200, 26);




        //button tìm kiếm
        timkiem4 = new JButton();
        timkiem4.setText("Tìm");
        timkiem4.setForeground(Color.black);
        timkiem4.setFont(new Font("Arial", Font.BOLD, 15));
        timkiem4.setBounds(400, 75, 80, 25);
// khung chứa nhập dl- nút
        //khung trái chứa nhập dl(5-250)
        JLabel sbd = new JLabel();
        sbd.setText("Khóa thi:");
        sbd.setForeground(Color.BLACK);
        sbd.setFont(new Font("Arial", Font.BOLD, 17));
        sbd.setBounds(10, 20, 100, 30);
        
        JLabel ho = new JLabel();
        ho.setText("Ngày thi:");
        ho.setForeground(Color.BLACK);
        ho.setFont(new Font("Arial", Font.BOLD, 17));
        ho.setBounds(10, 80, 100, 30);
        
        //textfield
        this.khoathi = new JTextField();
        this.khoathi.setText(null);
        this.khoathi.setBounds(90, 22, 120, 20);
        this.khoathi.setBackground(Color.white);

        ngaythi = new JTextField();
        ngaythi.setText(null);
        ngaythi.setBounds(90, 82, 120, 20);
        ngaythi.setBackground(Color.white);

        
        
        //khung phải nut(250-490)
        JButton them = new JButton("Thêm");
        them.setBounds(250, 20, 100, 20);
        
        JButton sua = new JButton("Sửa");
        sua.setBounds(250, 60, 100, 20);
        
        
        JButton quaylai = new JButton("Quay lại");
        quaylai.setBounds(350, 20, 100, 20);
        
        JButton taidl = new JButton("Tải dữ liệu");
        taidl.setBounds(350, 60, 100, 20);

        JButton chitiet = new JButton("Chi tiết");
        chitiet.setBounds(350, 100, 100, 20);
//CHỨC NĂNG
        timkiem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timkiem();
        }});
        tblDSSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               int i = tblDSSV.getSelectedRow();
               if (i == press)
               {                
                khoathi.setText("");
                ngaythi.setText("");
                
                press = -1;
               }
               else
               {
                    click(i);
                    press = i;
               }                               
                
        }});

        
        them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                them();
            }
        });
        
        sua.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua();
            }
        });
        
        quaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
        
        chitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitietphong();
            }
        });
        
        taidl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taidulieu();
        }});
//ADD frame
        //panel 1 add
        panel1.add(label1);
        panel1.add(timkiem);
        
        panel1.add(timkiem3);
        panel1.add(timkiem4);

        //panel 2 add
        panel2.add(jScrollPane1);

        //panel 3 add
        panel3.add(sbd);
        panel3.add(ho);

        
        panel3.add(this.khoathi);
        panel3.add(ngaythi);
       

        panel3.add(them);
        panel3.add(sua);
        panel3.add(quaylai);
        panel3.add(taidl);
        panel3.add(chitiet);

        //frame add
        add(panel1);
        add(panel2);
        add(panel3);
    }
   
   public void run(){
       this.setVisible(true);
   }
   
   //Hàm để tải dữ liệu lên table_ có thể thay thế bằng việc tải lên sẵn
   public void taidulieu(){
       bus = new KhoathiBUS();
       ArrayList<KhoathiDTO> arrayresult = bus.array;
       this.load_data_to_jtable(arrayresult);       
   }
   
   //Hàm sửa thông tin thí sinh
   public void sua(){
       int i = tblDSSV.getSelectedRow();
       if(i!=-1)
       {
            String ngaythi = this.ngaythi.getText();
            KhoathiDTO temp = new KhoathiDTO(khoathi.getText(), ngaythi);
            ArrayList temp2 = bus.update(temp);
            this.load_data_to_jtable(temp2);
       }
       else
           JOptionPane.showMessageDialog(null,"Bạn phải chọn khóa để mở chi tiết!","Cảnh báo",JOptionPane.CANCEL_OPTION);
      
   }
   
   //Hàm thêm thí sinh
   public void them(){
      QuanLyKhoaThi_ThemKhoa a = new QuanLyKhoaThi_ThemKhoa();
      a.setVisible(true);      
   }
   
   //Hàm để set hành động click và jtable_chi tiết thí sinh
   public void click(int i){
       KhoathiDTO temp = bus.array.get(i);
       this.khoathi.setText(temp.getKhoathi());
       this.khoathi.setEditable(false);
       this.ngaythi.setText(temp.getNgaythi());       
   }
   
   //Hàm để tìm kiếm
   public void timkiem(){
        String khoa = this.timkiem3.getText();
        ArrayList result = bus.timkiem(khoa);
        this.load_data_to_jtable(result);
   }
   
   //Hàm để mở frame chi tiết phòng
   public void chitietphong(){
       int i = tblDSSV.getSelectedRow();
       if(i!=-1)
       {
           QuanLyKhoaThi_ChitietKhoa a = new QuanLyKhoaThi_ChitietKhoa(i);
           a.setVisible(true);
       }
       else
           JOptionPane.showMessageDialog(null,"Bạn phải chọn khóa để mở chi tiết!","Cảnh báo",JOptionPane.CANCEL_OPTION);
   }
   //Hàm để load dữ liệu từ array vào jtable
   public void load_data_to_jtable(ArrayList data){
       //Xóa data cũ, load lại data mới
       if (model!=null)
       {
           model = new DefaultTableModel(header, 0)
                {   @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                };
       }
       for(int i=0;i<data.size();i++){
            Vector row = new Vector();
            KhoathiDTO khoathi=(KhoathiDTO)data.get(i);
            row.add(khoathi.getKhoathi());
            row.add(khoathi.getNgaythi());         
            model.addRow(row);
            }
        tblDSSV.setModel(model);       
   }
   
   public static void main(String[] args){
       QuanLyKhoaThi a = new QuanLyKhoaThi();
       a.run();
   }
}
