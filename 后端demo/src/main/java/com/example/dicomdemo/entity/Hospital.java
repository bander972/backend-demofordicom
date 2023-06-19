package com.example.dicomdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {
    public String getHname() {
        return hname;
    }

    public void setHname(String cname) {
        this.hname = cname;
    }

    public String getHinf() {
        return hinf;
    }

    public void setHinf(String cinf) {
        this.hinf = cinf;
    }

    public String getHcode() {
        return hcode;
    }

    public void setCcode(String ccode) {
        this.hcode = ccode;
    }

    @Id
    private String hname;

    private String hinf;

    private String hcode;
}
