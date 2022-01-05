package BUS;

//Class xử lý luồng hoạt động

import DAO.KhoathiDAO;
import DAO.PhongthiDAO;
import DTO.KhoathiDTO;
import DTO.PhongthiDTO;
import java.util.ArrayList;

public class PhongthiBUS {
    private PhongthiDAO dao;
    public ArrayList<PhongthiDTO> array;
    
    public PhongthiBUS(){
        dao = new PhongthiDAO();
        this.array = dao.get_all();
        if(this.array.isEmpty())
        {
            System.out.println("Lỗi get dữ liệu thí sinh!");
        }
    }
    
    //Hàm insert
    public void insert(PhongthiDTO phongthi){        
        boolean result =  dao.insert(phongthi);
        if(result)
        {
            this.array.add(phongthi);
        }        
    }               
    
    //hàm nội tại get phòng thi all
    private ArrayList get_phongthi_all(){
        PhongthiDAO dao = new PhongthiDAO();
        ArrayList phongthi = dao.get_all();
        return phongthi;
    }
    
    //Hàm get phòng theo khóa
    public ArrayList get_phongthi(String khoathi){
        ArrayList phongthi = this.get_phongthi_all();
        ArrayList result   = new ArrayList();
        for(int i=0; i<phongthi.size(); i++){
            PhongthiDTO temp = (PhongthiDTO) phongthi.get(i);
            if(temp.getKhoathi().equals(khoathi))
                result.add(temp);
        }
        return result;
    }
    
    //Tìm kiếm phòng thi
    public ArrayList timkiem(String input){     
        ArrayList result = new ArrayList();
        for(int i=0; i<this.array.size();i++)
        {
            PhongthiDTO temp = this.array.get(i);
            if(temp.getPhongthi().equals(input))
                result.add(temp);
        }              
        return result;
    }
    
    //hàm check trình độ
    //Truyền vào tham số phòng thi
    public String trinhdo(String phongthi){
        String temp = phongthi.substring(0, 2);
        return temp;
    }
    
    //Hàm get mã phòng mới nhất để tạo phòng
    //Truyền vào tham số trình độ
    public String get_maphongthi_newest(String trinhdo,String khoathi){
        int maphongthi = 0;
        for(int i=0; i<this.array.size();i++)
        {
            PhongthiDTO temp = this.array.get(i);
            String sub = temp.getPhongthi().substring(0, 2);            
            if(temp.getKhoathi().equals(khoathi))
            {                
                maphongthi++;
            }                    
        }        
        String maphong = null;
        if(maphongthi<9){
            maphongthi ++;
            maphong = trinhdo + "P0"+maphongthi;
        }
        if(maphongthi>9 && maphongthi<99){
            maphongthi ++;
            maphong = trinhdo + "P"+maphongthi;
        }
        return maphong;
    }
}

