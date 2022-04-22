package com.example.cms.JDBC;

public class AdminInformation {
    private int admin_id;
    private String ismi;
    private String familiyasi;
    private String telefon;
    private String email;
    private String username;
    private String parol;

    public AdminInformation(int admin_id, String ismi, String familiyasi, String telefon, String email, String username, String parol) {
        this.admin_id = admin_id;
        this.ismi = ismi;
        this.familiyasi = familiyasi;
        this.telefon = telefon;
        this.email = email;
        this.username = username;
        this.parol = parol;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }
}
