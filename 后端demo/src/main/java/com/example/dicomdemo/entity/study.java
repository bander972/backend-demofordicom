package com.example.dicomdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class study {
    private String accessionNum;
    private String studyId;
    private UUID instanceID;

    private Date studyDate;

    private Time studyTime;
    private String modality;
    private String bodyPart;
    private String description;
    private String patientAge;

}
