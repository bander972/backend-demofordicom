package com.example.dicomdemo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Getter
@Setter
public class Series {
    @TableId("seriesNumber")
    private String seriesNumber;

    private UUID seriesInstanceID;
    private String modality;
    private Date seriesDate;
    private Time seriesTime;


}
