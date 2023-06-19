package com.example.dicomdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Patient {
    @TableId("id")
    private Integer id;
    private String name;
    private Date birthDate;
    private Time  birthTime;
    private String sex;
    private float weight;
    private boolean isPregnancy;

    public Patient() {
    }

}
