package GUI;

import BUS.ThisinhBUS;
import DTO.ThisinhDTO;
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

public class QuanLyThiSinh extends JFrame{
    DefaultTableModel model;
    JTable tblDSSV;
    JScrollPane jScrollPane1;
    JTextField SBD, hot, tent, gioitinh,ngaysinhtxt,noisinhtxt,timkiem3,
            cmndtxt,ngaycaptxt,noicaptxt,sdttxt,emailtxt,phongthitxt,khoathitxt;
    JRadioButton nam, nu;
    JComboBox timkiem2;
    ButtonGroup groupgioitinh;    
    JButton timkiem4;
    Vector header;
    ThisinhBUS bus;
    int press=-1;
   
   public QuanLyThiSinh() {

        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Danh Sach Sinh Vien");
        setSize(800, 720);
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
       

        panel1.setPreferredSize(new Dimension(800, 120));
        panel2.setPreferredSize(new Dimension(800, 200));
        panel3.setPreferredSize(new Dimension(800, 400));

        //setLayout
        panel1.setLayout(null);
        panel2.setLayout(new FlowLayout());

        
        panel3.setBorder(title);
        panel3.setLayout(null);            

//Label head
        //label danh sách sv
        JLabel label1 = new JLabel();
        label1.setText("Danh Sách Thí Sinh");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(290, 10, 360, 50);

//table
        model = new DefaultTableModel();
        header = new Vector();
        header.add("SBD");
        header.add("Họ");
        header.add("Tên");
        header.add("Giới tính");
        header.add("Ngày sinh");
        header.add("Nơi sinh");
        header.add("CMND");
        header.add("Ngày cấp");
        header.add("Nơi cấp");        
        header.add("SDT");
        header.add("Email");
        header.add("Phòng Thi");
        header.add("Khóa Thi");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        tblDSSV = new JTable();
        tblDSSV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblDSSV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
        jScrollPane1.setPreferredSize(new Dimension(770, 200));

//chuc nang tim kiem
        //jlabel tim kiem
        JLabel timkiem = new JLabel();
        timkiem.setText("Tìm Kiếm");
        timkiem.setForeground(Color.black);
        timkiem.setFont(new Font("Arial", Font.BOLD, 20));
        timkiem.setBounds(150, 75, 110, 25);

        //TEXTFIELD timkiem
        timkiem3 = new JTextField();
        timkiem3.setBounds(350, 75, 250, 26);

        //COMBOBOX tim kiem
        String[] a = {"    SBD", "     Tên","     CMND", "    Phòng Thi","     Khóa Thi"};
        timkiem2 = new JComboBox(a);
        timkiem2.setSelectedIndex(0);
        timkiem2.setBounds(250, 75, 80, 25);



        //button tìm kiếm
        timkiem4 = new JButton();
        timkiem4.setText("Tìm");
        timkiem4.setForeground(Color.black);
        timkiem4.setFont(new Font("Arial", Font.BOLD, 15));
        timkiem4.setBounds(630, 75, 80, 25);
// khung chứa nhập dl- nút
        //khung trái chứa nhập dl(5-250)
        JLabel sbd = new JLabel();
        sbd.setText("SBD:");
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
        cmnd.setBounds(300, 10, 100, 30);
        
        JLabel ngaycap = new JLabel();
        ngaycap.setText("Ngày cấp:");
        ngaycap.setForeground(Color.BLACK);
        ngaycap.setFont(new Font("Arail", Font.BOLD, 17));
        ngaycap.setBounds(300, 60, 100, 30);
        
        JLabel noicap = new JLabel();
        noicap.setText("Nơi cấp:");
        noicap.setForeground(Color.BLACK);
        noicap.setFont(new Font("Arail", Font.BOLD, 17));
        noicap.setBounds(300, 110, 100, 30);
        
        JLabel sdt = new JLabel();
        sdt.setText("SDT:");
        sdt.setForeground(Color.BLACK);
        sdt.setFont(new Font("Arail", Font.BOLD, 17));
        sdt.setBounds(300, 160, 100, 30);
        
        JLabel email = new JLabel();
        email.setText("Email:");
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Arail", Font.BOLD, 17));
        email.setBounds(300, 210, 100, 30);
        
        JLabel phongthi = new JLabel();
        phongthi.setText("Phòng Thi:");
        phongthi.setForeground(Color.BLACK);
        phongthi.setFont(new Font("Arail", Font.BOLD, 17));
        phongthi.setBounds(300, 260, 100, 30);
        
        JLabel khoathi = new JLabel();
        khoathi.setText("Khóa Thi:");
        khoathi.setForeground(Color.BLACK);
        khoathi.setFont(new Font("Arail", Font.BOLD, 17));
        khoathi.setBounds(300, 310, 100, 30);
        
        JLabel gioitinh = new JLabel();
        gioitinh.setText("Giới tính:");
        gioitinh.setForeground(Color.BLACK);
        gioitinh.setFont(new Font("Arial", Font.BOLD, 17));
        gioitinh.setBounds(10, 250, 100, 30);

        //textfield
        SBD = new JTextField();
        SBD.setText(null);
        SBD.setBounds(90, 15, 120, 20);
        SBD.setBackground(Color.white);

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
        this.cmndtxt.setBounds(390, 20, 120, 20);
        
        this.ngaycaptxt = new JTextField();
        this.ngaycaptxt.setText(null);
        this.ngaycaptxt.setBackground(Color.white);
        //this.ngaycaptxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.ngaycaptxt.setBounds(390, 70, 120, 20);
        
        this.noicaptxt = new JTextField();
        this.noicaptxt.setText(null);
        this.noicaptxt.setBackground(Color.white);
        //this.noicaptxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.noicaptxt.setBounds(390, 120, 120, 20);
        
        this.sdttxt = new JTextField();
        this.sdttxt.setText(null);
        this.sdttxt.setBackground(Color.white);
        //this.sdttxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.sdttxt.setBounds(390, 170, 120, 20);
        
        this.emailtxt = new JTextField();
        this.emailtxt.setText(null);
        this.emailtxt.setBackground(Color.white);
        //this.email.setFont(new Font("Arail", Font.BOLD, 17));
        this.emailtxt.setBounds(390, 220, 120, 20);
        
        this.phongthitxt = new JTextField();
        this.phongthitxt.setText(null);
        this.phongthitxt.setBackground(Color.white);
        //this.phongthitxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.phongthitxt.setBounds(390, 270, 120, 20);
        
        this.khoathitxt = new JTextField();
        this.khoathitxt.setText(null);
        this.khoathitxt.setBackground(Color.white);
        //this.khoathitxt.setFont(new Font("Arail", Font.BOLD, 17));
        this.khoathitxt.setBounds(390, 320, 120, 20);
        
        
        //khung phải nut(250-490)
        JButton them = new JButton("Thêm");
        them.setBounds(600, 10, 150, 35);
        
        JButton sua = new JButton("Sửa");
        sua.setBounds(600, 50, 150, 35);
        
        JButton xoa = new JButton("Xóa");
        xoa.setBounds(600, 100, 150, 35);
        
        JButton sapxep = new JButton("Sắp Xếp");
        sapxep.setBounds(600, 150, 150, 35);
        
        JButton thoat = new JButton("Thoát");
        thoat.setBounds(600, 200, 150, 35);
        
        JButton taidl = new JButton("Tải dữ liệu");
        taidl.setBounds(600, 250, 150, 35);


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
                SBD.setText("");
                hot.setText("");
                tent.setText("");
                nam.setSelected(false);
                nu.setSelected(false);
                ngaysinhtxt.setText("");
                noisinhtxt.setText("");
                cmndtxt.setText("");
                ngaycaptxt.setText("");
                noicaptxt.setText("");
                sdttxt.setText("");
                emailtxt.setText("");
                phongthitxt.setText("");
                khoathitxt.setText("");
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
        
        xoa.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa();
            }
        });
        
        sua.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua();
            }
        });
        
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
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
        panel1.add(timkiem2);
        panel1.add(timkiem3);
        panel1.add(timkiem4);

        //panel 2 add
        panel2.add(jScrollPane1);

        //panel 3 add
        panel3.add(sbd);
        panel3.add(ho);
        panel3.add(ten);        
        panel3.add(cmnd);
        panel3.add(email);
        panel3.add(ngaycap);
        panel3.add(noicap);
        panel3.add(phongthi);
        panel3.add(khoathi);
        panel3.add(ngaysinh);
        panel3.add(noisinh);
        panel3.add(sdt);        
        panel3.add(gioitinh);
        
        panel3.add(SBD);
        panel3.add(hot);
        panel3.add(tent);
        panel3.add(this.ngaysinhtxt);
        panel3.add(this.noisinhtxt);
        panel3.add(this.cmndtxt);
        panel3.add(this.ngaycaptxt);
        panel3.add(this.noicaptxt);
        panel3.add(this.sdttxt);
        panel3.add(this.emailtxt);
        panel3.add(this.phongthitxt);
        panel3.add(this.khoathitxt);
        //panel3.add(this.gioitinh);                
        panel3.add(nam);
        panel3.add(nu);

        panel3.add(them);
        panel3.add(sua);
        panel3.add(xoa);        
        panel3.add(thoat);
        panel3.add(taidl);
                

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
       bus = new ThisinhBUS();
       ArrayList<ThisinhDTO> arrayresult = bus.array;
       this.load_data_to_jtable(arrayresult);       
   }
   
   //Hàm sửa thông tin thí sinh
   public void sua(){
       if(tblDSSV.getSelectedColumn()<0)
       {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin thay đổi","Cảnh báo",JOptionPane.CANCEL_OPTION);
           return;
       }
        ThisinhDTO thisinh = new ThisinhDTO();
        thisinh.setSBD(this.SBD.getText());
        thisinh.setHo(this.hot.getText());
        thisinh.setTen(this.tent.getText());
        thisinh.setCMND(this.cmndtxt.getText());
        thisinh.setEmail(this.emailtxt.getText());
        if (this.nam.isSelected())
            thisinh.setGioitinh("1");
        else
            thisinh.setGioitinh("0");                
        thisinh.setNgaycap(this.ngaycaptxt.getText());
        thisinh.setNgaysinh(this.ngaysinhtxt.getText());
        thisinh.setNoicap(this.noicaptxt.getText());
        thisinh.setNoisinh(this.noisinhtxt.getText());
        thisinh.setSDT(this.sdttxt.getText());      
        thisinh.setKhoathi(this.khoathitxt.getText());
        ArrayList temp = bus.update(thisinh);
        //this.taidulieu();
        this.load_data_to_jtable(temp);
   }
   
   //Hàm thêm thí sinh
   public void them(){
      QuanLyThiSinh_ThemThiSinh insert = new QuanLyThiSinh_ThemThiSinh();
      insert.setVisible(true);
      
   }
   
   public void xoa(){
       int rt = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
       if(rt == JOptionPane.YES_OPTION){
       int i = tblDSSV.getSelectedRow();
       if(i!=-1){
        ArrayList temp = bus.Delete(i);
        this.load_data_to_jtable(temp);
       }
       else
        JOptionPane.showMessageDialog(null,"Vui lòng chọn thí sinh cần xóa","Cảnh báo",JOptionPane.CANCEL_OPTION);
       }
   }
   
   //Hàm để set hành động click và jtable_chi tiết thí sinh
   public void click(int i){
       ThisinhDTO temp = bus.array.get(i);
       this.SBD.setText(temp.getSBD());
       this.SBD.setEditable(false);
       this.hot.setText(temp.getHo());
       this.tent.setText(temp.getTen());
       if(temp.getGioitinh().equals("1"))
       {
           this.nam.setSelected(true);
           this.nu.setSelected(false);
       }
       else
           this.nam.setSelected(false);
           this.nu.setSelected(true);
       this.ngaysinhtxt.setText(temp.getNgaysinh());
       this.noisinhtxt.setText(temp.getNoisinh());
       this.cmndtxt.setText(temp.getCMND());
       this.ngaycaptxt.setText(temp.getNgaycap());
       this.noicaptxt.setText(temp.getNoicap());
       this.sdttxt.setText(temp.getSDT());
       this.emailtxt.setText(temp.getEmail());
       this.phongthitxt.setText(temp.getPhongthi());
       this.khoathitxt.setText(temp.getKhoathi());
   }
   
   //Hàm để tìm kiếm
   public void timkiem(){
       String timkiem = timkiem3.getText();
       int loai       = timkiem2.getSelectedIndex();       
       ArrayList result = bus.timkiem(loai, timkiem);
       this.load_data_to_jtable(result);
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
            ThisinhDTO thisinh=(ThisinhDTO)data.get(i);
            row.add(thisinh.getSBD());
            row.add(thisinh.getHo());
            row.add(thisinh.getTen());
            row.add(thisinh.getGioitinh());
            row.add(thisinh.getNgaysinh());
            row.add(thisinh.getNoisinh());
            row.add(thisinh.getCMND());
            row.add(thisinh.getNgaycap());
            row.add(thisinh.getNoicap());
            row.add(thisinh.getSDT());
            row.add(thisinh.getEmail());
            row.add(thisinh.getPhongthi());
            row.add(thisinh.getKhoathi());            
            model.addRow(row);
            }
        tblDSSV.setModel(model);
       
   }
   
   public static void main(String[] args){
       QuanLyThiSinh a = new QuanLyThiSinh();
       a.run();
   }
}
