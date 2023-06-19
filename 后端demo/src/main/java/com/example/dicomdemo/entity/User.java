package com.example.dicomdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    public String getHcode() {
        return hcode;
    }

    public void setCcode(String ccode) {
        this.hcode = ccode;
    }


    private String hcode;


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Id
    private String uname;

    private String upassword;

    private String uemail;

    public String getEmail() {
        return uemail;
    }

    public void setEmail(String email) {
        this.uemail = email;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String cname) {
        this.hname = hname;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }
    private String hname;

    private String uauth;

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUauth() {
        return uauth;
    }

    public void setUauth(String uauth) {
        this.uauth = uauth;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    private String utype;

    private String utime;

}
