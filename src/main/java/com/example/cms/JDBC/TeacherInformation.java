package com.example.cms.JDBC;

public class TeacherInformation {
    private int teacher_id;
    private String ismi;
    private String familiyasi;
    private String telefon;
    private String email;
    private String fani;
    private String username;
    private String parol;

    public TeacherInformation(int teacher_id, String ismi, String familiyasi, String telefon, String email, String fani, String username, String parol) {
        this.teacher_id = teacher_id;
        this.ismi = ismi;
        this.familiyasi = familiyasi;
        this.telefon = telefon;
        this.email = email;
        this.fani = fani;
        this.username = username;
        this.parol = parol;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getFani() {
        return fani;
    }

    public void setFani(String fani) {
        this.fani = fani;
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
