/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DiemthiDAO;
import DTO.DiemthiDTO;
import DTO.ThisinhDTO;
import java.util.ArrayList;

/**
 *
 * @author gia
 */
public class DiemthiBUS {
    public DiemthiDAO dao;
    public ArrayList<DiemthiDTO> array;

    public DiemthiBUS() {
        this.dao = new DiemthiDAO();
        this.array = dao.get_all();
    }
    
    //Hàm get điểm thi theo SBD + Khóa thi
    public ArrayList get_diemthi_SBD_Khoathi(String SBD,String khoathi){
        ArrayList result = new ArrayList();
        for(int i=0; i<array.size();i++)
        {
            DiemthiDTO temp = array.get(i);
            if(temp.getSBD().equals(SBD) && temp.getKhoathi().equals(khoathi))
                result.add(temp);
        }
        return result;
    }
    
    public ArrayList update(DiemthiDTO diemthi){        
        dao.update(diemthi);
        int location = this.location_of_diemthi(diemthi);
        if(location != -1)
        {
            this.array.set(location, diemthi);
        }
        return this.array;                        
    }
    
    //Hàm tìm vị trí trong mảng
    private int location_of_diemthi(DiemthiDTO khoathi){
        for(int i=0;i<this.array.size();i++)
        {
            DiemthiDTO temp = this.array.get(i);
            if(temp.getSBD().equals(khoathi.getSBD()) && temp.getKhoathi().equals(khoathi.getKhoathi()))
                return i;
        }    
        return -1;
    }
    
    //Hàm trả về điểm của phòng thi truyền vào
    public ArrayList get_diemthi_Phongthi(String phongthi,String khoathi)
    {
        ArrayList result = new ArrayList();
        ThisinhBUS thisinhbus = new ThisinhBUS();
        ArrayList thisinh = thisinhbus.get_thisinh_theo_phongthi(phongthi, khoathi);
        for(int j=0; j<thisinh.size(); j++)
        {   
            int flag = 0;
            ThisinhDTO temp1= (ThisinhDTO)thisinh.get(j);
            for(int i=0;i<this.array.size();i++)
            {
                DiemthiDTO temp = this.array.get(i);                
                if(temp.getSBD().equals(temp1.getSBD()) && temp.getKhoathi().equals(temp1.getKhoathi()))
                {
                    flag = 1;
                    result.add(temp);                    
                    break;
                }                
            }    
            if(flag == 0)
            {
                DiemthiDTO tempp = new DiemthiDTO(temp1.getSBD(), temp1.getKhoathi(), 0, 0, 0, 0);                
                result.add(tempp);
            }
        }
        return result;
    }
    
    //Hàm thêm điểm 
    public void insert(DiemthiDTO diemthi)
    {
        dao.insert(diemthi);
        this.array.add(diemthi);
    }
}
