package DAO;

import DTO.PhongthiDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhongthiDAO {
    private ConnectDB db;
    private ArrayList<PhongthiDTO> array; //thay vì trả về BUS dạng array thì lưu
                                         //1 bản temp tại DAO
    
    public PhongthiDAO(){
        this.array = new ArrayList<PhongthiDTO>();
    }
    
    public ArrayList<PhongthiDTO> get_all(){
        try {
            db = new ConnectDB();
            ArrayList temp = db.loaddatafromtable("phongthi"); 
            for(int i=0; i<temp.size(); i++){
                ArrayList phongthi_i = (ArrayList) temp.get(i);                
                PhongthiDTO phongthi = new PhongthiDTO();
                phongthi.setPhongthi(phongthi_i.get(0).toString());
                phongthi.setKhoathi(phongthi_i.get(1).toString());
                
                //Add vào array
                this.array.add(phongthi);
            }
        } catch (SQLException ex) {
            return null;            
        }        
        return this.array;
    }
    
    public boolean insert(PhongthiDTO phongthi){
        String stament = "'"+phongthi.getPhongthi()+"','"+phongthi.getKhoathi()+"'";
        try {
            db = new ConnectDB();
            db.Insert("phongthi", stament);
            return true;
        } catch (SQLException ex) {
            return false;
        }        
    }
    
    public static void main(String[] args){
        PhongthiDAO a  = new PhongthiDAO();
        a.get_all();
        for(int i=0 ; i<a.array.size(); i++){
            System.out.println("khoathi : "+a.array.get(i).getKhoathi());
            System.out.println("phongthi : "+a.array.get(i).getPhongthi());
        }

    }
}
