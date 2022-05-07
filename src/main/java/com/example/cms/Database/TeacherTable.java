package com.example.cms.Database;

public class TeacherTable {
    private int teacher_id;
    private String fio;
    private String telefon;
    private String fani;
    private String guruhi;
    private String username;
    private String parol;

    public TeacherTable(int teacher_id, String fio, String telefon, String fani, String guruhi, String username, String parol) {
        this.teacher_id = teacher_id;
        this.fio = fio;
        this.telefon = telefon;
        this.fani = fani;
        this.guruhi = guruhi;
        this.username = username;
        this.parol = parol;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
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
