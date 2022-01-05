package GUI;

import BUS.DiemthiBUS;
import BUS.KhoathiBUS;
import BUS.PhongthiBUS;
import BUS.ThisinhBUS;
import DTO.DiemthiDTO;
import DTO.KhoathiDTO;
import DTO.PhongthiDTO;
import DTO.ThisinhDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class QuanLyDiemThi_Frame_Nhapdiem extends JFrame {

    DefaultTableModel model;
    JTextField  nghe,noi,SBD, doc,viet;
    JComboBox trinhdo; 
    ThisinhBUS thisinhbus;
    DiemthiBUS diemthibus;
    ArrayList<ThisinhDTO> thisinh_nhaplieu;    
    int location;
    ThisinhDTO thisinh_vitri;
    
    public QuanLyDiemThi_Frame_Nhapdiem(ArrayList<ThisinhDTO> thisinh_nhaplieu) {        
        this.thisinh_nhaplieu = thisinh_nhaplieu;
        thisinh_vitri = this.thisinh_nhaplieu.get(0);
        this.location = 0;
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border matte = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        TitledBorder title;
        title = BorderFactory.createTitledBorder(blackline, "KHUNG CHỨC NĂNG");
        title.setTitleJustification(TitledBorder.CENTER);
//frame
        setTitle("Nhập điểm");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());

//vùng làm việc:3- đầu-nút-danh sách
        JPanel panel1 = new JPanel();       
        JPanel panel3l = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel3l.setBackground(Color.lightGray);
        panel1.setPreferredSize(new Dimension(500, 80));
        panel3l.setPreferredSize(new Dimension(500,320));
        //setLayout
        panel1.setLayout(null);
        panel3l.setLayout(null);
        panel3l.setBorder(matte);

//Label head
        //label danh sách Sach
        JLabel label1 = new JLabel();
        label1.setText("Nhập điểm thí sinh");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(35, 8, 400, 50);



// khung chứa nhập dl- nút
        //khung trái chứa nhập dl(5-250)
        JLabel sbd = new JLabel();
        sbd.setText("SBD:");       
        sbd.setForeground(Color.BLACK);
        sbd.setFont(new Font("Arial", Font.BOLD, 17));
        sbd.setBounds(10, 10, 100, 30);
        
        JLabel nghelb = new JLabel();
        nghelb.setText("Điểm nghe:");
        nghelb.setForeground(Color.BLACK);
        nghelb.setFont(new Font("Arial", Font.BOLD, 17));
        nghelb.setBounds(10, 60, 100, 30);
              
        JLabel noilb = new JLabel();
        noilb.setText("Điểm nói:");
        noilb.setForeground(Color.BLACK);
        noilb.setFont(new Font("Arial", Font.BOLD, 17));
        noilb.setBounds(10, 110, 100, 30);
        
        JLabel doclb = new JLabel();
        doclb.setText("Điểm đọc:");
        doclb.setForeground(Color.BLACK);
        doclb.setFont(new Font("Arial", Font.BOLD, 17));
        doclb.setBounds(10, 160, 100, 30);
        
        JLabel vietlb = new JLabel();
        vietlb.setText("Điểm viết:");
        vietlb.setForeground(Color.BLACK);
        vietlb.setFont(new Font("Arial", Font.BOLD, 17));
        vietlb.setBounds(10, 210, 100, 30);

        SBD = new JTextField();        
        SBD.setText(thisinh_vitri.getSBD());        
        SBD.setBounds(95, 10, 120, 20);
        SBD.setBackground(Color.white);
        SBD.setEditable(false);
        
        this.nghe = new JTextField();
        this.nghe.setText(null);
        this.nghe.setBounds(95, 65, 120, 20);
        this.nghe.setBackground(Color.white);

        this.noi = new JTextField();
        this.noi.setText(null);
        this.noi.setBounds(95, 110, 120, 20);
        this.noi.setBackground(Color.white);
        
        
        this.doc = new JTextField();
        this.doc.setText(null);
        this.doc.setBounds(95, 160, 120, 20);
        this.doc.setBackground(Color.white);
        
        
        this.viet = new JTextField();
        this.viet.setText(null);
        this.viet.setBounds(95, 210, 120, 20);
        this.viet.setBackground(Color.white);
        

        //khung phải nut(250-490)
        JButton them = new JButton("Thêm");
        them.setBounds(300, 150, 100, 30);
/*        JButton sapxep = new JButton("Sắp Xếp");
        sapxep.setPreferredSize(new Dimension(180, 40)); */
        JButton thoat = new JButton("Quay Lại");
        thoat.setBounds(300, 200, 100, 30);


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

        this.nghe.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    noi.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    noi.requestFocus();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        this.noi.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    doc.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    doc.requestFocus();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        this.doc.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    viet.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    viet.requestFocus();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        this.viet.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    them();
                    nghe.setText(null);
                    noi.setText(null);
                    doc.setText(null);
                    viet.setText(null);
                    nghe.requestFocus();
                }
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    them();
                    nghe.setText(null);
                    noi.setText(null);
                    doc.setText(null);
                    viet.setText(null);
                    nghe.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
       
//ADD frame
        //panel 1 add
        panel1.add(label1);
        

        //panel 3 add
        

        panel3l.add(them);       
        panel3l.add(thoat);
        
        panel3l.add(sbd);
        panel3l.add(nghelb);
        panel3l.add(noilb);
        panel3l.add(doclb);
        panel3l.add(vietlb);
        
        panel3l.add(SBD);          
        panel3l.add(this.nghe);
        panel3l.add(this.noi);
        panel3l.add(this.doc);
        panel3l.add(this.viet);
        


        //frame add
        add(panel1);
        add(panel3l);                
    }

    public void run() {
        //pack();
        setVisible(true);
    }
   
    public void them(){        
        DiemthiDTO temp = new DiemthiDTO();
        temp.setSBD(this.SBD.getText());
        temp.setKhoathi(this.thisinh_vitri.getKhoathi());
        temp.setNghe(Float.parseFloat(this.nghe.getText()));
        temp.setNoi(Float.parseFloat(this.noi.getText()));
        temp.setDoc(Float.parseFloat(this.doc.getText()));
        temp.setViet(Float.parseFloat(this.viet.getText()));
        
        diemthibus = new DiemthiBUS();
        diemthibus.insert(temp);
        if(location<thisinh_nhaplieu.size()-1)
        {
            location++;
            thisinh_vitri = thisinh_nhaplieu.get(location);
            SBD.setText(thisinh_vitri.getSBD());
        }
        else
            this.dispose();
    }
    
    
  
    
    public void quaylai(){
        this.dispose();
    }
    
    public static void main(String[] args)
    {
//        QuanLyDiemThi_Frame_Nhapdiem a = new QuanLyDiemThi_Frame_Nhapdiem();
//        a.setVisible(true);
    }
}
