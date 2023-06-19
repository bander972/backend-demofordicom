package com.example.dicomdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class UserFile {
    private String ID;
    private String fileName;
    private String type;
    private String fileSource;
    private Date uploadTime;
    private String userName;
    private String wadoUrl;


}
