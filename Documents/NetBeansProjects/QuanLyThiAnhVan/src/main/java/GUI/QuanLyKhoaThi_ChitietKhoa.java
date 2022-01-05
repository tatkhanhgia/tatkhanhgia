package GUI;

import BUS.KhoathiBUS;
import BUS.ThisinhBUS;
import DTO.KhoathiDTO;
import DTO.PhongthiDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class QuanLyKhoaThi_ChitietKhoa extends JFrame {

    Vector header;
    JTable tblDSSV;
    JScrollPane jScrollPane1;
    JTextField phongthi, ngaythi,timkiem3,trinhdo,soluong; 
    DefaultTableModel model;
    JButton timkiem4;
    KhoathiBUS bus ;
    ArrayList del = new ArrayList();
    private KhoathiDTO temp;
    int press = -1;
    public static int location;
    public QuanLyKhoaThi_ChitietKhoa(int location) {
        bus = new KhoathiBUS();
        QuanLyKhoaThi_ChitietKhoa.location = location;
        temp = bus.array.get(location);
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Chi tiết Khóa thi");
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
        label1.setText("Chi tiết khóa thi "+temp.getKhoathi());
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(50, 10, 400, 50);

//table
        model = new DefaultTableModel();
        header = new Vector();
        header.add("Phòng thi");
        header.add("Ngày thi");
        header.add("Trình độ");
        header.add("Số lượng thí sinh");
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
        timkiem.setText("Tìm Kiếm phòng thi");
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
        sbd.setText("Phòng thi:");
        sbd.setForeground(Color.BLACK);
        sbd.setFont(new Font("Arial", Font.BOLD, 17));
        sbd.setBounds(10, 20, 100, 30);
        
        JLabel ho = new JLabel();
        ho.setText("Ngày thi:");
        ho.setForeground(Color.BLACK);
        ho.setFont(new Font("Arial", Font.BOLD, 17));
        ho.setBounds(10, 80, 100, 30);
        
        JLabel trinhdo = new JLabel();
        trinhdo.setText("Trình độ:");
        trinhdo.setForeground(Color.BLACK);
        trinhdo.setFont(new Font("Arial", Font.BOLD, 17));
        trinhdo.setBounds(210, 20, 100, 30);
        
        JLabel soluong = new JLabel();
        soluong.setText("Số lượng:");
        soluong.setForeground(Color.BLACK);
        soluong.setFont(new Font("Arial", Font.BOLD, 17));
        soluong.setBounds(210, 80, 100, 30);
        //textfield
        this.phongthi = new JTextField();
        this.phongthi.setText(null);
        this.phongthi.setBounds(90, 22, 120, 20);
        this.phongthi.setBackground(Color.white);

        ngaythi = new JTextField();
        ngaythi.setText(null);
        ngaythi.setBounds(90, 82, 120, 20);
        ngaythi.setBackground(Color.white);

        this.trinhdo = new JTextField();
        this.trinhdo.setText(null);
        this.trinhdo.setBounds(290, 23, 50, 20);
        this.trinhdo.setBackground(Color.white);
        
        this.soluong = new JTextField();
        this.soluong.setText(null);
        this.soluong.setBounds(290, 83, 50, 20);
        this.soluong.setBackground(Color.white);
        //khung phải nut(250-490)
        JButton them = new JButton("Thêm");
        them.setBounds(350, 20, 100, 20);
        
        
        JButton quaylai = new JButton("Quay lại");
        quaylai.setBounds(350, 60, 100, 20);
        
//        JButton taidl = new JButton("Tải dữ liệu");
//        taidl.setBounds(350, 60, 100, 20);

        JButton chitiet = new JButton("Chi tiết");
        chitiet.setBounds(350, 100, 100, 20);
//CHỨC NĂNG
        timkiem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
        }});
        tblDSSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {             
                click();
        }});

        
        them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                them();
            }
        });
        
        quaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
        
        chitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitietphongthi();
            }
        });
        
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
        panel3.add(trinhdo);
        panel3.add(soluong);
        
        panel3.add(this.phongthi);
        panel3.add(ngaythi);
        panel3.add(this.trinhdo);
        panel3.add(this.soluong);
        panel3.add(them);
        //panel3.add(sua);
        panel3.add(quaylai);
        //panel3.add(taidl);
        panel3.add(chitiet);

        //frame add
        add(panel1);
        add(panel2);
        add(panel3);
        ArrayList phongthii =bus.get_phongthi(temp.khoathi);
        
        this.load_data_to_jtable(phongthii);
    }

    public void run() {
        //pack();
        setVisible(true);
    }
   
    public void them(){        
        QuanLyPhongThi_ThemPhong a = new QuanLyPhongThi_ThemPhong(temp.getKhoathi());  
        a.setVisible(true);
        this.dispose();
    }
    
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
       ThisinhBUS thisinhbus = new ThisinhBUS();
       for(int i=0;i<data.size();i++){
            Vector row = new Vector();
            PhongthiDTO phongthi=(PhongthiDTO)data.get(i);
            row.add(phongthi.getPhongthi());
            row.add(temp.getNgaythi());     
            row.add(bus.get_trinhdo(phongthi.getPhongthi()));
            row.add(thisinhbus.count_thisinh_in_phongthi(phongthi.getPhongthi(), temp.getKhoathi()));
            model.addRow(row);
            }
        tblDSSV.setModel(model);       
   }

    
    public void quaylai(){
        this.dispose();
    }
    
    public void click(){
        int i = tblDSSV.getSelectedRow();    
        if(press == -1){
            ArrayList phongthii = bus.get_phongthi(temp.getKhoathi());
            PhongthiDTO phongthi     = (PhongthiDTO)phongthii.get(i);
            this.phongthi.setText(phongthi.getPhongthi());
            this.ngaythi.setText(temp.getNgaythi());
            this.trinhdo.setText(bus.get_trinhdo(phongthi.getPhongthi()));
            ThisinhBUS thisinhbus = new ThisinhBUS();
            this.soluong.setText(String.valueOf(thisinhbus.count_thisinh_in_phongthi(phongthi.getPhongthi(), temp.getKhoathi())));
            press = i;
        }
        else
        {
            this.phongthi.setText("");
            this.ngaythi.setText("");
            this.trinhdo.setText("");
            this.soluong.setText("");
            press = -1;
        }
        
    }
   
    public void chitietphongthi(){
        int i = tblDSSV.getSelectedRow();    
        if(i!=-1){
            PhongthiDTO temp = new PhongthiDTO();
            temp.setKhoathi(this.temp.getKhoathi());
            temp.setPhongthi(this.phongthi.getText());
            System.out.println("Khoa:"+temp.getKhoathi());
            System.out.println("Phong:"+temp.getPhongthi());
            QuanLyPhongThi_ChitietPhong a = new QuanLyPhongThi_ChitietPhong(temp);
            a.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng để xem chi tiết","Cảnh báo",JOptionPane.CANCEL_OPTION);
        }
    }
    
    public static void main(String[] args)
    {
        QuanLyKhoaThi_ChitietKhoa a = new QuanLyKhoaThi_ChitietKhoa(1);
        a.setVisible(true);
    }
}
