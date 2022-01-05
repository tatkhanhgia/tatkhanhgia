/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author gia
 */
public class PhongthiDTO {
    public String phongthi;
    public String khoathi;
    private String ngaythi;

    public PhongthiDTO() {
    }

    public PhongthiDTO(String phongthi, String khoathi) {
        this.phongthi = phongthi;
        this.khoathi = khoathi;
    }

    public String getPhongthi() {
        return phongthi;
    }

    public void setPhongthi(String phongthi) {
        this.phongthi = phongthi;
    }

    public String getKhoathi() {
        return khoathi;
    }

    public void setKhoathi(String khoathi) {
        this.khoathi = khoathi;
    }

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }
    
    
}
