package DAO;

import DTO.KhoathiDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhoathiDAO {
    private ConnectDB db;
    private ArrayList<KhoathiDTO> array; //thay vì trả về BUS dạng array thì lưu
                                         //1 bản temp tại DAO
    
    public KhoathiDAO(){
        this.array = new ArrayList<KhoathiDTO>();
    }
    
    public ArrayList<KhoathiDTO> get_all(){
        try {
            db = new ConnectDB();
            ArrayList temp = db.loaddatafromtable("khoathi"); //Get về dạng array lồng array
            for(int i=0; i<temp.size(); i++){
                ArrayList khoathi_i = (ArrayList) temp.get(i);                
                KhoathiDTO khoathi = new KhoathiDTO();
                khoathi.setKhoathi(khoathi_i.get(0).toString());
                khoathi.setNgaythi(khoathi_i.get(1).toString());
                
                //Add vào array
                this.array.add(khoathi);
            }
        } catch (SQLException ex) {
            return null;            
        }        
        return this.array;
    }
    
    public boolean insert(KhoathiDTO khoathi){
        String stament = "'"+khoathi.getKhoathi()+"','"+khoathi.getNgaythi()+"'";
        try {
            db = new ConnectDB();
            db.Insert("khoathi", stament);
            return true;
        } catch (SQLException ex) {
            return false;
        }        
    }
    
    public void update(KhoathiDTO khoathi){
        try {
            String table = "khoathi";
            String condition = "tenkhoa ='"+khoathi.getKhoathi()+"'";
            String update = "ngaythi = '"+khoathi.getNgaythi()+"'";
            db = new ConnectDB();
            db.Update(table, update, condition);            
        } catch (SQLException ex) {
            Logger.getLogger(ThisinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        KhoathiDAO a  = new KhoathiDAO();
        a.get_all();
        for(int i=0 ; i<a.array.size(); i++){
            System.out.println("khoathi : "+a.array.get(i).getKhoathi());
            System.out.println("ngaythi : "+a.array.get(i).getNgaythi());
        }
//        ThisinhDTO temp = new ThisinhDTO("B1003","Nguyễn Minh","Hiếu","1","2001-08-09","TPHCM","0987654321","2018-07-08","TPHCM","0123456789","asdxcv@gmail.com","B1P03","Khoa001");
//        a.insert(temp);
//        a.get_all();
//        for(int i=0 ; i<a.array.size(); i++){
//            System.out.println("sbd : "+a.array.get(i).getSBD());
//        }
//            ArrayList temp = a.get_phongthi_checkin_thisinh("Khoa001","A2");
//            for(int i=0 ; i<temp.size(); i++){
//            System.out.println("phongf thi:"+temp.get(i));
//        }
    }
}
