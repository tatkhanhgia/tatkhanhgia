package DAO;

import DTO.DiemthiDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiemthiDAO {
    private ConnectDB db;
    private ArrayList<DiemthiDTO> array; //thay vì trả về BUS dạng array thì lưu
                                         //1 bản temp tại DAO
    
    public DiemthiDAO(){
        this.array = new ArrayList<DiemthiDTO>();
    }
    
    public ArrayList<DiemthiDTO> get_all(){
        try {
            db = new ConnectDB();
            ArrayList temp = db.loaddatafromtable("diemthi"); //Get về dạng array lồng array
            for(int i=0; i<temp.size(); i++){
                ArrayList diemthi_i = (ArrayList) temp.get(i);                
                DiemthiDTO diemthi = new DiemthiDTO();
                diemthi.setSBD(diemthi_i.get(0).toString());
                diemthi.setKhoathi(diemthi_i.get(1).toString());
                diemthi.setNghe(Float.parseFloat(diemthi_i.get(2).toString()));
                diemthi.setNoi(Float.parseFloat(diemthi_i.get(3).toString()));
                diemthi.setDoc(Float.parseFloat(diemthi_i.get(4).toString()));
                diemthi.setViet(Float.parseFloat(diemthi_i.get(5).toString()));
                
                //Add vào array
                this.array.add(diemthi);
            }
        } catch (SQLException ex) {
            return null;            
        }        
        return this.array;
    }
    
    public boolean insert(DiemthiDTO khoathi){
        String stament = "'"+khoathi.getSBD()+"','"+khoathi.getKhoathi()+"',"+khoathi.getNghe()+","+khoathi.getNoi()+","+khoathi.getDoc()+","+khoathi.getViet();
        try {
            db = new ConnectDB();
            db.Insert("diemthi", stament);
            return true;
        } catch (SQLException ex) {
            return false;
        }        
    }
    
    public void update(DiemthiDTO khoathi){
        try {
            String table = "diemthi";
            String condition = "SBD ='"+khoathi.getSBD()+"' and khoathi = '"+khoathi.getKhoathi()+"'";
            String update = "nghe ="+khoathi.getNghe()+" , noi ="+khoathi.getNoi()+" , doc = "+khoathi.getDoc()+" , viet="+khoathi.getViet()+"";
            db = new ConnectDB();
            db.Update(table, update, condition);            
        } catch (SQLException ex) {
            Logger.getLogger(ThisinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        DiemthiDAO a = new DiemthiDAO();
        a.get_all();
        for(int i=0 ; i <a.array.size();i++)
        {
            System.out.println(a.array.get(i).getSBD());
            System.out.println(a.array.get(i).getKhoathi());
            System.out.println(a.array.get(i).getNghe());
            System.out.println(a.array.get(i).getNoi());
            System.out.println(a.array.get(i).getDoc());
            System.out.println(a.array.get(i).getViet());
        }
                    
    }
}
