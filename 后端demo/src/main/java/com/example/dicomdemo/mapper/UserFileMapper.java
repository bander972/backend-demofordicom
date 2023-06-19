package com.example.dicomdemo.mapper;

import com.example.dicomdemo.entity.UserFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserFileMapper {
    /**
     * 根据用户id获得用户文件列表
     * @param userName
     * @param begin
     * @param offset
     * @return
     */
   public List<UserFile> queryByUserName(String userName,Integer begin,Integer offset);

   public String queryFileCount(String userName);
}
