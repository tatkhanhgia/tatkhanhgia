package GUI;

import BUS.DiemthiBUS;
import BUS.ThisinhBUS;
import DTO.DiemthiDTO;
import DTO.PhongthiDTO;
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

public class QuanLyDiemThi extends JFrame{
    DefaultTableModel model;
    JTable tblDSSV;
    JScrollPane jScrollPane1;
    JTextField sobaodanh, khoathitxt, nghe,noi,doc,timkiem3,
            viet;
    int press = -1;
    
    Vector header;
    DiemthiBUS bus;
    DiemthiDTO diemthi;
    
   public QuanLyDiemThi(String SBD,String khoathi) {    
        diemthi = new DiemthiDTO();
        diemthi.setSBD(SBD);
        diemthi.setKhoathi(khoathi);
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Danh Sách Điểm");
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
        label1.setText("Điểm thí sinh SBD "+diemthi.getSBD());
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(150, 10, 500, 50);

//table
        model = new DefaultTableModel();
        header = new Vector();
        header.add("SBD");
        header.add("Khóa");
        header.add("Nghe");
        header.add("Nói");
        header.add("Đọc");
        header.add("Viết");        
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
        jScrollPane1.setPreferredSize(new Dimension(770, 200));

//chuc nang tim kiem
        //jlabel tim kiem
//        JLabel timkiem = new JLabel();
//        timkiem.setText("Tìm Kiếm");
//        timkiem.setForeground(Color.black);
//        timkiem.setFont(new Font("Arial", Font.BOLD, 20));
//        timkiem.setBounds(150, 75, 110, 25);
//
//        //TEXTFIELD timkiem
//        timkiem3 = new JTextField();
//        timkiem3.setBounds(350, 75, 250, 26);
//
//        //COMBOBOX tim kiem
//        String[] a = {"    SBD", "     Tên","     CMND", "    Phòng Thi","     Khóa Thi"};
//        timkiem2 = new JComboBox(a);
//        timkiem2.setSelectedIndex(0);
//        timkiem2.setBounds(250, 75, 80, 25);
//
//
//
//        //button tìm kiếm
//        timkiem4 = new JButton();
//        timkiem4.setText("Tìm");
//        timkiem4.setForeground(Color.black);
//        timkiem4.setFont(new Font("Arial", Font.BOLD, 15));
//        timkiem4.setBounds(630, 75, 80, 25);
// khung chứa nhập dl- nút
        //khung trái chứa nhập dl(5-250)
        JLabel sbd = new JLabel();
        sbd.setText("SBD:");
        sbd.setForeground(Color.BLACK);
        sbd.setFont(new Font("Arial", Font.BOLD, 17));
        sbd.setBounds(10, 10, 100, 30);
        
        JLabel ho = new JLabel();
        ho.setText("Khóa thi:");
        ho.setForeground(Color.BLACK);
        ho.setFont(new Font("Arial", Font.BOLD, 17));
        ho.setBounds(10, 60, 100, 30);
        
        JLabel ten = new JLabel();
        ten.setText("Điểm nghe:");
        ten.setForeground(Color.BLACK);
        ten.setFont(new Font("Arial", Font.BOLD, 17));
        ten.setBounds(10, 110, 100, 30);
        
        JLabel ngaysinh = new JLabel();
        ngaysinh.setText("Điểm nói:");
        ngaysinh.setForeground(Color.BLACK);
        ngaysinh.setFont(new Font("Arial", Font.BOLD, 17));
        ngaysinh.setBounds(10, 160, 100, 30);
        
        JLabel noisinh = new JLabel();
        noisinh.setText("Điểm đọc:");
        noisinh.setForeground(Color.BLACK);
        noisinh.setFont(new Font("Arail", Font.BOLD, 17));
        noisinh.setBounds(10, 210, 100, 30);
        
        JLabel cmnd = new JLabel();
        cmnd.setText("Điểm viết:");
        cmnd.setForeground(Color.BLACK);
        cmnd.setFont(new Font("Arail", Font.BOLD, 17));
        cmnd.setBounds(300, 10, 100, 30);
        

        //textfield
        sobaodanh = new JTextField();
        sobaodanh.setText(null);
        sobaodanh.setBounds(90, 15, 120, 20);
        sobaodanh.setBackground(Color.white);

        this.khoathitxt = new JTextField();
        this.khoathitxt.setText(null);
        this.khoathitxt.setBounds(90, 65, 120, 20);
        this.khoathitxt.setBackground(Color.white);

        nghe = new JTextField();
        nghe.setText(null);
        nghe.setBounds(90, 115, 120, 20);
        nghe.setBackground(Color.white);
        
        this.noi = new JTextField();
        this.noi.setText(null);
        this.noi.setBackground(Color.white);
        //this.noi.setFont(new Font("Arial", Font.BOLD, 17));
        this.noi.setBounds(90, 160, 120, 20);
        
        this.doc = new JTextField();
        this.doc.setText(null);
        this.doc.setBackground(Color.white);
        //this.doc.setFont(new Font("Arail", Font.BOLD, 17));
        this.doc.setBounds(90, 210, 120, 20);
        
        this.viet = new JTextField();
        this.viet.setText(null);
        this.viet.setBackground(Color.white);
        //this.viet.setFont(new Font("Arail", Font.BOLD, 17));
        this.viet.setBounds(390, 20, 120, 20);
        
        
        //khung phải nut(250-490)
        JButton them = new JButton("Thêm");
        them.setBounds(600, 10, 150, 35);
        
        JButton sua = new JButton("Sửa");
        sua.setBounds(600, 50, 150, 35);
        
        JButton xoa = new JButton("Xóa");
        xoa.setBounds(600, 100, 150, 35);
        
        JButton sapxep = new JButton("Sắp Xếp");
        sapxep.setBounds(600, 150, 150, 35);
        
        JButton thoat = new JButton("Quay lại");
        thoat.setBounds(600, 10, 150, 35);
        
        JButton taidl = new JButton("Tải dữ liệu");
        taidl.setBounds(600, 250, 150, 35);


//CHỨC NĂNG

        tblDSSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               int i = tblDSSV.getSelectedRow();
               if (i == press)
               {                
                sobaodanh.setText("");
                khoathitxt.setText("");
                nghe.setText("");                
                noi.setText("");
                doc.setText("");
                viet.setText("");     
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

        //panel 2 add
        panel2.add(jScrollPane1);

        //panel 3 add
        panel3.add(sbd);
        panel3.add(ho);
        panel3.add(ten);        
        panel3.add(cmnd);        
        panel3.add(ngaysinh);
        panel3.add(noisinh);        
        
        panel3.add(sobaodanh);
        panel3.add(this.khoathitxt);
        panel3.add(nghe);
        panel3.add(this.noi);
        panel3.add(this.doc);
        panel3.add(this.viet);

//        panel3.add(them);
        panel3.add(sua);
//        panel3.add(xoa);        
        panel3.add(thoat);
//        panel3.add(taidl);
                

        //frame add
        add(panel1);
        add(panel2);
        add(panel3);
        //Auto load dữ liệu vào trước
        bus = new DiemthiBUS();
        ArrayList result = bus.get_diemthi_SBD_Khoathi(SBD, khoathi);
        this.load_data_to_jtable(result);
    }
   
   public void run(){
       this.setVisible(true);
   }
   
   //Hàm để tải dữ liệu lên table_ có thể thay thế bằng việc tải lên sẵn
   public void taidulieu(){
        
   }
   
   //Hàm sửa thông tin thí sinh
   public void sua(){
       if(tblDSSV.getSelectedColumn()<0)
       {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin thay đổi","Cảnh báo",JOptionPane.CANCEL_OPTION);
           return;
       }
        DiemthiDTO diemthi = new DiemthiDTO();
        diemthi.setSBD(this.sobaodanh.getText());
        diemthi.setKhoathi(this.khoathitxt.getText());
        diemthi.setNghe(Float.parseFloat(this.nghe.getText()));
        diemthi.setNoi(Float.parseFloat(this.noi.getText()));
        diemthi.setDoc(Float.parseFloat(this.doc.getText()));
        diemthi.setViet(Float.parseFloat(this.viet.getText()));
              
        
        bus.update(diemthi);
        ArrayList result = bus.get_diemthi_SBD_Khoathi(diemthi.getSBD(), diemthi.getKhoathi());
        this.load_data_to_jtable(result);
        
   }
   
   //Hàm thêm thí sinh
   public void them(){
      QuanLyThiSinh_ThemThiSinh insert = new QuanLyThiSinh_ThemThiSinh();
      insert.setVisible(true);
      
   }
   
   //Hàm để set hành động click và jtable_chi tiết thí sinh
   public void click(int i){
       DiemthiDTO temp = bus.array.get(i);
       this.sobaodanh.setText(temp.getSBD());
       this.sobaodanh.setEditable(false);
       this.khoathitxt.setText(temp.getKhoathi());
       this.nghe.setText(String.valueOf(temp.getNghe()));
       this.noi.setText(String.valueOf(temp.getNoi()));
       this.doc.setText(String.valueOf(temp.getDoc()));
       this.viet.setText(String.valueOf(temp.getViet()));            
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
            DiemthiDTO thisinh=(DiemthiDTO)data.get(i);
            row.add(thisinh.getSBD());
            row.add(thisinh.getKhoathi());            
            row.add(thisinh.getNghe());
            row.add(thisinh.getNoi());
            row.add(thisinh.getDoc());
            row.add(thisinh.getViet());
            model.addRow(row);
            }
        tblDSSV.setModel(model);
       
   }
   
   public static void main(String[] args){       
       QuanLyDiemThi a = new QuanLyDiemThi("A2001","Khoa001");
       a.run();
   }
}
