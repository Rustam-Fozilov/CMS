package com.example.cms.Database;

public class UserInformation {
    private String fio;
    private String email;
    private String telefon;
    private String fani;
    private String guruhi;
    int user_id;

    public UserInformation(int user_id, String fio, String telefon, String fani, String guruhi) {
        this.user_id = user_id;
        this.fio = fio;
        this.telefon = telefon;
        this.fani = fani;
        this.guruhi = guruhi;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
}
