package BUS;

//Class xử lý luồng hoạt động

import DAO.ThisinhDAO;
import DTO.ThisinhDTO;
import java.util.ArrayList;

public class ThisinhBUS {
    private ThisinhDAO dao;
    public ArrayList<ThisinhDTO> array;
    
    public ThisinhBUS(){
        dao = new ThisinhDAO();
        this.array = dao.get_all();
        if(this.array.isEmpty())
        {
            System.out.println("Lỗi get dữ liệu thí sinh!");
        }
    }
    
    public boolean insert(ThisinhDTO thisinh){
        return dao.insert(thisinh);
    }
    
    public String get_phongthi(String khoathi,String trinhdo){
        ArrayList temp = dao.get_phongthi_checkin_thisinh(khoathi, trinhdo);        
        if(temp.isEmpty())
            temp = dao.get_phongthi_when_newest(khoathi, trinhdo);
        return String.valueOf(temp.get(0));
    }
    
    public void insert_without_SBD(ThisinhDTO thisinh,String trinhdo,String khoathi){
        int count = dao.get_SDB(trinhdo, khoathi);
        if(trinhdo.equals("A2"))
            if(count<10) thisinh.setSBD("A200"+count+1);
            if(count<100)thisinh.setSBD("A20" +count+1);
        else
            if(count<10) thisinh.setSBD("B100"+count+1);
            if(count<100)thisinh.setSBD("B10" +count+1);
        boolean a = this.insert(thisinh);
    }
    
    public String[] getkhoathi(){
        return dao.get_khoathi();
    }
}
