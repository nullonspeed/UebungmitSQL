package com.example.uebungmitsql;

public class Patient {
    String vn;
    String nn;

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }

    public Patient(String vn, String nn) {
        this.vn = vn;
        this.nn = nn;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "vn='" + vn + '\'' +
                ", nn='" + nn + '\'' +
                '}';
    }
}
