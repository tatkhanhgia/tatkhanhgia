package BUS;

//Class xử lý luồng hoạt động

import DAO.KhoathiDAO;
import DAO.PhongthiDAO;
import DTO.KhoathiDTO;
import DTO.PhongthiDTO;
import java.util.ArrayList;

public class KhoathiBUS {
    private KhoathiDAO dao;
    public ArrayList<KhoathiDTO> array;
    
    public KhoathiBUS(){
        dao = new KhoathiDAO();
        this.array = dao.get_all();
        if(this.array.isEmpty())
        {
            System.out.println("Lỗi get dữ liệu thí sinh!");
        }
    }
    
    //Hàm insert
    public void insert(KhoathiDTO khoathi){        
        boolean result =  dao.insert(khoathi);
        if(result)
        {
            this.array.add(khoathi);
        }        
    }               
    
    //Hàm update
    public ArrayList update(KhoathiDTO khoathi){
        dao.update(khoathi);
        int location = this.location_of_khoathi(khoathi);
        if(location != -1)
        {
            this.array.set(location, khoathi);
        }
        return this.array;
    }
    
    //Hàm tìm vị trí trong mảng
    private int location_of_khoathi(KhoathiDTO khoathi){
        for(int i=0;i<this.array.size();i++)
        {
            KhoathiDTO temp = this.array.get(i);
            if(temp.getKhoathi().equals(khoathi.getKhoathi()))
                return i;
        }    
        return -1;
    }
    
    
    //Hàm get phòng theo khóa_gọi qua BUS phòng thi để get
    public ArrayList get_phongthi(String khoathi){
        PhongthiBUS phongthibus = new PhongthiBUS();
        return phongthibus.get_phongthi(khoathi);
    }
    
    //Hàm get trình độ
    //Truyền vào tham số phòng thi
    public String get_trinhdo(String phongthi)
    {
        PhongthiBUS phongthibus = new PhongthiBUS();
        return phongthibus.trinhdo(phongthi);
    }
    
    //Tìm kiếm khóa thi
    public ArrayList timkiem(String input){     
        ArrayList result = new ArrayList();
        for(int i=0; i<this.array.size();i++)
        {
            KhoathiDTO temp = this.array.get(i);
            if(temp.getKhoathi().equals(input))
                result.add(temp);
        }              
        return result;
    }

    //Hàm get mã khóa thi mới nhất để tạo mới
    public String get_makhoathi(){
        KhoathiDTO temp = this.array.get(this.array.size()-1);
        String khoathi  = temp.getKhoathi();
        String result   = khoathi.substring(4, khoathi.length());
        int    location = Integer.parseInt(result);
        location ++;
        String a = null;
        if(location<9)
        {
           a = "Khoa00"+location;
        }else if(location <99){
           a = "Khoa0"+location;
        }else if(location >=99){
           a = "Khoa"+location;
        }
        return a;
    }
    
    public static void main(String[] args)
    {
        KhoathiBUS a = new KhoathiBUS();
        String result = a.get_makhoathi();
        System.out.println("result:"+result);
    }
}

