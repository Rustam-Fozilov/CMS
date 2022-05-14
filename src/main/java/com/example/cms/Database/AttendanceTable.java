package com.example.cms.Database;

import javafx.scene.control.CheckBox;

import java.util.Date;

public class AttendanceTable {
    private int attendance_id;
    private String fio;
    private String fani;
    private String statusi;
    private CheckBox select;
    private Date sana;

    public AttendanceTable(int attendance_id, String fio, String fani, String statusi, Date sana) {
        this.attendance_id = attendance_id;
        this.fio = fio;
        this.fani = fani;
        this.statusi = statusi;
        this.sana = sana;
    }

    public AttendanceTable(int attendance_id, String fio, String fani) {
        this.attendance_id = attendance_id;
        this.fio = fio;
        this.fani = fani;
        this.select = new CheckBox();
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFani() {
        return fani;
    }

    public void setFani(String fani) {
        this.fani = fani;
    }

    public String getStatusi() {
        return statusi;
    }

    public void setStatusi(String statusi) {
        this.statusi = statusi;
    }

    public Date getSana() {
        return sana;
    }

    public void setSana(Date sana) {
        this.sana = sana;
    }
}
