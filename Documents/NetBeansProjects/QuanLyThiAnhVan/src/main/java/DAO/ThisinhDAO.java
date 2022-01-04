package DAO;

import DTO.ThisinhDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThisinhDAO {
    private ConnectDB db;
    private ArrayList<ThisinhDTO> array; //thay vì trả về BUS dạng array thì lưu
                                         //1 bản temp tại DAO
    
    
    public ThisinhDAO(){
        this.array = new ArrayList<ThisinhDTO>();
    }
    
    public ArrayList<ThisinhDTO> get_all(){
        try {
            db = new ConnectDB();
            ArrayList temp = db.loaddatafromtable("thisinh"); //Get về dạng array lồng array
            for(int i=0; i<temp.size(); i++){
                ArrayList thisinh_i = (ArrayList) temp.get(i);                
                ThisinhDTO thisinh = new ThisinhDTO();
                thisinh.setSBD(thisinh_i.get(0).toString());
                thisinh.setHo(thisinh_i.get(1).toString());
                thisinh.setTen(thisinh_i.get(2).toString());
                thisinh.setGioitinh(thisinh_i.get(3).toString());
                thisinh.setNgaysinh(thisinh_i.get(4).toString());
                thisinh.setNoisinh(thisinh_i.get(5).toString());
                thisinh.setCMND(thisinh_i.get(6).toString());
                thisinh.setNgaycap(thisinh_i.get(7).toString());
                thisinh.setNoicap(thisinh_i.get(8).toString());
                thisinh.setSDT(thisinh_i.get(9).toString());
                thisinh.setEmail(thisinh_i.get(10).toString());
                thisinh.setPhongthi(thisinh_i.get(11).toString());
                thisinh.setKhoathi(thisinh_i.get(12).toString());
                
                //Add vào array
                this.array.add(thisinh);
            }
        } catch (SQLException ex) {
            return null;            
        }        
        return this.array;
    }
    
    public boolean insert(ThisinhDTO thisinh){
        String stament = "'"+thisinh.getSBD()+"',N'"+thisinh.getHo()+"',N'"+ thisinh.getTen()+
                         "',"+thisinh.getGioitinh()+",'"+thisinh.getNgaysinh()+
                         "','"+thisinh.getNoisinh() +"','"+thisinh.getCMND()+
                         "','"+thisinh.getNgaycap() +"','"+thisinh.getNoicap()+
                         "','"+thisinh.getSDT()     +"','"+thisinh.getEmail()+
                         "','"+thisinh.getPhongthi()+"','"+thisinh.getKhoathi()+"'";
        try {
            db = new ConnectDB();
            db.Insert("thisinh", stament);
            return true;
        } catch (SQLException ex) {
            return false;
        }        
    }
    
    public int get_SDB(String trinhdo,String khoathi){
        try {
            String statement = "`SBD` LIKE '"+trinhdo+"%' and `khoathi`=\""+khoathi+"\"";
            db = new ConnectDB();
            int count = db.count_in_DB_with_condition("thisinh", statement);
            return count;
        } catch (SQLException ex) {
            return -1;            
        }
    }
    
    public String[] get_khoathi(){
        try {
            db = new ConnectDB();
            String query = "SELECT tenkhoa from khoathi where datediff(ngaythi,DATE(now()))>=0;";
            ArrayList<String> temp = db.write_statement_select(query);
            String[] result = temp.toArray(new String[temp.size()]);
            return result;
        } catch (SQLException ex) {
            return null;            
        }
    }
    
    public ArrayList get_phongthi_checkin_thisinh(String khoathi,String trinhdo){
        try {
            db = new ConnectDB();
            String query = ""
                    + "Select tenphong"
                    + " from phongthi, thisinh"
                    + " where tenphong = thisinh.phongthi and thisinh.khoathi=phongthi.khoathi"
                    + " and thisinh.khoathi = \""+khoathi+"\" and thisinh.SBD like \""+trinhdo+"%\""                    
                    + " group by phongthi.tenphong"
                    + " having count(*)<30;";
            //System.out.println("QUERY:"+query);
            ArrayList<String> temp = db.write_statement_select(query);
            return temp;
        } catch (SQLException ex) {
            return null;            
        }
    }
    
    public ArrayList get_phongthi_when_newest(String khoathi,String trinhdo){
        try {
            db = new ConnectDB();
            String query = ""
                    + "Select tenphong"
                    + " from phongthi"
                    + " where phongthi.khoathi = \""+khoathi+"\" and "
                    + "phongthi.tenphong like \""+trinhdo+"%\"";
            //System.out.println("QUERY:"+query);
            ArrayList<String> temp = db.write_statement_select(query);
            return temp;
        } catch (SQLException ex) {
            return null;            
        }
    }
    
    public void update(ThisinhDTO thisinh){
        try {
            String table = "thisinh";
            String condition = "SBD ='"+thisinh.getSBD()+"' and khoathi ='"+thisinh.getKhoathi()+"'";
            String update = "ho =N'"+thisinh.getHo()+"',";
            update += "ten =N'"+thisinh.getTen()+"',";
            update += "gioitinh ="+thisinh.getGioitinh()+",";
            update += "ngaysinh ='"+thisinh.getNgaysinh()+"',";
            update += "noisinh =N'"+thisinh.getNoisinh()+"',";
            update += "cmnd =N'"+thisinh.getCMND()+"',";
            update += "ngaycap ='"+thisinh.getNgaycap()+"',";
            update += "noicap =N'"+thisinh.getNoicap()+"',";
            update += "sdt =N'"+thisinh.getSDT()+"',";
            update += "email =N'"+thisinh.getEmail()+"' ";
            db = new ConnectDB();
            db.Update(table, update, condition);            
        } catch (SQLException ex) {
            Logger.getLogger(ThisinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(ThisinhDTO thisinh){
        try {
            db = new ConnectDB();
            String table = "thisinh";
            String condition = " SBD = '"+thisinh.getSBD()+"' and khoathi='"+thisinh.getKhoathi()+"'";
            db.Delete(table, condition);
                    } catch (SQLException ex) {
            Logger.getLogger(ThisinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        ThisinhDAO a  = new ThisinhDAO();
        System.out.println(a.get_SDB("B1","Khoa004"));
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
