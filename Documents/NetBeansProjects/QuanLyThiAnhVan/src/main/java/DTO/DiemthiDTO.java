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
public class DiemthiDTO {
    public String SBD;
    public String khoathi;
    public float nghe;
    public float noi;
    public float doc;
    public float viet;

    public DiemthiDTO(String SBD, String khoathi, float nghe, float noi, float doc, float viet) {
        this.SBD = SBD;
        this.khoathi = khoathi;
        this.nghe = nghe;
        this.noi = noi;
        this.doc = doc;
        this.viet = viet;
    }

    public DiemthiDTO() {
    }

    public String getSBD() {
        return SBD;
    }

    public void setSBD(String SBD) {
        this.SBD = SBD;
    }

    public String getKhoathi() {
        return khoathi;
    }

    public void setKhoathi(String khoathi) {
        this.khoathi = khoathi;
    }

    public float getNghe() {
        return nghe;
    }

    public void setNghe(float nghe) {
        this.nghe = nghe;
    }

    public float getNoi() {
        return noi;
    }

    public void setNoi(float noi) {
        this.noi = noi;
    }

    public float getDoc() {
        return doc;
    }

    public void setDoc(float doc) {
        this.doc = doc;
    }

    public float getViet() {
        return viet;
    }

    public void setViet(float viet) {
        this.viet = viet;
    }
    
    
}
