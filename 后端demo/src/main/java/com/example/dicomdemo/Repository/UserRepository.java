package com.example.dicomdemo.Repository;

import com.example.dicomdemo.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByUname(String uname);

    List<User> findByHname(String cname);

    @Query(value="select * from user where cname = :hname and utype = :utype and uname like CONCAT('%',:uname,'%')",nativeQuery=true)
    List<User> findByCnameAndUtypeAndUname(@Param("hname")String hname, @Param("utype")String utype, @Param("uname")String uname);
}
