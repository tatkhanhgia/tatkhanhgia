package DTO;

//Clas dùng để tạo đối tượng thí sinh, lưuu trữ nhiều loại dữ liệu
public class ThisinhDTO {
    private String SBD;
    private String Ho;
    private String Ten;
    private String Gioitinh;
    private String Ngaysinh;
    private String Noisinh;
    private String CMND;
    private String Ngaycap;
    private String Noicap;
    private String SDT;
    private String Email;
    private String Phongthi;
    private String Khoathi;
    
    public ThisinhDTO(){
        this.SBD      = null;
        this.Ho       = null;
        this.Ten      = null;
        this.Gioitinh = null;
        this.Ngaysinh = null;
        this.Noisinh  = null;
        this.CMND     = null;
        this.Ngaycap  = null;
        this.Noicap   = null;
        this.SDT      = null;
        this.Email    = null;
        this.Phongthi = null;
        this.Khoathi  = null;
    }

    public ThisinhDTO(String sbd, String ho,
                      String ten ,String gioitinh,
                      String ngaysinh,String noisinh,
                      String CMND, String ngaycap,
                      String noicap, String sdt,
                      String email,String phongthi, String khoathi){
        this.SBD      = sbd;
        this.Ho       = ho;
        this.Ten      = ten;
        this.Gioitinh = gioitinh;
        this.Ngaysinh = ngaysinh;
        this.Noisinh  = noisinh;
        this.CMND     = CMND;
        this.Ngaycap  = ngaycap;
        this.Noicap   = noicap;
        this.SDT      = sdt;
        this.Email    = email;
        this.Phongthi = phongthi;
        this.Khoathi  = khoathi;
    }
 

    public String getSBD() {
        return SBD;
    }

    public void setSBD(String SBD) {
        this.SBD = SBD;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getNoisinh() {
        return Noisinh;
    }

    public void setNoisinh(String Noisinh) {
        this.Noisinh = Noisinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getNgaycap() {
        return Ngaycap;
    }

    public void setNgaycap(String Ngaycap) {
        this.Ngaycap = Ngaycap;
    }

    public String getNoicap() {
        return Noicap;
    }

    public void setNoicap(String Noicap) {
        this.Noicap = Noicap;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhongthi() {
        return Phongthi;
    }

    public void setPhongthi(String Phongthi) {
        this.Phongthi = Phongthi;
    }

    public String getKhoathi() {
        return Khoathi;
    }

    public void setKhoathi(String Khoathi) {
        this.Khoathi = Khoathi;
    }
    
    
    
}
