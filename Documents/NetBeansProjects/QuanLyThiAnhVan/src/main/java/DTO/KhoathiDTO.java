package DTO;

public class KhoathiDTO {
    public String khoathi;
    public String ngaythi;

    public KhoathiDTO(String khoathi, String ngaythi) {
        this.khoathi = khoathi;
        this.ngaythi = ngaythi;
    }

    public KhoathiDTO() {
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
