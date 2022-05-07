package com.example.cms.Database;

import java.util.Date;

public class PaymentTable {
    private int payment_id;
    private String fio;
    private String fani;
    private int miqdori;
    private String oy;
    private Date sana;

    public PaymentTable(int payment_id, String fio, String fani, int miqdori, String oy, Date sana) {
        this.payment_id = payment_id;
        this.fio = fio;
        this.fani = fani;
        this.miqdori = miqdori;
        this.oy = oy;
        this.sana = sana;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
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

    public int getMiqdori() {
        return miqdori;
    }

    public void setMiqdori(int miqdori) {
        this.miqdori = miqdori;
    }

    public String getOy() {
        return oy;
    }

    public void setOy(String oy) {
        this.oy = oy;
    }

    public Date getSana() {
        return sana;
    }

    public void setSana(Date sana) {
        this.sana = sana;
    }
}
