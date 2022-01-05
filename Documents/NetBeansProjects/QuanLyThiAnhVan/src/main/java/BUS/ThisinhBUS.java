package BUS;

//Class xử lý luồng hoạt động

import DAO.ThisinhDAO;
import DTO.ThisinhDTO;
import java.util.ArrayList;

public class ThisinhBUS {
    private ThisinhDAO dao;
    public ArrayList<ThisinhDTO> array;
    
    //Constructor get toàn bộ dữ liệu thí sinh
    public ThisinhBUS(){
        dao = new ThisinhDAO();
        this.array = dao.get_all();
        if(this.array.isEmpty())
        {
            System.out.println("Lỗi get dữ liệu thí sinh!");
        }
    }
    
    //Hàm để get danh sách thí sinh theo phòng thi_ khóa thi truyền vào
    public ArrayList get_thisinh_theo_phongthi(String phongthi, String khoathi){
        ArrayList result = new ArrayList();
        for(int i=0; i<this.array.size(); i++)
        {
            ThisinhDTO temp = this.array.get(i);
            if(temp.getPhongthi().equals(phongthi) && temp.getKhoathi().equals(khoathi))
                result.add(temp);
        }
        return result;
    }
    
    private void insert(ThisinhDTO thisinh){        
        boolean result =  dao.insert(thisinh);
        if(result)
        {
            this.array.add(thisinh);
        }        
    }
    
    public String get_phongthi(String khoathi,String trinhdo){
        ArrayList temp = dao.get_phongthi_checkin_thisinh(khoathi, trinhdo);        
        if(temp.isEmpty())
            temp = dao.get_phongthi_when_newest(khoathi, trinhdo);
        return String.valueOf(temp.get(0));
    }
    
    public ArrayList insert_without_SBD(ThisinhDTO thisinh,String trinhdo,String khoathi){
        int count = dao.get_SDB(trinhdo, khoathi);
        System.out.println("Thứ tự:"+count);
        System.out.println("Trình độ:"+trinhdo);
        if(trinhdo.equals("A2")){
            if(count<10) thisinh.setSBD("A200"+(count+1));
            else if(count<99)thisinh.setSBD("A20" +(count+1));
            else if(count>=99)thisinh.setSBD("A2" +(count+1));
        }
        else{
            if(count<10) thisinh.setSBD("B100"+(count+1));
            else if(count<99)thisinh.setSBD("B10" +(count+1));
            else if(count>=99)thisinh.setSBD("B1" +(count+1));
        }
        this.insert(thisinh);
        return this.array;
    }
    
    public String[] getkhoathi(){
        return dao.get_khoathi();
    }
    
    public ArrayList update(ThisinhDTO thisinh){
        dao.update(thisinh);
        int location = this.location_of_thisinh(thisinh);
        if(location != -1)
        {
            this.array.set(location, thisinh);
        }
        return this.array;
    }
    
    private int location_of_thisinh(ThisinhDTO thisinh){
        for(int i=0;i<this.array.size();i++)
        {
            ThisinhDTO temp = this.array.get(i);
            if(temp.getSBD().equals(thisinh.getSBD())&&temp.getKhoathi().equals(thisinh.getKhoathi()))
                return i;
        }    
        return -1;
    }
    
    public ArrayList timkiem(int loai,String input){        
        ArrayList<ThisinhDTO> result = new ArrayList();
        switch(loai){
           case 0://SBD
           {
               for(int i=0; i<this.array.size();i++){
                   ThisinhDTO temp = this.array.get(i);
                   if(temp.getSBD().equals(input))
                       result.add(temp);
               }
               break;
           }
           case 1://TEN
           {
               for(int i=0; i<this.array.size();i++){
                   ThisinhDTO temp = this.array.get(i);
                   if(temp.getTen().equalsIgnoreCase(input))
                       result.add(temp);
               }
               break;
           }
           case 2://CMND
           {
               for(int i=0; i<this.array.size();i++){
                   ThisinhDTO temp = this.array.get(i);
                   if(temp.getCMND().equals(input))
                       result.add(temp);
               }
               break;
           }
           case 3://phongthi
           {
               for(int i=0; i<this.array.size();i++){
                   ThisinhDTO temp = this.array.get(i);
                   if(temp.getPhongthi().equals(input))
                       result.add(temp);
               }
               break;
           }
           case 4://khoathi
           {
               for(int i=0; i<this.array.size();i++){
                   ThisinhDTO temp = this.array.get(i);
                   if(temp.getKhoathi().equals(input))
                       result.add(temp);
               }
               break;
           }
           case 5://sdt
           {
               for(int i=0; i<this.array.size();i++){
                   ThisinhDTO temp = this.array.get(i);
                   if(temp.getSDT().equals(input))
                       result.add(temp);
               }
               break;
           }
       }
        return result;
    }
    
    public ArrayList Delete(int location){
        ThisinhDTO temp = this.array.get(location);
        dao.delete(temp);
        this.array.remove(location);
        return this.array;
    }

    //Đếm số lượng thí sinh trong phòng theo khóa
    public int count_thisinh_in_phongthi(String phongthi,String khoathi){
        int j = 0;
        for(int i=0; i<this.array.size();i ++)
        {
            ThisinhDTO temp = this.array.get(i);
            if(temp.getPhongthi().equals(phongthi) && temp.getKhoathi().equals(khoathi))
                j++;
        }
        return j;
    }

}

