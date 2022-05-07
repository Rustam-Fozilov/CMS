package com.example.cms.Database;

public class AdminInformation {
    private int admin_id;
    private String fio;
    private String telefon;
    private String email;
    private String username;
    private String parol;

    public AdminInformation(int admin_id, String fio, String telefon, String username, String parol) {
        this.admin_id = admin_id;
        this.fio = fio;
        this.telefon = telefon;
        this.username = username;
        this.parol = parol;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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
