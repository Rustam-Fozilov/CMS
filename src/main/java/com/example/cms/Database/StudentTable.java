package com.example.cms.Database;

public class StudentTable {
    private String ismi;
    private String familiyasi;
    private String telefon;
    private String fani;
    private String guruhi;
    private int user_id;

    public StudentTable(int user_id, String ismi, String familiyasi, String telefon, String fani, String guruhi) {
        this.user_id = user_id;
        this.ismi = ismi;
        this.familiyasi = familiyasi;
        this.telefon = telefon;
        this.fani = fani;
        this.guruhi = guruhi;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public String getFamiliyasi() {
        return familiyasi;
    }

    public void setFamiliyasi(String familiyasi) {
        this.familiyasi = familiyasi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFani() {
        return fani;
    }

    public void setFani(String fani) {
        this.fani = fani;
    }

    public String getGuruhi() {
        return guruhi;
    }

    public void setGuruhi(String guruhi) {
        this.guruhi = guruhi;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
